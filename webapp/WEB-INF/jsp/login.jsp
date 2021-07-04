<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Login page</title>
    </head>
    <body>
        <form method="post">
            <p>Login page</p>
            <p>Username
            <input type="text" name="login" required></p>
            <p>Password
            <input type="password" name="password" required></p>
            <br>
            <br>
            <button value="Sign in" type="Submit">Login</button>
        </form>
        <p>Don't have account yet?
            <button onclick="window.location.href='/HillelProject_war_exploded/emb-store/registration';">
                Create new account
            </button>
        </p>
    </body>
</html>
