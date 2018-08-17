<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content_box">
<form id="update_id" name="update_name">
			<table>
				<tr>
					<td colspan="3" rowspan="3">
					<img
						src="${img}/upload/${imgp}" width="130" height="200"
						alt="" />
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
					<td colspan="2"><input type="text" name="pass" /></td>
				</tr>
				<tr>
					<td colspan="3"><input type="button" id="mypageMoveBtn"
						value="♥내페이지로 돌아가기" /></td>
					<td>나이</td>
					<td colspan="2">${user.age}세</td>
				</tr>
				<tr>
					<td>현재팀: ${user.teamId}</td>
					<td colspan="2"> 		
						<input type = "radio" id="teamid_1" name="teamId"
							value="A" /> 걍놀자
						<input type = "radio" id="teamid_2" name="teamId"
							value="B"  /> 지은이네
						<input type = "radio" id="teamid_3" name="teamId"
							value="D" /> 왕거북이
						<input type = "radio" id="teamid_4" name="teamId"
							value="C" /> 코딩짱</td>
					<td>성별</td>
					<td colspan="2">${user.gender}</td>
				</tr>
				<tr>
					<td>현재 역할 : ${user.roll}</td>
					<td colspan="2">
					<select name="roll" id="roll">
							<option value="leader">팀장</option>
							<option value="front">프론트개발</option>
							<option value="back">백단개발</option>
							<option value="android">안드로이드개발</option>
							<option value="cheerLeader">응원단장</option>
					</select>
					</td>
					<td>주민등록번호</td>
					<td colspan="2">${user.ssn}</td>
				</tr>
			</table>
			<input type="hidden" name="exTeamid" value='${user.teamId}'/>
			<input type="hidden" name="exRoll" value='${user.roll}'/>
			<input type="hidden" name="exPass" value='${user.password}'/>
			<input type="hidden" name="memId" value=${user.memId } /> 
			<input type="hidden" name="action" value="modify" /> 
			<input type="hidden" name="page" value="modify" /> 
			<input type="button" id="updateConfirmBtn" value="수정확인" />
		</form>
		
<form method="post" enctype="multipart/form-data" action="${context}/member.do?action=fileupload&page=retrieve">
  파일업로드: <input type="file" name="upfile"><br/>
   		  <input type="submit" value="파일업로드">
</form>
</div>		
