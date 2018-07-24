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
	<form name="search_id_form" action="${context}/member.do" onsubmit="return moveForm()" method="get">
		<input type="text" name="idsearch" />
		 <input type="hidden" name="action" value="retrieve" />
		<input type="hidden" name="page" value="search_id_result" /> 
		<input type="submit" name="아이디 검색" />
	</form>
</body>
</html>