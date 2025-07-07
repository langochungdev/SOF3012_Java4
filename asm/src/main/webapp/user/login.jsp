<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String username = "";
    String password = "";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            if (c.getName().equals("user")) {
                try {
                    String decoded = new String(java.util.Base64.getDecoder().decode(c.getValue()));
                    String[] parts = decoded.split("\\|");
                    if (parts.length == 2) {
                        username = parts[0];
                        password = parts[1];
                    }
                } catch (Exception e) {}
            }
        }
    }
    request.setAttribute("savedUsername", username);
    request.setAttribute("savedPassword", password);
%>

<!DOCTYPE html>
<html>
<head>
    <style>
        html, body {
            margin: 0;
            padding: 0;
            height: 100%;
            font-family: Arial, sans-serif;
        }
        .center-wrapper {
            height: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .login-box {
            width: 350px;
            border: 1px solid #e67e22;
        }
        .login-box .header {
            background-color: #e0f0d0;
            padding: 10px;
            font-weight: bold;
            font-size: 16px;
            box-shadow: inset 0 -1px 0 #ccc;
        }
        .login-box .body {
            padding: 15px;
        }
        .login-box label {
            display: block;
            margin-bottom: 6px;
            font-weight: bold;
            text-transform: uppercase;
        }
        .login-box input[type="text"],
        .login-box input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #e67e22;
            font-size: 14px;
            margin-bottom: 15px;
            outline: none;
        }
        .remember {
            display: flex;
            align-items: center;
            margin-bottom: 15px;
            font-weight: bold;
            text-transform: uppercase;
        }
        .remember input[type="checkbox"] {
            margin-right: 10px;
        }
        .login-box .footer {
            padding: 10px;
            background-color: #f0f0f0;
            text-align: right;
        }
        .btn-login {
            background-color: #f77f2f;
            color: white;
            border: none;
            padding: 8px 18px;
            border-radius: 6px;
            font-size: 15px;
            font-weight: bold;
            box-shadow: 2px 2px 4px gray;
            cursor: pointer;
        }
        .btn-login:hover {
            background-color: #e06600;
        }
        .msg {
            text-align: center;
            font-weight: bold;
            color: red;
        }
    </style>
</head>
<body>

<div class="center-wrapper">
    <form class="login-box" action="login" method="post">
        <div class="header">Login</div>

        <div class="body">
            <label for="username">Username?</label>
            <input type="text" name="username" id="username" value="${savedUsername}" required />

            <label for="password">Password?</label>
            <input type="password" name="password" id="password" value="${savedPassword}" required />

            <label class="remember">
                <input type="checkbox" name="remember"
                    <c:if test="${not empty savedUsername and not empty savedPassword}">checked</c:if> />
                Remember me?
            </label>

            <div class="msg">${error}</div>
        </div>

        <div class="footer">
            <button type="submit" class="btn-login">Login</button>
        </div>
    </form>
</div>

</body>
</html>
