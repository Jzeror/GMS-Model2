<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/header.jsp" />
<body>
	<table id="admin-tab-layout" class="margin-auto">
		<tr class="height-140">
			<td colspan="2"><img src="resources/img/home/head.png"
				style="height: 135px; width: 100%" alt="" /></td>
		</tr>
		<tr style="height: 500px; width: 100%">
			<td id="admin-tab-layout-td" align="center">


				<form id="update_id" name="update_name">
					<table>
						<tr>
							<td colspan="3" rowspan="3"><img
								src="${img}/mypage/${user.memId}.jpg" width="130" height="200"
								alt="" /></td>
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
							<td colspan="3"><input type="button" id="mypageMove"
								value="♥내페이지로 돌아가기" /></td>
							<td>나이</td>
							<td colspan="2">${user.age}세</td>
						</tr>
						<tr>
							<td>현재팀: ${user.teamId}</td>
							<td colspan="2"> 		
 							<input type = "radio" id="teamid_1" name="teamid"
 								value="A" /> 걍놀자
 							<input type = "radio" id="teamid_2" name="teamid"
 								value="B"  /> 지은이네
 							<input type = "radio" id="teamid_3" name="teamid"
 								value="D" /> 왕거북이
 							<input type = "radio" id="teamid_4" name="teamid"
 								value="C" /> 코딩짱</td>




							<td>성별</td>
							<td colspan="2">${user.gender}</td>
						</tr>
						<tr>
							<td>현재 역할 : ${user.roll}</td>
							<td colspan="2"><select name="roll" id="roll">
									<option value="" selected="selected">선택하세요</option>
									<option value="leader">팀장</option>
									<option value="front">프론트개발</option>
									<option value="back">백단개발</option>
									<option value="android">안드로이드개발</option>
									<option value="cheerLeader">응원단장</option>
							</select></td>
							<td>주민등록번호</td>
							<td colspan="2">${user.ssn}</td>
						</tr>
					</table>
					<input type="hidden" name="memId" value=${user.memId } /> <input
						type="hidden" name="action" value="update" /> <input
						type="hidden" name="page" value="mypage" /> <input type="button"
						id="updateConfirmBtn" value="수정확인" />
				</form>


			</td>
			<td align="center">
				<div id="admin-login-layout">
					<h2>정보 수정</h2>
				</div> 
			</td>
		</tr>
		<tr style="height: 140px; width: 100%">
			<td class="width-80pt" colspan="2"></td>
		</tr>
	</table>
<script>
	document.getElementById('mypageMove').addEventListener('click', function() {
		router.move({
			context : '${context}',
			domain : 'member',
			action : 'move',
			page : 'mypage'
		});
	});

	var form = document.getElementById('update_id');
	var roll = document.getElementById('roll');
	for(var i=0 ; i< roll.options.length;i++){
		if(roll.options[i].value==='${user.roll}'){
			roll.options[i].setAttribute("selected","selected");
		}
	}
	for(var i=1 ; i<=4 ; i++){
		if(document.getElementById('teamid_'+i).value==='${user.teamId}'){
			document.getElementById('teamid_'+i).checked =true;
		}
	}
	
	document.getElementById("updateConfirmBtn").addEventListener(
			'click',
			function() {				
				form.action = "${context}/member.do";
				form.method = "post";
				if (form.pass.value === "") {
					mem.setPassword('${user.password}');
				} else {
					mem.setPassword(form.pass.value)
				}
				form.pass.value = mem.getPassword();
				form.submit();
			});
</script>
</body>
</html>


