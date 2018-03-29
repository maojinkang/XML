<%@page import="com.info.Userinfo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>网站头部文件</title>
</head>
<body>
	<%
		if(session.getAttribute("uid")!=null){//已登录
			String type = (String)session.getAttribute("userType");
			if(type.equals("teacher")){
				%>
				<jsp:include page="TopFiles/top1.jsp"></jsp:include>
			<%}else{%>
				<jsp:include page="TopFiles/top2.jsp"></jsp:include>
			<%}
		}else{%>
			<jsp:include page="TopFiles/top3.jsp"></jsp:include>
		<%}%>
</body>
</html>