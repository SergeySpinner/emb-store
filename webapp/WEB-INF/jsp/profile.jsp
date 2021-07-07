<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <style>

    </style>
</head>
    <body>
        <p>Id : ${user.id}</p>
        <p>Name : ${user.userName}</p>
        <p>Password : ${user.password}</p>

        <button onclick="window.location.href='/HillelProject_war_exploded/emb-store/shop-page';">Shop page</button>

        <button onclick="window.location.href='/HillelProject_war_exploded/emb-store/basket';">Basket page</button>

        <button onclick="window.location.href='/HillelProject_war_exploded/emb-store/logout';">Log out</button>
    </body>
</html>
