<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Sign up</title>
    </head>
    <body>
        <p style="font-family: 'Arial Rounded MT Bold'; font-size: 40px">REGISTRATION<p/>
        <form method="post" style="font-family: 'sans-serif'; font-size: 20px">
            <p>Username
                <input type="text" name="userName" required>
            </p>
            <p>User role:
                <select id="userRole" name="userRole" required>
                    <option selected>Click here to show the list of roles</option>
                    <option value="ADMIN">The Admin</option>
                    <option value="MANUFACTURER">The Manufacturer</option>
                    <option value="USER">The User</option>
                </select>
            </p>
            <p>Contact mail:
                <input type="email" name="mail" required>
            </p>
            <p>Login:
                <input type="text" name="login" required>
            </p>
            <p>Password:
                <input type="password" name="password" required>
            </p>

            <button value="Sign up" type="submit">Create new user</button>
        </form>
        <button onclick="window.location.href='/HillelProject_war_exploded/emb-store/login';">
            Go back
        </button>
    </body>
</html>
