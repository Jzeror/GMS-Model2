<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="menu_box">
	<ul id="menu">
		<li><a onclick="common.move('member','move','index')">HOME</a></li>
		<li><a href="">ABOUT</a></li>
		<li><a onclick="common.move('admin','move','main')">ADMIN</a></li>
		<li><a onclick="common.move('member','move','search_id_form')">아이디찾기</a></li>
		<li><a onclick="common.move('member','list','member_list')">회원목록</a></li>
		<li><a onclick="common.move('member','move','delete_form')">삭제</a></li>
	</ul>
</div>