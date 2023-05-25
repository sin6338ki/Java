package com.smhrd.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Map<String, Command> list = null;

	public void init(ServletConfig config) throws ServletException {
		
		list = new HashMap<>();
		list.put("/join.do", new JoinController());
		list.put("/login.do", new LoginController());
		list.put("/update.do", new UpdateController());			
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String key = reqUri.substring(contextPath.length());
		
		System.out.println(key);
		
		Command controller = list.get(key);
		String des = controller.process(request, response);
		System.out.println(des);
		
		if(des.equals("joinSuccess.jsp") || des.equals("update.jsp")) {
			RequestDispatcher rd = request.getRequestDispatcher(des);
			rd.forward(request, response);
		}else {
			response.sendRedirect(des);
		}	
	}
}
