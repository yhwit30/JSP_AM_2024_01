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
		String inputLimit = request.getParameter("limit");
		String inputColor = request.getParameter("color");

		int dan = 2;
		if (inputString != null && !inputString.equals("")) {
			dan = Integer.parseInt(inputString);
		}

		int limit = 9;
		if (inputLimit != null && !inputLimit.equals("")) {
			limit = Integer.parseInt(inputLimit);
		}

		if (inputColor == null || inputColor.equals("")) {
			inputColor = "black";
		}

		printWriter.print("<body bgcolor = \"black\">");

		printWriter.append("<h1 style=\"color:" + inputColor + "\">==" + dan + "단==</h1>");

		for (int i = 1; i <= limit; i++) {
			System.out.println();
//			printWriter.append("<div style=\"color:" + inputColor+"\">" + dan + " * " + i + " = " + dan * i + "<br></div>");
			printWriter.append(
					String.format("<div style= \"color:%s\"> %d * %d = %d<br></div>", inputColor, dan, i, dan * i));
		}
		printWriter.print("<body/>");

	}

}
