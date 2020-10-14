<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<title>类目编辑</title>
<meta charset="utf-8"/>

</head>
<body>
<div class="container">

	<%@include file="header.jsp"%>
	<link rel="stylesheet" href="admin/css/bootstrap.css"/>
	<br><br>
	
	<form class="form-horizontal" action="admin/type/edit" method="post">
		<input type="hidden" name="id" value="${type.id}">
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">名称</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="name" value="${type.name}" required="required">
			</div>
		</div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">序号</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="num" value="${type.num}">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-10">
				<button type="submit" class="btn btn-success">提交修改</button>
			</div>
		</div>
	</form>
	
	<span style="color:red;">${msg}</span>
	
</div>	
</body>
</html>