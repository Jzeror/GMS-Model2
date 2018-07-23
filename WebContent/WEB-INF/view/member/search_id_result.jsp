<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="domain.MemberBean"%>
<%
String ctx = application.getContextPath();
%>
<% 
MemberBean user = (MemberBean)request.getAttribute("member");
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
		<tr>
			<td><%=user.getMemId() %></td>
			<td><%=user.getTeamId() %></td>
			<td><%=user.getName() %></td>
			<td><%=user.getAge() %></td>
			<td><%=user.getRoll() %></td>
			<td><%=user.getSsn() %></td>
			<td><%=user.getPassword() %></td>
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