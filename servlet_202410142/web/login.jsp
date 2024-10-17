<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <link rel="stylesheet" href="lib/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h2 class="text-center mt-5">用户登录</h2>
            <form action="login" method="post" class="mt-4">
                <div class="form-group">
                    <label for="username">用户名</label>
                    <input type="text" class="form-control" id="username" name="userName" placeholder="输入用户名" required>
                </div>
                <div class="form-group">
                    <label for="password">密码</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="输入密码" required>
                </div>
                <button type="submit" class="btn btn-primary btn-block">登录</button>
            </form>
            <c:if test="${not empty errorMessage}">
                <div class="alert alert-danger mt-3" role="alert">
                        ${errorMessage}
                </div>
            </c:if>
            <c:if test="${not empty successMessage}">
                <div class="alert alert-success mt-3" role="alert">
                        ${successMessage}
                </div>
            </c:if>
            <div class="text-center mt-3">
                <a href="register.jsp">还没有账号？立即注册</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
