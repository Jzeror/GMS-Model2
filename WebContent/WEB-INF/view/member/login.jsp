<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<div id="content">
			<h1>로그인</h1>
			<form id="user-login-form-id" name="user_login_form_name">
				id:<br> 
				<input type="text" name="memId"> 
				<br> pass:
				<br>
				<input type="password" name="pass"> <br>
				<br> 
				<input id="loginFormBtn" type="button" value="저언송">
			</form>
		</div>
		<div id="footer">
			<jsp:include page="../common/footer.jsp" />
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
						var node2 = document.createElement("input");
						node2.innerHTML= '<input type="hidden" name="page" value="retrieve" />';
						form.appendChild(node2);
						form.action = "${context}/member.do";
						form.method = "post";
						form.submit();
					} else {
						alert(x.text);

					}
				});
</script>
</html>


