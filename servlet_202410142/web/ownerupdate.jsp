<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>所有人信息界面</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Arial', sans-serif;
        }
        .container {
            max-width: 900px;
            margin-top: 50px;
            padding: 30px;
            background-color: #fff;
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
        .form-group {
            margin-bottom: 15px;
        }
        .btn-primary {
            background-color: #4e54c8;
            border-color: #4e54c8;
        }
        .btn-primary:hover {
            background-color: #2e3a9f;
            border-color: #2e3a9f;
        }
        .btn-danger {
            background-color: #e74c3c;
            border-color: #e74c3c;
        }
        .btn-danger:hover {
            background-color: #c0392b;
            border-color: #c0392b;
        }
        .footer {
            text-align: center;
            color: #777;
            margin-top: 30px;
        }
        .alert-info {
            margin-top: 20px;
        }
        .table th, .table td {
            vertical-align: middle;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="header">
        <a class="quit" href="servlet.QuitServlet">退出</a>
        <h1>宠物管理系统</h1>
        <ul class="nav justify-content-center">
            <li class="nav-item"><a class="nav-link" href="petsearch.jsp">宠物</a></li>
        </ul>
    </div>

    <form action="servlet.PetOwnerServlet?purpose=upda" method="post">
        <c:forEach items="${ownerList}" var="mess">
            <input type="hidden" name="ownerid" value="${mess.id}">
            <table class="table table-bordered">
                <tr>
                    <th>所有人名称</th>
                    <td><input type="text" class="form-control" name="name" value="${mess.name}"></td>
                </tr>
                <tr>
                    <th>地址</th>
                    <td><input type="text" class="form-control" name="address" value="${mess.address}"></td>
                </tr>
                <tr>
                    <th>城市</th>
                    <td><input type="text" class="form-control" name="city" value="${mess.city}"></td>
                </tr>
                <tr>
                    <th>电话号码</th>
                    <td><input type="text" class="form-control" name="telephone" value="${mess.telephone}"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="submit" class="btn btn-primary btn-block">修改</button>
                    </td>
                </tr>
            </table>
        </c:forEach>
    </form>

    <table class="table table-bordered">
        <c:forEach items="${listFb}" var="info">
        <tr class="alert alert-info">
            <td colspan="2">${info.mess}</td>
        </tr>
        </c:forEach>

        <form action="petsearch.jsp" method="post">
            <button type="submit" class="btn btn-danger btn-block">返回</button>
        </form>

        <form action="servlet.PetOwnerServlet?purpose=upda" method="post">
            <c:forEach items="${newMess}" var="mess">
                <input type="hidden" name="ownerid" value="${mess.id}">
                <table class="table table-bordered">
                    <tr>
                        <th>所有人名称</th>
                        <td><input type="text" class="form-control" name="name" value="${mess.name}"></td>
                    </tr>
                    <tr>
                        <th>地址</th>
                        <td><input type="text" class="form-control" name="address" value="${mess.address}"></td>
                    </tr>
                    <tr>
                        <th>城市</th>
                        <td><input type="text" class="form-control" name="city" value="${mess.city}"></td>
                    </tr>
                    <tr>
                        <th>电话号码</th>
                        <td><input type="text" class="form-control" name="telephone" value="${mess.telephone}"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <button type="submit" class="btn btn-primary btn-block">修改</button>
                        </td>
                    </tr>
                </table>
            </c:forEach>
        </form>

        <table class="table table-bordered">
            <c:forEach items="${listFb}" var="info">
                <tr class="alert alert-info">
                    <td colspan="2">${info.mess}</td>
                </tr>
            </c:forEach>
        </table>


</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
