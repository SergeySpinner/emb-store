<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Shop</title>
    </head>
    <body>
        <p>Shop items</p>
        <c:forEach items="${products}" var="product">
            <br>
            <c:out value="${product.id}"/>
        </c:forEach>
    <br>
        <button onclick="window.location.href='/HillelProject_war_exploded/emb-store/profile';">Go to profile</button>
    </body>
</html>
