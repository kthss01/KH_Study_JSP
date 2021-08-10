<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<%-- isErrorPage="true" 에러페이지라고 명시하는거 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>
	<h1>에러 페이지</h1>
	<h3>에러 종류: <%= exception.getClass().getName() %></h3>
	<%-- 브라우저에 바로 뒷페이지로 한거
		history.go(-1); 한거랑 같음
		history.go(0); 현재 페이지 리로드
	 --%>
	<button onclick="history.back();">이전페이지로</button>
</body>
</html>