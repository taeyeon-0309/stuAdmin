<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2021/4/9
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <!--    <title>欢迎页面-X-admin2.0</title>-->
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
</head>
<body>
<div class="x-body layui-anim layui-anim-up">
    <blockquote class="layui-elem-quote">
        欢迎管理员:<span class="x-red">${sessionScope.ad.a_name}</span>
    </blockquote>
    <fieldset class="layui-elem-field">
        <legend>个人信息</legend>
        <div class="layui-field-box">
            <table class="layui-table">
                <tbody>
                <tr>
                    <th>用户名</th>
                    <td>${sessionScope.ad.a_username}</td></tr>
                <tr>
                    <th>姓名</th>
                    <td>${sessionScope.ad.a_name}</td></tr>
                <tr>
                    <th>电话</th>
                    <td>${sessionScope.ad.a_phone}</td></tr>
                <tr>
                    <th>级别描述</th>
                    <td>${sessionScope.ad.a_describe}</td></tr>
                </tbody>
            </table>
        </div>
    </fieldset>
</div>
</body>
</html>
