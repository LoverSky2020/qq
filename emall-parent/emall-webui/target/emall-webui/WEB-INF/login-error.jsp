<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>请先登录</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="admin/css/bootstrap.css">
</head>

<!-- 设置背景图片 -->
<body style="background:#fbf8ef;background-size:100%;">

<div class="container">
    <h2 class="form-signin-heading" style="text-align: center;">
         Emall系统消息
    </h2>
    <h3 style="text-align: center;">${requestScope.exception.message }</h3>

    <a style="width: 150px;margin: 50px auto 0px auto;" class="btn btn-lg btn-success btn-block" href="admin/login/page">回到登陆页面</a>

</div>

</body>
<script type="text/javascript" src="admin/js/jquery.js"></script>
<script type="text/javascript">

</script>
</html>
