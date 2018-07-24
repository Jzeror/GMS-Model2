<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = application.getContextPath();%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>

	<form name="search_team_form" action="${context}/member.do" onsubmit="return moveForm" method="get">
	<h2>팀 검색 </h2>
	<input type="text" name="search"/>
	<input type="hidden" name="action" value="search" />
	<input type="hidden" name="page" value="search_team_result"/>
	<input type="submit" name="검색"/>
	</form>
	
</body>
</html>