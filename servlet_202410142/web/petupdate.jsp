<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>更新宠物信息</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Arial', sans-serif;
        }
        .container {
            max-width: 800px;
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
        .form-group label {
            font-weight: bold;
        }
        .form-control {
            border-radius: 8px;
            border: 1px solid #ddd;
        }
        .btn-primary {
            background-color: #4e54c8;
            border-color: #4e54c8;
        }
        .btn-primary:hover {
            background-color: #2e3a9f;
            border-color: #2e3a9f;
        }
        .btn-secondary {
            background-color: #ddd;
            border-color: #ddd;
        }
        .footer {
            text-align: center;
            color: #777;
            margin-top: 30px;
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

    <form action="servlet.PetServlet?purpose=upda" method="post">
        <c:forEach items="${petViewList}" var="mess">
            <input type="hidden" name="petid" value="${mess.id}">

            <div class="form-group">
                <label for="petName">宠物名称</label>
                <input type="text" class="form-control" id="petName" name="name" value="${mess.name}" required>
            </div>

            <div class="form-group">
                <label for="petType">类型</label>
                <select class="form-control" id="petType" name="updateType" required>
                    <c:forEach items="${typeList}" var="tl">
                        <option <c:if test="${mess.type eq tl.type}">selected="selected"</c:if> value="${tl.type}">
                                ${tl.type}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="birthDate">出生日期</label>
                <input type="date" class="form-control" id="birthDate" name="birthdate" value="${mess.birthDate}" required>
            </div>

            <div class="form-group">
                <label for="ownerName">所有人名称</label>
                <input type="text" class="form-control" id="ownerName" name="ownername" value="${mess.ownerName}" required>
            </div>

            <div class="form-group text-center">
                <button type="submit" class="btn btn-primary">修改</button>
                <a href="petsearch.jsp" class="btn btn-secondary">返回</a>
            </div>
        </c:forEach>
    </form>

    <c:forEach items="${listFb}" var="info">
        <div class="alert alert-info" role="alert">${info.mess}</div>
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
