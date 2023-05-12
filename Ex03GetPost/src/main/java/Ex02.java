

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex02")
public class Ex02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pwcheck = request.getParameter("pwcheck");
		String gender = request.getParameter("gender");
		String blood = request.getParameter("blood");
		String birth = request.getParameter("birth");
		String[] hobby = request.getParameterValues("hobby");
		String color = request.getParameter("color");
		String text = request.getParameter("text");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("아이디 : " + id);
		out.print("<br>비밀번호 : " + pw);
		
		if(pw.equals(pwcheck)) {
			out.print("<br>비밀번호가 일치합니다");
		}else {
			out.print("<br>비밀번호가 일치하지 않습니다");
		}
		
		out.print("<br>성별 : " + gender);
		out.print("<br>혈액형 : " + blood);
		out.print("<br>생일 : " + birth);
		
		out.print("<br>취미 : ");
		for(int i = 0; i < hobby.length ; i++) {
			out.print(hobby[i] + " ");
		}
		
		out.print("<br>좋아하는 색 : " + color);
		out.print("<br>남기고 싶은 말 : " + text);
	}

}
