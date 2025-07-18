<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tìm kiếm video</title>
<style type="text/css">
body {
	font-family: Arial, sans-serif;
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	margin: 0;
	background-color: #f4f4f4;
}

.search-container {
	width: 80%;
	max-width: 800px;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: white;
}

h2, h3 {
	text-align: center;
}

form {
	display: flex;
	justify-content: center;
	margin-bottom: 20px;
}

input[type="text"] {
	width: 60%;
	padding: 8px;
	margin-right: 10px;
}

input[type="submit"] {
	padding: 8px 16px;
	background-color: #4CAF50;
	color: white;
	border: none;
	cursor: pointer;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 10px;
}

th, td {
	border: 1px solid #ccc;
	padding: 8px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}
</style>
</head>
<body>
	<div class="search-container">
		<h2>Tìm kiếm video</h2>
		<form action="videoSearch" method="get">
			<label>Nhập từ khóa:</label> <input type="text" name="keyword"
				value="${keyword}"> <input type="submit" value="Tìm kiếm">
		</form>

		<h3>Kết quả tìm kiếm</h3>
		<table>
			<tr>
				<th>Tiêu đề video</th>
				<th>Số lượt thích</th>
				<th>Còn hiệu lực</th>
			</tr>
			<c:forEach var="v" items="${videos}">
				<tr>
					<td>${v.title}</td>
					<td>${v.favorites != null ? v.favorites.size() : 0}</td>
					<td>${v.active ? 'Có' : 'Không'}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>