<%@page import="com.info.Userinfo"%>
<%@page import="java.util.List"%>
<%@page import="com.info.UinfoBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel=stylesheet href="css/bootstrap/css/bootstrap.css">
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/resume.css" type="text/css" rel="stylesheet" />
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="/scripts/jquery.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%String page1 = request.getParameter("page");
if(page1.equals("one")){%>
<jsp:include page="top.jsp"></jsp:include>
	<div  class="row login-box">
       <div class="col-md-8 col-md-offset-2">
            <div class='panel panel-primary'>
                 <div class="panel-heading">学生管理 </div>
                 <table class="table table-hover table-bordered" contenteditable="true">
                   <thead>
                     <tr>
                       <th>学号</th>
                       <th>姓名</th>                       
                       <th>操作</th>
                     </tr>
                   </thead>
                   <tbody>
                    <%List<Userinfo> list = Userinfo.selectAll();
                    for(Userinfo b : list){ %>   
                    <tr>
                    
                       <td><%=b.getName() %></td>
                       <td><%=UinfoBean.findName(b.getId()) %></td>                                      
                       <td>                  		
                       		<a href="Sinformation.jsp?id=<%=b.getId() %>" class="btn btn-info btn-xs" role="button">查看信息</a>
                       		<a href="StudentinfoServlet?id=<%=b.getId()%>&&type=delete" class="btn btn-danger btn-xs" role="button">删除学生</a>
                       </td>
                     </tr>
					<%} %>
                   </tbody>
                 </table>				
            </div>
            <br>				
       </div>
   </div>
   <%}else{ %>
   	<jsp:include page="top.jsp"></jsp:include>
	<div  class="row login-box">
       <div class="col-md-8 col-md-offset-2">
            <div class='panel panel-primary'>
                 <div class="panel-heading">学生管理 </div>
                 <table class="table table-hover table-bordered" contenteditable="true">
                   <thead>
                     <tr>
                       <th>学号</th>
                       <th>姓名</th>                       
                       <th>操作</th>
                     </tr>
                   </thead>
                   <tbody>
                    <%List<Userinfo> list = Userinfo.selectAll();
                    for(Userinfo b : list){ %>   
                    <tr>
                    
                       <td><%=b.getName() %></td>
                       <td><%=UinfoBean.findName(b.getId()) %></td>                                      
                       <td>                  		
                       		<a href="Ainfo?id=<%=b.getId() %>&&type=select&&class_id=1" class="btn btn-info btn-xs" role="button">查看成绩</a>
                       		<a href="saveCJ.jsp?id=<%=b.getId() %>&&type=save&&class_id=1" class="btn btn-danger btn-xs" role="button">添加成绩</a>
                       		<a href="saveCJ.jsp?id=<%=b.getId() %>&&type=update&&class_id=1" class="btn btn-danger btn-xs" role="button">修改成绩</a>
                       </td>
                     </tr>
					<%} %>
                   </tbody>
                 </table>				
            </div>
            <br>				
       </div>
   </div>
   <%} %>
</body>
</html>