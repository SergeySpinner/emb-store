<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:${req.getSession().setAttribute("userId",null)}/>
<c:redirect url="/emb-store/login"/>
</body>
</html>
