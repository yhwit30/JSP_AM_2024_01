//package com.KoreaIT.java.Jsp_AM.servlet;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Map;
//
//import com.KoreaIT.java.Jsp_AM.config.Config;
//import com.KoreaIT.java.Jsp_AM.exception.SQLErrorException;
//import com.KoreaIT.java.Jsp_AM.util.DBUtil;
//import com.KoreaIT.java.Jsp_AM.util.SecSql;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//@WebServlet("/article/detail")
//public class ArticleDetailServlet extends HttpServlet {
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//		// DB연결
//		try {
//			Class.forName(Config.getDbDriverClassName());
//		} catch (ClassNotFoundException e) {
//			System.out.println("클래스가 없습니다.");
//			e.printStackTrace();
//		}
//
//
//		Connection conn = null;
//
//		try {
//			conn = DriverManager.getConnection(Config.getDbUrl(), Config.getDbUser(), Config.getDbPw());
//			response.getWriter().append("연결 성공!");
//
//			// 해당 게시글이 있는 목록페이지 - 목록 돌아갈 때 필요
//			int page = 1;
//
//			if (request.getParameter("page") != null && request.getParameter("page").length() != 0) {
//				page = Integer.parseInt(request.getParameter("page"));
//			}
//			
//			
//			//해당 게시글 가져오기
//			int id = Integer.parseInt(request.getParameter("id"));
//
//			SecSql sql = SecSql.from("SELECT *");
//			sql.append("FROM article");
//			sql.append("WHERE id = ?;", id);
//
//			Map<String, Object> articleRow = DBUtil.selectRow(conn, sql);
//			
//			
//			//작성자 정보 가져오기
//			sql = SecSql.from("SELECT *");
//			sql.append("FROM `member`");
//			sql.append("WHERE id = ?;", articleRow.get("memberId"));
//			
//			Map<String, Object> memberRow = DBUtil.selectRow(conn, sql);
//			
//			
//
//			request.setAttribute("page", page);
//			request.setAttribute("articleRow", articleRow);
//			request.setAttribute("memberRow", memberRow);
//			request.getRequestDispatcher("/jsp/article/detail.jsp").forward(request, response);
//
//		} catch (SQLException e) {
//			System.out.println("에러 : " + e);
//		} catch (SQLErrorException e) {
//			e.getOrigin().printStackTrace();
//
//		} finally {
//			try {
//				if (conn != null && !conn.isClosed()) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doGet(request, response);
//	}
//}



