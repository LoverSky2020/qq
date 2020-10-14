<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>管理员添加</title>
<meta charset="utf-8" />

</head>
<body>
<div class="container">

	<%@include file="header.jsp"%>
	<link rel="stylesheet" href="admin/css/bootstrap.css" />
	<br><br>
	
	<c:if test="${requestScope.exception.message != null}">
		<div class="alert alert-danger" role="alert">${requestScope.exception.message}</div>
	</c:if>
	
	<form class="form-horizontal" action="admin/save" method="post">
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">用户名</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" value="${admin.username}" id="input_name" name="username" required="required">
			</div>
		</div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">密码</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" value="${admin.password}" id="input_name" name="password" required="required">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-10">
				<button type="submit" class="btn btn-success">提交保存</button>
			</div>
		</div>
	</form>
	
</div>
</body>
</html>