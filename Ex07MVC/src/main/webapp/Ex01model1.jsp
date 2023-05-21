
<%@page import="com.smhrd.model.Students"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.smhrd.model.FullStack"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- WEB MVC MODEL 1 : 비즈니스 로직(Controller), 화면표현(view) >> JSP에 작성
		프로젝트의 규모가 작을 때 사용 -->
		
<!-- DB 연동 -->
<!-- 0. JDBC 관련 도구 가져오기
	: 라이브러리 추가 (WEBAPP > WEB-INF) -->

<%
	//DB 연동시 필요한 객체 선언
	Connection conn = null; //데이터베이스 연결
	PreparedStatement ps = null; //sql 다루는 객체
	ResultSet rs = null; //sql 실행 관련 객체
	//데이터베이스에서 불러온 정보
	Students stu = null;
	
	try{
	
	//1. 오라클과 연결한 드라이버 가지고 오기(동적로딩)
	//동적로딩 : 프로그램 실행 후 코드를 만났을 때 실행
	//정적로딩 : 프로그램 실행하자마자 실행
	Class.forName("oracle.jdbc.OracleDriver");
	
	//2. 지정한 데이터베이스와 연결하기 위한 객체 생성(Connection)
	//객체 생성 후 데이터베이스와 연결시 url, 데이터베이스 계정 정보 필요
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "service";
	String password = "12345";
	
	conn = DriverManager.getConnection(url, user, password);
	
	//3. sql문 작성
	String sql = "select * from students where name=?";

	//sql 쿼리문을 다루기 위한 객체 생성 (PreparedStatement)
	ps = conn.prepareStatement(sql);

	//sql문 ? 자리 채우기 : setString(자리수, 값)
	ps.setString(1, "지영");

	//4. sql 실행
	//insert, delete, update => executeUpdate() - 반환타입 int(몇 개의 행이 업데이트 되었는지)
	//select => executeQuery() - 반환타입 ResultSet(읽어본 데이터 포함, 커서의 개념)
	//ResultSet은 next와 함께 사용
	//왜? 첫번째 행은 속성명을 의미하기 때문
	rs = ps.executeQuery();
	
	if(rs.next()){
		//next()반환타입은 true 혹은 false
		//커서가 가리키는 행에 데이터가 있을 때 true, 없으면 false
		String name = rs.getString("name");
		String major = rs.getString("major");
		String age = rs.getString("age");
		//데이터베이스에서 가져온 정보를 객체로 생성
		stu = new Students(name, major, age);

	}
	
	}catch(ClassNotFoundException e){
		//클래스(oracleDrive)의 경로가 잘못됐을 경우
		System.out.println("OracleDriver 클래스의 경로가 잘못되었습니다.");
	}catch(SQLException e){
		System.out.println("SQL 예외가 발생했습니다.");
	}catch(Exception e){ //모든 예외상황 상위 클래스)
		System.out.println("다른 예외상황이 발생했습니다.");
		e.printStackTrace(); //원인, 발생 절차 콘솔창에 출력
	}finally{
		//예외 상황이 발생하던 하지 않던 무조건 실행
		//사용한 자원 반환(생성한 순서 반대로 반환)
		try{
			//상위 catch문에서 오류가 발생하면 각 객체는 null 값을 갖게 됨
			//null 값은 close가 불가능하므로 예외처리
			rs.close();
			ps.close();
			conn.close();
		}catch(Exception e){
			System.out.println("finally에서 예외상황 발생!");
			e.printStackTrace();
		}
	}
%>

이름 : <%= stu.getName() %><br>
전공 : <%= stu.getMajor() %><br>
나이 : <%= stu.getAge() %><br>


</body>
</html>