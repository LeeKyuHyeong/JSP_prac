package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GameServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int you = Integer.parseInt(request.getParameter("you"));
		int com = (int) (Math.random() * 3) + 1;

		System.out.println(you + ", " + com);

		request.setAttribute("you", choose(you));
		request.setAttribute("com", choose(com));
		request.setAttribute("win", whoWinner(you, com));

		RequestDispatcher dispatcher = request.getRequestDispatcher("/game/game_action.jsp");
		dispatcher.forward(request, response);

	}

	private String whoWinner(int you, int com) {
		int result = you - com;
		
		if(result == -2 || result == 1) {
			return "당신의 승리입니다.";
		} else if (result == 0) {
			return "무승부입니다.";
		} else {
			return "패배입니다.";
		}			
	}

	public String choose(int key) {

		switch (key) {
		case 1:
			return "가위";
		case 2:
			return "바위";
		case 3:
			return "보";
		default:
			return "에러";
		}
	}
}
