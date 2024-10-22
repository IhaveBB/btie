<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理员页面</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .card {
            margin-bottom: 20px;
        }
        .table td, .table th {
            word-wrap: break-word;
            overflow: hidden;
        }
        .action-description {
            max-width: 200px; /* 根据需要调整最大宽度 */
            white-space: normal; /* 允许文本换行 */
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">管理员系统</a>
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item"><a class="nav-link" href="home.jsp">首页</a></li>
        </ul>
    </div>
</nav>

<div class="container mt-5">
    <h2 class="text-center">管理员页面</h2>

    <div class="row">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">所有用户的登录日志</div>
                <div class="card-body">
                    <table class="table table-bordered">
                        <thead class="thead-dark">
                        <tr>
                            <th>用户ID</th>
                            <th>登录时间</th>
                            <th>登录IP</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${not empty allLogs}">
                            <c:forEach var="log" items="${allLogs}">
                                <tr>
                                    <td>${log.userId}</td>
                                    <td>${log.loginTime}</td>
                                    <td>${log.loginIp}</td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty allLogs}">
                            <tr>
                                <td colspan="3" class="text-center">没有登录记录</td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <div class="col-md-6">
            <div class="card">
                <div class="card-header">所有用户的操作日志</div>
                <div class="card-body">
                    <table class="table table-bordered">
                        <thead class="thead-dark">
                        <tr>
                            <th>用户ID</th>
                            <th>操作时间</th>
                            <th class="action-description">操作描述</th>
                            <th>访问IP</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${not empty allOperationLogs}">
                            <c:forEach var="operationLog" items="${allOperationLogs}">
                                <tr>
                                    <td>${operationLog.userId}</td>
                                    <td>${operationLog.actionTime}</td>
                                    <td class="action-description">${operationLog.url}</td>
                                    <td>${operationLog.ip}</td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty allOperationLogs}">
                            <tr>
                                <td colspan="4" class="text-center">没有操作记录</td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <p class="text-center"><a href="home.jsp" class="btn btn-secondary">返回首页</a></p>
</div>
</body>
</html>
