<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>宠物信息展示</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f1f5f8;
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
        .table th, .table td {
            vertical-align: middle;
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

    <form action="servlet.PetServlet?purpose=send" method="post">
        <table class="table table-bordered table-striped">
            <c:forEach items="${petMess}" var="mess">
                <tr>
                    <th>宠物名称</th>
                    <td><input type="text" class="form-control" name="name" value="${mess.name}" readonly></td>
                </tr>
                <tr>
                    <th>类型</th>
                    <td><input type="text" class="form-control" name="type" value="${mess.type}" readonly></td>
                </tr>
                <tr>
                    <th>出生日期</th>
                    <td><input type="text" class="form-control" name="birthdate" value="${mess.birthDate}" readonly></td>
                </tr>
                <tr>
                    <th>所有人名称</th>
                    <td><input type="text" class="form-control" name="ownername" value="${mess.ownerName}" readonly></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="submit" class="btn btn-primary btn-block">修改信息</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>

    <table class="table table-bordered table-striped">
        <c:forEach items="${petMess}" var="mess">
            <tr>
                <td colspan="2" class="text-center">
                    <form action="servlet.PetVisitServlet?purpose=visitList" method="post">
                        <input type="hidden" name="pet_id" value="${mess.id}">
                        <input type="submit" class="btn btn-info" value="阅览病例">
                    </form>
                </td>
                <td colspan="2" class="text-center">
                    <form action="servlet.PetVisitServlet?purpose=editor" method="post">
                        <input type="hidden" name="pet_name" value="${mess.name}">
                        <input type="submit" class="btn btn-success" value="增加病例">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <table class="table table-bordered table-striped">
        <c:forEach items="${newPetMess}" var="mess">
            <tr>
                <th>宠物名称</th>
                <td><input type="text" class="form-control" name="name" value="${mess.name}" readonly></td>
            </tr>
            <tr>
                <th>类型</th>
                <td><input type="text" class="form-control" name="type" value="${mess.type}" readonly></td>
            </tr>
            <tr>
                <th>出生日期</th>
                <td><input type="text" class="form-control" name="birthdate" value="${mess.birthDate}" readonly></td>
            </tr>
            <tr>
                <th>所有人名称</th>
                <td><input type="text" class="form-control" name="ownername" value="${mess.ownerName}" readonly></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit" class="btn btn-primary btn-block">修改信息</button>
                </td>
            </tr>
        </c:forEach>
    </table>

    <c:forEach items="${listFb}" var="info">
        <div class="alert alert-info" role="alert">${info.mess}</div>
    </c:forEach>


</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
