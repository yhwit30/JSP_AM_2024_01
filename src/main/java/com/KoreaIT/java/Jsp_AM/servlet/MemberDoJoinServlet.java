package com.KoreaIT.java.Jsp_AM.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.KoreaIT.java.Jsp_AM.config.Config;
import com.KoreaIT.java.Jsp_AM.exception.SQLErrorException;
import com.KoreaIT.java.Jsp_AM.util.DBUtil;
import com.KoreaIT.java.Jsp_AM.util.SecSql;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/doJoin")
public class MemberDoJoinServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// DB연결
		try {
			Class.forName(Config.getDbDriverClassName());
		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 없습니다.");
			e.printStackTrace();
		}

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(Config.getDbUrl(), Config.getDbUser(), Config.getDbPw());

			//아이디 중복체크
			String loginId = request.getParameter("loginId");
			String loginPw = request.getParameter("loginPw");
			String name = request.getParameter("name");
			
			SecSql sql = SecSql.from("SELECT count(*) AS cnt");
			sql.append("FROM `member`");
			sql.append("WHERE loginId = ?;", loginId);
			
			boolean isJoinableLoginId = DBUtil.selectRowIntValue(conn, sql) == 0;
			if(isJoinableLoginId == false) {
				response.getWriter().append(String.format(
						"<script>alert('%s 아이디는 이미 사용중입니다.'); location.replace('../member/join');</script>", loginId));
				return;
			}
			
			//회원정보 DB에 넣는 쿼리
			sql = SecSql.from("INSERT INTO `member`");
			sql.append("SET regDate = NOW(),");
			sql.append("loginId = ?,", loginId);
			sql.append("loginPw = ?,", loginPw);
			sql.append("`name` = ?;", name);

			DBUtil.insert(conn, sql);

			response.getWriter().append(String.format(
					"<script>alert('%s님, 환영합니다. 회원가입이 완료되었습니다.'); location.replace('../article/list');</script>", name));
			///
			
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} catch (SQLErrorException e) {
			e.getOrigin().printStackTrace();
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}