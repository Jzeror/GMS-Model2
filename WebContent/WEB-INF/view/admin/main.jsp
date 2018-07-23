<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="<%=application.getContextPath()%>" />
<!doctype html>
<html lang="en">
<jsp:include page="../common/header.jsp" />
<body>

<div id="wrapper" >
	<div id="header">
		<jsp:include page="../common/title_box.jsp" />
		<jsp:include page="menu_box.jsp" />
	</div> <!-- header end -->
	<div id="content">
		<jsp:include page="content_box.jsp" />
	</div> <!-- content end -->
		<jsp:include page="../common/footer.jsp"></jsp:include>
</div>

</body>
</html>
