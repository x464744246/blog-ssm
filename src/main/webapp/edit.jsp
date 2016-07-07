<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>


<head lang="en">
<meta charset="UTF-8">
<title>ChenDiDi's Rocks</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />


<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/default.css">
<link href="css/fileinput.css" media="all" rel="stylesheet"
	type="text/css" />
<script src="http://libs.useso.com/js/jquery/2.1.1/jquery.min.js"></script>
<script src="js/fileinput.js" type="text/javascript"></script>
<script src="js/fileinput_locale_zh.js" type="text/javascript"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"
	type="text/javascript"></script>



<link rel="alternate icon" type="image/png" href="assets/i/favicon.png">
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<link rel="stylesheet"
	href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<style type="text/css">
.table th, .table td {
	text-align: center;
	width: 33%;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}
</style>
<script type="text/javascript">
	function toVaild() {
		var title =  $('#title').val();
		title = encodeURI(title);
		$("#title").val(title);
	
		var article =  $('#article').val();
		article = encodeURI(article);
		$("#article").val(article);
		//document.getElementByid("title").value = encodeURI(encodeURI(document.getElementByid("title").value));
		//document.getElementByid("article").value = encodeURI(encodeURI(document.getElementByid("article").value));
		//alert( $('#article').val());
		return true;

	}
</script>

<!-- 
<script>
	$("#file-0").fileinput({
		'allowedFileExtensions' : [ 'jpg', 'png', 'gif' ],
	});

	$(document).ready(function() {
		$("#test-upload").fileinput({
			'showPreview' : false,
			'allowedFileExtensions' : [ 'jpg', 'png', 'gif' ],
			'elErrorContainer' : '#errorBlock'
		});
		/*
		$("#test-upload").on('fileloaded', function(event, file, previewId, index) {
		    alert('i = ' + index + ', id = ' + previewId + ', file = ' + file.name);
		});
		 */
	});
</script> -->
</head>

<body>

	<nav class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#example-navbar-collapse">
			<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#">ChenDiDi's Rocks</a>
	</div>
	<div class="collapse navbar-collapse" id="example-navbar-collapse">
		<ul class="nav navbar-nav">
			<li class="active"><a href="./Message_PageAction.action?page=1">首页</a></li>
			<li><a href="./Message_AddAction.action">添加文章</a></li>
			<li><a href="./MAndRAction.action?page=1">我的回复</a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"> 更多 <b class="caret"></b>
			</a>
				<ul class="dropdown-menu pull-right">
					<li><a href="#">jmeter</a></li>
					<li><a href="#">EJB</a></li>
					<li><a href="#">Jasper Report</a></li>
					<li class="divider"></li>
					<li><a href="#">分离的链接</a></li>
					<li class="divider"></li>
					<li><a href="#">另一个分离的链接</a></li>
				</ul></li>
		</ul>
		<!--用户下拉列表-->
		<ul class="nav pull-right">

			<li class="dropdown"><a data-toggle="dropdown"
				class="dropdown-toggle " href="#">${sessionScope.u.name}<strong
					class="caret"></strong></a>
				<ul class="dropdown-menu pull-right">
					<li><a href="./PasswordChange.action">更改密码</a></li>

		
					<li class="divider"></li>
					<li><a href="./Login_OutAction.action">退出登录</a></li>
				</ul></li>
		</ul>
	</div>
	</nav>
	</br>
	</br>
	</br>
	<div class="row container-fluid">
		<div class="col-md-10 col-md-offset-1">

			<form action="./Message_AddCheckAction.action" role="form" onsubmit="return toVaild()">
				<div class="form-group">
					<label for="name">标题</label> </br> <input id="title" type="text"
						name="title" class="form-control" placeholder="文本输入">
				</div>

				<div class="form-group">
					</br> <label for="name">内容</label> </br>
					<textarea id="article" name="article" class="form-control"
						rows="18"></textarea>
				</div>

				<!-- 	<div class="form-group">
					</br> <input name="images" id="file-0a" class="file" type="file" multiple
						data-min-file-count="1"> </br>

				</div> -->

				<div class="am-cf ">
					</br> <input id="send" type="submit" name="" value="发   表 "
						class="am-btn am-btn-primary am-btn-sm am-fl am-u-sm-centered">
				</div>
			</form>

		</div>
	</div>
	<!-- onClick="this.form.action='./Message_AddCheckAction.action'" -->

</body>

</html>