<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Shop</title>
    </head>
    <body>
        <p>Shop items</p>
        <table>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><c:out value="${product.id}"/></td>
                    <td><c:out value="${product.name}"/></td>
                    <td><c:out value="${product.price}"/></td>
                    <td><c:out value="${product.prodQuantity}"/></td>
                    <td><c:out value="${product.prodInfo}"/></td>
                    <td><a href="addToBasket?productId=${product.id}"> Buy this product</a> </td>
                </tr>
                <br>
            </c:forEach>
        </table>
    <br>
        <button onclick="window.location.href='/HillelProject_war_exploded/emb-store/profile';">Go to profile</button>
    </body>
</html>