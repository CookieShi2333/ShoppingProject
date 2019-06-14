<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>天狗_综合商城</title>
</head>
<link rel="stylesheet" type="text/css" href="css/productList.css" />
<script type="text/javascript"src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css" />

<body>
	<!-- 导入头部 -->
	<%@ include file="common_top.jsp"%>
	<!--SubPageMenu-->
	<div id="commonMenu"></div>
	<div id="ListCenter">
	<%@ include file="leftbox.jsp"%> 
		<div class="rightBox">
			<!-- start -->
			<section class="pc-banner">
	<div class="swiper-container">
		<div class="swiper-wrapper">
			<div class="swiper-slide swiper-slide-center none-effect">
				<a href='#'>
					<img src="img/banner001.jpg">
				</a>
				<div class="layer-mask"></div>
			</div>
			<div class="swiper-slide">
				<a href="#">
					<img src="img/banner002.jpg">
				</a>
				<div class="layer-mask"></div>
			</div>
			<div class="swiper-slide">
				<a href="#">
					<img src="img/banner003.jpg">
				</a>
				<div class="layer-mask"></div>
			</div>
			<div class="swiper-slide">
				<a href="#">
					<img src="img/banner004.jpg">
				</a>
				<div class="layer-mask"></div>
			</div>
			<div class="swiper-slide">
				<a href="#">
					<img src="img/banner005.jpg">
				</a>
				<div class="layer-mask"></div>
			</div>
		</div>
		<div class="button">
			<div class="swiper-button-prev"></div>
			<div class="swiper-button-next"></div>
		</div>
	</div>
</section>
<script type="text/javascript" src="js/swiper.min.js"></script>
<script type="text/javascript">

	window.onload = function() {
		var swiper = new Swiper('.swiper-container',{
			autoplay: false,
			speed: 1000,
			autoplayDisableOnInteraction: false,
			loop: true,
			centeredSlides: true,
			slidesPerView: 2,
			pagination: '.swiper-pagination',
			paginationClickable: true,
			prevButton: '.swiper-button-prev',
			nextButton: '.swiper-button-next',
			onInit: function(swiper) {
				swiper.slides[2].className = "swiper-slide swiper-slide-active";
			},
			breakpoints: {
				668: {
					slidesPerView: 1,
				}
			}
		});
	}


</script>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
			<!-- end -->
			<div class="sequence">
				<span>&nbsp;&nbsp;排序方式:</span> 
				    <ul>
				      <li class="active" id="more">默认</li>
				      <li>畅销商品</li>
				      <li>新品上架</li>
				      <li id="up">价格从高到低</li>
				      <li id="down">价格从低到高</li>
				      <li id="add">商品增加</li>
				      <li id="update">商品编辑</li>
				      <li id="delete">商品删除</li>
				    </ul>
			</div>

			<div id="goods"></div>

			<div class="next">
				一共<span>323</span>条记录，当前第<span>1</span>页，共<span>30</span>页<a
					href="#">上一页</a><a href="#">下一页</a>
			</div>

			<div id="model" style="display:none">
				<div class="product" id="$id$">
					<dl>
						<dt>
							<a><img style="width:100%; height:100%" src="$img$"/> </a><span></span>
						</dt>
						<dd>
							<del>市场价：$oldMoney$</del>
							元
						</dd>
						<dd>
							<b>$money$</b>元
						</dd>
						<dd>
							<a href=$href$>$title$</a>
						</dd>
						<dd>
						<input type="checkbox" id="ck" name="" value=""/>
							<span>累计售出$count$件</span>-->
						</dd>
						<dd>
						    <input type="button" value="查看商品详情" onClick="check()"/>
						</dd>
					</dl>
				</div>
			</div>
		</div>
	</div>
	<!-- 导入脚部 -->
	<%@ include file="common_bottom.jsp"%>
</body>
</html>
