<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jstl( JavaServer Pages Standard Tag Library)</h1>
	<p><c:out value="1234"></c:out></p>
	<p><c:out value="java"></c:out></p>
	<p><c:out value="${null }">jstl</c:out></p>
	
	<jsp:useBean id="bean" class="com.bit.entity.JavaBean" scope="page"></jsp:useBean>
	<c:set target="${bean }" property="su1" value="1234"></c:set>
	<c:set target="${bean }" property="nalja" value="<%=new java.util.Date() %>"></c:set>
	<ul>
		<li>${bean.su1 }</li>
		<li>${bean.nalja }</li>
	</ul>
</body>
</html>