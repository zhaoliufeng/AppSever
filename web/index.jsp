<%@ page import="db.VersionDAO" %><%--
  Created by IntelliJ IDEA.
  User: zhaol
  Date: 2018/1/18
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>AppSever Admin</title>
  </head>
  <body>
  <%
    String name = request.getParameter("name");
  %>
  你好 : <%=name %>！<br><br>
  当前最新版本号是:<%=VersionDAO.getVersion()%><br>
  下载地址是: <%=VersionDAO.getUpdateLink()%><br><br>
  <form action="VersionServlet">
    <!--设置版本号-->
    <input type="hidden" name="op" value="1">
    <input type="hidden" name="name" value=<%=name%>>
    新版本号 : <input name="version"><br>
    下载地址 : <input name="link"><br>
    <input type="submit" value="提交">
  </form>
  </body>
</html>
