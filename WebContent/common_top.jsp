<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>天狗商城_天狗商城</title>
</head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<body> 
	<!--topHeader-->
	<div class="topHeader">
		<div id="shoppingCart" class="t_menu">
			<div class="hello">
			<!--  ${account} <%= request.getSession().getAttribute("account")%> 都可以接受数据 -->
				您好：<span style="color:blue"> [${sessionScope.account}]</span>,欢迎光临天狗商城! [ <a href="login.jsp" class="deng">请登录</a>
				<a href="login.jsp" class="tui">退出!</a> ],新用户？[ <a href="login.jsp"
					class="zhuce">免费注册</a> <a href="#" class="guan">用户管理</a> ]
			</div>
			<div class="shop">
				<span class="shoppingcart"> <a href="myShopping.html">购物车<span
						class="red1">0</span>件</a> </span> <a class="sub" href="javascript:void(0)">我的订单</a>|
				<a class="sub" href="javascript:void(0)">网站地图</a>| <a class="sub"
					href="javascript:void(0)">帮助中心</a>| <a class="sub"
					href="javascript:void(0)">加入收藏</a>| <a class="sub"
					href="javascript:void(0)">设为首页</a>
			</div>
		</div>
	</div>
	<!--top-->
	<div class="top">
		<div id="header" class="header">
			<a class="logo" href="javascript:void(0)"></a>
			<div class="searchBox">
				<input id="searchBox" type="text" value="" />
				<p class="search_commodity">商品</p>
				<p class="seach_hot">
					<!-- <a href="javascript:void(0)">手机</a>/ <a href="javascript:void(0)">钟表</a>/
					<a href="javascript:void(0)">家电</a>/ <a href="javascript:void(0)">电脑</a>/
					<a href="javascript:void(0)">男装</a>/ <a href="javascript:void(0)">女装</a>/
					<a href="javascript:void(0)">灯具</a>/ <a href="javascript:void(0)">童装</a>/
					<a href="javascript:void(0)">儿童玩具</a>/ <a href="javascript:void(0)">笔记本</a>/
					<a href="javascript:void(0)">平板</a>/ <a href="javascript:void(0)">相机</a>/
					<a href="javascript:void(0)">鞋</a> -->
				</p>
			</div>
			<a class="seach" id="search"  href="javascript:void(0)">搜索</a>
		</div>
	</div>
	<!--topNav-->
	<div class="topNav">
		<div class="topNav_menu">
			<a href="javascript:void(0)" id="commodityList">所有商品分类</a>
			<ul class="topNavList">
				<li><a href="index.jsp">首页</a></li>
				<li><img src="img/test/topNavLi.png" /></li>
				<li><a href="#">手机数码</a></li>
				<li><img src="img/test/topNavLi.png" /></li>
				<li><a href="#">礼品箱包</a></li>
				<li><img src="img/test/topNavLi.png" /></li>
				<li><a href="#">厨具用品</a></li>
				<li><img src="img/test/topNavLi.png" /></li>
				<li><a href="#">名牌手表</a></li>
				<li><img src="img/test/topNavLi.png" /></li>
				<li><a href="#">服饰鞋帽</a></li>
				<li><img src="img/test/topNavLi.png" /></li>
				<li><a href="#">个护化妆</a></li>
				<li><img src="img/test/topNavLi.png" /></li>
				<li><a href="#">母婴用品</a></li>
				<li><img src="img/test/topNavLi.png" /></li>
			</ul>
			<div class="topNav_hot">
			<!--<a href="javascript:void(0)">  a标签失去链接功能  -->
				<a href="javascript:void(0)">分享</a> <a href="javascript:void(0)">导航</a>
				<a href="javascript:void(0)">团购</a> <a href="javascript:void(0)">充值</a>
				<div class="new"></div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function getCookie(name) {
			var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
			if (arr = document.cookie.match(reg))
				return unescape(arr[2]);
			else
				return null;
		}
		var cookie = getCookie("login_state");
		if (cookie != null) {
			var tui = document.getElementsByClassName("tui")[0];
			var zhuce = document.getElementsByClassName("zhuce")[0];
			var deng = document.getElementsByClassName("deng")[0];
			var guan = document.getElementsByClassName("guan")[0];
			tui.className = "";
			guan.className = "";
			zhuce.style.cssText = "display:none;";
			deng.style.cssText = "display:none;";
		}
		
		//编写就绪程序
		$(function(){
			//绑定搜索按钮的单击事件id=search
			$("#search").on("click",function(){
			//获取searchBox的value值，其实就是Input的text文本值
			var _boxVal=$("#searchBox").val();//取文本框中输入的值
			//alert(_boxVal);
			//将获取页面元素的值传递到后台，然后进行数据筛选
			ajax("get", "http://localhost:8080/ShoppingProject/getGoods","title="+_boxVal,function(result){
				initData(result);
			},function(){})
			
			});
		});
		
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
					console.log(this);
					$("input:checkbox").val(this.id);
				}
			}
		}
		
		
		//查看商品详情,点击事件函数
   function check(){
	var product = goods.getElementsByClassName("product");
	for(var i = 0; i < product.length; i++){
	    product[i].onclick=function(){
		window.location.href = "http://localhost:8080/ShoppingProject/goodsDetail?id=" + this.id;
	}}
}

	</script>
</body>
</html>
