<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String title = request.getParameter("title");
	String name = request.getParameter("name");
	String pwd = request.getParameter("password");
	String content = request.getParameter("content");
	
	String sql = "INSERT INTO m1board(no, title, name, password, content) ";
		   sql += "VALUES(m1board_seq.nextval, ?, ?, ?, ?)";
		   
	boolean result = false;
	
	Connection conn = null;				//JDBC 연결 위한 객체
	PreparedStatement pstmt = null;		//sql 쿼리문 준비시켜 놓는 객체
	//ResultSet rs = null;
	
	try {
		Class.forName("oracle.jdbc.OracleDriver");												//오라클이 존재한다면
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oj", "oj");	//연결객체 넣어준다
		pstmt = conn.prepareStatement(sql);														//미리 sql넘겨주기
		pstmt.setString(1, title);
		pstmt.setString(2, name);
		pstmt.setString(3, pwd);
		pstmt.setString(4, content);															//?네개 바인딩처리
		
		pstmt.executeUpdate();																	//executeQuery = select할때 거의 
																								//executeUpdate = 글쓰기, 수정, 삭제
		result = true;
		
	} catch(Exception e) {
		e.printStackTrace();
	} finally{		//얻어온 자원 역순으로 닫아준다.
		if(pstmt != null) try{pstmt.close();}catch(Exception e){}
		if(conn != null) try{conn.close();}catch(Exception e){}
	}
	
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