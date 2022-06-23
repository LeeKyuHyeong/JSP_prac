<%@page import="board.model.BoardDao"%> 
<%@page import="board.model.BoardDto"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	long no = Long.parseLong(request.getParameter("no"));

	
	String pwd = request.getParameter("password");
	
	BoardDto boardDto = new BoardDto();
	boardDto.setNo(no);
	boardDto.setPassword(pwd);
	
	BoardDao boardDao = BoardDao.getInstance();
	boolean result = boardDao.deleteBoard(boardDto);	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">

	if(!confirm('삭제하시겠습니까?')) history.back();

	<%if(result) { %>
		alert("글 삭제 성공");
		location.href="list.jsp";
	<%}else {%>
		alert("비밀번호가 틀립니다.");
		history.back();
	<%} %>
</script>
</body>
</html>