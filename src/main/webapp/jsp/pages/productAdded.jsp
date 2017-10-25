<%@ page import="model.Product" %>
<%@ page import="data.daoImpl.ProductDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <head>
        <meta charset="utf-8">
        <title>product added</title>
        <link rel="stylesheet" href="/lib/css/main.css">
    </head>
</head>
<body>
    <%
        Product product = new Product();
        product.setTitle(request.getParameter("title"));
        product.setDescription(request.getParameter("description"));
        product.setPrice(Integer.parseInt(request.getParameter("price")));
        new ProductDao().insert(product);
    %>
    <h1>Добавлено</h1>
</body>
</html>
