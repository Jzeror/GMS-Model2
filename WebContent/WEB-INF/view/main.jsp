<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="common/header.jsp" />
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="common/title_box.jsp" />
			<jsp:include page="common/login_box.jsp" />
			<jsp:include page="common/menu_box.jsp" />
		</div>		<!-- header end -->
		<div id="content">
			<jsp:include page="common/content_box.jsp" />
		</div>		<!-- content end -->
		<jsp:include page="common/footer.jsp" />
	</div>
<script>
function move(domain, action, page){
	console.log('클릭 테스트 콘솔 성공!! ${context}');
	alert('클릭 테스트 성공!! ${context}');
	location.href = "${context}/"+domain+".do?action="+action+"&page="+page;
}
function moveForm() {
        return false;
}
</script>
</body>
</html>

