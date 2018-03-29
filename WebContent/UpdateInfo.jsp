<%@page import="com.info.Userinfo"%>
<%@page import="com.info.UinfoBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel=stylesheet href="css/bootstrap/css/bootstrap.css">
</head>
<body>
	<jsp:include page="top.jsp" />
	<%
	int id = Integer.valueOf(request.getParameter("id"));
	String name = Userinfo.findName(id);
	UinfoBean info= UinfoBean.findUbyID(id); 
	request.setAttribute("studentinfo", info);
	%>
	<jsp:useBean id="studentinfo" scope="request"
		class="com.info.UinfoBean"></jsp:useBean>
	<jsp:setProperty property="*" name="studentinfo" />
	<div>
	<div class="col-md-8 col-md-offset-2">
	
		<div class="panel panel-default">
			<!-- 标题 -->
			<div class="panel-heading">
				<h3 class="panel-title">个人信息</h3>
			</div>

			<div class="panel-body">

				<div class="panel-body">
					<!-- 表单 -->
					<form action="StudentinfoServlet?id=<%=id%>&&type=update" method="post" class="form-horizontal">
						
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">学号</label>
							<div class="col-sm-6">
							<%=name %>
							</div>
						</div>
						
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-6">
							<input class="form-control" type="text" name="name" value="<jsp:getProperty property="name" name="studentinfo"/>">
							</div>
						</div>
						
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">院系</label>
							<div class="col-sm-6">
							<jsp:getProperty property="department" name="studentinfo"/>
							</div>
						</div>
						
						<div class="form-group ">
						<label for="inputPassword3" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-10">
							<div class="radio-inline">
								<label>
									<input type="radio" name="sex" checked="checked" value="男">男
								</label>
							</div>
							<div class="radio-inline">
								<label>
									<input type="radio" name="sex" value="女">女
								</label>
							</div>
						</div>
						</div>
						
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">专业</label>
							<div class="col-sm-6">
							<jsp:getProperty property="major" name="studentinfo"/>
							</div>
						</div>
						
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">班级</label>
							<div class="col-sm-6">
							<jsp:getProperty property="class_u" name="studentinfo"/>
							</div>
						</div>
						
						<div class="form-group col-sm-12" align="center">

								<input type="submit" value="提交" class="btn btn-primary ">
						</div>			
					</form>
				</div>
			</div>
		</div>
		
		</div>
		
	</div>
</body>
</html>