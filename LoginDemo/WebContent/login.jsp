<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <title>Signin</title>
    <!-- Bootstrap core CSS -->
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="static/css/signin.css" rel="stylesheet">
  </head>
  <% Object msg = request.getAttribute("errorMessage"); %>
  <body>
    <div class="container">
      <form class="form-signin" action="login" method="POST">
        <h2 class="form-signin-heading">登录</h2>
        <label for="inputEmail" class="sr-only">Username</label>
        <input type="text" name="username" class="form-control" placeholder="username" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="password" class="form-control" placeholder="Password" required>
		<span style="color:red"><%= msg!=null?msg:"" %></span>
        <div class="checkbox">
          <label>
            <input type="checkbox" name="remember"> Remember me 1 week
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->
  </body>
</html>
