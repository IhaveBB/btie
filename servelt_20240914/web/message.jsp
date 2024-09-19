<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.nicebao.model.Message" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>留言板</title>
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center">留言板</h2>

    <!-- 用户登录后显示留言表单 -->
    <% if (session.getAttribute("userName") != null) { %>
    <div class="text-center">
        <p>欢迎，<%= session.getAttribute("userName") %>！</p>
        <form action="message" method="post" class="mt-4">
            <div class="form-group">
                <textarea class="form-control" name="content" rows="3" placeholder="请输入留言" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary btn-block">提交留言</button>
        </form>
    </div>
    <% } else { %>
    <!-- 如果未登录则提示登录 -->
    <div class="alert alert-warning text-center" role="alert">
        请 <a href="login.jsp" class="alert-link">登录</a> 后再提交留言。
    </div>
    <% } %>

    <hr>

    <h3 class="text-center">所有留言</h3>
    <div class="list-group">
        <!-- 显示所有留言 -->
        <%
            List<Message> messages = (List<Message>) request.getAttribute("messages");
            if (messages != null && !messages.isEmpty()) {
                for (Message message : messages) {
        %>
        <div class="list-group-item">
            <strong><%= message.getUserName() %>:</strong>
            <p><%= message.getContent() %></p>
            <small class="text-muted"><%= message.getCreatedAt() %></small>
        </div>
        <%
            }
        } else {
        %>
        <div class="list-group-item text-center">
            <p>暂无留言</p>
        </div>
        <%
            }
        %>
    </div>

    <!-- 错误信息提示 -->
    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
    %>
    <div class="alert alert-danger mt-3" role="alert">
        <%= errorMessage %>
    </div>
    <%
        }
    %>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
