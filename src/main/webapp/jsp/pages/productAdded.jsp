<%@ page import="dto.Product" %>
<%@ page import="data.daoImpl.ProductDao" %><%--
  Created by IntelliJ IDEA.
  User: allexeyVS
  Date: 16.10.17
  Time: 3:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<%
    Product product = new Product();
    product.setName(request.getParameter("name"));
    product.setDescription(request.getParameter("description"));
    product.setPrice(Integer.parseInt(request.getParameter("price")));
    new ProductDao().insert(product);

%>
<h1>Добавлено</h1>
<a href="../../"> Back </a>

</body>
</html>
