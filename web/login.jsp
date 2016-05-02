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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/skeleton.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
        <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">
        <title>Sistema de manejo de inscripciones</title>
    </head>
    <body>
        <div class="container">
            <section class="header">
                <h2>Sistema de manejo de inscripciones</h2>
                <img src="img/logo.png" alt="logotec">
            </section>
            <c:if test="${empty param.whatever}">
                <p style="color: red">${error_msg}</p>
            </c:if>
            <form method="POST" action="login">
                <div class="row">
                    <div class="six columns">
                        <label for="username">Nombre de usuario</label>
                        <input type="text" name="username" class="u-full-width">
                    </div>
                    <div class="six columns">
                        <label for="password">Contraseña</label>
                        <input type="password" name="password" class="u-full-width">
                    </div>
                </div>
                <div class="row">
                    <input type="submit" value="Entrar" class="button-primary">
                </div>
            </form>
        </div>
    </body>
</html>
