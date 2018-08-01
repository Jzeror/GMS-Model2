<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content_box">
	<table id="contentBoxTab">
		<tr id="contentBoxMeta">
			<th>아이디</th>
			<th>이 름</th>
			<th>나 이</th>
			<th>성 별</th>
			<th>팀 명</th>
			<th>역 할</th>
		</tr>
		<c:forEach  items="${list}"  var="mem" >
		<tr>
			<td>${mem.memId}</td>
			<td><a class="username" id="${mem.memId}" >${mem.name}</a></td>
			<td>${mem.age} </td>
			<td>${mem.gender}</td>
			<td>${mem.teamId}</td>
			<td>${mem.roll}</td>
		<%--<td>${mem.getRoll()}</td>--%>
		</tr>
		</c:forEach>
	</table>
</div>
 <script> 
document.getElementById('contentBoxMeta').className='bgColorisYellow';
var x = document.querySelectorAll('.username');
for(i in x){
	x[i].style.color = 'white';
	x[i].style.cursor = 'pointer';
	x[i].addEventListener('click', function(){
		location.href='${context}/admin.do?action=retrieve&page=memberDetail&idsearch='+this.getAttribute('id');
	});
}
</script>