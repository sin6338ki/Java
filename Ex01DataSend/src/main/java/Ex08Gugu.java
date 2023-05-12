

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex08Gugu")
public class Ex08Gugu extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String color = request.getParameter("color");
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		PrintWriter out = response.getWriter();
		out.print("<table border='1' bgcolor='" + color + "'>");
		for(int j = num1; j<=num2 ; j++) {
			out.print("<tr>");
			for(int i = 1 ; i<=9; i++) {
				out.print("<td>" + j + " * " + i + " = " + j*i + "</td>");
			}
			out.print("</tr>");
		}

		out.print("</table>");
	}

}
