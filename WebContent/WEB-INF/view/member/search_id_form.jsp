<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<form action="<%=ctx %>/member.do">
	<input type="text" name="idsearch"/>
	<input type="submit" name="아이디 검색" />			
				<input type="hidden" name="action" value="move" />
						<input type="hidden" name="page" value="search_id_result"/>
	</form>
</body>
</html>