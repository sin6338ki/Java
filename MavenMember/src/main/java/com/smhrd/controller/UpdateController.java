package com.smhrd.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.WebMember;
import com.smhrd.model.WebMemberDAO;

public class UpdateController implements Command{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		String url ="";
		
		try {
			
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			String email = (String)session.getAttribute("loginEmail");
			System.out.println(email);
			String pw = request.getParameter("pw");
			String tel = request.getParameter("tel");
			String address = request.getParameter("address");
			
			WebMember member = new WebMember(email, pw, tel, address);
			
			WebMemberDAO dao = new WebMemberDAO();
			int cnt = dao.update(member);
			
			if(cnt>0) {
				System.out.println("회원정보 수정 성공");
				session.setAttribute("loginTel", tel);
				session.setAttribute("loginAddress", address);
				url = "index.jsp";
				
			}else {
				System.out.println("회원정보 수정 실패");
				url = "update.jsp";
			}
		}catch (UnsupportedEncodingException e) {
			System.out.println("인코딩 방식 잘못 지정");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}
}
