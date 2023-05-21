<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>랜덤 당첨 게임</h1>
	<%
		
		Random rd = new Random();
		request.setCharacterEncoding("UTF-8");
		int itemCnt = request.getParameterValues("item").length;
		int rdNum = rd.nextInt(itemCnt+1);
		
		String subject = request.getParameter("subject");
		String result = request.getParameterValues("item")[rdNum];
	%>
	<fieldset>
		<legend>랜덤뽑기결과</legend>
		<table>
			<tr><td><%= subject%></td></tr>
			<tr><td><%= result%></td></tr>
		</table>
	</fieldset>
</body>
</html>