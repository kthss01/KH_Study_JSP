<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 조회 페이지</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
		</tr>
		
		<c:forEach var="data" items="${ list }" varStatus="st">
		<tr>
			<td>${ data.no }</td>
			<td>${ data.title }</td>
			<td>${ data.writer }</td>
			<td>${ data.date }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>