package com.kh.practice.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.PageInfo;
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

	public int getListCount() {
		Connection conn = JDBCTemplate.getConnection();
		
		int listCount = new Prac1Dao().getListCount(conn);
		
		JDBCTemplate.close(conn);
		
		return listCount;
	}

	public ArrayList<Board> selectList(PageInfo pi) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Board> list = new Prac1Dao().selectList(conn, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
}
