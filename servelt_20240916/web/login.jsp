<%--
  Created by IntelliJ IDEA.
  User: wangwei
  Date: 2024/9/16
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
</head>
<body>
<h1>用户登录</h1>
<form action="login" method="post">
    <label for="username">用户名：</label>
    <input type="text" id="username" name="username" required>
    <br>
    <label for="password">密码：</label>
    <input type="password" id="password" name="password" required>
    <br>
    <input type="submit" value="登录">
</form>
<p><a href="register">注册</a></p>
<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>
</body>
</html>

