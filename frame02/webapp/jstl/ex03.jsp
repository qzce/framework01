<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="msgs" value="java,web,db,spring"></c:set>
	<c:forTokens items="${msgs }" delims="," var="msg">
		<p>${msg }</p>
	</c:forTokens>
	<p>begin</p>
	<c:import url="ex02.jsp"></c:import>
	<p>end</p>
	<c:url value="target.jsp" var="target">
		<c:param name="id" value="admin"></c:param>
	</c:url>
	
	<a href="${target }">link</a>
</body>
</html>