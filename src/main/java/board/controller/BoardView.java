package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDao;
import board.model.BoardDto;

public class BoardView extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		
		Long no = Long.parseLong(request.getParameter("no"));
		
		BoardDao boardDao = BoardDao.getInstance();
		
		if(boardDao.updateReadcount(no)) {
			BoardDto boardDto = boardDao.getBoardView(no);
			
			return new ModelAndView("/WEB-INF/board/content.jsp", "boardDto", boardDto);			
		} else {
			ModelAndView mav = new ModelAndView("/WEB-INF/board/result.jsp");
			mav.addObject("msg", "존재하지 않는 게시물입니다.");
			mav.addObject("url", "BoardList.do");
			return mav;
		}
		
	}

}
