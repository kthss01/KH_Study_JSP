package com.session.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTestServlet
 */
@WebServlet("/sessionTest.do")
public class SessionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 세션 생성되어잇으면 생성된거 가져오고 없으면 생성해서 가져옴
		HttpSession session = request.getSession();
		// session 유효기간 설정한다고 함
		// 여기다 음수값 넣으면 무한으로 뜨게 됨
		// invalidate 메소드 쓰는거 아니면 session 제거되지 않고 무한적으로있게 됨 메모리 누수 날 수 있음
		// 따라서 유효시간 작성 안하는게 좋음 0 -1 조심
		session.setMaxInactiveInterval(60); // 1분 여기도 초 단위
		session.setAttribute("testValue", session.getId());
		
		// request dispatcher response, request 가지고 가면서 화면 전환만 일어나고 url 그대로였음
		
		// 화면 전환만 해주는 케이스 (request, response 가지고 가지 않음)
		// root 면 빈문자로 넘어오니까 / 로 해줘야함
		response.sendRedirect(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
