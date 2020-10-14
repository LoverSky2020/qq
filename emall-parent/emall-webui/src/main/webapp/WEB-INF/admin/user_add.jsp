<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>客户添加</title>
<meta charset="utf-8" />

</head>
<body>
<div class="container">

	<%@include file="header.jsp"%>
	<link rel="stylesheet" href="admin/css/bootstrap.css" />
	<br><br>
		
	<c:if test="${msg != null}">
		<div class="alert alert-danger" role="alert">${msg}</div>
	</c:if>
	
	<form class="form-horizontal" action="admin/user/save" method="post">
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">用户</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="username" required="required"  value="${user.username}">
			</div>
		</div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">密码</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="password" required="required"  value="${user.password}" >
			</div>
		</div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">姓名</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="name"   value="${user.name}" >
			</div>
		</div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label"  >电话</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="phone" value="${user.phone}" >
			</div>
		</div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label" >地址</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" value="${user.address}" id="input_name" name="address" >
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