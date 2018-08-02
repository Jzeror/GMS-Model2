<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/header.jsp" />
<body>

	<table id="admin-tab-layout" class="margin-auto">
		<tr class="height-140">
			<td colspan="2">
				<img src="resources/img/home/head.png" style="height: 135px; width:100%" alt="" />
			</td>
		</tr>
		<tr style="height: 500px; width: 100%">
			<td id="admin-tab-layout-td" align="center">

	<table>
		<tr>
			<td colspan="3" rowspan="3"><img src="${img}/mypage/${user.memId}.jpg" width="130" height="200" alt="" /></td>
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
				<input type="button" id="mypageMove" value="업데이트하러가기">
				<!-- <a id="mypageMoveToDelete">삭제하러가기</a> -->
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
				</div>
			<script>
			document.getElementById('loginFormBtn')
			.addEventListener('click', function(){
			var x = service.nullChecker([document.user_login_form_name.name.value, document.user_login_form_name.pass.value]);
			if(x.checker){
				var form = document.getElementById("user-login-form-id");
				form.action = "${context}/member.do";
				form.method = "post";
				form.submit();
				}else{
					alert(x.text);
					
				}
			});
			</script>
			</td>
		</tr>
		<tr style="height: 140px; width: 100%">
			<td class="width-80pt" colspan="2"></td>
		</tr>
	</table>






</body>
<script>
document.getElementById("mypageMoveToDelete")
.addEventListener('click', function(){
	 router.move({
		 context :'${context}',
		 domain : 'member',
		 action : 'move',
		 page : 'delete_form'});
});

			document.getElementById('mypageMove').addEventListener('click', function(){
				router.move({
					 context :'${context}',
					 domain : 'member',
					 action : 'move',
					 page : 'update_form'});
			});
			</script>
</html>