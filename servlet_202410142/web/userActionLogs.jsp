<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>操作日志</title>
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
<h1>操作日志</h1>

<table>
    <thead>
    <tr>
        <th>IP 地址</th>
        <th>操作 URL</th>
        <th>操作时间</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="log" items="${actionLogs}">
        <tr>
            <td>${log.substring(log.indexOf("IP: ") + 4, log.indexOf(" | URL"))}</td>
            <td>${log.substring(log.indexOf("URL: ") + 5, log.indexOf(" | 操作时间"))}</td>
            <td>${log.substring(log.indexOf("操作时间: ") + 5)}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
