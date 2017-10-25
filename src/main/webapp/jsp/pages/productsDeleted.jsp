<%@ page import="data.daoImpl.ProductDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>all products deleted</title>
    <link rel="stylesheet" href="/lib/css/main.css">
</head>
    <body>
    <%= new ProductDao().deleteAll() %>
    <h1>Все записи удалены</h1>
</body>
</html>
