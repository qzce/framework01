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
	<h1>제어문-반복문</h1>
	<c:forEach begin="1" end="10" step="2" var="idx" varStatus="status">
		<p>${idx }출력${status.index }</p>
	</c:forEach>
	<hr/>
	<%
		ArrayList<String> list=new ArrayList<String>();
		list.add("item1");
		list.add("item2");
		list.add("item3");
		list.add("item4");
		
		HashSet<String> hset=new HashSet<String>();
		hset.add("set1");
		hset.add("set2");
		hset.add("set3");
		hset.add("set4");
		
		HashMap<String,String> hmap=new HashMap<String,String>();
		hmap.put("key1", "val1");
		hmap.put("key2", "val2");
		hmap.put("key3", "val3");
		hmap.put("key4", "val4");
		
		pageContext.setAttribute("alist", hmap);
	%>
	
	<ul>
		<c:forEach items="${alist }" var="msg">
		<li>${status.index}~${msg }</li>
		</c:forEach>
	</ul>
	
</body>
</html>