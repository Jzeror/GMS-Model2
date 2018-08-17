<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="content-box">
<table id="admin-tab-layout" class="margin-auto">
	<tr class="height-140">
		<td colspan="2"></td>
	</tr>
	<tr style="height: 500px; width: 100%">
		<td id="admin-tab-layout-td" align="center">
			<table>
			<tr>
				<td colspan="3" rowspan="3">
				 <img src="${img}/upload/${imgp}" width="130" height="200"	alt="" />
				</td>
				<td>ID</td>
				<td colspan="2">${user.memId}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td colspan="2">${user.name}</td>
			</tr>
			<tr>
				<td>비번</td>
				<td colspan="2">********</td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="button" id="moveToModify"value="업데이트하러가기">
					<input type="button" id="mypageMoveToDelete" value="삭제하러가기">
				</td>
				<td>나이</td>
				<td colspan="2">${user.age}세</td>
			</tr>
			<tr>
				<td>팀 아이디</td>
				<td colspan="2">${user.teamId}</td>

				<td>성별</td>
				<td colspan="2">${user.gender}</td>
			</tr>
			<tr>
				<td>역할</td>
				<td colspan="2">${user.roll}</td>
				<td>주민등록번호</td>
				<td colspan="2">${user.ssn}</td>
			</tr>
			</table>
		</td>
		<td align="center">
			<div id="admin-login-layout">
				<h2>마이페이지</h2>
		</td>
	</tr>
	<tr style="height: 140px; width: 100%">
		<td class="width-80pt" colspan="2"></td>
	</tr>
</table>
</div>
