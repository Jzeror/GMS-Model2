<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>update_form</title>
</head>
<body>
	<h3>비밀번호 변경</h3>
<form name="update_form" action="${context}/member.do" onsubmit="return moveForm()" method="get" >
아이디 : <input type="text" name="id" /><br>
비밀번호 : <input type="password" name="oldpass" /> <br />
새 비밀번호 : <input type="password" name="newpass" /> <br />
						<input type="hidden" name="action" value="update" />
						<input type="hidden" name="page" value="update_result"/>
<input type="submit" name="즈언송"/>
</form>
</body>
</html>




