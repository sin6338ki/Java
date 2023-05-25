package com.smhrd.database;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionManager {
	
	//실제 연결, 실행 등의 역할을 수행할 session을 생성해주는 factory
	//DB에서 session은 연결부터 sql 실행하고, 실행 후 연결 끊기까지의 일련의 과정을 session이라고 함
	public static SqlSessionFactory sqlSessionFactory;

   //클래스 초기화 블럭 : 클래스가 처음 로딩될 때 딱 한번만 수행
	//작성한 프로그램이 실행되자마자 메모리에 적재 > 클래스를 초기화 해주는 역할
   static {
      //설정정보 가지고 오기위한 mybatis-config.xml 경로 작성
	   //연결하고 싶은 데이터베이스의 정보 가져오기
      String resource = "com/smhrd/database/mybatis-config.xml";
       //실제 정보 가져오기 위하여 reader 사용
       //지정한 경로 안의 파일 내용을 읽을 때 사용
      Reader reader;
      
      System.out.println(resource);
      //경로가 문자열로 작성되어 있음. 오타 발생 가능성 있음 >> 예외처리
      try {
         //문자열 경로로 파일읽기
         reader = Resources.getResourceAsReader(resource);
         //읽은 정보를 토대로 DB 관련 기능을 가진 SqlSessionFactory 생성
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
         System.out.println("sqlSessionFactory");
      }catch (IOException e) {
         e.printStackTrace();
      }
   }

   //static 초기화 블럭에서 생성된 factory를 반환해주는 메서드
   //만약 데이터베이스와 연결하고 싶어. 그럼 get~ 호출하면 db연결~끊기까지 작업을 해주는 factory를 생성해줌
   public static SqlSessionFactory getSqlSessionFactory() {
	   //static : 객체 생성하지 않아도 메서드를 실행하며 바로 실행됨
	   return sqlSessionFactory;
   }
   }
