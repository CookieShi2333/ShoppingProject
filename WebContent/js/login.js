function register() {
		var email = document.getElementById("email").value;
		var account = document.getElementById("account").value;
		var passWord = document.getElementById("password").value;
		var rePassWord = document.getElementById("repassword").value;
		var inputVerifyCode = document.getElementById("inputVerifyCode").value;
		// innerText 获取标签中的文本
		var verifyCode = document.getElementById("verifyCode").innerText;
		if (email == "") {
			alert("邮箱不能为空!");
			//获得焦点事件
			document.getElementById("email").focus();
			/*$("#email").focus();  jquery写法*/f
			return;
		} else if (account == "") {
			alert("用户名不能为空!");
			document.getElementById("account").focus();
			return;
		} else if (passWord == "") {
			alert("密码不能为空!");
			document.getElementById("password").focus();
			return;
		}else if(rePassWord==""){
			alert("确认密码不能为空");
			document.getElementById("repassword").focus();
			return;
		}else if (passWord != rePassWord) {
			alert("两次密码不一致!");
			document.getElementById("repassword").value = "";
			document.getElementById("repassword").focus();
			return;
		} else if (inputVerifyCode == "") {
			document.getElementById("inputVerifyCode").focus();
			alert("请输入验证码!");
			return;
		} else if (inputVerifyCode != verifyCode) {
			alert("验证码错误!");
			document.getElementById("inputVerifyCode").value = "";
			document.getElementById("inputVerifyCode").focus();
			return;
		}
		
		ajax("get", "http://localhost:8080/ShoppingProject/userInfoAccount", "account=" + account,
				function(result) {
					// succeed
			var content=JSON.parse(result);
			if(content.resultCode=="1"){
				alert("用户账号已经存在!");
			}else{
				ajax("get", "http://localhost:8080/ShoppingProject/register", "email="
						+ email + "&account=" + account + "&password=" + passWord,
						function(result) {
							// succeed
							initData(result);
						}, function() {
							// failed
						});
			}
				}, function() {
					// failed
				});
        
		

		function initData(result) {
			//假设已经知道了json的长度,用len表示
			var content = JSON.parse(result);
			if (content.resultCode == 0) {
				alert(content.message);
			}else{
				alert(content.message);
				window.location.reload();
			}
		}
	}

	function login() {
		var account = document.getElementById("accountLogin").value;
		var password = document.getElementById("passwordLogin").value;
		if (account == "") {
			alert("用户名不能为空!");
			document.getElementById("accountLogin").focus();
			return;
		} else if (password == "") {
			alert("密码不能为空!");
			document.getElementById("passwordLogin").focus();
			return;
		}

		
		
		ajax("get", "http://localhost:8080/ShoppingProject/login", "account="
				+ account + "&password=" + password, function(result) {
			// succeed
			initData(result);
		}, function() {
			// failed
		});

		function initData(result) {
			//假设已经知道了json的长度,用len表示
			var content = JSON.parse(result);
			if (content.resultCode == "1") {
				alert(content.message);
				addCookie("login_state", content.account, 10);
				window.open("index.jsp");
			}if (content.resultCode == "2") {
				alert(content.message);
			}if (content.resultCode == "3") {
				alert(content.message);
			}
			//console.log(content.data.account);
			
		}

		function addCookie(name, value, expiresHours) {
			var cookieString = name + "=" + escape(value);
			//判断是否设置过期时间,0代表关闭浏览器时失效  
			if (expiresHours > 0) {
				var date = new Date();
				date.setTime(date.getTime + expiresHours * 3600 * 1000);
				cookieString = cookieString + "; expires=" + date.toGMTString();
			}
			document.cookie = cookieString;
		}
	}