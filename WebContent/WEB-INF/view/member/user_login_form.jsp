<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String ctx = application.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>admin_login</title>
<link rel="stylesheet" href="resources/css/style.css" />
</head>
<body>
	<table id="admin-tab-layout" class="margin-auto">
		<tr class="height-140">
			<td colspan="2">
				<img src="resources/img/home/head.png" style="height: 135px; width:100%" alt="" />
			</td>
		</tr>
		<tr id="admin-tab-layout-tr">
			<td id="admin-tab-layout-td" align="center">
			<img src="resources/img/home/mug_obj_201601311533061929.jpg"  alt="" />
			</td>
			<td align="center">
				<div id="admin-login-layout">
					<h1>로그인</h1>
					<form id=" admin-login-form" name="user_login_form" action="${context}/member.do"
					onsubmit="return moveForm()" method="get">  
						id:<br>
						<input type="text" name="name">
						<br>
						pass:<br>
						<input type="password" name="pass"> 
						<br><br>
						<input type="hidden" name="action" value="login" />
						<input type="hidden" name="page" value="index"/>
						<input type="submit" value="저언송" >
					</form>
				</div>
			</td>
		</tr>
		<tr class="height-140">
			<td class="width-80pt" colspan="2"></td>
		</tr>
	</table>
</body>
</html>
