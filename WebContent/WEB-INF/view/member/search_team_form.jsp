<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = application.getContextPath();%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>

	<form id="search_team_form">
	<h2>팀 검색 </h2>
	<input type="text" name="search"/>
	<input type="hidden" name="action" value="search" />
	<input type="hidden" name="page" value="search_team_result"/>
	<input type="submit" id="search_team_form_btn" name="검색"/>
	</form>
	
	<script>
	document.getElementById('search_team_form_btn').addEventListener('click',function(){
		var form=document.getElementById('search_team_form');
		form.action="${context}/member.do";
		form.method='get';
		var teamId= form.search.value;
		if(teamId==""){
			alert( "Please provide teamId!" );
			document.form.search.focus() ;
			return false;
		}
	});
	</script>
</body>
</html>