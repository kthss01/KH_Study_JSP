package com.kh.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.kh.model.vo.User;

/**
 * Servlet implementation class jQAjaxServlet4
 */
@WebServlet("/jqTest4.do")
public class jQAjaxServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jQAjaxServlet4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<User> list = new ArrayList<>();
		
		list.add(new User(1, "유재석", 30, '남'));
		list.add(new User(2, "한지민", 32, '여'));
		list.add(new User(3, "배수지", 31, '여'));
		list.add(new User(4, "송지효", 30, '여'));
		list.add(new User(5, "김종국", 33, '남'));
		
		int input = Integer.parseInt(request.getParameter("input"));
		 
		/** JSON (JavaScript Object Notation : 자바스크립트 객체 표기법)
		 * - JSON을 사용하여 모든 데이터형을 서버와 주고 받을 수 있다.
		 * 	 (숫자, 문자열, boolean, 배열, 객체, null)
		 * - '{'로 시작하여 '}'로 끝나고 그 속에 데이터를 표기하는데 'key:value' 쌍으로 구성된다.
		 * - key는 문자열로 표현하므로 반드시 쌍따옴표를 해야하고, value는 기본자료형이나 문자열, 배열, 객체가 들어간다.
		 * 	 (단, value로는 char형은 안됨)
		 *   순서는 의미 없고 단지 'key:value'로 올바르게 매핑만 되어있으면 된다.
		 **/
		
		User findUser = null;
		JSONObject jsonUser = null;
		
		for (int i = 0; i < list.size(); i++) {
			
			if (list.get(i).getNo() == input) {
				findUser = list.get(i);
				
				jsonUser = new JSONObject();
				
				jsonUser.put("no", findUser.getNo());
				jsonUser.put("name", findUser.getName());
				jsonUser.put("age", findUser.getAge());
				// char -> string으로 변환해줘야함
				jsonUser.put("gender", findUser.getGender() + "");
			}
		}
		
		// 브라우저로 json 객체 전ㅅㅇ
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// JSONObject 출력하는 방법 3가지 있음
		// 근데 null인 경우가 있을 수 있으므로 jsonUser로 보내는게 좋음
		System.out.println(jsonUser.toJSONString());
		System.out.println(jsonUser.toString());
		System.out.println(jsonUser);
		
		out.print(jsonUser);
		out.flush();
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
