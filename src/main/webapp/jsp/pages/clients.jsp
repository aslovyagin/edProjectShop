<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>clients</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
    <header>
        <div>All Clients</div>
    </header>

    <div>
        <%= (new java.util.Date()).toLocaleString()%>
        <table>
            <thead>
                <tr>
                    <th>login</th>
                    <th>last name</th>
                    <th>first name</th>
                    <th>status</th>
                </tr>
            <tbody>
            <c:forEach items="${clients}" var="client">
                <tr>
                    <td><c:out value="${client.login}"></c:out></td>
                    <td>${client.lastName}</td>
                    <td>${client.firstName}</td>
                    <td>${client.status}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
