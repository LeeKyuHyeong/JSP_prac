package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDao;
import board.model.BoardDto;

public class BoardDeleteAction extends AbstractController{

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {

		Long no = Long.parseLong(request.getParameter("no"));
		String pwd = request.getParameter("password");
		BoardDto boardDto = new BoardDto();
		
		boardDto.setNo(no);
		boardDto.setPassword(pwd);
		
		BoardDao boardDao = BoardDao.getInstance();
		
		if(boardDao.deleteBoard(boardDto)) {
			List<BoardDto> list = boardDao.getBoardList();
			
			return new ModelAndView("/WEB-INF/board/list.jsp", "list", list);
		} else {
			ModelAndView mav = new ModelAndView("/WEB-INF/board/result.jsp");
			mav.addObject("msg", "비밀번호가 다릅니다.");
			mav.addObject("url", "javascript:history.back();");
			return mav;
		}
	}
	
}
