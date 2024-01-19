package com.KoreaIT.java.Jsp_AM;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/printDan")
public class HomeMainServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		response.getWriter().append("hello world").append(request.getContextPath());
		
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().append("==8단==<br>");
		
		for(int i = 1; i <= 9; i++) {
			System.out.println();
			response.getWriter().append("8 * "+ i + " = " + 8*i + "<br>");
		}
		
		
	}

}




