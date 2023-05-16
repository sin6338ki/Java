<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>학점확인프로그램</legend>
		<form action="Ex01Request.jsp">
		<%
		
		int java = Integer.parseInt(request.getParameter("java"));
		int web = Integer.parseInt(request.getParameter("web"));
		int iot = Integer.parseInt(request.getParameter("iot"));
		int and = Integer.parseInt(request.getParameter("and"));
		
		%>
			<table align="center">
				<tr>
					<td>이름</td>
					<td><% out.print(request.getParameter("name")); %></td>
				</tr>
				<tr>
					<td>Java점수</td>
					<td><%= java %></td>
				</tr>
				<tr>
					<td>Web점수</td>
					<td><%= web %></td>
				</tr>
				<tr>
					<td>IoT점수</td>
					<td><%= iot %></td>
				</tr>
				<tr>
					<td>Android점수</td>
					<td><%= and %></td>
				</tr>
				<tr>
					<td>평균</td>
					<% double avg = (java + web + and + iot)/4.0;
						String score = "";
						
						if(avg >= 95){
							score = "A+";
						}else if(avg >= 90){
							score = "A";
						}else if(avg >= 85){
							score = "B+";
						}else if(avg >= 80){
							score = "B";
						}else {
							score = "F";
						}
						
						%>
					<td><%= avg %></td>
				</tr>
				<tr>
					<td>학점</td>
					<td><strong><%= score %></strong></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>