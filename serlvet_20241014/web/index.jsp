<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.nicebao.model.Message" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="lib/css/bootstrap.min.css">
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

    <!-- 留言板标题 -->
    <h3 class="text-center">所有留言</h3>
    <div class="list-group">
        <!-- 显示所有留言 -->
        <%
            // 获取请求属性中的留言列表
            List<Message> messages = (List<Message>) request.getAttribute("messages");
            if (messages != null && !messages.isEmpty()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                for (Message message : messages) {
        %>
        <div class="list-group-item">
            <strong><%= message.getUserName() %>:</strong>
            <p><%= message.getContent() %></p>
            <small class="text-muted"><%= dateFormat.format(message.getCreatedAt()) %></small>
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

    <!-- 分页导航 -->
    <%
        // 获取当前页码和总页数
        Integer currentPage = (Integer) request.getAttribute("currentPage");
        Integer totalPages = (Integer) request.getAttribute("totalPages");
        if (currentPage == null) currentPage = 1;
        if (totalPages == null) totalPages = 1;
    %>
    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center mt-4">
            <!-- 上一页按钮 -->
            <li class="page-item <%= (currentPage == 1) ? "disabled" : "" %>">
                <a class="page-link" href="?page=<%= currentPage - 1 %>" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>

            <!-- 页码按钮 -->
            <%

                int startPage = Math.max(1, currentPage - 2);
                int endPage = Math.min(totalPages, currentPage + 2);
                for (int i = startPage; i <= endPage; i++) {
            %>
            <li class="page-item <%= (currentPage == i) ? "active" : "" %>">
                <a class="page-link" href="?page=<%= i %>"><%= i %></a>
            </li>
            <% } %>

            <!-- 下一页按钮 -->
            <li class="page-item <%= (currentPage == totalPages) ? "disabled" : "" %>">
                <a class="page-link" href="?page=<%= currentPage + 1 %>" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>

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
<script src="lib/js/bootstrap.min.js"></script>
</body>
</html>
