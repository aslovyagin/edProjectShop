<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>products</title>
    <link rel="stylesheet" href="lib/css/main.css">
</head>
<body>
    <header>
        <div>All Products</div>
    </header>
    <div>
        <table>
            <thead>
                <tr>
                    <th>title</th>
                    <th>price</th>
                    <th></th>
                </tr>
            <tbody>
            <c:forEach items="${allProducts}" var="product">
                <tr>
                    <td class="tooltip"><c:out value="${product.title}"></c:out><span class="tooltiptext"><c:out value="${product.description}"></c:out></span></td>
                    <td><c:out value="${product.price}"></c:out> ₽</td>
                    <td><button class="add">1</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
