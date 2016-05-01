<%-- 
    Document   : index
    Created on : May 1, 2016, 3:07:27 PM
    Author     : Evan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    <c:if test="${empty param.whatever}">
        <p style="color: red">${error_msg}</p>
    </c:if>
        <form method="POST" action="login">
            <input type="text" name="username">
            <input type="password" name="password">
            <input type="submit">
        </form>
    </body>
</html>
