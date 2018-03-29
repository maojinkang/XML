<%@page import="com.info.Achievementinfo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel=stylesheet href="css/bootstrap/css/bootstrap.css">
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
	<jsp:useBean id="CJinfo" scope="request"
		class="com.info.Achievementinfo"></jsp:useBean>
	<jsp:setProperty property="*" name="CJinfo" />
		<div class="col-md-10 col-md-offset-1">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>语文</th>
							<th>数学</th>
							<th>英语</th>
							<th>java程序设计</th>
							<th>c语言</th>
							<th>xml</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><jsp:getProperty property="chinese_A" name="CJinfo"/></td>
                      		<td><jsp:getProperty property="math" name="CJinfo"/></td>
                       		<td><jsp:getProperty property="english" name="CJinfo"/></td>
                       		<td><jsp:getProperty property="java" name="CJinfo"/></td>
                       		<td><jsp:getProperty property="c" name="CJinfo"/></td>
                       		<td><jsp:getProperty property="xml" name="CJinfo"/></td>
						</tr>
					</tbody>
				</table>
			<br>
		</div>
		<a href="#" onclick="history.back()">返回上一页</a>
</body>
</html>