<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/header.jsp" />
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="../common/title_box.jsp" />
			<jsp:include page="../common/login_box.jsp" />
			<jsp:include page="../common/menu_box.jsp" />
		</div>
		<!-- header end -->
		<div id="content">
			<h3>회원탈퇴</h3>
			<form id="delete_form">
				아이디:<input type="text" name="id" /><br> 비밀번호:<input
					type="password" name="pass" /><br />
				<!--node로 처리해서 삭제한다. <input type="hidden" name="action" value="delete" />  -->
				<input type="button" id='delete_form_btn' value="조오오온송" />
			</form>
		</div>
		<!-- content end -->
		<div id="footer">
			<jsp:include page="../common/footer.jsp" />
		</div>
	</div>

	<script>
		document.getElementById('delete_form_btn').addEventListener('click',function() {
							var form = document.getElementById('delete_form');
							
							var node = document.createElement('input');
							node.innerHTML = '<input type="hidden" name="action" value="delete" />';
							form.appendChild(node);
							if (form.pass.value === '${user.password}'
									&& form.id.value === '${user.memId}') {
								form.action = "${context}/member.do";
								form.method = "post";
								form.submit();
							} else {
								alert("입력이 잘못되었습니다.");
							}

						});
	</script>
</body>
</html>

