<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.nicebao.model.User" %>
<%@ page import="com.nicebao.listener.OnlineUserListener" %>
<%
    User user = (User) session.getAttribute("user");
    String lastLoginTime = user.getLastLoginTime() != null ? user.getLastLoginTime().toString() : "从未登录";
    String currentIp = request.getRemoteAddr();
%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>欢迎</title>
    <style>
        body {
            font-family: 'Helvetica Neue', Arial, sans-serif;
            background: linear-gradient(to right, #4facfe, #00f2fe);
            margin: 0;
            padding: 20px;
            color: #333;
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        p {
            font-size: 16px;
            text-align: center;
            margin: 10px 0;
            color: #555;
        }
        a {
            display: inline-block;
            margin: 10px auto;
            padding: 10px 15px;
            background-color: #007BFF;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<h1>欢迎, <%= user.getUsername() %>!</h1>
<p>在线人数: ${OnlineUserListener.getOnlineCount()}</p>
<p>上次登录时间: <%= lastLoginTime %></p>
<p>当前 IP 地址: <%= currentIp %></p>
<a href="${pageContext.request.contextPath}/logs">查看登录日志</a>
<a href="${pageContext.request.contextPath}/logout">退出登录</a>
</body>
</html>
