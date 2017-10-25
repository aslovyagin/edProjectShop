<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>addition</title>
    <link rel="stylesheet" href="/lib/css/main.css">
<body>
    <tags:navbar/>

    <header>
        <div>Add New Product To Database</div>
    </header>

    <div class="form-style">
        <form action="/addProductToDB" method="POST">
            <input type="text"   placeholder="title"       name="title">
            <input type="text"   placeholder="price"       name="price">
            <input type="text"   placeholder="description" name="description">
            <input type="submit" value="Add">
        </form>
    </div>

</body>
</html>
