<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/index.html">메인</a>
	<table>
		<thead>
			<th>id</th>
			<th>username</th>
			<th>age</th>
		</thead>
		<tbody>
			<c:forEach var="item" items="${members}">
				<tr>
					<td>${item.id}</td>
					<td>${item.username}</td>
					<td>${item.age}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>