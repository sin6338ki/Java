<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//세션에 저장된 id값 받아오기
		String id = (String)session.getAttribute("id");
	%>
	
	<%= id %>님 환영합니다. 
	<a href="Ex08Logout">로그아웃</a>
</body>
</html>