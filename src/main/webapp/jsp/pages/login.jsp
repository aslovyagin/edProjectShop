<%--
  Created by IntelliJ IDEA.
  User: allexeyVS
  Date: 20.10.17
  Time: 3:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" method="POST">
    <input type="text" name="username">
    <input type="text" name="password">
    <input type="submit" value="LOG IN">
</form>

<hr>

<form action="/reg" method="POST">
    <input type="text" name="firstName">
    <input type="text" name="surName">
    <input type="text" name="login">
    <input type="text" name="password">
    <input type="text" name="adress">
    <input type="submit" value="Register">

</form>
</body>
</html>
