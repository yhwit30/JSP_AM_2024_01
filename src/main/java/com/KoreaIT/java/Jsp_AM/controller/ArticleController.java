package com.KoreaIT.java.Jsp_AM.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.KoreaIT.java.Jsp_AM.service.ArticleService;
import com.KoreaIT.java.Jsp_AM.util.DBUtil;
import com.KoreaIT.java.Jsp_AM.util.SecSql;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ArticleController {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private Connection conn;
	
	private ArticleService articleService;

	public ArticleController(HttpServletRequest request, HttpServletResponse response, Connection conn) {
		this.conn = conn;
		this.request = request;
		this.response = response;
		
		this.articleService = new ArticleService(conn);
	}

	public void showList() throws ServletException, IOException {
		// 해당 게시글이 있는 목록페이지 - 목록 돌아갈 때 필요
		int page = 1;

		if (request.getParameter("page") != null && request.getParameter("page").length() != 0) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		// 목록에 몇 개의 게시글을 보여줄 지
		int itemsInAPage = articleService.getItemsInAPage();

		int totalPage = articleService.getTotalPage();

		List<Map<String, Object>> articleRows = articleService.getForPrintArticles(page);

		// 로그인 정보 가져오기
		HttpSession session = request.getSession();

		boolean isLogined = false;
		int loginedMemberId = -1;
		Map<String, Object> loginedMember = null;

		if (session.getAttribute("loginedMemberId") != null) {
			isLogined = true;
			loginedMemberId = (int) session.getAttribute("loginedMemberId");
			loginedMember = (Map<String, Object>) session.getAttribute("loginedMember");
		}

		// jsp에 넘겨주기
		request.setAttribute("isLogined", isLogined);
		request.setAttribute("loginedMemberId", loginedMemberId);
		request.setAttribute("loginedMember", loginedMember);
		request.setAttribute("page", page);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("articleRows", articleRows);
		request.getRequestDispatcher("/jsp/article/list.jsp").forward(request, response);

		/////

	}

	public void showDetail() throws ServletException, IOException {
		// 해당 게시글이 있는 목록페이지 - 목록 돌아갈 때 필요
		int page = 1;

		if (request.getParameter("page") != null && request.getParameter("page").length() != 0) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		// 해당 게시글 가져오기
		int id = Integer.parseInt(request.getParameter("id"));

		SecSql sql = SecSql.from("SELECT *");
		sql.append("FROM article");
		sql.append("WHERE id = ?;", id);

		Map<String, Object> articleRow = DBUtil.selectRow(conn, sql);

		// 작성자 정보 가져오기
		sql = SecSql.from("SELECT *");
		sql.append("FROM `member`");
		sql.append("WHERE id = ?;", articleRow.get("memberId"));

		Map<String, Object> memberRow = DBUtil.selectRow(conn, sql);

		// jsp에 넘겨주기
		request.setAttribute("page", page);
		request.setAttribute("articleRow", articleRow);
		request.setAttribute("memberRow", memberRow);
		request.getRequestDispatcher("/jsp/article/detail.jsp").forward(request, response);

	}

	public void goToWrite() throws ServletException, IOException {
		// 로그인이 되어 있는지 확인
		HttpSession session = request.getSession();
		if (session.getAttribute("loginedMemberId") == null) {
			response.getWriter().append(
					String.format("<script>alert('로그인 후 이용해주세요.'); location.replace('../member/login');</script>"));
			return;
		}

		// 현 로그인 id 정보 가져오기
		int loginedMemberId = -1;

		if (session.getAttribute("loginedMemberId") != null) {
			loginedMemberId = (int) session.getAttribute("loginedMemberId");
		}
		
		// jsp에 넘겨주기
		request.setAttribute("loginedMemberId", loginedMemberId);
		request.getRequestDispatcher("/jsp/article/write.jsp").forward(request, response);

	}

	public void goToModify() throws IOException, ServletException {
		// 해당 게시글이 있는 목록페이지 - 목록 돌아갈 때 필요
		int page = 1;

		if (request.getParameter("page") != null && request.getParameter("page").length() != 0) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		// 로그인이 되어 있는지 확인
		HttpSession session = request.getSession();
		if (session.getAttribute("loginedMemberId") == null) {
			response.getWriter().append(
					String.format("<script>alert('로그인 후 이용해주세요.'); location.replace('list?page=%d');</script>", page));
			return;
		}

		// 현 로그인 id 정보 가져오기
		int loginedMemberId = -1;

		if (session.getAttribute("loginedMemberId") != null) {
			loginedMemberId = (int) session.getAttribute("loginedMemberId");
		}

		// 해당 게시글 가져오기
		int id = Integer.parseInt(request.getParameter("id"));

		SecSql sql = SecSql.from("SELECT *");
		sql.append("FROM article");
		sql.append("WHERE id = ?;", id);

		Map<String, Object> articleRow = DBUtil.selectRow(conn, sql);

		// 해당 게시글 작성자와 현 로그인 id 확인하기

		if (articleRow.get("memberId").equals(loginedMemberId) == false) {
			response.getWriter().append(String.format(
					"<script>alert('%d번 글은 수정권한이 없습니다.'); location.replace('list?page=%d');</script>", id, page));
			return;
		}

		// jsp에 넘겨주기
		request.setAttribute("loginedMemberId", loginedMemberId);
		request.setAttribute("page", page);
		request.setAttribute("articleRow", articleRow);
		request.getRequestDispatcher("/jsp/article/modify.jsp").forward(request, response);

	}

}