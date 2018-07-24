<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.MemberBean" %>
<%
String ctx = application.getContextPath();
List<MemberBean> lst= (List)request.getAttribute("list");
%>


<!doctype html>
<html lang="en">
<head>
<link rel="stylesheet" href="../../css/style.css" />
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
<h2 align= "Center">회원리스트</h2>
<table id="member-list" align="Center">
<tr>
	<td>아이디</td>
	<td>팀아이디</td>
	<td>이름</td>
	<td>패스워드</td>
	<td>역할</td>
	<td>나이</td>
	<td>주민등록</td>
</tr>

<% for(MemberBean m: lst){ %>
	<tr>
	
			<td><%=m.getMemId() %></td>
			<td><%=m.getTeamId()%></td>
			<td><%=m.getName()%></td>
			<td><%=m.getPassword()%></td>
			<td><%=m.getRoll()%></td>
			<td><%=m.getAge()%></td>
			<td><%=m.getSsn()%></td>
	</tr>
	<% } %>
</table>
<form action="<%=ctx %>/member.do">
<input type="hidden" name="action" value="list"/>
<input type="hidden" name="page" value="index"/>
<input type="submit" value="홈으로 가기"/>
</form>

</body>
</html>



