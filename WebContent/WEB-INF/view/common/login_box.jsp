<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="login_box">
			<a id="goUserLoginForm" >LOGIN</a>
			&nbsp;&nbsp;
			<a id="goJoinForm">JOIN</a>
</div>
<script>
/* var goUserLoginForm = document.getElementById('goUserLoginForm'); */

document.getElementById('goUserLoginForm')
 .addEventListener('click', function(){
	 router.move({
		 context :'${context}',
		 domain : 'member',
		 action : 'move',
		 page : 'user_login_form'});
});

document.getElementById('goJoinForm')
.addEventListener('click', function(){ 
	var x = {context :'${context}', 
			domain: 'member',
			action: 'move',
			page: 'join_form'};
	router.move(x);
});
</script>