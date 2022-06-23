<%@page import="board.model.BoardDao"%>
<%@page import="board.model.BoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	BoardDao boardDao = BoardDao.getInstance();
	System.out.println("리스트에서의 싱글톤hash : " + boardDao.hashCode());
	List<BoardDto> list = boardDao.getBoardList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/board.css" type="text/css">
</head>
<body>
<table width="600">
	<caption>게시판 리스트</caption>
	<tr>
		<th>글 번호</th>
		<th>제목</th>
		<th>이름</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	<% for(BoardDto dto : list) {%>
	<tr>
		<td><%=dto.getNo() %></td>
		<td><%=dto.getTitle() %></td>
		<td><%=dto.getName() %></td>
		<td><%=dto.getWriteday() %></td>
		<td align="right"><%=dto.getReadcount() %></td>
		<%-- <td><%=rs.getString("title") %></td>
		<td><%=rs.getString("name") %></td>
		<td><%=rs.getString("writeday") %></td>
		<td align="right"><%=rs.getInt("readcount") %></td> --%>
	</tr>
	<% } %>
</table><br/>
<a href="insert.jsp">[글쓰기]</a>
</body>
</html>