<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改密码</title>
<link href="css/bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<script type="text/javascript">
function validate() {
	var password = document.getElementById("password");
	var password1 = document.getElementById("password1");
	if (password.value == "") {
		alert("密码不能为空！");
		password.focus();
		return false;
	} else if (password.length<6 || password.length>12) {
		alert("密码长度不符合要求，请输入6-12位密码!");
		password.focus();
		return false;
	}
	if (password.value != password1.value) {
		alert("两次输入密码不相同！");
		password.focus();
		return false;
	}
	return true;
}
function changeValidateCode() {
	document.getElementById("validateCode").src = "ValidateCodeServlet?rand="
			+ Math.random();
}
</script>
<body>
	<jsp:include page="top.jsp"/>
	<div class="row login-box">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-success">
			<div class="panel-body">
			<form action="UpDataPServlet" method="post" class="form-horizontal" onsubmit="return validate();">
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">原密码</label>
					<div class="col-sm-9">
						<input class="form-control" type="password" name="password2" id="password2">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-9">
						<input class="form-control" type="password" name="password" id="password">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">再次输入</label>
					<div class="col-sm-9">
						<input class="form-control" type="password" name="password1" id="password1">
					</div>
				</div>
				<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">验证码</label>
					<div class="col-sm-3">
						<input class="form-control" type="text" name="verifyCode">
					</div>
					<div class="col-sm-4" >
						<img src="ValidateCodeServlet" id="validateCode" title="点击换一换" onclick="changeValidateCode()">
						<a href="javascript:changeValidateCode();">看不清？</a>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="col-sm-4">
							<input type="submit" value="提交" class="btn btn-primary btn-block">
						</div>
					</div>
				</div>
			</form>
			</div>
			</div>
		</div>
		</div>
</body>
</html>