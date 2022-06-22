<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Connection conn = null;		//커넥션 객체를 참조
	
	boolean result = false;		//db연결 성공하면 true
	
	try {
		Class.forName("oracle.jdbc.OracleDriver");	//오라클 driver 존재 유무 확인
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oj", "oj");
		result = true;
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		if(conn != null){
			try{
			conn.close();
			} catch(Exception e) {}
		}
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(result){ %>
DB 커넥트 성공
<%}else { %>
DB 오류
<% } %>
</body>
</html>