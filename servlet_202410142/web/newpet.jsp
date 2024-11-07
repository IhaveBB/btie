<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>增加新宠物</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background: linear-gradient(to right, #4e54c8, #8f94fb);
            font-family: 'Helvetica Neue', Arial, sans-serif;
        }
        .container {
            max-width: 600px;
            margin-top: 50px;
            background-color: #fff;
            padding: 30px;
            border-radius: 15px;
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
            color: #333;
        }
        .form-control {
            border-radius: 6px;
            box-shadow: none;
            transition: border-color 0.3s;
        }
        .form-control:focus {
            border-color: #4e54c8;
        }
        .btn-primary {
            background-color: #4e54c8;
            border-color: #4e54c8;
        }
        .btn-primary:hover {
            background-color: #3b419a;
            border-color: #3b419a;
        }
        .btn-secondary {
            background-color: #ccc;
            border-color: #ccc;
        }
        .btn-secondary:hover {
            background-color: #aaa;
            border-color: #aaa;
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
        <h1>宠物管理系统</h1>
        <ul class="nav justify-content-center">
            <li class="nav-item"><a class="nav-link" href="petsearch.jsp">宠物</a></li>
        </ul>
    </div>

    <form action="servlet.PetServlet?purpose=insert" method="post">
        <div class="form-group">
            <label for="ownerSt">所有人名称</label>
            <select class="form-control" name="ownerSt" id="ownerSt">
                <c:forEach items="${ownerSelect}" var="owner">
                    <option value="${owner.name}">${owner.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="petname">宠物名称</label>
            <input type="text" class="form-control" id="petname" name="petname" required>
        </div>

        <div class="form-group">
            <label for="typeSt">类型</label>
            <select class="form-control" name="typeSt" id="typeSt">
                <c:forEach items="${typeSelect}" var="ts">
                    <option value="${ts.type}">${ts.type}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="birthdate">出生日期</label>
            <input type="date" class="form-control" id="birthdate" name="birthdate" required>
        </div>

        <div class="form-group row">
            <div class="col-6">
                <input type="submit" class="btn btn-primary btn-block" value="添加">
            </div>
            <div class="col-6">
                <form action="petsearch.jsp" method="post">
                    <input type="submit" class="btn btn-secondary btn-block" value="返回">
                </form>
            </div>
        </div>
    </form>

    <c:forEach items="${listFb}" var="info">
        <div class="message">${info.mess}</div>
    </c:forEach>


</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
