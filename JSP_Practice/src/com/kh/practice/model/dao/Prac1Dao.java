package com.kh.practice.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.PageInfo;
import com.kh.common.JDBCTemplate;
import com.kh.practice.model.vo.Practice;

public class Prac1Dao {

	public ArrayList<Practice> selectList(Connection conn) {
		
		ArrayList<Practice> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = ("SELECT * FROM TestTable");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
//			pstmt.setString(1, "test");
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				list.add(new Practice(rset.getString(1)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return null;
	}

	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT COUNT(*) FROM BOARD WHERE BOARD_TYPE=1 AND STATUS='Y'";
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if (rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return listCount;
	}

	public ArrayList<Board> selectList(Connection conn, PageInfo pi) {
		
		ArrayList<Board> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM (SELECT ROWNUM RNUM, A.* FROM (SELECT BOARD_NO, CATEGORY_NAME, BOARD_TITLE, USER_ID, COUNT, CREATE_DATE FROM BOARD B JOIN CATEGORY USING(CATEGORY_NO) JOIN MEMBER ON (BOARD_WRITER=USER_NO) WHERE BOARD_TYPE=1 AND B.STATU='Y' OREDER BY BOARD_NO DESC) A) WHERE RNUM BETWEEN ? AND ?";
		
		int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
//				list.add(new Board(
//							rset.getInt("BOARD_NO"),
//							rset.getString("CATEGORY_NAME"),
//							rset.getString("BOARD_TITLE"),
//							rset.getString("USER_ID"),
//							rset.getInt("COUNT"),
//							rset.getDate("CREATE_DATE")
//						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}


}
