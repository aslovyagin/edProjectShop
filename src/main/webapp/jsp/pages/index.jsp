<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ page import="model.Product" %>
<%@ page import="data.daoImpl.ProductDao" %>
<%@ page import="model.User" %>
<%@ page import="data.daoImpl.UserDao" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Добро пожаловать, JSP!</title>
    <link rel="stylesheet" type="text/css" href="lib/css/theme.css">
</head>
<body>
<div class="form-style">
<h1>Добро пожаловать!</h1>

<form name="addProduct" action="jsp/pages/productAdded.jsp" method="POST">
    <input type="text" placeholder="title" name="title" value="" size="50"/>
    <br>
    <input type="text" placeholder="price" name="price" value="" size="50"/>
    <br>
    <input type="text" placeholder="description" name="description" value="" size="50"/>
    <br>
    <input type="submit" value="AddProduct">
</form>
</div>
<a href="/ViewProducts" class="push_button blue">Show products </a>
<a href="jsp/pages/productsDeleted.jsp" class="push_button red">Delete  products </a>
<a href="/logout" class="push_button red">Exit</a>
</body>
</html>
