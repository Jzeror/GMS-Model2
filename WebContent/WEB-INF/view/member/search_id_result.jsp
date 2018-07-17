<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<table align="Center">
		<tr>
			<td>ID</td>
			<td>TEAM_ID</td>
			<td>NAME</td>
			<td>AGE</td>
			<td>ROLL</td>
			<td>SSN</td>
			<td>PASSWORD</td>
		</tr>
	</table>
	<br /><br />
	<form action="<%=ctx %>/member.do" align="Center">
	<input type="hidden" name="action" value="move"/>
<input type="hidden" name="page" value="index"/>
	<input type="submit" value="메인으로 가기"/>
	</form>
</body>
</html>