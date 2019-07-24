<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
</head>
<body>
	<h1>EL 표현식</h1>
	<table>
		<tr>
			<th>출력</th>
			<th>Java</th>
			<th>EL</th>
		</tr>
		<tr>
			<td>String</td>
			<td><%="abcd" %></td>
			<td>${"ABCD" }</td>
		</tr>
		<tr>
			<td>String</td>
			<td><% out.print("ABCD"); %></td>
			<td>${"ABCD" }</td>
		</tr>
		<tr>
			<td>숫자(정수)</td>
			<td><%=1234 %></td>
			<td>${1234+1 }</td>
		</tr>
		<tr>
			<td>숫자(정수-나눗셈)</td>
			<td><%=5/2 %></td>
			<td>${5/2 }</td>
		</tr>
		<tr>
			<td>true/false</td>
			<td><%=3<4 %></td>
			<td>${4 gt 3 }</td>
		</tr>
		<tr>
			<td>true/false</td>
			<td><%=3<4 %></td>
			<td>${4 ge 6 }</td>
		</tr>
	</table>
</body>
</html>