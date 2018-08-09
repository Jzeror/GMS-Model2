<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="header.jsp" />
<body>
	<div id="wrapper">
		<div id="header">
		
			<jsp:include page="title_box.jsp" />
			<jsp:include page="login_box.jsp" />
			<jsp:include page="menu_box.jsp" />
		</div>		<!-- header end -->
		<div id="content">
			<jsp:include page="content_box.jsp" />
		</div>		<!-- content end -->
		<jsp:include page="footer.jsp" />
	</div>
</body>
<script >
	common.main('${context}');
</script>
</html>

