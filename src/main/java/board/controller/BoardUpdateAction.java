package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDao;
import board.model.BoardDto;

public class BoardUpdateAction extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		BoardDao boardDao = BoardDao.getInstance();
		Long no = Long.parseLong(request.getParameter("no"));
		
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		String content = request.getParameter("content");
		
		BoardDto boardDto = new BoardDto();
		boardDto.setNo(no);
		boardDto.setTitle(title);
		boardDto.setName(name);
		boardDto.setPassword(pwd);
		boardDto.setContent(content);

		if(boardDao.updateBoard(boardDto)) {
			return new ModelAndView("redirect:BoardView.do?no=" + no);
		} else {
			ModelAndView mav = new ModelAndView("/WEB-INF/board/result.jsp");
			mav.addObject("msg", "비밀번호가 다릅니다.");
			mav.addObject("url", "javascript:history.back();");
			return mav;
		}				
	}
}
