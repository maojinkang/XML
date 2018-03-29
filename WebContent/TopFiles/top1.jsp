<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>网站头部文件</title>
<link rel=stylesheet href="css/bootstrap/css/bootstrap.css"/>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/resume.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"/>
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%String name = (String)session.getAttribute("username"); %>
	<nav class="navbar navbar-default">
     <div class="navbar-header">
       <a class="navbar-brand" href="#">欢迎来到简易的学生管理系统</a>
     </div>
     <div class="collapse navbar-collapse">

			<ul class="nav navbar-nav">
			<li><a href="index.jsp">首页</a></li>
			
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					信息维护
					<b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="updatePWD.jsp">修改密码</a></li>
				</ul>
			</li>
			
		</ul>
		
		<ul class="nav navbar-nav">
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					信息查询
					<b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="allStuendt.jsp?page=one">学生信息</a></li>
					<li class="divider"></li>
					<li><a href="add1.jsp">添加学生</a></li>
					<li class="divider"></li>
					<li><a href="allStuendt.jsp?page=two">学生成绩管理</a></li>
				</ul>
			</li>
		</ul>
		
			
			<ul class="nav navbar-nav  navbar-right">
				<li>
					<a href="#"><span class="glyphicon glyphicon-user" style="font-size: 18px;"> <%=name %></span></a></li>
				<li>
					<a href="out.jsp"><span class="glyphicon glyphicon-send" style="font-size: 18px;"> 安全退出</span></a></li>
			</ul>
     </div>
     
     
  </nav>
  
</body>
</html>