package com.KoreaIT.java.Jsp_AM.controller;

import java.io.IOException;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberController {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Connection conn;

	public MemberController(HttpServletRequest request, HttpServletResponse response, Connection conn) {
		this.conn = conn;
		this.request = request;
		this.response = response;
	}

	public void goToJoin() throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/member/join.jsp").forward(request, response);
	}

	public void goToLogin() throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/member/login.jsp").forward(request, response);
	}		
}
