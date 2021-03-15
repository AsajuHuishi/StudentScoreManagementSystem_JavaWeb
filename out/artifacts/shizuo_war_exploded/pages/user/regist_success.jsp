<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">
<title>注册页面</title>
	<base href="http://localhost:8080/shizuo/">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
</style>
</head>
<body>
		<div id="header">
				<img class="logo_img" alt="" src="static/img/logo2.png" >
				<span class="wel_word"></span>
				<div>
					<span>欢迎<span class="um_span">${user.username}</span>光临尚硅谷书城</span>
					<a href="pages/order/order.html">我的订单</a>
					<a href="index.html">注销</a>&nbsp;&nbsp;
					<a href="index.html">返回</a>
				</div>
		</div>
		
		<div id="main">
		
			<h1>注册成功! <a href="index.html">转到主页</a></h1>
	
		</div>
		
		<div id="bottom">
			<span>
				AsajuHuishi 2021
			</span>
		</div>
</body>
</html>