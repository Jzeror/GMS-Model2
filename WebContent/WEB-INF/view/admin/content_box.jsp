<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content_box">
	<div id="contentBoxSearch">
		<select name="searchOption" id="searchOption">
				<option value="none">검색조건</option>
 				<option value="userId">아이디</option>
 				<option value="name">이름</option>
 				<option value="team_id">팀 id</option>
 		</select>
		<input type="text" id="searchWord" name="searchWord" placeholder="검색어 입력"/>
		<input type="button" id="searchBtn" value="검색" />
	</div>
	
	<table id="contentBoxTab">
		<tr id="contentBoxMeta">
			<th>아이디</th>
			<th>이 름</th>
			<th>나 이</th>
			<th>성 별</th>
			<th>팀 명</th>
			<th>역 할</th>
		</tr>
		<c:forEach  items="${list}" var="mem"  >
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
		<tr>
			<td colspan="6">
				<ul class="pageBox">
					<c:forEach begin="${beginPage}" end="${endPage}" step="1" varStatus="i">
						<li>
						<a class="pageNumber" id="${i.index}" >${i.index}</a>
						</li>
						
					</c:forEach>
					<c:if test="${countTF}">
						<li>
						<a id="moveNext">다음▶</a>
						</li>
					</c:if>
				</ul>
			</td>
		</tr>
	</table>
</div>
 <script>

  admin.main('${context}');
  
	document.getElementById("moveNext").addEventListener('click',function(){
		 location.href = '${context}/admin.do?action=list&page=main&endPage=${endPage}';
	});
	
	
</script>