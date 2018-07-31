<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String ctx = application.getContextPath();
String a = (String)request.getAttribute("createResult");
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>joinresult</title>
</head>
<body>
	<%=a %>
	<form id="moveMain">
	<input type="hidden" name="action" value="move" />
	<input type="hidden" name="page" value="index" />
	<input type="button" id="moveMainBtn" value="메인으로가기"/>
	</form>
	
	<script>
	document.getElementById("moveMainBtn").addEventListener('click', function(){
		var form = document.getElementById("moveMain");
		form.action = "${context}/member.do";
		form.method = "get";
		form.submit();
	});
	</script>
</body>
</html>