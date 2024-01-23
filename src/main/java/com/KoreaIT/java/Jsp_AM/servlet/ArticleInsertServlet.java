package com.KoreaIT.java.Jsp_AM.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import com.KoreaIT.java.Jsp_AM.util.DBUtil;
import com.KoreaIT.java.Jsp_AM.util.SecSql;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/article/doWrite")
public class ArticleInsertServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// DB연결
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 없습니다.");
			e.printStackTrace();
		}

		String url = "jdbc:mysql://127.0.0.1:3306/JSP_AM?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull";
		String user = "root";
		String password = "";
		
		

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, user, password);
			response.getWriter().append("연결 성공!");

			String title = "기본제목";
			String body = "기본내용";
			if (request.getParameter("title") != null && request.getParameter("title").length() != 0) {
				title = request.getParameter("title");
			}
			if (request.getParameter("body") != null && request.getParameter("body").length() != 0) {
				body = request.getParameter("body");
			}
			
			if(!title.equals("기본제목") || !body.equals("기본내용")) {
			SecSql sql = SecSql.from("INSERT INTO article");
			sql.append("SET regDate = NOW(),");
			sql.append("title = ?,", title);
			sql.append("`body` = ?;", body);
			
			System.out.println(sql);
			
			DBUtil.insert(conn, sql);
			}
			
			SecSql sql = SecSql.from("SELECT *");
			sql.append("FROM article");
			sql.append("ORDER BY id DESC");
			sql.append("limit 1;");

			Map<String, Object> insertRow = DBUtil.selectRow(conn, sql);
			
			int lastId = (int)insertRow.get("id");
			
			request.setAttribute("lastId", lastId);
			request.getRequestDispatcher("/jsp/article/doWrite.jsp").forward(request, response);

		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}


