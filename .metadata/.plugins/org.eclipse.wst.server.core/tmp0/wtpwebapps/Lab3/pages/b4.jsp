<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Video title</th>
			<th>Người thích</th>
			<th>Ngày thích</th>
		</tr>
		<c:forEach var="u" items="${users}">
			<c:forEach var="f" items="${u.favorites}">
				<tr>
					<td>${f.video.title}</td>
					<td>${u.fullname}</td>
					<td>${f.likeDate}</td>
				</tr>
			</c:forEach>
		</c:forEach>
	</table>
</body>
</html>