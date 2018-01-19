<%--
  Created by IntelliJ IDEA.
  User: zhaol
  Date: 2018/1/18
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="inputStyle.css">
    <title>输入</title>
</head>
<body>
    <form action="AdminServlet" >
        <div id="mainFormDiv">
            <!--操作码 请求版本号-->
            <span id="loginText">登陆</span><br>
            <input type="hidden" name="op" value="100">
            <input name="name" class="inputBox" placeholder="用户名"><br/>
            <input type="password" name="pw" class="inputBox" placeholder="密码"><br/>
            <input type="submit" value="提交" class="submitButton">
        </div>
    </form>
</body>
</html>
