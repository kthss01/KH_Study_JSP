<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/*
	String name = (String) request.getAttribute("name");	
	String age = (String) request.getAttribute("age");	
	String city = (String) request.getAttribute("city");	
	String height = (String) request.getAttribute("height");	
	String gender = (String) request.getAttribute("gender");	
	String food = (String) request.getAttribute("foods");
	*/
	
	//System.out.println(request.getParameter("name"));
	
	// request에 정보 다 담겨있음
	String name = (String) request.getParameter("name");	
	String age = (String) request.getParameter("age");	
	String city = (String) request.getParameter("city");	
	String height = (String) request.getParameter("height");	
	String gender = (String) request.getParameter("gender");
	String[] foods = (String[]) request.getParameterValues("food");
	String food = String.join(",", foods);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>
<style type="text/css">
	h2{color:red;}
	span.name{color:orange; font-weight:bold;}
	span.gender{color:yellow; font-weight:bold; background-color:black;}
	span.age{color:green; font-weight:bold;}
	span.city{color:blue; font-weight:bold;}
	span.height{color:navy; font-weight:bold;}
	span.food{color:purple; font-weight:bold;}
</style>
</head>
<body>
	
	<h2>개인취향 테스트 결과(POST)</h2>
	<span class='name'><%= name %></span> 님은   <!-- 표현식 -->
	<span class='age'><%= age %></span>이시며, 
	<span class='city'><%= city %></span>에 사는 
	키 <span class='height'><%= height %></span>cm인 
	<span class='gender'><%= gender %></span>입니다. 
	좋아하는 음식은 <span class='food'><%= food %></span>입니다.

</body>
</html>