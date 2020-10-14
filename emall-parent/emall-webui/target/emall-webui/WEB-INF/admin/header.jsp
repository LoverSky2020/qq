<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<%
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
	<base href="<%=basePath%>">
<meta charset="utf-8"/>
</head>
<body>

	<nav class="navbar navbar-default" role="navigation" style="background-color:#fbf8ef;">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="admin/index/page">后台首页</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li <c:if test="${flag==1}">class="active"</c:if>><a href="admin/type/list/page">类目管理</a></li>
					<li <c:if test="${flag==2}">class="active"</c:if>><a href="admin/goods/list">商品管理</a></li>
					<li <c:if test="${flag==3}">class="active"</c:if>><a href="admin/order/list">订单管理</a></li>
					<li <c:if test="${flag==4}">class="active"</c:if>><a href="admin/user/list">用户管理</a></li>
					<li <c:if test="${flag==5}">class="active"</c:if>><a href="admin/list">管理员</a></li>
					<li><a href="admin/logout">退出</a></li>
				</ul>
			</div>
		</div>
	</nav>

</body>
</html>