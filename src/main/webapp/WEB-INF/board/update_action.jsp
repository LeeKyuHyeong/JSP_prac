<%@page import="board.model.BoardDao"%> 
<%@page import="board.model.BoardDto"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	long no = Long.parseLong(request.getParameter("no"));

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
	
	BoardDao boardDao = BoardDao.getInstance();
	boolean result = boardDao.updateBoard(boardDto);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	<%if(result) { %>
		alert("글 수정 성공");
		location.href="content.jsp?no=<%=boardDto.getNo() %>";
	<%}else {%>
		alert("글 수정 실패");
		history.back();
	<%} %>
</script>
</body>
</html>