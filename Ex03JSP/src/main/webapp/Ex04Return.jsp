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
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	String ope = request.getParameter("ope");
	int result;
	if(ope.equals("+")){
		result = num1 + num2;
	}else if(ope.equals("-")){
		result = num1 - num2;
	}else if(ope.equals("*")){
		result = num1 * num2;
	}else{
		result = num1 / num2;
	}
	%>
	<%= num1%>
	<%= ope%>
	<%= num2%>
	=
	<%= result %>
</body>
</html>