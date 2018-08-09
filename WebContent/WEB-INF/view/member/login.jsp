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
			<h1>로그인</h1>
			<form id="user-login-form-id" name="user_login_form_name">
				id:<br> 
				<input type="text" name="memId"> 
				<br> pass:
				<br>
				<input type="password" name="pass"> <br>
				<br> 
			
				<!--이제 페이지를 자바에서 결정하자<input type="hidden" name="page" value="mypage"/> -->
				<input id="loginFormBtn" type="button" value="저언송">
			</form>
		</div>
		<!-- content end -->
		<div id="footer">
			<jsp:include page="../common/footer.jsp" />
		</div>
	</div>
	<script>
		document.getElementById('loginFormBtn').addEventListener(
				'click',function() {
					var form = document.getElementById("user-login-form-id");
					var x = service.nullChecker([
							form.name.value,
							document.user_login_form_name.pass.value ]);
					if (x.checker) {
						var node = document.createElement("input");
						node.innerHTML= '<input type="hidden" name="action" value="login" />';
						form.appendChild(node);
						form.action = "${context}/member.do";
						form.method = "post";
						form.submit();
					} else {
						alert(x.text);

					}
				});
	</script>
</body>
</html>


