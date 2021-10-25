package com.kh.practice.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.common.JDBCTemplate;
import com.kh.practice.model.vo.Board;

public class Prac2Dao {

	public List<Board> findAll(Connection conn) {
		List<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM BOARD A, MEMBER B WHERE A.WRITER = B.ID AND STATUS = 'Y'";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int no = rs.getInt("NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String writer = rs.getString("WRITER");
				String status = rs.getString("STATUS");
				Date createDate = rs.getDate("CREATE_DATE");
				Date updateDate = rs.getDate("UPDATE_DATE");
				
				list.add(new Board(no, title, content, writer, status, createDate, updateDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
}
