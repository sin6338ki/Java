<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%for(int i=1; i<=10; i++){ %>
		<%=i %>
	<%} %>
	<br>
	<C:forEach var="i" begin="1" end="10" step="1">
		<!-- el 문법 : 특정 영역에 저장된 값을 사용할 수 있도록 해주는 문법 -->
		<C:out value="${i}"/>
	</C:forEach>
</body>
</html>