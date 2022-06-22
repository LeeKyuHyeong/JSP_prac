<%@page import="java.util.Iterator"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;				//쿼리 실행한 결과 데이터를 담고 있는 객체 
	
	String sql = "SELECT no, title, name, writeday, readcount ";
		  sql += "FROM m1board ORDER BY no DESC";	//글번호 역순 으로 정렬
	
	try{
		Class.forName("oracle.jdbc.OracleDriver");												//오라클이 존재한다면
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oj", "oj");	//연결객체 넣어준다
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();		
		
		while(rs.next()) {
%>
	<tr>
		<td><%=rs.getLong("no") %></td>
		<td><%=rs.getString("title") %></td>
		<td><%=rs.getString("name") %></td>
		<td><%=rs.getString("writeday") %></td>
		<td align="right"><%=rs.getInt("readcount") %></td>
	</tr>
<%
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	} finally{		//얻어온 자원 역순으로 닫아준다.
		if(rs != null) try{rs.close();}catch(Exception e){}
		if(pstmt != null) try{pstmt.close();}catch(Exception e){}
		if(conn != null) try{conn.close();}catch(Exception e){}
	}
%>
</table><br/>
<a href="insert.jsp">[글쓰기]</a>
</body>
</html>