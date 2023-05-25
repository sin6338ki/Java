package com.smhrd.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.WebMember;
import com.smhrd.model.WebMemberDAO;

public class LoginController implements Command {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String url ="";
		
		try {
			
			request.setCharacterEncoding("UTF-8");
			String email = request.getParameter("email");
			String pw = request.getParameter("pw");
			
			WebMember member = new WebMember(email, pw);
			
			WebMemberDAO dao = new WebMemberDAO();
			WebMember loginMember = dao.login(member);
			
			if(loginMember != null) {
				System.out.println("로그인 성공");
				HttpSession session = request.getSession();
				session.setAttribute("loginEmail", loginMember.getEmail());
				session.setAttribute("loginTel", loginMember.getTel());
				session.setAttribute("loginAddress", loginMember.getAddress());
				System.out.println(loginMember.getEmail());
				System.out.println(loginMember.getTel());
				System.out.println(loginMember.getAddress());
				
				url = "index.jsp";
				
			}else {
				System.out.println("로그인 실패");
				url = "index.jsp";
			}
		}catch (UnsupportedEncodingException e) {
			System.out.println("인코딩 방식 잘못 지정");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}
}
