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
<% int num = Integer.parseInt(request.getParameter("num")); %>
	<h1>랜덤 당첨 게임</h1>
	<fieldset>
		<legend>랜덤뽑기</legend>
		<form action="Pr03randomOutput.jsp" method="post">
			<table>
				<tr>
					<td>주제</td>
					<td><input type="text" name="subject"></td>
				</tr>
				
				<% 
				for(int i = 1; i <= num ; i++){
					out.print("<tr>");
					out.print("<td>아이템:</td>");
					out.print("<td><input type='text' name='item'></td>");
					out.print("</tr>");
				}

			%>
				
			<tr><td><input type="submit" value="랜덤뽑기"></td></tr>	
			</table>
			
		</form>
	</fieldset>
</body>
</html>