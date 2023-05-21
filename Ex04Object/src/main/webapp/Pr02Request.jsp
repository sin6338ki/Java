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
	request.setCharacterEncoding("UTF-8");
%>
	<fieldset>
		<legend>학점확인프로그램</legend>
		<form method="post" action="Pr02Request.jsp">
		<table>
		<%
		String name = request.getParameter("name");
		int javaScore = Integer.parseInt(request.getParameter("java"));
		int webScore = Integer.parseInt(request.getParameter("web"));
		int iotScore = Integer.parseInt(request.getParameter("iot"));
		int andScore = Integer.parseInt(request.getParameter("and"));
		
		double avg = (javaScore + webScore + iotScore + andScore) / 4.0;
		
		String grade = "";
		
		if(avg >= 95){
			grade = "A+";
		}else if(avg >= 90){
			grade = "A";
		}else if(avg >= 85){
			grade = "B+";
		}else if(avg >= 80){
			grade = "B";
		}else{
			grade = "F";
		}
		%>
			<tr>
				<td>이름</td>
				<td><%= name %></td>
			</tr>
				<tr>
				<td>Java점수</td>
				<td><%= javaScore %></td>
			</tr>
				<tr>
				<td>Web점수</td>
				<td><%= webScore %></td>
			</tr>
				<tr>
				<td>Iot점수</td>
				<td><%= iotScore %></td>
			</tr>
				<tr>
				<td>Android점수</td>
				<td><%= andScore %></td>
			</tr>
			<tr>
				<td>평균</td>
				<td><%= avg %></td>
			</tr>
			<tr>
				<td>학점</td>
				<td><strong><%= grade%></strong></td>
			</tr>
		</table>
		
		</form>
	</fieldset>

</body>
</html>