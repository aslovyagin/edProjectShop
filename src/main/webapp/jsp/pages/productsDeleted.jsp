<%@ page import="data.daoImpl.ProductDao" %><%--
  Created by IntelliJ IDEA.
  User: allexeyVS
  Date: 16.10.17
  Time: 4:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%= new ProductDao().deleteAll() %>
<h1>Все записи удалены</h1>
<a href="../../"> Back </a>
</body>
</html>
