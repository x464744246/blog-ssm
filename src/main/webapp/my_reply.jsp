<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<title>ChenDiDi's Rocks</title>
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


</head>

<body >

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





	<!--锟斤拷锟斤拷-->
	<div class="container-fluid">

		</br>
	
		<div class="list-group  container-fluid">
			<a href="#" class="list-group-item active">
				<h4 class="list-group-item-heading">我的回复</h4>
			</a>

			<c:forEach items="${reply}" var="reply">
				</br>

				<div class="row container-fluid">
					
					<div class="col-md-8  col-md-offset-2">
						<a href="#" class="list-group-item">
							<h4 class="list-group-item-heading">${reply.title}</h4>
							<pre class="list-group-item-text">${reply.replymessage}</pre>

						</a>
						<button class="btn btn-small btn-link  pull-right" id="delete"
							type="button"
							onclick="location='./MAndR_DeleteAction.action?replyid='+'${reply.replyid}'">删除回复</button>
					</div>
				</div>


			</c:forEach>
		</div>

		</br>


		<nav style="text-align: center">
		<ul class="pagination ">
			<li><a
				href="./Message_ReplyAction.action?page=1&messageid=${sessionScope.m.messageid}">&laquo;</a></li>
			<li><a
				href="./Message_ReplyAction.action?page=${page-2}&messageid=${sessionScope.m.messageid}">${page-2}</a></li>
			<li><a
				href="./Message_ReplyAction.action?page=${page-1}&messageid=${sessionScope.m.messageid}">${page-1}</a></li>
			<li><a
				href="./Message_ReplyAction.action?page=${page}&messageid=${sessionScope.m.messageid}">${page}</a></li>
			<li><a
				href="./Message_ReplyAction.action?page=${page+1}&messageid=${sessionScope.m.messageid}">${page+1}</a></li>
			<li><a
				href="./Message_ReplyAction.action?page=${page+2}&messageid=${sessionScope.m.messageid}">${page+2}</a></li>
			<li><a
				href="./Message_ReplyAction.action?page=-1&messageid=${sessionScope.m.messageid}">&raquo;</a></li>
		</ul>
		</nav>
		
	</div>
</body>

</html>