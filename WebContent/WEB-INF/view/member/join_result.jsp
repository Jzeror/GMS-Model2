<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String ctx = application.getContextPath();
String a = (String)request.getAttribute("createResult");
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>joinresult</title>
</head>
<body>
	<%=a %>
</body>
</html>