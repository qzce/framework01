<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String msg="hello el";
	pageContext.setAttribute("msg", msg);
	%>
	<h1>동작</h1>
	<p>${pageScope.msg }</p>
	<p>${requestScope.msg }</p>
	<p>${sessionScope.msg }</p>
	<p>${applicationScope.msg }</p>
</body>
</html>