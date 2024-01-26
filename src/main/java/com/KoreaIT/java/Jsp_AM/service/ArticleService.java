package com.KoreaIT.java.Jsp_AM.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.KoreaIT.java.Jsp_AM.util.DBUtil;
import com.KoreaIT.java.Jsp_AM.util.SecSql;

public class ArticleService {
	private Connection conn;

	public ArticleService(Connection conn) {
		this.conn = conn;
	}

	public int getItemsInAPage() {
		return 10;
	}

	public int getTotalPage() {
		int itemsInAPage = getItemsInAPage();
		
		SecSql sql = SecSql.from("SELECT COUNT(*) AS cnt");
		sql.append("FROM article");

		int totalCnt = DBUtil.selectRowIntValue(conn, sql);
		int totalPage = (int) Math.ceil(totalCnt / (double) itemsInAPage);

		return totalPage;
	}

	public List<Map<String, Object>> getForPrintArticles(int page) {
		int itemsInAPage = getItemsInAPage();
		int limitFrom = (page - 1) * itemsInAPage;
		
		// 전 게시글 가져오는 쿼리
		SecSql sql = SecSql.from("SELECT A.*, M.name AS writer");
		sql.append("FROM article AS A");
		sql.append("INNER JOIN `member` AS M");
		sql.append("ON A.memberId = M.id");
		sql.append("ORDER BY id DESC");
		sql.append("LIMIT ?, ?;", limitFrom, itemsInAPage);
		
		return DBUtil.selectRows(conn, sql);
	}

}
