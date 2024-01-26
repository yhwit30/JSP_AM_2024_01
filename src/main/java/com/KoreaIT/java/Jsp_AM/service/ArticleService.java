package com.KoreaIT.java.Jsp_AM.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.KoreaIT.java.Jsp_AM.dao.ArticleDao;
import com.KoreaIT.java.Jsp_AM.util.DBUtil;
import com.KoreaIT.java.Jsp_AM.util.SecSql;

public class ArticleService {
	private Connection conn;

	private ArticleDao articleDao;

	public ArticleService(Connection conn) {
		this.conn = conn;
		this.articleDao = new ArticleDao(conn);
	}

	public int getItemsInAPage() {
		return 10;
	}

	public int getTotalPage() {
		int itemsInAPage = getItemsInAPage();
		int totalCnt = articleDao.getTotalPage();
		int totalPage = (int) Math.ceil(totalCnt / (double) itemsInAPage);

		return totalPage;
	}

	public List<Map<String, Object>> getForPrintArticles(int page) {
		int itemsInAPage = getItemsInAPage();
		int limitFrom = (page - 1) * itemsInAPage;

		return articleDao.getForPrintArticles(page, itemsInAPage, limitFrom);
	}

}
