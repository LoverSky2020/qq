<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>客户列表</title>
<meta charset="utf-8"/>

</head>
<body>
<div class="container">

	<%@include file="header.jsp"%>
	<link rel="stylesheet" href="admin/css/bootstrap.css"/>
	<div class="text-right"><a class="btn btn-warning" href="admin/user/save/page">添加客户</a></div>
		
	<br>
	
	<table class="table table-bordered table-hover">

	<tr>
		<th width="5%">ID</th>
		<th width="5%">用户</th>
		<th width="10%">姓名</th>
		<th width="10%">电话</th>
		<th width="10%">地址</th>
		<th width="15%">操作</th>
	</tr>
	
	<c:forEach var="user" items="${users}">
         <tr>
         	<td><p>${user.id}</p></td>
         	<td><p>${user.username}</p></td>
         	<td><p>${user.name}</p></td>
         	<td><p>${user.phone}</p></td>
         	<td><p>${user.address}</p></td>
			<td>
				<a class="btn btn-info" href="admin/user/to/reset/password?id=${user.id}">重置密码</a>
				<a class="btn btn-primary" href="admin/user/to/edit?id=${user.id}">修改</a>
				<a class="btn btn-danger" href="admin/user/remove?id=${user.id}">删除</a>
			</td>
       	</tr>
     </c:forEach>
     
</table>

<br>${pageTool}<br>
</div>
</body>
</html>