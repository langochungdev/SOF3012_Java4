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

        .change-box {
            width: 600px;
            border: 1px solid #e67e22;
        }

        .change-box .header {
            background-color: #e0f0d0;
            padding: 10px;
            font-weight: bold;
            font-size: 16px;
            box-shadow: inset 0 -1px 0 #ccc;
        }

        .change-box .body {
            padding: 15px;
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
        }

        .form-group {
            flex: 1 1 calc(50% - 20px);
        }

        .form-group label {
            display: block;
            margin-bottom: 6px;
            font-weight: bold;
            text-transform: uppercase;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #e67e22;
            font-size: 14px;
            outline: none;
        }

        .change-box .footer {
            padding: 10px;
            background-color: #f0f0f0;
            text-align: right;
        }

        .btn-change {
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

        .btn-change:hover {
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
    <form class="change-box" action="${pageContext.request.contextPath}/change-password" method="post">
        <div class="header">Change Password</div>

        <div class="body">
            <div class="form-group">
                <label for="current">Current Password?</label>
                <input type="password" name="currentPassword" id="current" required />
            </div>

            <div class="form-group">
                <label for="newpass">New Password?</label>
                <input type="password" name="newPassword" id="newpass" required />
            </div>

            <div class="form-group">
                <label for="confirm">Confirm New Password?</label>
                <input type="password" name="confirmPassword" id="confirm" required />
            </div>
        </div>

        <div class="msg">${message}</div>
        <div class="msg">${error}</div>

        <div class="footer">
            <button type="submit" class="btn-change">Change</button>
        </div>
    </form>
</div>

</body>
</html>
