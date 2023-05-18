

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/GetSession")
public class GetSession extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//세션 객체 생성
		//세션 아이디는 클라이언트에 저장되어 있음. 클라이언트>>서버 요청 
		HttpSession session = request.getSession();
		
		//-- 세션 값 가져오기
		//getAttirbute(String(name))
		String id = (String)session.getAttribute("id");
		//Object 타입으로 반환 >> 원래 타입으로 다운 캐스팅
		int age = (int)session.getAttribute("age");
		ArrayList<String> al = (ArrayList<String>)session.getAttribute("list");
		
		//응답 데이터 형식
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); //PrintWriter 텍스트 출력 스트림 생성
		out.print("id : " + id + "<br>");
		out.print("age : " + age + "<br>");
		out.print("list : " + al.toString());
	}

}
