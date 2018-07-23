<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="<%=application.getContextPath()%>" />
<div id="login_box">
			<a href="${context}/member.do?action=move&page=user_login_form">LOGIN</a>
			&nbsp;&nbsp;<a href="${context}/member.do?action=move&page=join_form">JOIN</a>
		</div>