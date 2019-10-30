<%--
  Created by IntelliJ IDEA.
  User: 1298509345
  Date: 2019/10/29
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>简易邮箱服务</title>
  </head>
  <body>
  <form method="POST" action="rest/sendService/sendEmail">
    收件人地址: <br>
    <input type="text" name="email"><br>
    邮件主题:<br>
    <input type="text" name="title"><br>
    内容：<br>
    <input type="text" name="content"><br>
    <br>
    <input type="submit",value="发送">
  </form>
  </body>
</html>
