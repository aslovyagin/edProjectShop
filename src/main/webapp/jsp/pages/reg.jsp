<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>reg</title>
    <link rel="stylesheet" href="/lib/css/main.css">
<body>
    <form action="/reg" method="POST">
        <input type="text" placeholder="login" name="login">
        <input type="text" placeholder="last name" name="lastName">
        <input type="text" placeholder="first name" name="firstName">
        <input type="text" placeholder="password" name="password">
        <input type="submit" value="Register">
    </form>

    <div>
        <c:out value="${cause}"></c:out>
    </div>
</body>
</html>
