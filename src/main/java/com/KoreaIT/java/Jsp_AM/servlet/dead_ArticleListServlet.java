//package com.KoreaIT.java.Jsp_AM.servlet;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.List;
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
//@WebServlet("/article/list")
//public class ArticleListServlet extends HttpServlet {
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
//		Connection conn = null;
//
//		try {
//			conn = DriverManager.getConnection(Config.getDbUrl(), Config.getDbUser(), Config.getDbPw());
//
//			// 해당 게시글이 있는 목록페이지 - 목록 돌아갈 때 필요
//			int page = 1;
//
//			if (request.getParameter("page") != null && request.getParameter("page").length() != 0) {
//				page = Integer.parseInt(request.getParameter("page"));
//			}
//
//			//목록에 몇 개의 게시글을 보여줄 지
//			int itemsInAPage = 10;
//			int limitFrom = (page - 1) * itemsInAPage;
//
//			SecSql sql = SecSql.from("SELECT COUNT(*) AS cnt");
//			sql.append("FROM article");
//
//			int totalCnt = DBUtil.selectRowIntValue(conn, sql);
//			int totalPage = (int) Math.ceil(totalCnt / (double) itemsInAPage);
//
//			//전 게시글 가져오는 쿼리
//			sql = SecSql.from("SELECT A.*, M.name AS writer");
//			sql.append("FROM article AS A");
//			sql.append("INNER JOIN `member` AS M");
//			sql.append("ON A.memberId = M.id");
//			sql.append("ORDER BY id DESC");
//			sql.append("LIMIT ?, ?;", limitFrom, itemsInAPage);
//
//			List<Map<String, Object>> articleRows = DBUtil.selectRows(conn, sql);
//			
//			//로그인 정보 가져오기
//			HttpSession session = request.getSession();
//			
//			boolean isLogined = false;
//			int loginedMemberId = -1;
//			Map<String, Object> loginedMember = null;
//
//			if (session.getAttribute("loginedMemberId") != null) {
//				isLogined = true;
//				loginedMemberId = (int) session.getAttribute("loginedMemberId");
//				loginedMember = (Map<String, Object>) session.getAttribute("loginedMember");
//			}
//
//			
//			request.setAttribute("isLogined", isLogined);
//			request.setAttribute("loginedMemberId", loginedMemberId);
//			request.setAttribute("loginedMember", loginedMember);
//
//			request.setAttribute("page", page);
//			request.setAttribute("totalPage", totalPage);
//			request.setAttribute("articleRows", articleRows);
//			request.getRequestDispatcher("/jsp/article/list.jsp").forward(request, response);
//			
//			/////
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
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doGet(request, response);
//	}
//}

