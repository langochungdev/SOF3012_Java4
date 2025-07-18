<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link rel="stylesheet" href="css/style.css">
<style>
*{
box-sizing: border-box;
}
body {
	font-family: Arial, sans-serif;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

.login-container {
	width: 300px;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

.error {
	color: red;
}

input[type="text"], input[type="password"] {
	width: 100%;
	padding: 8px;
	margin: 10px 0;
}

input[type="submit"] {
	width: 100%;
	padding: 8px;
	background-color: #4CAF50;
	color: white;
	border: none;
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="login-container">
		<h2>Đăng nhập</h2>
		<c:if test="${not empty error}">
			<p class="error">${error}</p>
		</c:if>
		<form action="login" method="post">
			<input type="text" name="idOrEmail" placeholder="id hoặc mail" required> 
			<input type="password" name="password" placeholder="password"required> 
			<input type="submit" value="Đăng nhập">
		</form>
	</div>
</body>
</html>