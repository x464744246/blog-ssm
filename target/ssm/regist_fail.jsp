<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head lang="en">
	<meta charset="UTF-8">
	<title>Let's Rock</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="format-detection" content="telephone=no">
	<meta name="renderer" content="webkit">
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<link rel="alternate icon" type="image/png" href="assets/i/favicon.png">
	<link rel="stylesheet" href="assets/css/amazeui.min.css" />
	<style>
		.header {
			text-align: center;
		}
		
		.header h1 {
			font-size: 200%;
			color: #333;
			margin-top: 30px;
		}
		
		.header p {
			font-size: 14px;
		}

	</style>
	
	
</head>

<body>
	<div class="header">
		<div class="am-g">
			<h1>注册失败，用户名已存在</h1>
		</div>
		<hr />
	</div>
	<div class="am-g">
		<div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">

			<form name="regist" action="Regist_ReturnAction.action" method="post" class="am-form" ">
				
				<div class="am-cf ">
					<input type="submit" name="" value="返回注册" class="am-btn am-btn-primary am-btn-sm am-fl am-u-sm-centered">
				</div>
			</form>
			<hr>
			<p>© 2016 ChenDiDi.</p>
		</div>
	</div>
</body>

</html>
