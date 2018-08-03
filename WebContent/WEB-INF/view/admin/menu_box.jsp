<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="menu_box">
	<ul id="menu">
		<li><a id="goHome" >HOME</a></li>
		<li><a href="">ABOUT</a></li>
		<li><a id="goAdmin">ADMIN</a></li>
		<li><a id="goSearchId" >아이디찾기</a></li>
		<li><a id="goList" >회원목록</a></li>
		<li><a id="goDelete">삭제</a></li>
		<li><a id="gorandom">랜덤아이디</a></li>
	</ul>
</div>
<script>
document.getElementById('goHome').addEventListener('click',function(){
	router.move({ context : "${context}",
		domain : "member",
		action : "move",
		page : "index"});
});
document.getElementById('goAdmin').addEventListener('click',function(){
	router.move({ context : "${context}",
		domain : "admin",
		action : "move",
		page : "main"});
});
document.getElementById('goSearchId').addEventListener('click',function(){
	router.move({ context : "${context}",
		domain : "member",
		action : "move",
		page : "search_id_form"});
	
});
document.getElementById('goList').addEventListener('click',function(){
	router.move({ context : "${context}",
		domain : "member",
		action : "list",
		page : "member_list"});
	
});
document.getElementById('goDelete').addEventListener('click',function(){
	router.move({context : "${context}",
		domain : "member",
		action : "move",
		page : "delete_form"});
	
});
document.getElementById('gorandom').addEventListener('click',function(){
	router.move({context : "${context}",
		domain : "member",
		action : "count",
		page : "index"});
	
});
</script>