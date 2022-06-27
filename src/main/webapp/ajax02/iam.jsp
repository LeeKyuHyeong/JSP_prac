<%@ page language="java" contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String msg = null;
	
	if(name.equals("손흥민")) {
		msg = "그래 난 " + age + "살 "+ name + ". 월클이지!";
	} else if(name.equals("이수진")) {
		msg = "그래 난 " + name + ". 수영고수!";
	} else if(name.equals("이기준")) {
		msg = "그래 난 " + name + ". 멍청이지!";
	} else {
		msg = "그래 난 " + name + ". 내이름도 기억해줘...";
	}
%>

<%=msg %>