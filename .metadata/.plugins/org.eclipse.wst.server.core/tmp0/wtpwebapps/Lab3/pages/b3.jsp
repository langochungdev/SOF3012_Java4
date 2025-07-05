<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>favorites</title>
</head>
<body>
    <h2>${user.fullname}</h2>
    <c:forEach var="f" items="${user.favorites}">
        <div class="video">
            <strong>Tiêu đề:</strong> ${f.video.title} <br>
            <strong>Lượt xem:</strong> ${f.video.views} <br>
            <strong>Mô tả:</strong> ${f.video.description}
        </div>
        <hr>
    </c:forEach>
</body>
</html>
