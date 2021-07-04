<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Email error</title>
    </head>
    <body>
    <p style="font-size: 35px">Email <b>${email}</b> is already exists.</p>
    <button onclick="window.history.go(-1); return false;">
        Get back
    </button>
    </body>
</html>
