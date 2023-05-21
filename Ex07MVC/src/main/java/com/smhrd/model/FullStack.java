package com.smhrd.model;

//FullStack테이블에서 가지고 온 학생 데이터를 하나로 묶어주는 작업
//객체 >> 학생 한명의 데이터를 의미함 >> VO(Value Object)
//VO 작성 순서
//1) 필드 - 테이블 컬럼 이름과 일치
//2) 생성자
//3) 메서드 : VO는 보통 getter 메서드까지 만듦
public class FullStack { //데이터베이스 테이블에서 가져온 정보면 클래스명과 테이블명 동일하게 
	//필드 이름도 테이블의 컬럼명과 동일하게
	//접근제한자 사용
	private String name;
	private String major;
	private String phone;
	
	//생성자
	//: 매개변수(DB에서 가져온 값), 필드 초기화까지 진행할 수 있도록!
	public FullStack(String name, String major, String phone) {
		//생성된 FullStack 객체의 필드를 DB에서 가지온 값으로 초기화
		this.name = name;
		this.major = major;
		this.phone = phone;
	}

	//getter 메서드
	public String getName() {
		return name;
	}

	public String getMajor() {
		return major;
	}

	public String getPhone() {
		return phone;
	}
	
}
