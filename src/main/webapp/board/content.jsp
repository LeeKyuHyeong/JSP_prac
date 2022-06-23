<%@page import="board.model.BoardDto"%>
<%@page import="board.model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	long no = Long.parseLong(request.getParameter("no"));
	
	BoardDao boardDao = BoardDao.getInstance();
	boolean result = boardDao.updateReadcount(no);
	if(!result) {
%>
	<script>
		alert('해당하는 글이 존재하지 않습니다.');
		location.href='list.jsp';
	</script>		
<%
		return;
	}
	BoardDto boardDto = boardDao.getBoardView(no);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/board.css" type="text/css">
</head>
<body>
<table width="700">
	<caption>글 상세보기</caption>
	<tr>
		<th>글 번호</th>
		<th><%=boardDto.getNo() %></th>
	</tr>
	<tr>
		<th>제목</th>
		<th><%=boardDto.getTitle() %></th>
	</tr>
	<tr>
		<th>이름</th>
		<th><%=boardDto.getName() %></th>
	</tr>
	<tr>
		<th>조회수</th>
		<th><%=boardDto.getReadcount() %></th>
	</tr>
	<tr>
		<th>작성시간</th>
		<th><%=boardDto.getWriteday() %></th>
	</tr>
	<tr>
		<th>내용</th>
		<th><%=boardDto.getContent() %></th>
	</tr>
</table> <br>
<a href="list.jsp">[목록]</a>
<a href="update.jsp?no=<%=boardDto.getNo() %>">[수정]</a>
<a href="delete.jsp?no=<%=boardDto.getNo() %>">[삭제]</a>
</body>
</html>