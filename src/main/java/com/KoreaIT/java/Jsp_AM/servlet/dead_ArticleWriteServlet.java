//package com.KoreaIT.java.Jsp_AM.servlet;
//
//import java.io.IOException;
//import java.util.Map;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//@WebServlet("/article/write")
//public class ArticleWriteServlet extends HttpServlet {
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//
//		// 로그인이 되어 있는지 확인
//		HttpSession session = request.getSession();
//		if(session.getAttribute("loginedMemberId") == null){
//			response.getWriter()
//			.append(String.format("<script>alert('로그인 후 이용해주세요.'); location.replace('../member/login');</script>"));
//			return;
//		}
//		
//		// 현 로그인 id 정보 가져오기
//		int loginedMemberId = -1;
//
//		if (session.getAttribute("loginedMemberId") != null) {
//			loginedMemberId = (int) session.getAttribute("loginedMemberId");
//		}
//		request.setAttribute("loginedMemberId", loginedMemberId);
//
//		request.getRequestDispatcher("/jsp/article/write.jsp").forward(request, response);
//
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//}


