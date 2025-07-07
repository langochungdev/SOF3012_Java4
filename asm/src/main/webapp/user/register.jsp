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

        .register-box {
            width: 600px;
            border: 1px solid #e67e22;
        }

        .register-box .header {
            background-color: #e0f0d0;
            padding: 10px;
            font-weight: bold;
            font-size: 16px;
            box-shadow: inset 0 -1px 0 #ccc;
        }

        .register-box .body {
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

        .register-box .footer {
            padding: 10px;
            background-color: #f0f0f0;
            text-align: right;
        }

        .btn-submit {
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

        .btn-submit:hover {
            background-color: #e06600;
        }

        .message {
            color: green;
            font-weight: bold;
            margin-top: 10px;
        }

        .error {
            color: red;
            font-weight: bold;
            margin-top: 10px;
        }
    </style>
</head>

<body>

    <div class="center-wrapper">
        <form class="register-box" action="register" method="post">
            <div class="header">Registration</div>

            <div class="body">
                <div class="form-group">
                    <label for="id">Username?</label>
                    <input type="text" name="id" id="id" required />
                </div>

                <div class="form-group">
                    <label for="password">Password?</label>
                    <input type="password" name="password" id="password" required />
                </div>

                <div class="form-group">
                    <label for="fullname">Fullname?</label>
                    <input type="text" name="fullname" id="fullname" required />
                </div>

                <div class="form-group">
                    <label for="email">Email Address?</label>
                    <input type="email" name="email" id="email" required />
                </div>
            </div>

            <div class="footer">
                <button type="submit" class="btn-submit">Sign Up</button>
            </div>

            <div align="center">
                <p class="message">${message}</p>
                <p class="error">${error}</p>
            </div>
        </form>
    </div>

</body>

</html>
