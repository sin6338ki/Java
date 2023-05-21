

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Pr08LoginCheck")
public class Pr08LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		HttpSession session = request.getSession();
		
		if(id.equals("test") && pw.equals("12345")) {
			session.setAttribute("loginId", id);
			response.sendRedirect("Pr08Main.jsp");
		}else {
			response.sendRedirect("Pr08LoginForm.html");
		}
	}

}
