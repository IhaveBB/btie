<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.nicebao.model.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.nicebao.listener.OnlineUserListener" %>
<%
    User user = (User) session.getAttribute("user");
    String lastLoginTime = user.getLastLoginTime() != null ? user.getLastLoginTime().toString() : "Never";
    String currentIp = request.getRemoteAddr();
%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            background-size: cover;
            background-repeat: no-repeat;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .container {
            text-align: center;
            padding: 30px;
            border-radius: 8px;
            background-color: rgba(255, 255, 255, 0.9);
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
        }
        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #004085;
        }
        .btn-danger:hover {
            background-color: #c82333;
            border-color: #bd2130;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>欢迎, <%= user.getUsername() %>!</h1>
    <p class="text-center">在线人数: ${OnlineUserListener.getOnlineCount()}</p>
    <p>上次登录时间: <%= lastLoginTime %></p>
    <p>当前 IP 地址: <%= currentIp %></p>
    <a href="${pageContext.request.contextPath}/logs" class="btn btn-primary">查看登录日志</a>
    <a href="${pageContext.request.contextPath}/admin" class="btn btn-primary">管理员页面</a>
    <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger">退出登录</a>
</div>
</body>
</html>
