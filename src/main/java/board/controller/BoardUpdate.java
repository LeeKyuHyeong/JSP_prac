package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDao;
import board.model.BoardDto;

public class BoardUpdate extends AbstractController{

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		BoardDao boardDao = BoardDao.getInstance();
		Long no = Long.parseLong(request.getParameter("no"));
		
		BoardDto boardDto = boardDao.getBoardView(no);
		
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		
		return new ModelAndView("/WEB-INF/board/update.jsp", "boardDto", boardDto);
	}
	
}
