<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录日志</title>
    <style>
        body {
            font-family: 'Helvetica Neue', Arial, sans-serif;
            background: linear-gradient(to right, #ff7e5f, #feb47b);
            color: #333;
        }
        .log-card {
            margin: 20px auto;
            padding: 20px;
            border-radius: 15px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
            background-color: #ffffff;
            max-width: 600px;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .table {
            width: 100%;
            margin-bottom: 20px;
        }
        a {
            display: inline-block;
            margin: 20px auto;
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
<div class="container">
    <h2 class="text-center">登录日志</h2>
    <div class="log-card">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>登录时间</th>
                <th>登录IP</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="log" items="${logs}">
                <tr>
                    <td>${log.loginTime}</td>
                    <td>${log.loginIp}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <p class="text-center"><a href="welcome.jsp">返回首页</a></p>
</div>
</body>
</html>
