package CONTROLLER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CharDAO {
	
	// 캐릭터 행동 메서드 모음
	// 출근하기, 수업듣기, 팀프로젝트, 코딩테스트, 자격증 공부, 예습 복습 등

	Connection conn = null;
	PreparedStatement pstm = null; // 쿼리문 실행시키는 객체
	ResultSet rs = null; // 쿼리문을 통해 발생한 응답을 받을 수 있는 객체

	int exp = 0;
	int stress = 0;
	int hp = 0;
	
	int changeExp = 0;
	int changeStress = 0;
	int changeHp = 0;
	
	int eventStress = 0;
	
	// DB연결
	public void getConn() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String id = "campus_k_0417_3";
			String pw = "smhrd3";

			conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// DB닫기
	public void close() {
		// DB 연결 끊기 → 역순
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	// 게이지 변경
	public int gaugeChange(String nick) {

		int result = 0;
        try {
        	String sql = "select * from DEVELOPER_DAMA where user_nick = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nick);
			rs = pstm.executeQuery();
	        
			while(rs.next()) {
		        exp = rs.getInt("char_exp");
		        stress = rs.getInt("char_stress");
		        hp = rs.getInt("char_hp");			
	        }
			
			eventStress(nick);
			eventHp(nick);
			
			exp += changeExp;
			stress += changeStress + eventStress;
			hp += changeHp;
			
			if(stress < 0) {
				stress = 0;
			}else if(stress > 100) {
				stress = 100;
			}
			
			if(hp < 0) {
				hp = 0;
			}else if(hp > 100) {
				hp = 100;
			}
			
			String sql2 = "update developer_dama set char_exp = ?, char_stress = ?, char_hp = ? where user_nick = ?";
			pstm = conn.prepareStatement(sql2);
			pstm.setInt(1, exp);
			pstm.setInt(2, stress);
			pstm.setInt(3, hp);
			pstm.setString(4, nick);
			result = pstm.executeUpdate();
		       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
        return result;
	}
	
	// 출근하기
	public void goSmhrd(String nick) {
		getConn();

		changeExp = 0;
		changeStress = 10;
		changeHp = -10;
		
		gaugeChange(nick);
		
		close();
	}
	
	// 수업듣기
	public void listeningClass(String nick) {
		getConn();

		changeExp = 10;
		changeStress = 5;
		changeHp = -10;
		
		gaugeChange(nick);
		
		close();
	}
	
	// 팀프로젝트
	public void teamProject(String nick) {
		getConn();

		changeExp = 15;
		changeStress = 10;
		changeHp = -15;
		
		gaugeChange(nick);
		
		close();
	}
	
	// 코딩테스트
	public void codingTest(String nick) {
		getConn();

		changeExp = 15;
		changeStress = 15;
		changeHp = -20;
		
		gaugeChange(nick);
		
		close();
	}
	
	// 자격증 공부
	public void studyCertificate(String nick) {
		getConn();

		changeExp = 15;
		changeStress = 10;
		changeHp = -15;
		
		gaugeChange(nick);
		
		close();
	}
	
	// 예습복습
	public void selfEdu(String nick) {
		getConn();

		changeExp = 10;
		changeStress = 10;
		changeHp = -10;
		
		gaugeChange(nick);
		
		close();
	}
	
	// 점심시간
	public void lunchTime(String nick) {
		getConn();

		changeExp = 0;
		changeStress = -10;
		changeHp = 10;
		
		gaugeChange(nick);
		
		close();
	}
	
	// 집에가기
	public void goHome(String nick) {
		getConn();

		changeExp = 0;
		changeStress = -20;
		changeHp = 15;
		
		gaugeChange(nick);
		
		close();
	}
	
	// 월요일 5시 퇴근
	public void monday(String nick) {
		getConn();

		changeExp = 0;
		changeStress = -15;
		changeHp = 10;
		
		gaugeChange(nick);
		
		close();
	}

	// 수업시간에 졸기
	public void snooze(String nick) {
		getConn();

		changeExp = -5;
		changeStress = 5;
		changeHp = 10;
		
		gaugeChange(nick);
		
		close();
	}
	
	// 주말에 쉬기
	public void weekend(String nick) {
		getConn();

		changeExp = -20;
		changeStress = -20;
		changeHp = 20;
		
		gaugeChange(nick);
		
		close();
	}
	
	// 커피마시기
	public void coffee(String nick) {
		getConn();

		changeExp = 0;
		changeStress = 0;
		changeHp = 5;
		
		gaugeChange(nick);
		
		close();
	}
	
	//hp이벤트
	public void eventHp(String nick) {
		if(exp >= 0 && exp <= 20) {
			eventStress = 5;
		}else if(exp >= 80 && exp <= 100) {
			eventStress = -10;
		}
	}
	
	//stress이벤트
	public void eventStress(String nick) {
		if(stress >= 70 && stress <= 100) {
			changeStress *= 2;
		}
	}
 

}

