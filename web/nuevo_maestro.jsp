<%-- 
    Document   : nuevo_maestro
    Created on : May 2, 2016, 3:16:42 AM
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
        <title>Nuevo maestro</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container push-top">
            <h2>Nuevo maestro</h2>
            <form method="POST" action="${pageContext.request.contextPath}/maestros/crear">
                <div class="row">
                    <div class="six columns">
                        <label for="username">Nómina</label>
                        <input type="text" name="nomina" class="u-full-width">
                    </div>
                    <div class="six columns">
                        <label for="username">Nombre completo</label>
                        <input type="text" name="nombre" class="u-full-width">
                    </div>
                </div>
                <div class="row">
                    <div class="six columns">
                        <label for="telefono">Teléfono</label>
                        <input type="text" name="telefono" class="u-full-width">
                    </div>
                    <div class="six columns">
                        <label for="email">Email</label>
                        <input type="text" name="email" class="u-full-width">
                    </div>
                </div>
                <div class="row">
                    <input type="submit" value="Crear" class="button-primary">
                </div>
            </form>
        </div>
    </body>
</html>
