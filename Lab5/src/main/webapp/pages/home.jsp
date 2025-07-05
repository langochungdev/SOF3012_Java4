<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<body>
    <c:if test="${not empty sessionScope.user}">
        <p>${sessionScope.user.fullname}!</p>
    </c:if>

    <h3>Trang chủ</h3>
    <p>Số lượt khách viếng thăm: ${applicationScope.visitors}</p>

     <a href="${pageContext.request.contextPath}/login?action=logout">Đăng xuất</a>
</body>
</html>
