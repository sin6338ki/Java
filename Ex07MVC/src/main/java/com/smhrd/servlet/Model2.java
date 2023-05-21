package com.smhrd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.Students;


@WebServlet("/Model2")
public class Model2 extends HttpServlet {
	
	//Model2.로 요청 먼저
	//1. DB연동
	//2. SQL 실행 (Students 테이블의 모든 값 가져오기)
	//3. 3명의 학생정보 >> 세션에 저장
	//4. Ex02model.jsp로 이동

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//DB 연동시 필요한 객체 선언
		Connection conn = null; //데이터베이스 연결
		PreparedStatement ps = null; //sql 다루는 객체
		ResultSet rs = null; //sql 실행 관련 객체
		//데이터베이스에서 불러온 정보
		Students stu = null;
		List<Students> stuList = new ArrayList<Students>();
		PrintWriter out = response.getWriter();
		
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
		String sql = "select * from students";

		//sql 쿼리문을 다루기 위한 객체 생성 (PreparedStatement)
		ps = conn.prepareStatement(sql);

		//4. sql 실행
		//insert, delete, update => executeUpdate() - 반환타입 int(몇 개의 행이 업데이트 되었는지)
		//select => executeQuery() - 반환타입 ResultSet(읽어본 데이터 포함, 커서의 개념)
		//ResultSet은 next와 함께 사용
		//왜? 첫번째 행은 속성명을 의미하기 때문
		rs = ps.executeQuery();
		
		HttpSession session = request.getSession();
		session.setAttribute("stuList", stuList);
		
		while(rs.next()){
			//next()반환타입은 true 혹은 false
			//커서가 가리키는 행에 데이터가 있을 때 true, 없으면 false
			String name = rs.getString("name");
			String major = rs.getString("major");
			String age = rs.getString("age");
			//데이터베이스에서 가져온 정보를 객체로 생성
			stu = new Students(name, major, age);
			//생성한 객체 배열에 저장
			stuList.add(stu);		
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
		
		response.sendRedirect("Ex02model2.jsp");
	}

}
