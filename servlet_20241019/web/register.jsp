<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            background-image: url('your-background-image.jpg'); /* 替换为你的背景图 */
            background-size: cover;
            background-repeat: no-repeat;
        }
        .register-card {
            max-width: 400px;
            margin: auto;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        .btn-success:hover {
            background-color: #28a745;
            border-color: #218838;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <div class="register-card">
        <h2 class="text-center">注册</h2>
        <form action="register" method="post">
            <div class="form-group">
                <label for="username">用户名:</label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">密码:</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <div class="text-danger">${errorMessage}</div>
            <button type="submit" class="btn btn-success btn-block">注册</button>
        </form>
        <p class="text-center mt-3">已有账号? <a href="login.jsp">登录</a></p>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
