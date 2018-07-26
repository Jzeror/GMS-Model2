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
	<h3>회원탈퇴</h3>
	<form id="delete_form">
		아이디:<input type="text" name="id" /><br> 
		비밀번호:<input type="password" name="pass" /><br /> 
		<input type="hidden" name="action" value="delete" /> 
		<input type="hidden" name="page" value="index" /> 
		<input type="submit" id='delete_form_btn' name="조오오온송" />
	</form>
	<script>
	document.getElementById('delete_form_btn').addEventListener('click', function(){
		var form = document.getElementById('delete_form');
		form.action="${context}/member.do";
		form.method="post";
		var id=form.id.value;
		var pass=form.pass.value;
		if(id==""){
			alert( "Please provide your id!" );
			document.form.name.focus() ;
            return false;
		}
		if(pass==""){
			alert( "Please provide your pass!" );
			document.form.pass.focus() ;
            return false;
		}
		form.submit();
	});
	</script>
</body>
</html>


