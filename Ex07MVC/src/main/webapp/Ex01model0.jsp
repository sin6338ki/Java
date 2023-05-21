<%@page import="java.sql.SQLException"%>
<%@page import="com.smhrd.model.FullStack"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
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
<!-- WEB MVC MODEL 1 : 비즈니스로직(Controller), 화면표현(View) >> JSP에 작성
	프로젝트의 규모가 작을 때 사용 -->
<!-- DB연동(JDBC) -->
<%

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	FullStack fs = null;
	
	try{
		//0. JDBC관련 도구 가져오기 - 라이브러리 추가 (webapp > WEB-INF에 넣어주기)
		//1. 오라클과 연결할 드라이버 가지고 오기(동적 로딩)
		//   동적로딩 : 코드를 만났을 때 실행 (정적로딩 : 프로그램 실행하자마자 실행)
		Class.forName("oracle.jdbc.OracleDriver");

		//2. 지정한 데이터베이스와 연결하기 위한 객체 생성 : Connection
		//	- url, 시스템 계정 지정하여 데이터베이스 접속
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "service";
		String password = "12345";
		
		conn = DriverManager.getConnection(url, user, password);
		
		//sql 틀
		String sql = "select * from fullstack where name=?";
		
		//sql 쿼리문을 다루기 위한 객체 생성 : PreparedStatement - 완성, 실행 등
		ps = conn.prepareStatement(sql);
		
		//? 자리 채우기 : setString(자리수(1부터 시작),값)
		ps.setString(1, "선영표");
		
		//INSERT, DELETE, UPDATE → executeUpdate() : 반환타입 int (몇개의 행이 업데이트 되었는지)
		//SELECT(read) → executeQuery() : 반환타입 ResultSet (읽어온 데이터 포함, 커서의 개념)
		//Resultset 은 next 와 함께 사용 (그 다음행으로 커서 이동)
		//sql 실행 
		rs = ps.executeQuery();
		
		if(rs.next()){ //next() : true/false 
						//        → true : 커서가 가리키는 행에 데이터가 있을 때
						//        → false : 커서가 가리키는 행에 데이터가 없을 때 
			String name = rs.getString("name"); //매개인자 : 컬럼 - 컬럼이름 
			String major = rs.getString(2); // 혹은 컬럼번호(1부터 시작) 사용 가능
			String phone = rs.getString("phone");
			
			//데이터베이스에서 가져온 정보를 객체로 생성
			fs = new FullStack(name, major, phone);
		}
	}catch(ClassNotFoundException e){
		//Exception : 모든 예외상황의 상위 클래스
		//ClassNotFoundException : 클래스의 경로가 잘못됐을 경우(OracleDrive 가지고 올 때 경로가 잘못됐을 경우)
		System.out.println("OracleDriver 클래스 못찾음!");
	}catch(SQLException e){
		System.out.println("sql 예외 발생!");
	}catch(Exception e){
		System.out.println("다른 예외 발생!");
		e.printStackTrace(); //원인, 발생 절차 콘솔창에 출력
	}finally{ //예외상황이 발생하던지, 하지 않던지간에 무조건 실행!
		//사용한 자원 반환(생성한 순서 반대로 반환)
		try{ //catch문 오류 발생되면 rs, ps, conn은 null값 
			//null값은 close불가하므로 try~catch문 사용하여 예외처리
			rs.close();
			ps.close();
			conn.close();
		}catch(Exception e){
			System.out.println("finally에서 예외상황 발생!");
			e.printStackTrace();
		}
	}
	
%>

이름 : <%=fs.getName() %><br>
전공 : <%=fs.getMajor() %><br>
전화번호 : <%=fs.getPhone() %><br>

</body>
</html>