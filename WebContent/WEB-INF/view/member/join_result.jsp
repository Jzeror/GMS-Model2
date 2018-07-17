<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>joinresult</title>
</head>
<body>
	가입되셨습니다
	<form action="../login/admin_login_form.jsp">
	<input type="submit" value ="로그인하러 가기"/>
	</form>
		<form action="<%=ctx %>/member.do">
			<input type="hidden" name="action" value="move" />
	<input type="hidden" name="page" value="index" />
	<input type="submit" value ="메인으로 가기"/>
	</form>	
</body>
</html>