<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<c:url var="url" value="/account/sign-in" />
	<i>${message}</i>
	<form action="${url}" method="post">
		<input name="username" /><br> <input name="password" type="password" />
		<hr>
		<button>Login</button>
	</form>
</body>
</html>