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
		<input type="submit" id="search_id_form_btn" name="아이디 검색" />
	</form>
	<script>
	document.getElementById("search_id_form_btn").addEventListener('click',function(){
	var form = document.getElementById("search_id_form");
	form.action="${context}/member.do";
	form.method="get";
	var id= form.idsearch.value;
	if(id==""){
		alert( "Please provide searchId!" );
		document.form.idsearch.focus() ;
		return false;
	}
	});
	</script>
</body>
</html>