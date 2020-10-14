<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>登录</title>
	<meta charset="UTF-8">

</head>
<body>
	
	<jsp:include page="header.jsp"/>
	<link rel="stylesheet" type="text/css" href="static/index/css/public.css">
	<link rel="stylesheet" type="text/css" href="static/index/css/common.css">
	<link rel="stylesheet" type="text/css" href="static/index/css/logon.css">
	<link rel="stylesheet" type="text/css" href="static/index/css/font.css">
	<div id="main" class="logincoent">
	
		<div class="rebackgroundimg">
			<div class="registruer">
				<div class="regrnamepwd">
					<p class="iteljk">登录<span><a href="register">未注册请先注册</a></span></p>
					<form action="user/login" method="post">
					   <ul class="ul_form">
							<li class="user">
								<i class="iconfont icon-yonghu"></i>
								<input type="text" class="username" name="username" placeholder="请输入用户名">
							</li>
							<li class="pwdmia">
								<i class="iconfont icon-mima"></i>
								<input type="password" class="pwd" name="password" placeholder="请再次输入密码">
							</li>
						</ul>
						<input type="submit" value="立即登录" class="sub">
						<div style="color: red;font-size: 16px;text-align: center;margin-top: 20px;">${requestScope.exception.message}</div>
					</form>
				</div>
			</div>
		</div>
		
	</div>

	<jsp:include page="footer.jsp"/>

</body>
<script src="static/index/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">

</script>
</html>