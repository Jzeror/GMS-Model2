<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/header.jsp" />
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="../common/title_box.jsp" />
			<jsp:include page="menu_box.jsp" />
		</div>
		<!-- header end -->
		<div id="content">
			<jsp:include page="content_box.jsp" />
		</div>
		<!-- content end -->
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
	<script>
		function move(domain, action, page) {
			location.href = "${context}/" + domain + ".do?action=" + action
					+ "&page=" + page;
		}
	</script>
</body>
</html>
