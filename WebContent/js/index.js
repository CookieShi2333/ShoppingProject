//就绪函数
$(function(){
	var data=null;
	$("#up").on("click",function(){
		ajax("get", "http://localhost:8080/ShoppingProject/getGoods", "sort=" + "up", function(
				result) {
			// succeed
			initData(result);
		}, function() {
			// failed

		});
	})
	
	$("#down").on("click",function(){
		ajax("get", "http://localhost:8080/ShoppingProject/getGoods", "sort=" + "down", function(
				result) {
			// succeed
			initData(result);
		}, function() {
			// failed

		});
	})
	
	

	
	ajax("get", "http://localhost:8080/ShoppingProject/getGoods",null, function(
			result) {
		// succeed
		initData(result);
	}, function() {
		// failed

	});
	
	
	//增加商品
	$("#add").on("click",function(){
		 //alert(1);
		 window.location.href="add_goodinfo.jsp";
	})



	//删除商品
	$("#delete").on("click",function(){
		 
		  if($("input").is(":checked")){
			 // alert("sss");
			  if(confirm("确认要删除该商品吗?")){
				  var _ckVal=$("input:checkbox").val();
				ajax("get","http://localhost:8080/ShoppingProject/deleteGoods","id="+_ckVal,function(result){
					var content=JSON.parse(result);
					if(content.resultCode=="1"){
						//删除成功
						alert(content.message);
						//页面刷新
						window.location.reload();
					}else{
						alert(content.message);
					}
				},function(){})
			  }
		  }
	})

	
})



//查看商品详情,点击事件函数
function check(){
	var product = goods.getElementsByClassName("product");
	for(var i = 0; i < product.length; i++){
		window.location.href = "http://localhost:8080/ShoppingProject/goodsDetail?id="+this.id;
	}
}


		function initData(result) {
			//假设已经知道了json的长度,用len表示
			var content = JSON.parse(result);
			var data = content.data;
			console.log(data);
			var items = "";
			for ( var i = 0; i < data.length; i++) {
				var item = document.getElementById("model").innerHTML;
				var list = item.replace("$title$", data[i].title).replace(
						"$id$", data[i].id).replace("$oldMoney$",
						data[i].oldMoney).replace("$money$", data[i].money)
						.replace("$img$", data[i].image).replace("$count$",
								data[i].sellNumber);
				items += list;
			}
			var goods = document.getElementById("goods");
			goods.innerHTML = items;
			var product = goods.getElementsByClassName("product");
			for ( var i = 0; i < product.length; i++) {
				product[i].onclick = function() {
					$("input:checkbox").val(this.id);
				}
			}
		}