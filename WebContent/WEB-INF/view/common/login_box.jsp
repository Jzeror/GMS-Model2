<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="login_box">
			<a id="goUserLoginForm" >LOGIN</a>
			&nbsp;&nbsp;
			<a id="goJoinForm">JOIN</a>
</div>
<script>
/* var goUserLoginForm = document.getElementById('goUserLoginForm'); */

document.getElementById('goUserLoginForm')
 .addEventListener('click', function(){ // 콜백함수
	 new Common().move('${context}','member','move','user_login_form');
});
document.getElementById('goJoinForm')
.addEventListener('click', function(){ 
	new Common().move('${context}','member','move','join_form');
});
</script>