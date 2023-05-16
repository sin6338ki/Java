<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align="center">
	<h1>랜덤 당첨 게임</h1>
		<fieldset>
			<legend>랜덤뽑기결과</legend>
			<form action="Ex02createInput.jsp">
				<% 
				String[] items = request.getParameterValues("item");
				
				Random rd = new Random();
				int ran = rd.nextInt(items.length);
				
				String print = items[ran];
				
				%>
				<%= request.getParameter("subject") %>
				<br>
				<%=  print%>
			</form>
		</fieldset>
</body>
</html>