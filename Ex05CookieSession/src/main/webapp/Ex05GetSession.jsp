<%@page import="java.util.ArrayList"%>
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
	
	//-- 세션 값 가져오기
	//getAttirbute(String(name))
	String id = (String)session.getAttribute("id");
	//Object 타입으로 반환 >> 원래 타입으로 다운 캐스팅
	Integer age = (Integer)session.getAttribute("age");
	ArrayList<String> al = (ArrayList<String>)session.getAttribute("list");
	
	%>
	
	id : <%=id %><br>
	age : <%=age %><br>
	list : <%=al %>
	
	<a href="Ex06RemoveSession.jsp">세션 삭제</a>
	<a href="Ex07Invalidate.jsp">세션 전부 삭제</a>
	
</body>
</html>