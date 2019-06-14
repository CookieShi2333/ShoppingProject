<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title>商品添加页</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/ajax.js"></script>
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="css/templatemo_style.css" rel="stylesheet" type="text/css">	
	<style type="text/css">
		.message{width:400px;margin:auto auto 10px auto;line-height:24px;color:#ffd5bc;overflow:hidden}
		.message .input{width:219px;height:28px;line-height:28px;border:none;background:#333333;padding-left:20px;color:#ffffff;font-family:Microsoft YaHei;}
		.message .liulan{width:64px;height:28px;border:1px solid #ffb660;background:#fe9e19;color:#ffffff;cursor:pointer;}
		.message .files{position:absolute;left:-1000px;top:52px;heigth:26px;cursor:pointer;filter: Alpha(opacity=0);-moz-opacity:0;opacity:0;} 
		.btn_index{margin-right:120px;}
		.btn_sub{margin-right:120px;}
	</style>
<body class="templatemo-bg-gray">
	<div class="container">
		<div class="col-md-12">	
			<h1 class="text-center margin-bottom-15">商品新增</h1>		
			<form class="form-horizontal templatemo-contact-form-2 templatemo-container" role="form" action="#" method="post">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">				          		          	
				           	<div class="col-sm-12">
				            	<div class="templatemo-input-icon-container">
				            		<i class="fa fa-user"></i>
				            		<input type="text" class="form-control" id="title" placeholder="商品标题">
				            	</div>		            		            		            
				          	</div>              
				        </div>
				        <div class="form-group">
				            <div class="col-sm-12">
				            	<div class="templatemo-input-icon-container">
				            		<i class="fa fa-envelope"></i>
				            		<input type="text" class="form-control" id="old_money" placeholder="价格">
				            	</div>
				          	</div>
				        </div>
				        <div class="form-group">
				            <div class="col-sm-12">
				            	<div class="templatemo-input-icon-container">
				            		<i class="fa fa-phone"></i>
				            		<input type="text" class="form-control" id="money" placeholder="商城价格">
				            	</div>
				          	</div>
				        </div>
				        <div class="form-group">
				            <div class="col-sm-12">
				            	<div class="templatemo-input-icon-container">
				            		<i class="fa fa-info-circle"></i>
				            		<input type="text" class="form-control" id="goodNumber" placeholder="商品数量">
				            	</div>
				          	</div>
				        </div>
				        <div class="form-group">
				            <div class="col-sm-12">
				            	<div class="templatemo-input-icon-container">
				            		<i class="fa fa-info-circle"></i>
				            		<input type="text" class="form-control" id="sellNumber" placeholder="累计售出">
				            	</div>
				          	</div>
				        </div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
				          <div class="col-md-12">
				            <div class="templatemo-input-icon-container">
				            	<i class="fa fa-pencil-square-o"></i>
				            	<textarea rows="10" cols="50" class="form-control" id="message" placeholder="商品简介"></textarea>
				            </div>
				          </div>
				        </div>
				        <div class="col-md-12">
		            		<input type="button" value="提交全部信息" id="add_form" class="btn btn-warning pull-right btn_sub">	
		            		<input type="button" value="返回首页" class="btn btn-warning pull-right btn_index">	
		          		</div>
					</div>					
				</div>	        
		      </form>
		      <div class="message">
			      <form method="post" id="fileForm" action="upload" enctype="multipart/form-data">
					<input type="text" id="txt" name="txt" class="input" value="文件域" disabled="disabled" />
					<input type="file" id="f" onChange="txt.value=this.value" name="fileName" style="height:26px;" class="files"  size="1" hidefocus />
					<input type="button" onMouseMove="f.style.pixelLeft=event.x-60;f.style.pixelTop=this.offsetTop;" value="上传图片" size="30" onClick="f.click()" class="liulan" />
					<input type="submit"  value="提交图片" id="tj" size="30" class="liulan" />
				   ${msg}	
				   </form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		$(".btn_index").on("click",function(){
			// 返回首页
			window.location.href="index.jsp";
		})
		
		var _msg = "${msg}";
		if(_msg == "文件上传成功!") {
			alert("文件上传成功!" + "${realFileName}");
			window.location.href="add_goodinfo.jsp";
		}
		//通过ajax提交参数
		//给表单的提交按钮绑定一个单击事件
		$("#add_form").bind("click",function(){
			//通过jquery选择器获取参数
			var _title = $("#title").val();
			var _oldMoney = $("#old_money").val();
			var _money = $("#money").val();
			var _goodNumber = $("#goodNumber").val();
			var _sellNumber = $("#sellNumber").val();
			var _message = $("#message").val();
			var _image = "${realFileName}";
			
			ajax("get","http://localhost:8080/ShoppingProject/addGoods",
					"title="+_title+"&oldMoney="+_oldMoney+"&money="+_money+"&goodNumber="+_goodNumber+
					"&sellNumber="+_sellNumber+"&goodIntroduction="+_message+"&images="+_image,
					function(result){
				var content = JSON.parse(result);
				if(content.resultCode == "1"){
					alert("添加成功!");
					window.location.href="index.jsp";
				}else{
					alert("添加失败!");
				}
			},function(){});
		})
	})
</script>
</html>