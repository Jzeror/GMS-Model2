<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<% 
String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>main</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<table id="main-tab-layout" class="margin-auto">
		<tr class="height-140">
			<td colspan="2"><img src="img/home/head.png"
				style="height: 135px; width: 100%" alt="" /></td>
		</tr>
		<tr id="main-tab-layout-tr">
			<td id="main-tab-layout-td" align="center"><img
				src="img/home/htm_20150216175457142.jpg" alt="" /></td>
			<td align="center">
						<br />
						<h4>현재 회원 수 : <mark>5078명</mark></h4>			
						<br>
					
					<a href="<%=ctx%>/member.do?action=move&page=admin_login_form">관리자로그인</a><br />
						<a href="<%=ctx%>/member.do?action=move&page=join_form"> <button>회원가입</button> </a><br />
						<a href="<%=ctx%>/member.do?action=move&page=update_form"> <button>비번바꾸기</button> </a><br />
						<a href="<%=ctx%>/member.do?action=move&page=delete_form"> <button>계정삭제</button> </a><br />
						<a href="<%=ctx%>/member.do?action=move&page=member_list"> <button>회원 목록</button> </a><br />
						<a href="<%=ctx%>/member.do?action=move&page=search_team_form"> <button>팀이름 검색</button> </a><br />
						<a href="<%=ctx%>/member.do?action=move&page=search_id_form"> <button>아이디 검색</button> </a><br />

			</td>
		</tr>
		<tr class="height-140">
			<td class="width-80pt" colspan="2"></td>
		</tr>
	</table>
</body>
</html>
