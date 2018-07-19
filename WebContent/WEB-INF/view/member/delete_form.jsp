<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<h3>회원탈퇴</h3>
<form action="<%=ctx %>/member.do">
아이디:<input type="text" name="id" /><br>
비밀번호:<input type="password" name="pass" /><br />
						<input type="hidden" name="action" value="delete" />
						<input type="hidden" name="page" value="delete_result"/>
<input type="submit" name="조오오온송" />
</form>
</body>
</html>


