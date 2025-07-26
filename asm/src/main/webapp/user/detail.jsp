<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        * { box-sizing: border-box; }
        body {
            margin: 0;
            font-family: Arial, sans-serif;
        }
        .container {
            display: flex;
            padding: 24px 5%;
            gap: 30px;
        }
        .main-video {
            flex: 7;
            display: flex;
            flex-direction: column;
        }
        .main-video .video-frame {
            width: 100%;
            height: 400px;
            background-color: #fff;
            border: 1px solid #e67e22;
            display: flex;
            align-items: center;
            justify-content: center;
            margin-bottom: 16px;
        }
        .main-video .video-frame img {
            height: 100%;
        }
        .main-video .title {
            font-size: 20px;
            font-weight: bold;
            margin-bottom: 8px;
        }
        .main-video .description {
            font-size: 15px;
            color: #444;
            margin-bottom: 16px;
        }
        .main-video .actions {
            display: flex;
            gap: 10px;
        }
        .btn {
            padding: 8px 18px;
            font-size: 14px;
            border: none;
            border-radius: 20px;
            color: white;
            cursor: pointer;
            box-shadow: 1px 1px 3px gray;
            text-decoration: none;
        }
        .btn-like {
            background-color: #3ea6ff;
        }
        .btn-share {
            background-color: #f77f2f;
        }
        .suggestions {
            flex: 3;
            display: flex;
            flex-direction: column;
            gap: 16px;
        }
        .suggestion-item {
            display: flex;
            gap: 10px;
            cursor: pointer;
            text-decoration: none;
        }
        .suggestion-poster {
            width: 120px;
            height: 68px;
            background-color: #fff;
            border: 1px solid lightgreen;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .suggestion-poster img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }
        .suggestion-title {
            flex: 1;
            font-size: 14px;
            font-weight: bold;
            color: #111;
            line-height: 1.4;
            display: flex;
            align-items: center;
        }
        .suggestion-header {
            font-weight: bold;
            margin-bottom: 8px;
            color: #e67e22;
        }
    </style>
</head>
<body>
<div class="container">
    <!-- Video chính -->
    <div class="main-video">
        <div class="video-frame">
            <img src="http://localhost:8080/asm/assets/img/${video.poster}" alt="poster">
        </div>
        <div class="title">${video.title}</div>
        <div class="description">${video.description}</div>
        <div class="actions">
            <a href="favorite?id=${video.id}" class="btn btn-like">Like</a>
            <a href="share?id=${video.id}" class="btn btn-share">Share</a>
        </div>
    </div>

    <div class="suggestions">
        <div class="suggestion-header">Đã xem gần đây</div>
        <c:choose>
            <c:when test="${not empty historyList}">
                <c:forEach var="v" items="${historyList}">
                    <a href="detail?id=${v.id}" class="suggestion-item">
                        <div class="suggestion-poster">
                            <img src="http://localhost:8080/asm/assets/img/${v.poster}" alt="${v.title}">
                        </div>
                        <div class="suggestion-title">${v.title}</div>
                    </a>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <div style="color: #888; margin-bottom: 10px;">Chưa có lịch sử xem</div>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>

