<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<nav>
    <ul>
        <li><a href="/login">Log In</a></li>
        <li><a href="/reg">Sign Up</a></li>
        <li><a href="/logout">Log Out</a></li>
        <li><a href="/products">Products</a></li>
        <li><a href="/cart">Cart</a></li>
        <c:if test = "${status eq 'ADMIN'}">
            <li><a href="/clients">Clients</a></li>
        </c:if>
    </ul>
</nav>
