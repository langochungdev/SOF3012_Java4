<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        .video-grid { display: flex; flex-wrap: wrap; gap: 20px; padding: 20px; justify-content: center; }
        .video-card {
            flex-basis: calc(33.33% - 20px);
            border: 1px solid #e67e22;
            box-shadow: 0 0 4px #ccc;
            font-family: Arial, sans-serif;
            background: white;
        }
        .poster { height: 150px; display: flex; justify-content: center; align-items: center; }
        .poster img { max-height: 100%; max-width: 100%; }
        .title { padding: 10px; text-align: center; font-weight: bold; background: #e0f0d0; }
        .actions { padding: 10px; text-align: center; background: #f9f9f9; display: flex; justify-content: center; gap: 10px; }
        .btn {
            padding: 6px 14px;
            font-size: 14px;
            border: none;
            border-radius: 6px;
            color: white;
            cursor: pointer;
            text-decoration: none;
        }
        .btn-share { background-color: #f77f2f; }
        .btn-unlike { background-color: #337ab7; }
    </style>
</head>
<body>

<div class="video-grid">
    <c:forEach var="f" items="${favorites}">
        <div class="video-card">
            <a href="detail?id=${f.video.id}">
                <div class="poster">
                    <img src="assets/img/${f.video.poster}" alt="${f.video.title}" />
                </div>
            </a>
            <div class="title">${f.video.title}</div>
            <div class="actions">
                <a href="favorite?action=delete&id=${f.video.id}" class="btn btn-unlike">Unlike</a>
                <a href="share?id=${f.video.id}" class="btn btn-share">Share</a>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>
