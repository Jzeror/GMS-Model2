<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String ctx = application.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>admin_login</title>
<link rel="stylesheet" href="../../css/style.css" />
</head>
<body>
	<table id="admin-tab-layout" class="margin-auto">
		<tr class="height-140">
			<td colspan="2">
				<img src="../../img/home/head.png" style="height: 135px; width:100%" alt="" />
			</td>
		</tr>
		<tr id="admin-tab-layout-tr">
			<td id="admin-tab-layout-td" align="center">
			<img src="../../img/home/mug_obj_201601311533061929.jpg"  alt="" />
			</td>
			<td align="center">
		<div id="admin-login-layout">
			<h1>로그인</h1>
			<form id=" admin-login-form" action="<%=ctx%>/member.do">  
				admin-id:<br>
				<input type="text" name="adminid"/>
				<br>
				admin-pass:<br>
				<input type="password" name="adminpass"> 
				<br><br>
				<input type="hidden" name="action" value="login" />
				<input type="hidden" name="page" value="admin_login_result"/>
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
