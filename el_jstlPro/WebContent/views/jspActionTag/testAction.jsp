<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 지시자 include 써서 하는 방법 --%>
	<%-- <%@ include file="common.jsp" %> --%>
	
	<jsp:include page="common.jsp"/>
	
	<h1 align="center">testAction.jsp 내용입니다.</h1>
	
	<%--<% request.setAttribute("name", "유재석");
		request.getRequestDispatcher("testForward.jsp").forward(request, response);
	--%>
	
	<% request.setAttribute("name", "유재석"); %>
	<%-- request.getParameter로 받을 수 있음 --%>
	<%-- <jsp:forward> </jsp:forward>이 안에 주석 쓰면 에러남 --%>
	<jsp:forward page="testForward.jsp">
		<jsp:param value="rowun" name="name"/> 
	</jsp:forward>
</body>
</html>