<%@ page contentType="text/html;charset=UTF-8" %>
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

        .forgot-box {
            width: 400px;
            border: 1px solid #e67e22;
        }

        .forgot-box .header {
            background-color: #e0f0d0;
            padding: 10px;
            font-weight: bold;
            font-size: 16px;
            box-shadow: inset 0 -1px 0 #ccc;
        }

        .forgot-box .body {
            padding: 15px;
        }

        .forgot-box label {
            display: block;
            margin-bottom: 6px;
            font-weight: bold;
            text-transform: uppercase;
        }

        .forgot-box input {
            width: 100%;
            padding: 10px;
            border: 1px solid #e67e22;
            font-size: 14px;
            margin-bottom: 15px;
            outline: none;
        }

        .forgot-box .footer {
            padding: 10px;
            background-color: #f0f0f0;
            text-align: right;
        }

        .btn-retrieve {
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

        .btn-retrieve:hover {
            background-color: #e06600;
        }

        .msg {
            text-align: center;
            font-weight: bold;
            color: red;
            padding-bottom: 10px;
        }
    </style>
</head>
<body>

<div class="center-wrapper">
    <form class="forgot-box" action="forgot-password" method="post">
        <div class="header">Forgot Password</div>

        <div class="body">
            <label for="username">Username?</label>
            <input type="text" name="username" id="username" required />

            <label for="email">Email?</label>
            <input type="email" name="email" id="email" required />

            <div class="msg">${message}</div>
            <div class="msg">${error}</div>
        </div>

        <div class="footer">
            <button type="submit" class="btn-retrieve">Retrieve</button>
        </div>
    </form>
</div>

</body>
</html>
