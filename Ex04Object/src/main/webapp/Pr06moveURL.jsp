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
		String site = request.getParameter("url");
		if(site.equals("네이버")){
			response.sendRedirect("http://naver.com");
		}else if(site.equals("다음")){
			response.sendRedirect("http://daum.net");
		}else{
			response.sendRedirect("http://google.com");
		}
	
	
	
	%>
</body>
</html>