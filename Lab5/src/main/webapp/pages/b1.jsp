<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<body>
    <h3>Đăng nhập</h3>
    <form action="login" method="post">
        Username: <input type="text" name="username"/><br/>
        Password: <input type="password" name="password"/><br/>
        <button type="submit">Đăng nhập</button>
    </form>

    <p style="color:red">${error}</p>
</body>
</html>
