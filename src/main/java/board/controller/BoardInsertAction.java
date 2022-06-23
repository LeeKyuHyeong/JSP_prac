package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDao;
import board.model.BoardDto;

public class BoardInsertAction extends AbstractController {

	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		String content = request.getParameter("content");
		
		BoardDto boardDto = new BoardDto();
		boardDto.setTitle(title);
		boardDto.setName(name);
		boardDto.setPassword(pwd);
		boardDto.setContent(content);
				
		System.out.println(boardDto);
		
		BoardDao boardDao = BoardDao.getInstance();
		boolean result = boardDao.insertBoard(boardDto);
		
		if(result) {
			return new ModelAndView("redirect:BoardList.do");			
		} else {
			ModelAndView mav = new ModelAndView("/WEB-INF/board/result.jsp");
			mav.addObject("msg", "글 등록 실패");
			mav.addObject("url", "javascript:history.back();");
			return mav;
		}
		
	}

}
