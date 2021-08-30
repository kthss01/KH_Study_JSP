package com.kh.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.vo.Board;
import com.kh.board.service.BoardService;

@WebServlet("/binsert")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("btitle");
		String writer = request.getParameter("bwriter");
		String content = request.getParameter("bcontent");
		
		// not null 조건이라 처리
		if (title == null || title.equals("") ||
			writer == null || writer.equals("") ||
			content == null || content.equals("")) {
			String message = "게시글 등록 실패!";
			request.setAttribute("message", message);
			
			request.getRequestDispatcher(request.getContextPath() + "/views/common/error.jsp").forward(request, response);
		}
		
		Board b = new Board(title, writer, content);
		
		int result = new BoardService().insertBoard(b);
		
		if (result > 0) {
			response.sendRedirect(request.getContextPath() + "/blist");
		} else {
			String message = "게시글 등록 실패!";
			request.setAttribute("message", message);
			
			request.getRequestDispatcher(request.getContextPath() + "/views/common/error.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
