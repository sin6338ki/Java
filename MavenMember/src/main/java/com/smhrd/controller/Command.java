package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

	public String process(HttpServletRequest request, HttpServletResponse response);
	
}
