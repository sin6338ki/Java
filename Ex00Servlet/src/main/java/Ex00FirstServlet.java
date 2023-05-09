

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@~ : 어노테이션(주석) >> 컴파일할 때 한번 확인을 함
//WebServlet : url-mapping해주는 역할
@WebServlet("/First")

// HttpServlet 클래스를 상속 받음
public class Ex00FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//  객체의 직렬화(자바 바이트 형태로 변환)
//	자바 바이트 형태를 다시 객체 형태로 변환 (역직렬화)
//	직렬화와 역직렬화 과정에서 클래스 자체가 변환이 될 수 있음. 따라서 클래스에 버전을 구현한 것
	
//	생성자 : 객체 생성시 사용
//	생서자를 사용하여 객체를 생성했다고 해서 바로 서블릿의 기능을 사용할 수 있는 것은 아님
//	객체 생성 >> 단순 자바 객체 생성 단계 >> 요청과 응답 불가능 >> init 메소드 호출 필요
//	init 메소드 호출함으로 서블릿객체가 되어 통신(요청, 응답)을 할 수 있음
    public Ex00FirstServlet() {
        super();
        System.out.println("생성자 호출!");
    }

//	init 매소드 : 객체가 서블릿 역할을 할 수 있도록 초기화
//  >> 이 작업은 비용이 많이 드는 작업으로 
//  	서버로 요청이 들어올 때마다 작업을 하면 비효율적임
//    	따라서 최초로 요청이 들어오면 객체를 생성하고 init 메소드를 호출 후 서블릿 객체로 초기화 
//    	그 다음 요청이 들어오면 이미 생성되어 있는 객체를 그대로 사용함
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 호출!");
	}

//	destroy 메소드 : 만들어진 서블릿 객체를 소멸시킴
//	서버가 종료되거나 재시작할 때 활용됨
//	이 메소드가 호출되고 난 후 다음 요청이 들어오면 다시 객체를 생성하고 init 메소드를 호출
	public void destroy() {
		System.out.println("destroy 호출!");
	}

//	service 메소드 : 사용자의 요청과 응답을 처리
//	대부분의 기능은 service에서 작성
//	1. 모든 요청은 service에서 받음
//	2. GET/POST에 따라 다르게 처리하고 싶은 경우
//		service가 doGET 혹은 doPost 메소드가 호출되도록 할 수 있음
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service 호출!");
		super.service(request, response);
	}

//	http 요청 메소드가 GET일 경우
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 호출!");
	}

//	http 요청 메소드가 POST일 경우
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 호출!");
	}

}
