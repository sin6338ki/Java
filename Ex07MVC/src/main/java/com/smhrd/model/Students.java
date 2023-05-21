package com.smhrd.model;

public class Students {
	
	//데이터베이스의 Students 테이블에서 가지고 온 학생의 데이터를 하나로 묶어주는 작업
	//객체 >> 한생 한 명의 데이터를 의미함 (VO)
	//VO 작성 순서
	//1)필드 - 테이블 컬럼과 일치
	//2)생성자
	//3)메서드 - VO는 보통 getter 메서드까지만 만듦
	
	private String name;
	private String major;
	private String age;
	
	//생성자
	//매개변수(DB에서 가져온 값)으로 필드 초기화까지
	public Students(String name, String major, String age) {
		this.name = name;
		this.major = major;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getMajor() {
		return major;
	}

	public String getAge() {
		return age;
	}
	
	
	

}
