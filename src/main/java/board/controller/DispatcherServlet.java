package board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String requestURI = request.getRequestURI();
		String action = requestURI.substring(request.getContextPath().length());
		System.out.println("requestURI : " + requestURI);
		System.out.println("action : " + action);
		
		AbstractController controller = null;
			
		ModelAndView mav = null;				
		
		if(action.equals("/BoardInsert.do")) {
			controller = new BoardInsert();
			mav = controller.handleRequestInternal(request, response);			
		} else if(action.equals("/BoardInsertAction.do")) {
			controller = new BoardInsertAction();
			mav = controller.handleRequestInternal(request, response);
		} else if(action.equals("/BoardList.do")) {
			controller = new BoardList();
			mav = controller.handleRequestInternal(request, response);
		}
		
		if(mav != null) {
			String viewName = mav.getViewName();
			
			if(viewName.startsWith("redirect:")) {
				response.sendRedirect(viewName.substring("redirect:".length()));
				return;
			}
			
			Map<String, Object> map = mav.getModel();
			
			for(String key : map.keySet()) {
				request.setAttribute(key, map.get(key));
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(mav.getViewName());
			dispatcher.forward(request, response);
			
		} else {
			System.out.println("DispatcherServlet에서 길을 잃었다~");
		}
		
	}
}
