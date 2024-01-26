package com.KoreaIT.java.Jsp_AM.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.KoreaIT.java.Jsp_AM.util.DBUtil;
import com.KoreaIT.java.Jsp_AM.util.SecSql;

public class ArticleDao {
	private Connection conn;

	public ArticleDao(Connection conn) {
		this.conn = conn;
	}

	public int getTotalPage() {

		// 게시글 전체 개수 가져오는 쿼리
		SecSql sql = SecSql.from("SELECT COUNT(*) AS cnt");
		sql.append("FROM article");

		return DBUtil.selectRowIntValue(conn, sql);
	}

	public List<Map<String, Object>> getForPrintArticles(int page, int itemsInAPage, int limitFrom) {

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
