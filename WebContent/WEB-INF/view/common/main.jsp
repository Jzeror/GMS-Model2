<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<jsp:include page="header.jsp" />
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="title_box.jsp" />
			<c:choose>
				<c:when test="${log eq 'login'}">
					<jsp:include page="../common/logout_box.jsp" />
				</c:when>
				<c:otherwise>
					<jsp:include page="../common/login_box.jsp" />
				</c:otherwise>
			</c:choose>
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

