<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录日志</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .log-card {
            margin-top: 20px;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<div class="container mt-5">
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
    <p class="text-center"><a href="welcome.jsp" class="btn btn-secondary">返回首页</a></p>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
