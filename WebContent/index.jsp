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
					
					<a href="<%=ctx%>/member.do?action=move&page=admin_login_form">관리자로그인</a>
						<form action="<%=ctx%>/member.do">
						<input type="hidden" name="action" value="move"/>
						<input type="hidden" name="page" value="join_form"/>
						<input type="submit" value ="사용자가입"/>
						</form>
						<form action="<%=ctx%>/member.do">
						<input type="hidden" name="action" value="move" />
						<input type="hidden" name="page" value="update_form"/>
						<input type="submit" value ="비번바꾸기"/>
						</form>
						<form action="<%=ctx%>/member.do">
						<input type="hidden" name="action" value="move" />
						<input type="hidden" name="page" value="delete_form"/>
						<input type="submit" value ="계정삭제"/>
						</form>
						<form action="<%=ctx%>/member.do">
						<input type="hidden" name="action" value="move" />
						<input type="hidden" name="page" value="member_list"/>
						<input type="submit" value ="회원 목록"/>
						</form>
						<form action="<%=ctx%>/member.do">
						<input type="hidden" name="action" value="move" />
						<input type="hidden" name="page" value="search_team_form"/>
						<input type="submit" value ="팀이름 검색"/>
						</form>
						<form action="<%=ctx%>/member.do">
						<input type="hidden" name="action" value="move" />
						<input type="hidden" name="page" value="search_id_form"/>
						<input type="submit" value ="아이디 검색"/>
						</form>
			</td>
		</tr>
		<tr class="height-140">
			<td class="width-80pt" colspan="2"></td>
		</tr>
	</table>
</body>
</html>
