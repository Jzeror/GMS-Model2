<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.MemberBean" %>
<%
String ctx = application.getContextPath();
%>
<% 
List<MemberBean> lst = (List)request.getAttribute("memlist");
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Document</title>
</head>
<body>
	<h2 align="Center">팀리스트</h2>
	<table align="Center">
		<tr >
			<td>팀아이디</td>
			<td>아이디</td>
			<td>이름</td>
			<td>역할</td>
			<td>나이</td>
		</tr>
		<% for(MemberBean m: lst){%>
	<tr >
		<td><%=m.getTeamId()%></td>
			<td><%=m.getMemId() %></td>
			<td><%=m.getName()%></td>
			<td><%=m.getRoll()%></td>
			<td><%=m.getAge()%></td>
	</tr>
	

	<% }%>
	</table>
	<br /><br />
		<form action="<%=ctx %>/member.do" align="Center">
		<input type="hidden" name="action" value="move"/>
		<input type="hidden" name="page" value="index"/>
		<input type="submit" value="메인으로 가기"/></form>
</body>
</html>