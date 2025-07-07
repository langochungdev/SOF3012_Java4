<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        * { box-sizing: border-box; }
        html, body {
            margin: 0;
            padding: 0;
            height: 100%;
            font-family: Arial, sans-serif;
        }

        .wrapper {
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }

        .admin-nav {
            background: linear-gradient(to bottom, #222, #000);
            border-radius: 10px;
            padding: 15px 25px;
            display: flex;
            align-items: center;
            box-shadow: 0 4px 8px rgba(0,0,0,0.5);
        }

        .admin-logo {
            color: yellow;
            font-weight: bold;
            font-size: 18px;
            text-transform: uppercase;
            margin-right: auto;
        }

        .admin-nav a {
            color: #99ff66;
            margin-left: 30px;
            text-decoration: none;
            font-weight: bold;
            text-transform: uppercase;
            font-size: 14px;
        }

        .admin-nav a:hover {
            text-shadow: 0 0 5px lime;
        }

        main {
            flex: 1;
            padding: 20px;
        }

        .admin-footer {
            background: linear-gradient(to bottom, #222, #000);
            border-radius: 10px;
            padding: 12px 20px;
            text-align: center;
            color: #99ff66;
            font-size: 13px;
            box-shadow: 0 -2px 8px rgba(0,0,0,0.5);
        }
    </style>
</head>
<body>

<div class="wrapper">

    <!-- Navbar -->
    <div class="admin-nav">
        <a href="home" class="admin-logo">Administration Tool</a>
        <a href="home">Home</a>
        <a href="videos">Videos</a>
        <a href="users">Users</a>
        <a href="reports">Reports</a>
        <a href="logout">Logout</a>
    </div>

    <main>
        <c:choose>
    <c:when test="${not empty view}">
        <jsp:include page="${view}.jsp" />
    </c:when>
    <c:otherwise>
        <jsp:include page="homelist.jsp" />
    </c:otherwise>
</c:choose>

    </main>

    <!-- Footer -->
    <footer class="admin-footer">
        © 2025 Administration Panel. All rights reserved.
    </footer>

</div>

</body>
</html>
