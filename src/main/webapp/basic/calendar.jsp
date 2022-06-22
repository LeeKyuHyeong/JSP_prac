<%@ page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%! 
	public String dateFormat(int year, int month, int date) {
	return year + "년 " +
		   (month+1) + "월 + " +
			date + "일"; 			
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Calendar c = Calendar.getInstance();	//인스턴스 얻어온 바로 그 시점
	
	//out.println(c.get(Calendar.YEAR) + "년 " + (c.get(Calendar.MONTH)+1) + "월 " + c.get(Calendar.DATE) + "일");
%>
<h1>
	<%-- <%=dateFormat(c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1, c.get(Calendar.DATE)) %> --%>
</h1>
</body>
</html>