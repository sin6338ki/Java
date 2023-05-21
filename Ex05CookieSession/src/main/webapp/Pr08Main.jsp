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
		String id = (String)session.getAttribute("loginId");
	%>
	
	<%=id %>님 환영합니다
	<a href="Pr08Logout">로그아웃</a>
</body>
</html>