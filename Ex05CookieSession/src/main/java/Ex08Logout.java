

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Ex08Logout")
public class Ex08Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션 삭제
		HttpSession session = request.getSession();
		
		//특정 세션만 삭제
		session.removeAttribute("id");
		//전부 삭제
//		session.invalidate();
		
		//로그인페이지로 이동
		response.sendRedirect("Ex08LoginForm.html");
	}

}
