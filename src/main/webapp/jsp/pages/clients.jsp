<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
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
                    <td><c:out value="${client.lastName}"></c:out></td>
                    <td><c:out value="${client.firstName}"></c:out></td>
                    <td><c:out value="${client.status}"></c:out></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
