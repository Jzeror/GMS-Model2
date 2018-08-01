<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu_box">
	<ul id="menu">
		<li><a id="goHome" >HOME</a></li>
		<li><a >ABOUT</a></li>
		<li><a id="goAdmin" >ADMIN</a></li>
	</ul>
</div>
<script>
document.getElementById('goHome')
.addEventListener('click', function(){ // 콜백함수
	router.move({ context : '${context}',
		domain : 'member',
		action : 'move',
		page : 'index'});
});
document.getElementById('goAdmin')
.addEventListener('click', function(){ 
	admin.check("${context}");
});


</script>
