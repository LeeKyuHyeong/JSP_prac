<%@page import="board.model.BoardDao"%> 
<%@page import="board.model.BoardDto"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String title = request.getParameter("title");
	String name = request.getParameter("name");
	String pwd = request.getParameter("password");
	String content = request.getParameter("content");
	
	BoardDto boardDto = new BoardDto();
	
	boardDto.setTitle(title);
	boardDto.setName(name);
	boardDto.setPassword(pwd);
	boardDto.setContent(content);
	
	BoardDao boardDao = BoardDao.getInstance();
	System.out.println("인서트 액션에서의 싱글톤hash : " + boardDao.hashCode());
	boolean result = boardDao.insertBoard(boardDto);
	
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
		alert("글 등록 성공");
		location.href="list.jsp";
	<%}else {%>
		alert("글 등록 실패");
		history.back();
	<%} %>
</script>
</body>
</html>