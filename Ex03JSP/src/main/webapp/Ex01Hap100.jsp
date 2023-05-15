<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<span>1~100까지희 합 : </span>
	<%
		int sum = 0;
		for(int i = 1 ; i <= 100 ; i++){
			sum += i;
		}
	%>
	<%= sum %>
</body>
</html>