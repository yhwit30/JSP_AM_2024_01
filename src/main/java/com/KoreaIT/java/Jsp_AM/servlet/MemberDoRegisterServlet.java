package com.KoreaIT.java.Jsp_AM.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import com.KoreaIT.java.Jsp_AM.config.Config;
import com.KoreaIT.java.Jsp_AM.util.DBUtil;
import com.KoreaIT.java.Jsp_AM.util.SecSql;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/doRegister")
public class MemberDoRegisterServlet extends HttpServlet {

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

			///////////
			String loginId = "값없음";
			String loginPw = "값없음";
			String loginPwConfirm = "비번확인";
			String name = "이름없음";

			if (request.getParameter("loginId") != null && request.getParameter("loginId").length() != 0) {
				loginId = request.getParameter("loginId");
			}
			
			SecSql sql = SecSql.from("SELECT *");
			sql.append("FROM `member`");
			sql.append("WHERE loginId = ?;", loginId);

			Map<String, Object> articleRow = DBUtil.selectRow(conn, sql);
			
			if(loginId.equals(articleRow.get("loginId"))) {
				response.getWriter().append(
						String.format("<script>alert('이미 있는 아이디야'); location.replace('register');</script>"));
			}
			
			
						
			if (request.getParameter("loginPw") != null && request.getParameter("loginPw").length() != 0) {
				loginPw = request.getParameter("loginPw");
			}
			if (request.getParameter("name") != null && request.getParameter("name").length() != 0) {
				name = request.getParameter("name");
			}
			if (request.getParameter("loginPwConfirm") != null
					&& request.getParameter("loginPwConfirm").length() != 0) {
				loginPwConfirm = request.getParameter("loginPwConfirm");
			}
			
			if (loginPw.equals(loginPwConfirm) == false) {
				response.getWriter().append(
						String.format("<script>alert('비밀번호 다시 확인해'); location.replace('register');</script>"));

			}
			int id = -1; // 지역전역변수 때문에
				if (!loginId.equals("값없음") && !loginPw.equals("값없음") && !name.equals("이름없음")) {

					sql = SecSql.from("INSERT INTO `member`");
					sql.append("SET regDate = NOW(),");
					sql.append("loginId = ?,", loginId);
					sql.append("loginPw = ?,", loginPw);
					sql.append("`name` = ?;", loginPw);

					id = DBUtil.insert(conn, sql);
				}

			if (id == -1) {
				response.getWriter().append(
						String.format("<script>alert('제대로 입력하시오!!'); location.replace('register');</script>"));
			}

			response.getWriter().append(String
					.format("<script>alert('%d번 회원이 등록되었습니다.'); location.replace('../article/list');</script>", id));

			///////////

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}