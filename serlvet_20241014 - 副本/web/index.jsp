<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%
    String userName = (String) session.getAttribute("userName");
    if (userName == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" href="lib/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="jumbotron mt-5">
        <h1 class="display-4">欢迎, ${userName}!</h1>
        <p class="lead">这是您的用户管理系统首页。</p>
        <hr class="my-4">
        <a class="btn btn-danger btn-lg" href="logout" role="button">注销</a>
    </div>
</div>
</body>
</html>
