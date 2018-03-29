<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link href="css/bootstrap/css/bootstrap.css" rel="stylesheet">
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<%int id = Integer.valueOf(request.getParameter("id"));
	int class_id = Integer.valueOf(request.getParameter("class_id"));%>
	<div class="row login-box">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-success">
			<div class="panel-heading" align="center"></div>
			<div class="panel-body">
			<%String type = request.getParameter("type");
			if(type.equals("save")){%>
			<form action="Ainfo?type=save&&id=<%=id %>&&class_id=<%=class_id %>" method="post" class="form-horizontal" onsubmit="return validate();">
			<%}else{ %>
			<form action="Ainfo?type=update&&id=<%=id %>&&class_id=<%=class_id %>" method="post" class="form-horizontal" onsubmit="return validate();">
			<%} %>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">语文</label>
					<div class="col-sm-9">
						<select class="form-control" name="chinese">
  							<option value="不及格">不及格</option>
  							<option value="及格">及格</option>
  							<option value="优秀">优秀</option>
  						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">数学</label>
					<div class="col-sm-9">
						<select class="form-control" name="math">
  							<option value="不及格">不及格</option>
  							<option value="及格">及格</option>
  							<option value="优秀">优秀</option>
  						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">英语</label>
					<div class="col-sm-9">
						<select class="form-control" name="english">
  							<option value="不及格">不及格</option>
  							<option value="及格">及格</option>
  							<option value="优秀">优秀</option>
  						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">java</label>
					<div class="col-sm-9">
						<select class="form-control" name="java">
  							<option value="不及格">不及格</option>
  							<option value="及格">及格</option>
  							<option value="优秀">优秀</option>
  						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">c语言</label>
					<div class="col-sm-9">
						<select class="form-control" name="c">
  							<option value="不及格">不及格</option>
  							<option value="及格">及格</option>
  							<option value="优秀">优秀</option>
  						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">xml</label>
					<div class="col-sm-9">
						<select class="form-control" name="xml">
  							<option value="不及格">不及格</option>
  							<option value="及格">及格</option>
  							<option value="优秀">优秀</option>
  						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12" align="center">
						<div class="col-sm-offset-4 col-sm-4">
						<%if(type.equals("save")){%>
							<input type="submit" value="添加成绩" class="btn btn-primary btn-block">
							<%}else{ %>
							<input type="submit" value="修改成绩" class="btn btn-primary btn-block">
							<%} %>
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