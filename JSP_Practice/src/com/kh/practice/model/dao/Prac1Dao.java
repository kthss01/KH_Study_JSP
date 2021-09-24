package com.kh.practice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

}
