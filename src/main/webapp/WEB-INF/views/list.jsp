<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<br />
	<div class="container">
		<table class="table">
			<thead class="thead-light">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${list}">
					<tr>
						<td>${board.bno}</td>
						<td><a href="update?bno=${board.bno}">${board.title}</a></td>
						<td>${board.writer}</td>
						<td><fmt:formatDate value="${board.regdate}" type="both" pattern="yyyy-MM-dd HH:mm" /></td>
						<td>${board.readcount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<ul class="pagination mx-auto">
			<c:if test="${pageMaker.prev}"> <!-- prev가 true이면 -->
				<li class="page-item">
					<a class="page-link" href="${pageMaker.startPage - 1}">이전 <!-- 이전블럭의 마지막 페이지 -->
				</a></li>
			</c:if>
			<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="i">
				<c:choose>
					<c:when test="${pageMaker.cri.page == i}">
						<li class="page-item active">
							<a class="page-link active" href="#">${i}</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="page-item">
							<a class="page-link" href="#">${i}</a>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${pageMaker.next}">
				<li class="page-item">
					<a class="page-link" href="${pageMaker.endPage + 1}">다음 
				</a></li>
			</c:if>
		</ul>
		<button type="submit" class="btn btn-primary" onclick="location.href='input'">글쓰기</button>
	</div>

</body>
</html>

