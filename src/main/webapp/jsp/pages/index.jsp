<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
    <%@ page import="java.util.*, java.text.*" %>
        <%@ page import="model.Product" %>
            <%@ page import="data.daoImpl.ProductDao" %>
                <%@ page import="model.User" %>
                    <%@ page import="data.daoImpl.UserDao" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Добро пожаловать, JSP!</title>
    <link rel="stylesheet" type="text/css" href="lib/css/theme.css">
</head>

<body>
    <div class="form-style">
        <h1>Добро пожаловать!</h1>

        <form name="addProduct" action="/jsp/pages/productAdded.jsp" method="POST">
            <input type="text" placeholder="title" name="title" value="" size="50" />
            <br>
            <input type="text" placeholder="price" name="price" value="" size="50" />
            <br>
            <input type="text" placeholder="description" name="description" value="" size="50" />
            <br>
            <input type="submit" value="AddProduct">
        </form>
    </div>
    <a href="/ViewProducts" class="push_button blue">Show products </a>
    <a href="/jsp/pages/productsDeleted.jsp" class="push_button red">Delete products </a>
    <a href="/logout" class="push_button red">LOG OUT</a>
</body>

</html>
