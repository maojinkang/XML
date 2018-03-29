<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="css/bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="top.jsp"/>
	<div class="row login-box">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-success">
				<div class="panel-heading" align="center">添加学生</div>
				<div class="panel-body">
					<form action="addStudentServlet" method="post" class="form-horizontal">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">系别</label>
							<div class="col-sm-9">
								<input class="form-control" type="text" name="DEPARTMENT"
									id="DEPARTMENT">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">专业</label>
							<div class="col-sm-9">
								<input class="form-control" type="text" name="MAJOR"
									id="MAJOR">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">班级</label>
							<div class="col-sm-9">
								<input class="form-control" type="text" name="CLASS"
									id="CLASS">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">人数</label>
							<div class="col-sm-9">
								<input class="form-control" type="text" name="n"
									id="n">
							</div>
						</div> 
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">学号起始值</label>
							<div class="col-sm-9">
								<input class="form-control" type="text" name="n1"
									id="n1">
							</div>
						</div>
						<div class="col-sm-offset-2 col-sm-8">
							<div class="col-sm-6">
								<input type="button" onclick="window.location.href='index.jsp'" value="返回首页" class="btn btn-primary btn-block">
							</div>
							<div class="col-sm-6">
								<input type="submit" value="下一步" class="btn btn-primary btn-block">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>