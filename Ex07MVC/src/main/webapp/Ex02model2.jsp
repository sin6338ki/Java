<%@page import="com.smhrd.model.Students"%>
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
<!-- 세션 안에 저장되어 있는 학생 정보(3명) 테이블로 출력하기 -->
<table border=1>
	<tr>
		<td>이름</td>
		<td>전공</td>
		<td>나이</td>
	</tr>
	
	<%
		ArrayList<Students> stu = (ArrayList)session.getAttribute("stuList");
		
		for(int i = 0 ; i < stu.size() ; i++){
			out.print("<tr>");
			out.print("<td>" + stu.get(i).getName() + "</td>");
			out.print("<td>" + stu.get(i).getMajor() + "</td>");
			out.print("<td>" + stu.get(i).getAge() + "</td>");
			out.print("</tr>");
		}
	
	%>

</table>
</body>
</html>