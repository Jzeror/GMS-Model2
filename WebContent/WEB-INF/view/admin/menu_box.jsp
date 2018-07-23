<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="<%=application.getContextPath()%>" />
<div id="menu_box">
			<ul id="menu">
				<li><a href="${context}/member.do?action=move&page=index">HOME</a></li>
		<li><a href="">ABOUT</a></li>
		<li><a href="${context}/admin.do?action=move&page=main">ADMIN</a></li>
		<li><a href="${context}/member.do?action=move&page=search_id_form">아이디찾기</a></li>
		<li><a href="${context}/member.do?action=move&page=member_list">회원목록</a></li>
	</ul>
</div>