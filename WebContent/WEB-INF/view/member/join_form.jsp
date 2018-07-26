<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 
memId, ssn, name, roll, teamId, password;
 -->
 <% 
String ctx = application.getContextPath();
%>
 <!doctype html>
 <html lang="en">
<jsp:include page="../common/header.jsp"/>
 <body>
 	<form id="join_form">
 		아이디 : <input type="text" name="memid"/><br>
 		이름 : <input type="text" name="name" /><br>
 		비밀번호 : <input type="password" name="password" /><br>
 		주민등록번호(ex.940501-2) : <input type="text" name="ssn" />
 		<input type="hidden" name="action" value="join" />
 		<input type="hidden" name="page" value="join_result" />
 		<input id="join_form_btn" type="button" value="밸류"/>
 	</form>
 	<script>
	document.getElementById('join_form_btn').addEventListener('click', function(){
		var form = document.getElementById('join_form');
		var mem = new Mem();
		form.action="${context}/member.do";
		form.method="post";
		mem.setMemId(form.memid.value);
		if(mem.joinValidation()){
		form.submit();
		}
	});
 	</script>
 </body>
 </html>