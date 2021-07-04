<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Invalid login</title>
    </head>
    <body>
        <p style="font-size: 35px">Login <b>${login}</b> is already exists.</p>
        <button onclick="window.history.go(-1); return false;">
            Get back
        </button>
    </body>
</html>
