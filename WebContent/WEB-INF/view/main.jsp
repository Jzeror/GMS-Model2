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
</body>
</html>

