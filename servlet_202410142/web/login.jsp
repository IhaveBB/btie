<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>宠物诊所系统登录</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background: linear-gradient(to right, #4e54c8, #8f94fb);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .login-card {
            background-color: #fff;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 400px;
        }
        .login-card h1 {
            color: #4e54c8;
            text-align: center;
            margin-bottom: 30px;
        }
        .form-control:focus {
            border-color: #4e54c8;
            box-shadow: 0 0 0 0.2rem rgba(78, 84, 200, 0.25);
        }
        .btn-primary {
            background-color: #4e54c8;
            border-color: #4e54c8;
        }
        .btn-primary:hover {
            background-color: #3b419a;
            border-color: #3b419a;
        }
        .error-message {
            color: #e74c3c;
            text-align: center;
            margin-top: 10px;
        }
        .login-footer {
            text-align: center;
            color: #777;
            margin-top: 20px;
        }
        .login-footer a {
            color: #4e54c8;
        }
        .login-footer a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="login-card">
    <h1>宠物诊所应用</h1>
    <form action="servlet.EmpServlet" method="post">
        <div class="form-group">
            <label for="username">用户名</label>
            <input type="text" class="form-control" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">密&nbsp;&nbsp;码</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <div class="form-group row">
            <div class="col-6">
                <input type="submit" class="btn btn-primary btn-block" value="登录">
            </div>
            <div class="col-6">
                <input type="reset" class="btn btn-secondary btn-block" value="重置">
            </div>
        </div>
    </form>
    <c:forEach items="${listFb}" var="info">
        <div class="error-message">${info.mess}</div>
    </c:forEach>
    <div class="login-footer">
        <p>©郑州轻工业大学版权所有</p>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
