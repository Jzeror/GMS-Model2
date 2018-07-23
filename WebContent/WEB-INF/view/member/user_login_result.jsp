<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Document</title>
</head>
<body>
	성공
	<form action="<%=ctx %>/member.do">
	<input type="hidden" name="action" value="move" />
	<input type="hidden" name="page" value="index" />
	<input type="submit" value ="메인으로 가기"/>
	</form>
	
	
	
	
<!-- 
	실패
	<form action="../../main.jsp">
	<input type="submit" value ="메인으로 가기"/>
	</form> -->




</body>
</html>