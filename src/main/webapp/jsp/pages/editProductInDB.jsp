<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>edition</title>
    <link rel="stylesheet" href="/lib/css/main.css">
<body>
    <tags:navbar/>

    <header>
        <div>Edit Product</div>
    </header>

    <div class="form-style">
        <form action="/editProductInDB" method="POST">
            <input type="hidden" value="<c:out value="${product.id}"></c:out>"          name="id">
            <input type="text"   value="<c:out value="${product.title}"></c:out>"       name="title">
            <input type="text"   value="<c:out value="${product.price}"></c:out>"       name="price">
            <input type="text"   value="<c:out value="${product.description}"></c:out>" name="description">
            <input type="submit" value="Apply">
        </form>
    </div>

</body>
</html>
