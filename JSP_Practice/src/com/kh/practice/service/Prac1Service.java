package com.kh.practice.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.practice.model.dao.Prac1Dao;
import com.kh.practice.model.vo.Practice;

public class Prac1Service {

	public ArrayList<Practice> selectList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Practice> list = new Prac1Dao().selectList(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
}
