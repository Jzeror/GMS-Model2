<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String ctx = application.getContextPath();
%>
<!DOCTYPE html>
<html>

<jsp:include page="../common/header.jsp" />

<body>
	<table id="admin-tab-layout" class="margin-auto">
		<tr class="height-140">
			<td colspan="2">
				<img src="resources/img/home/head.png" style="height: 135px; width:100%" alt="" />
			</td>
		</tr>
		<tr id="admin-tab-layout-tr">
			<td id="admin-tab-layout-td" align="center">
			<img src="${img}/home/mug_obj_201601311533061929.jpg"  alt="" />
			</td>
			<td align="center">
				<div id="admin-login-layout">
					<h1>로그인</h1>
					<form id="user-login-form" > 
						id:<br>
						<input type="text" name="name">
						<br>
						pass:<br>
						<input type="password" name="pass"> 
						<br><br>
						<input type="hidden" name="action" value="login" />
						<input type="hidden" name="page" value="index"/>
						<input id="loginFormBtn" type="submit"  value="저언송" >
					</form>
				</div>
			<script>
/* 			mem.setMemId('홍이야');
			alert('유효성 체크값: '+mem.loginValidation()); */
			document.getElementById('loginFormBtn')
			.addEventListener('click', function(){
				
				var form = document.getElementById("user-login-form");
				form.action = "${context}/member.do";
				form.method = "post";
				
			if(service.loginValidation([form.name.value,form.pass.value])){
				form.submit();
				}
			});
			
			</script>
			</td>
		</tr>
		<tr class="height-140">
			<td class="width-80pt" colspan="2"></td>
		</tr>
	</table>
</body>
</html>
