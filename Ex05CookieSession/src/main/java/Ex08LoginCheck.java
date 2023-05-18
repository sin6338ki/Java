

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Ex08LoginCheck")
public class Ex08LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		//로그인 폼 html(클라이언트)에서 요청한 값 받기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//받은 값이 아래와 같이 일치하면 세션을 생성 후 id 저장하고 main 페이지로 이동
		if(id.equals("test") && pw.equals("1234")) {
			//클라이언트로부터 세션 아이디 받기
			HttpSession session = request.getSession();
			//세션에 id 항목에 loginForm으로부터 받은 id값 저장하기
			session.setAttribute("id", id);
			//main 페이지로 이동
			//- forwarding : 데이터를 포함해서 이동하고 싶을 때
			//- Redirecting : 이동하고 싶을 때
			response.sendRedirect("Ex08Main.jsp");
						
		}else {//값이 일치하지 않으면 다시 loginForm 페이지로 이동
			response.sendRedirect("Ex08LoginForm.html");
		}
		
	}

}
