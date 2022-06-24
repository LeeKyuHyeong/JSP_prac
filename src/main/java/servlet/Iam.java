package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Iam extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));

		System.out.printf("name : %s, age : %d\n", name, age);
		
		String iam = say(name, age);
		
		request.setAttribute("iam", iam);
		//가려는 url 또는 파일명
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ajax01/iam2.jsp");
		dispatcher.forward(request, response);
		
	}

	private String say(String name, int age) {
		String msg = null;
		
		if (name.equals("손흥민")) {
			msg = "그래 난 " + age + "살 " + name + ". 월클이지!";
		} else if (name.equals("이수진")) {
			msg = "그래 난 " + age + "살 " + name + ". 수영고수!";
		} else if (name.equals("이기준")) {
			msg = "그래 난 " + age + "살 " + name + ". 멍청이지!";
		} else {
			msg = "그래 난 " + age + "살 " + name + ". 내이름도 기억해줘...";
		}
		
		return msg;
	}
}
