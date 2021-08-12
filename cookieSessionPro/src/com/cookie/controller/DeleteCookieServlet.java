package com.cookie.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteCookieServlet
 */
@WebServlet("/deleteCookie.do")
public class DeleteCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 삭제를 할 때 빈 객체를 똑같은 이름으로 생성
		Cookie deleteCookie = new Cookie("Id", "");
		deleteCookie.setMaxAge(0);
		
		response.addCookie(deleteCookie);
		
		String html = "<html>";
		html += "<body>";
		html += "<h1>현재 사이트에서 저장한 쿠키값</h1>";
		html += "<ul>";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				html += "<li>" + c.getName() + " : " + c.getValue() + "</li>";
			}
		}
		html += "</ul>";
		// replace로 하게되면 history 내역이 안남게됨
		html += "<button onclick='location.replace(\"deleteCookie.do\");'>쿠키삭제하기</button>";
		// request.getContextPath() context root / 로 주면 "" 으로 나옴
		// error 나오면 이거 참고하라고 하심
		html += "<button onclick='history.back();'>이전페이지로</button>";
		html += "<button onclick='history.go(-1);'>이전페이지로</button>";
		html += "<button onclick='history.go(0);'>새로고침</button>";
		
		html += "</body>";
		html += "</html>";

		response.setContentType("text/html;charset=UTF-8;");
		PrintWriter out = response.getWriter();
		out.print(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}