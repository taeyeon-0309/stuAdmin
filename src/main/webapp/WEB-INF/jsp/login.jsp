<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2021/2/17
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/usersLogin.css?v=100">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="icon" href="/images/favicon.ico" sizes="32x32" />
    <script src="/js/jquery-1.3.2.min.js?v=100"></script>
    <script src="../../js/login.js?v=100"></script>

    <title>宿舍管理系统</title>
</head>
<body class="body">

<div class="login-container">

    <form class="form-signin" action="/login" method="post">
        <div class="form-signin-heading" style="text-align: center">
            <h1 class="sign-title">管理员登录</h1>
            <img src="/images/logo2.jpg" alt=""/>
        </div>
        <div class="login-wrap">
            <label style="color: red">${sessionScope.amsg}</label>
            <input type="text" id="a_username" name="a_username" class="form-control" placeholder="username" style="font-size: 18px" autofocus/>
            <input type="password" id="a_password" name="a_password" class="form-control" placeholder="password" style="font-size: 18px"/>
            <p>
                <a href="/login2" class="other">学生端</a>
            </p>
            <button type="submit" class="btn btn-lg btn-login btn-block">登录</button>
        </div>

    </form>
</div>

</body>

</html>