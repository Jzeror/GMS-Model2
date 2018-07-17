<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>user_login</title>
<link rel="stylesheet" href="../../css/style.css" />
</head>
<body>
	<table id="user-tab-layout" class="margin-auto">
		<tr class="height-140">
			<td colspan="2"><img src="../../img/home/head.png"
				style="height: 135px; width: 100%" alt="" /></td>
		</tr>
		<tr id="user-tab-layout-tr">
			<td id="user-tab-layout-td" align="center"><img
				src="../../img/home/2016-01-24_12.36.59.png" alt="" /></td>
			<td align="center">

				<div id="user-login-layout">
					<h1>로그인</h1>
					<form id="user-login-form" action="user_login_result.jsp">
						USER-ID:<br> <input type="text" name='USER-ID' value='cc'>
						<br /> USER-PASS:<br> <input type="text" name='USER-PASS'
							value='dd'> <br /> <br /> <input type="submit" />
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
