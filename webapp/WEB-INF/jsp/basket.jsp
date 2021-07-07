<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Basket page</title>
    </head>
    <body>
    <b>Basket of </b>
    <br>
        <table>
            <c:forEach items="${map}" var="item">
                <tr>
                    <td><c:out value="${item.getValue().id}"/></td>
                    <td><c:out value="${item.getValue().name}"/></td>
                    <td><c:out value="${item.getValue().price}"/></td>
                    <td><c:out value="${item.getValue().prodInfo}"/></td>
                    <td><a href="deleteBasketItem?productId=${item.getKey()}"> Delete this product</a> </td>
                </tr>
            </c:forEach>
        </table>
        <br>
<%--        <table>--%>
<%--            <c:forEach items="${ids}" var="id">--%>
<%--                <tr>--%>
<%--                    <td><a href="deleteBasketItem?productId=${id}"> Delete this product</a> </td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--        </table>--%>
        <button onclick="window.location.href='/HillelProject_war_exploded/emb-store/profile';">Go to profile</button>
    </body>
</html>
