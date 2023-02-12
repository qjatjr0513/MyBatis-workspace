<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#list-area{
		border : 1px solid white;
		text-align: center;
	}
	
	.outer a {
		color: white;
		text-decoration : none;
	}
	
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="outer" align="center">
		<br>
		<h1 align="center">게시판</h1>
		<br>
		
		<div id="search-area">
			<form action="search.bo" method="get">
				<input type="hidden" name="currentPage" value="1">
				<select name="condition">
						<!--  방법1. -->
<%-- 					<option value="writer" ${condition == 'writer' ? "selected":"" } >작성자</option> --%>
<%-- 					<option value="title" ${condition == 'title' ? "selected":"" } >제목</option> --%>
<%-- 					<option value="content" ${condition == 'content' ? "selected":"" } >내용</option> --%>
					<option value="writer" >작성자</option>
					<option value="title" >제목</option>
					<option value="content">내용</option>
				</select>
				
				<c:if test="${ not empty condition }">
					<script>
						let condition = document.querySelector("#search-area select option[value=${condition}]");
						condition.selected = true;
					</script>
				</c:if>
				<!--
					// 0. 검색한 내용대로 게시글 뽑아오기 + 페이징 처리
					// 1. 검색한 기록이 남아 있을수 있도록
					// 2. 검색한 셀렉트박스 옵션이 선택되어 있도록
					3. 페이지 이동시 내가 검색한 내용이 유지되도록 추가
				 -->
				<input type="text" name="keyword" value="${keyword }">
				<button type="submit">검색</button>
			</form>		
		</div>		
		
		<table id="list-area">
			<thead>
				<tr>
					<th>글번호</th>
					<th width="400">제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ list }" var="b">
					<tr>
						<td>${b.boardNo }</td>
						<td><a href="detail.bo?bno=${b.boardNo }">${b.boardTitle }</a></td>
						<td>${b.boardWriter }</td>
						<td>${b.count }</td>
						<td>${b.createDate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		
		<div id="paging-area">
		
		<c:if test="${ empty condition }">
			<c:if test="${ pi.currentPage ne 1 }">
				<a href="list.bo?currentPage=${pi.currentPage -1 }">[이전]</a>
			</c:if>
			
			<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }" step="1">
				<a href="list.bo?currentPage=${p }">[${p}]</a>
			</c:forEach>
			
			<c:if test="${ pi.currentPage ne pi.maxPage }">
				<a href="list.bo?currentPage=${pi.currentPage+1 }">[다음]</a>
			</c:if>
		</c:if>
		
		<c:if test="${!empty condition }">
			<c:if test="${ pi.currentPage ne 1 }">
				<a href="search.bo?currentPage=${pi.currentPage -1 }&condition=${condition}&keyword=${keyword}">[이전]</a>
			</c:if>
			
			<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }" step="1">
				<a href="search.bo?currentPage=${p }&condition=${condition}&keyword=${keyword}">[${p}]</a>
			</c:forEach>
			
			<c:if test="${ pi.currentPage ne pi.maxPage }">
				<a href="search.bo?currentPage=${pi.currentPage+1 }&condition=${condition}&keyword=${keyword}">[다음]</a>
			</c:if>
		</c:if>
		
			
			
		</div>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>