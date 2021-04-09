<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2021/3/2
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>修改信息</title>
    <link rel="icon" href="/images/favicon.ico" sizes="32x32" />
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <link rel="stylesheet" href="/css/pg_btn.css">
    <script type="text/javascript" src="./js/jquery-1.3.2.min.js"></script>
    <script src="lib/layui/layui.js"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
</head>

<body>

<div class="x-body">
    <%--把表单封装成一个Student对象传给服务端--%>
    <form class="layui-form"  id="f_auto" action="/changeInfo2" method="post">
        <p align="center">
            <label style="color: red">
                <span class="">${emsg}</span>
            </label>
        </p>
        <input type="hidden" value="${sessionScope.st1.s_id}" name="s_id" id="s_id" class="layui-input"/>
        <div class="layui-form-item">
            <label for="s_studentid" class="layui-form-label">
                <span class="">学号</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_studentid" name="s_studentid"
                       autocomplete="off" value="${sessionScope.st1.s_studentid}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="s_name" class="layui-form-label">
                <span class="">姓名</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_name" name="s_name"
                       autocomplete="off" value="${sessionScope.st1.s_name}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="s_sex" class="layui-form-label">
                <span class="">性别</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_sex" name="s_sex"
                       autocomplete="off" value="${sessionScope.st1.s_sex}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="s_age" class="layui-form-label">
                <span class="">电话</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_age" name="s_age"
                       autocomplete="off" value="${sessionScope.st1.s_age}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="s_phone" class="layui-form-label">
                <span class="">电话</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_phone" name="s_phone"
                       autocomplete="off" value="${sessionScope.st1.s_phone}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="s_classid" class="layui-form-label">
                <span class="">班号</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_classid" name="s_classid" 
                       autocomplete="off" value="${sessionScope.st1.s_classid}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="s_classname" class="layui-form-label">
                <span class="">班级</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_classname" name="s_classname" 
                       autocomplete="off" value="${sessionScope.st1.s_classname}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="s_dormitoryid" class="layui-form-label">
                <span class="">宿舍号</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_dormitoryid" name="s_dormitoryid" 
                       autocomplete="off" value="${sessionScope.st1.s_dormitoryid}" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item" id="btn_xg">
            <button  class="layui-btn" id="btn_on"  lay-submit="" lay-filter="updateAdmin">
                修改
            </button>
        </div>
    </form>
</div>

<script>

</script>
</body>
</html>


