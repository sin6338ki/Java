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
		//-- 저장된 쿠키 가져오기
		//클라이언트에 저장된 쿠키를 서버로 보내기 (request)
		Cookie[] cookies = request.getCookies();
	
		for(Cookie c : cookies){
			//쿠키의 name, valu 화면에 출력
			out.print(c.getName() + " : " + c.getValue() + "<br>");
		}
	%>
	
	<a href="Ex03removeCookie.jsp">쿠키삭제</a>
</body>
</html>