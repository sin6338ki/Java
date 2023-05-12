

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex04Operation")
public class Ex04Operation extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String ope = request.getParameter("ope");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(ope.equals("+")) {
			out.print(num1 + " + " + num2 + " = " + (num1 + num2));
		}else if(ope.equals("-")) {
			out.print(num1 + " - " + num2 + " = " + (num1 - num2));
		}else if(ope.equals("*")) {
			out.print(num1 + " * " + num2 + " = " + (num1 * num2));
		}else {
			out.print(num1 + " / " + num2 + " = " + (num1 / num2));
		}
		
	}

}
