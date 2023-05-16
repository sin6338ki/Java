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
			<legend>랜덤뽑기</legend>
			<form action="Ex02randomOutput.jsp">
				주제 : 
				<input type="text" name="subject">
				<br>
				
				<%
				
				for(int i = 1 ; i <= Integer.parseInt(request.getParameter("num")); i++){
					out.print("아이템 : "); 
					out.print("<input type='text' name='item'>");
					out.print("<br>");
				}
				%>

				<input type="submit" value="랜덤뽑기">
				
			</form>
		</fieldset>

</body>
</html>