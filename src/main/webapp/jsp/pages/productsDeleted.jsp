<%@ page import="data.daoImpl.ProductDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>all products deleted</title>
    <link rel="stylesheet" href="/lib/css/main.css">
</head>
    <tags:navbar/>
    <body>
    <%= new ProductDao().deleteAll() %>
    <h1>Все записи удалены</h1>
</body>
</html>
