<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>products</title>
    <link rel="stylesheet" href="/lib/css/main.css">
</head>
<body>
    <tags:navbar/>
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
                    <td>
                    <form method="get" <c:choose>
                                           <c:when test="${status eq 'ACTIVE'}">action="/addProductToCart"</c:when>
                                           <c:when test="${status eq 'ADMIN'}"> action="/editProductInDB" </c:when>
                                       </c:choose>>
                        <button <c:choose>
                                    <c:when test="${status eq 'ACTIVE'}">class="add" </c:when>
                                    <c:when test="${status eq 'ADMIN'}"> class="edit"</c:when>
                                </c:choose>
                        type="submit" name="productId" value="<c:out value="${product.id}"></c:out>">1</button>
                    </form>
                    </td>
                </tr>
            </c:forEach>
            <c:if test = "${status eq 'ADMIN'}">
                <tr>
                    <td></td>
                    <td></td>
                    <td>
                        <form action="/addProductToDB" method="get">
                            <button class="create" type="submit">1</button>
                        </form>
                    </td>
                </tr>
            </c:if>
            </tbody>
        </table>
    </div>
</body>
</html>
