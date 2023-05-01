package MODEL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {
//	데이터베이스의 데이터에 접근하기 위한 객체
//	데이터베이스 연결, 해제, 조회, 데이터 삽입, 삭제 등 기능 수행
	
	Connection conn;
	PreparedStatement psmt = null;
	ResultSet rs;
	
// 	데이터베이스 연결
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "service";
			String db_pw = "12345";
			conn = DriverManager.getConnection(url, db_id, db_pw);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("DB연결실패");
			e.printStackTrace();
		}
	}
	
//	데이터베이스 연결 해제
	public void getClose() {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(psmt!=null) {
				psmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
		}
		
	}


// Bow 아이템 조회
	public ArrayList<ItemVO> bowList() {
		ArrayList<ItemVO> BowList = new ArrayList<ItemVO>();
		
		connect();

		try {
			String sql = "select * from BowVO";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
//			rs의 커서를 기준으로 다음에 데이터가 있는지 없는지 확인
			while(rs.next()) {
				BowVO bow = new BowVO(0, null, 0, 0);
				bow.setItemNum(rs.getInt(1));
				bow.setName(rs.getString(2));
				bow.setAttackPower(rs.getInt(3));
				bow.setDurability(4);
				BowList.add(bow);				
			}
			
			getClose();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return BowList;
		
	}
	
// Sword 아이템 조회
	
	public ArrayList<ItemVO> swordList() {
		ArrayList<ItemVO> SwordList = new ArrayList<ItemVO>();
		
		connect();

		try {
			String sql = "select * from SwordVO";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
//			rs의 커서를 기준으로 다음에 데이터가 있는지 없는지 확인
			while(rs.next()) {
				SwordVO sword = new SwordVO(0, null, 0);
				sword.setItemNum(rs.getInt(1));
				sword.setName(rs.getString(2));
				sword.setAttackPower(rs.getInt(3));
				SwordList.add(sword);				
			}
			
			getClose();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return SwordList;
		
	}
	
}