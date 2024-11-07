<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>登录日志</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
    </style>
</head>
<body>
<h1>登录日志</h1>

<table>
    <thead>
    <tr>
        <th>IP 地址</th>
        <th>登录时间</th>
        <th>登录状态</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="log" items="${loginLogs}">
        <tr>
            <td>${log.substring(log.indexOf("IP: ") + 4, log.indexOf(" | 登录时间"))}</td>

            <td>${log.substring(log.indexOf("登录时间: ") + 5, log.indexOf(" | 登录状态"))}</td>

            <td>${log.substring(log.indexOf("登录状态: ") + 5)}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
