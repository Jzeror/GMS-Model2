<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>mypage</title>
<style>
table, tr, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
.width-full{width: 100%}
.width-80pt{width: 80%}
.height-full{height: 100% }
.margin-auto{margine : 0 auto}
.height-140{height:140px}
#main-tab-layout-td{width:80%;}
#main-tab-layout-tr{height:480px; width:80%;}
#main-tab-layout{heigth:760px; width:100%}
</style>
</head>
<body>
	<table id="main-tab-layout" class="margin-auto">
		<tr class="height-140">
			<td colspan="2">
				<img src="../../img/home/head.png" style="height: 135px; width:100%" alt="" />
			</td>
		</tr>
		<tr id="main-tab-layout-tr">
			<td style="width: 80%"><p style="font-size:900% " align="center">MyPage</p></td>
			<td><a href="../home/main.html"><p align="center">로그아웃</p></a>
		</tr>
		<tr class="height-140">
			<td class="width-80pt" colspan="2"></td>
		</tr>
	</table>
</body>
</html>






