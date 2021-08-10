<%-- directive page : 페이지 지시자 태그 (페이지에 대한 설정) errorPage = "errorPage.jsp" 이런식으로 명시 가능 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page errorPage = "errorPage.jsp"  %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01_sum</title>
</head>
<body>
<!-- HTML 주석 : 개발자 도구 탭에 노출이 됨 (클라이언트한테 전달이 된다) -->
<%-- JSP 주석 : 개발자 도구 탭에 노출이 안됨 (클라이언트한테 전달이 안됨) --%>

<%-- 필드를 선언하는 태그 엘리먼트 --%>
<%-- <%! private int age = 20; %> --%>
<%-- <% 스크립틀릿 태그 - 자바 문법을 작성한다  %> --%>

<% // 일반적인 자바코드를 작성 가능
	int total = 0;
	for (int i = 0; i <= 10; i++) {
		total += i;
	}
	
	// 에러 발생시킨거
	String s = null;
	char c = s.charAt(0);
	
%> 
	<%-- 16pt 단위도 있음 21.333px임 --%>
	<h4>1부터 10까지의 합은 <span style="color: red; font-size: 16pt;"><%= total %></span>입니다</h4>
	<h4>1부터 10까지의 합은 <span style="color: red; font-size: 16pt;"><% out.print(total); %></span>입니다</h4>
</body>
</html>