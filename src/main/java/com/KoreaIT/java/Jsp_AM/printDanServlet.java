package com.KoreaIT.java.Jsp_AM;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/printDan")
public class printDanServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		PrintWriter printWriter = response.getWriter();

		String inputString = request.getParameter("dan");
		int dan = 2;
		if (inputString != null && !inputString.equals(""))
			dan = Integer.parseInt(inputString);

		
		printWriter.append("==" + dan + "단==<br>");

		for (int i = 1; i <= 9; i++) {
			System.out.println();
			printWriter.append(dan+ " * " + i + " = " + dan * i + "<br>");
		}

	}

}


