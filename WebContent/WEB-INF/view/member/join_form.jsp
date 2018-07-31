 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/header.jsp" />
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="../common/title_box.jsp" />
			<jsp:include page="../common/login_box.jsp" />
			<jsp:include page="../common/menu_box.jsp" />
		</div>		<!-- header end -->
		<div id="content">

<form id="join_form">
 		아이디 : <input type="text" name="memid"/><br>
 		이름 : <input type="text" name="name" /><br>
 		비밀번호 : <input type="text" name="password" /><br>
 		주민등록번호(ex.940501-2) : <input type="text" name="ssn" />
 		<input type="hidden" name="action" value="join" />
 		<input type="hidden" name="gender"  />
 		<input type="hidden" name="age"  />
 		<br /><br />
 		소속팀
 		<input type = "radio" name="teamid"
 			value="none" checked="checked" /> 없음
 			<input type = "radio" name="teamid"
 			value="A" /> 걍놀자
 			<input type = "radio" name="teamid"
 			value="B"  /> 지은이네
 			<input type = "radio" name="teamid"
 			value="D" /> 왕거북이
 			<input type = "radio" name="teamid"
 			value="C" /> 코딩짱
 			<br /><br />
 			프로젝트역할
 			<select name="roll" id="roll">
 				<option value="leader">팀장</option>
 				<option value="front">프론트개발</option>
 				<option value="back">백단개발</option>
 				<option value="android">안드로이드개발</option>
 				<option value="cheerLeader">응원단장</option>
 			</select>
 			<br/><br />
 			수강과목
 			<input type="checkbox" name="subject"
 				value="java" checked="checked" /> Java
 				<input type="checkbox" name="subject" value="clang" /> C언어
 				<input type="checkbox" name="subject" value="JSP" /> JSP
 				<input type="checkbox" name="subject" value="PHP" /> PHP
 				<input type="checkbox" name="subject" value="nodejs" /> NodeJS
 				<input type="checkbox" name="subject" value="linux" /> Linux
 				<input type="checkbox" name="subject" value="html" /> HTML
 				<input type="checkbox" name="subject" value="spring" /> Spring
 				<br/><br />
 				
 				<input id="join_form_btn" type="button" value="밸류"/>
 	</form>

		</div>		<!-- content end -->
		<div id="footer">
		<jsp:include page="../common/footer.jsp" />
		</div>
	</div>
	<script>
	document.getElementById('join_form_btn').addEventListener('click', function(){
	 	var form = document.getElementById("join_form");
	 	var node = document.createElement('input');
	 	node.innerHTML = '<input type="hidden" name="action" value="join" />',
	 			'<input type="hidden" name="gender" />',
	 			'<input type="hidden" name="age" />'; 
	 	form.appendChild(node);
	 	var x = service.nullChecker([form.memid.value,form.password.value,form.name.value,form.ssn.value]);	
	 	if(x.checker){
			form.action="${context}/member.do";
			form.method="post";
			mem.join(form.ssn.value);
			form.gender.value=mem.getGender();
			form.age.value=mem.getAge();
			form.submit();
		}else{
			alert(x.text);
		}
	});
 	</script>
</body>
</html>

 