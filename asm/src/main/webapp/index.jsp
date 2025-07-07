<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
* { box-sizing: border-box; }
html, body {
	margin: 0; padding: 0; height: 100%;
	font-family: Arial, sans-serif;
}
.wrapper { min-height: 100vh; display: flex; flex-direction: column; }
nav {
	background-color: #007BFF;
	display: flex;
	align-items: center;
	padding: 10px 20px;
}
.logo {
	color: white;
	font-weight: bold;
	font-size: 18px;
	margin-right: auto;
	text-decoration: none;
	white-space: nowrap;
}
.nav-item { position: relative; margin-left: 20px; }
.nav-item>a {
	color: white; text-decoration: none;
	padding: 8px 12px; display: block;
	white-space: nowrap;
}
.nav-item>a:hover {
	background-color: #0056b3;
	border-radius: 4px;
}
.dropdown {
	display: none;
	position: absolute;
	top: 100%; left: -99px;
	background-color: white;
	min-width: 200px;
	box-shadow: 0 2px 8px rgba(0, 0, 0, 0.2);
	z-index: 1000;
}
.dropdown a {
	color: black;
	padding: 10px 15px;
	display: block;
	text-decoration: none;
	border-bottom: 1px solid #eee;
	white-space: nowrap;
}
.dropdown a:hover { background-color: #f5f5f5; }
.nav-item:hover .dropdown { display: block; }
main { flex: 1; padding: 20px; }
.user-footer {
	background-color: #007BFF;
	color: white;
	text-align: center;
	padding: 12px 20px;
	font-size: 14px;
	border-radius: 0 0 8px 8px;
	box-shadow: 0 -2px 6px rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<div class="wrapper">
		<nav>
    <a href="home" class="logo">Online Entertainment</a>

    <c:if test="${not empty sessionScope.user}">
        <div class="nav-item">
            <a href="favorite">My Favorites</a>
        </div>
    </c:if>

    <div class="nav-item">
        <a href="#">My Account</a>
        <div class="dropdown">
            <c:choose>
                <c:when test="${empty sessionScope.user}">
                    <a href="login">Trang đăng nhập</a>
                    <a href="register">Trang đăng ký</a>
                    <a href="forgot-password">Quên mật khẩu</a>
                </c:when>
                <c:otherwise>
                    <a href="change-password">Trang đổi mật khẩu</a>
                    <a href="profile">Trang cập nhật tài khoản</a>
                    <a href="logout">Đăng xuất, về trang chủ</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>


		<main>
	<c:choose>
		<c:when test="${not empty includePage}">
			<jsp:include page="${includePage}" />
		</c:when>
		<c:otherwise>
			<jsp:include page="homelist.jsp" />
		</c:otherwise>
	</c:choose>
</main>



		<footer class="user-footer">© 2025 Online Entertainment. All rights reserved.</footer>
	</div>
</body>
</html>
