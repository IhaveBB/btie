<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>宠物信息查询结果</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f4f6f9;
            font-family: 'Arial', sans-serif;
        }
        .container {
            max-width: 900px;
            margin-top: 50px;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
        }
        .header {
            text-align: center;
            margin-bottom: 30px;
        }
        .header h1 {
            color: #4e54c8;
        }
        .header a.quit {
            color: #fff;
            background-color: #e74c3c;
            padding: 10px 20px;
            border-radius: 6px;
            text-decoration: none;
            font-size: 16px;
            position: absolute;
            top: 30px;
            right: 30px;
        }
        .header a.quit:hover {
            background-color: #c0392b;
        }
        .table th, .table td {
            vertical-align: middle;
        }
        .btn-danger {
            background-color: #e74c3c;
            border-color: #e74c3c;
        }
        .btn-danger:hover {
            background-color: #c0392b;
            border-color: #c0392b;
        }
        .message {
            color: #e74c3c;
            text-align: center;
            margin-top: 15px;
        }
        .footer {
            text-align: center;
            color: #777;
            margin-top: 30px;
        }
        .footer a {
            color: #4e54c8;
        }
        .footer a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="header">
        <a class="quit" href="servlet.QuitServlet">退出</a>
        <h1>宠物诊所应用</h1>
        <ul class="nav justify-content-center">
            <li class="nav-item"><a class="nav-link" href="petsearch.jsp">宠物</a></li>
        </ul>
    </div>

    <table class="table table-bordered table-hover">
        <thead>
        <tr class="table-primary">
            <th>宠物名称</th>
            <th>所有人名称</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${petList}" var="mess">
            <tr>
                <td><a href="servlet.PetServlet?petname=${mess.name}&purpose=see">${mess.name}</a></td>
                <td><a href="servlet.PetOwnerServlet?ownername=${mess.ownerName}&purpose=see">${mess.ownerName}</a></td>
                <td>
                    <form action="servlet.PetServlet?purpose=delete" method="post" class="d-inline">
                        <input type="hidden" name="petName" value="${mess.name}">
                        <input type="hidden" name="ownerName" value="${mess.ownerName}">
                        <button type="submit" class="btn btn-danger btn-sm">删除</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="row">
        <div class="col-12 text-center">
            <form action="petsearch.jsp" method="post">
                <button type="submit" class="btn btn-secondary">重新查询</button>
            </form>
        </div>
    </div>

    <c:forEach items="${listFb}" var="info">
        <div class="message">${info.mess}</div>
    </c:forEach>
</div>

<div class="footer">
    <p>©郑州轻工业大学版权所有</p>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
