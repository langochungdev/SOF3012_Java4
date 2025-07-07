<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        .video-grid {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            padding: 20px;
        }

        .video-card {
            flex-basis: calc(33.33% - 20px);
            border: 1px solid #e67e22;
            box-shadow: 0 0 4px #ccc;
            font-family: Arial, sans-serif;
            background-color: white;
        }

        .poster {
            height: 150px;
            background-color: #fff;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .poster img {
            max-height: 100%;
            max-width: 100%;
        }

        .title {
            background-color: #e0f0d0;
            padding: 10px;
            font-weight: bold;
            font-size: 14px;
            text-align: center;
        }

        .actions {
            padding: 10px;
            display: flex;
            justify-content: center;
            gap: 10px;
            background-color: #f9f9f9;
        }

        .btn {
            padding: 6px 14px;
            font-size: 14px;
            border: none;
            border-radius: 6px;
            color: white;
            cursor: pointer;
            box-shadow: 2px 2px 4px gray;
            text-decoration: none;
        }

        .btn-like {
            background-color: #4CAF50;
        }

        .btn-share {
            background-color: #f77f2f;
        }

        .pagination {
            display: flex;
            justify-content: center;
            margin-top: 20px;
            gap: 5px;
        }

        .pagination a {
            display: inline-block;
            background-color: #999;
            color: white;
            text-decoration: none;
            padding: 10px 14px;
            font-size: 16px;
            border-radius: 5px;
            box-shadow: 2px 2px 4px #888;
        }

        .pagination a:hover {
            background-color: #777;
        }

        .pagination .disabled {
            opacity: 0.5;
            pointer-events: none;
        }
    </style>
</head>
<body>

<div class="video-grid">
    <c:forEach var="v" items="${videos}">
        <div class="video-card">
            <a href="detail?id=${v.id}">
                <div class="poster">
                    <img src="http://localhost:8080/asm/assets/img/${v.poster}" alt="${v.title}" />
                </div>
            </a>
            <div class="title">${v.title}</div>
            <div class="actions">
                <a href="favorite?id=${v.id}" class="btn btn-like">Like</a>
                <a href="share?id=${v.id}" class="btn btn-share">Share</a>
            </div>
        </div>
    </c:forEach>
</div>

<div class="pagination">
    <c:choose>
        <c:when test="${page > 1}">
            <a href="home?p=1">|&lt;</a>
            <a href="home?p=${page - 1}">&lt;&lt;</a>
        </c:when>
        <c:otherwise>
            <a class="disabled">|&lt;</a>
            <a class="disabled">&lt;&lt;</a>
        </c:otherwise>
    </c:choose>

    <c:choose>
        <c:when test="${page < totalPage}">
            <a href="home?p=${page + 1}">&gt;&gt;</a>
            <a href="home?p=${totalPage}">&gt;|</a>
        </c:when>
        <c:otherwise>
            <a class="disabled">&gt;&gt;</a>
            <a class="disabled">&gt;|</a>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
