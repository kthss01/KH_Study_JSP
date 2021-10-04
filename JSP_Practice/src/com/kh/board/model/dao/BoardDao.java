package com.kh.board.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.board.model.vo.Board;

public class BoardDao {

	public int insertBoard(Connection conn, Board b) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO BOARD VALUES (SEQ_BNO.NEXTVAL,?,?,?,DEFAULT)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getWriter());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateBoard(Connection conn, Board b) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE BOARD SET BOARD_TITLE = ?, BOARD_CONTENT = ? WHERE BOARD_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setInt(3, b.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Board> selectBoardList(Connection conn) {
		
		ArrayList<Board> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM BOARD";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				int no = rset.getInt("NO");
				String writer = rset.getString("WRITER");
				String title = rset.getString("TITLE");
				String content = rset.getString("CONTENT");
				Date date = rset.getDate("DATE");
				
				list.add(new Board(no, title, writer, content, date));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

}
