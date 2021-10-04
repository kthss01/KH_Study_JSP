package com.kh.board.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Board;

public class BoardService {

	public int insertBoard(Board b) {
		Connection conn = getConnection();
		
		int result = new BoardDao().insertBoard(conn, b);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);
		
		return result;
	}

	public int updateBoard(Board b) {
		Connection conn = getConnection();
		
		int result = new BoardDao().updateBoard(conn, b);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);
		
		return result;
	}

	public ArrayList<Board> selectBoardList() {
		Connection conn = getConnection();
		
		ArrayList<Board> list = new BoardDao().selectBoardList(conn);
		
		close(conn);
		
		return list;
	}

}
