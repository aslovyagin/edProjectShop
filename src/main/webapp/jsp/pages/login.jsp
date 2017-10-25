<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>login</title>
    <link rel="stylesheet" href="/lib/css/main.css">
<body>
    <p style="text-align:center;">
        <a style="color: #ffffff;" href="/reg">SIGN UP</a>
    </p>

    <form action="/login" method="POST">
        <input type="text" placeholder="login"  name="login">
        <input type="text" placeholder="password"  name="password">
        <input type="submit" value="LOG IN">
    </form>

    <div>
        <c:out value="${cause}"></c:out>
    </div>
</body>
</html>
