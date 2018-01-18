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
    <title>输入</title>
</head>
<body>
    <form action="AdminServlet">
        <!--操作码 请求版本号-->
        <input type="hidden" name="op" value="100">
        <input name="name"><br/>
        <input type="password" name="pw"><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
