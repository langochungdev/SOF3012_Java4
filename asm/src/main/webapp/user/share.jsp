<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

        .share-box {
            width: 350px;
            border: 1px solid #e67e22;
        }

        .share-box .header {
            background-color: #e0f0d0;
            padding: 10px;
            font-weight: bold;
            font-size: 16px;
            box-shadow: inset 0 -1px 0 #ccc;
        }

        .share-box .body {
            padding: 15px;
        }

        .share-box label {
            font-size: 15px;
            font-weight: bold;
            display: block;
            margin-bottom: 8px;
        }

        .share-box input[type="email"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #e67e22;
            font-size: 14px;
            outline: none;
        }

        .share-box .footer {
            padding: 10px;
            background-color: #f0f0f0;
            text-align: right;
            box-shadow: inset 0 1px 0 #ccc;
        }

        .btn-send {
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

        .btn-send:hover {
            background-color: #e06600;
        }
    </style>
</head>
<body>

<div class="center-wrapper">
    <form class="share-box" action="share" method="post">
        <div class="header">Send video to your friend</div>
        <div class="body">
            <label for="email">Your friend’s email?</label>
            <input type="email" name="email" id="email" required />
            <input type="hidden" name="videoId" value="${videoId}" />
        </div>
        <div class="footer">
            <button type="submit" class="btn-send">Send</button>
        </div>
    </form>
</div>

</body>
</html>
