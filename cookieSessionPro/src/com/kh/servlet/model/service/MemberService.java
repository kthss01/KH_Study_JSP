package com.kh.servlet.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.kh.servlet.common.JDBCTemplate;
import com.kh.servlet.model.dao.MemberDao;
import com.kh.servlet.model.vo.Member;

public class MemberService {

	public Member login(String userId, String password) {
		Connection conn = JDBCTemplate.getConnection();
		
		Member m = new MemberDao().login(conn, userId, password);
		
		try {
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return m;
	}

}
