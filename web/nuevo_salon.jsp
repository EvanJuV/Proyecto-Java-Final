<%-- 
    Document   : nuevo_salon
    Created on : May 2, 2016, 3:57:47 AM
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
        <title>Nuevo salón</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container push-top">
            <h2>Nuevo salón</h2>
            <form method="POST" action="${pageContext.request.contextPath}/salones/crear">
                <div class="row">
                    <div class="six columns">
                        <label for="numero_salon">Número de salón</label>
                        <input type="text" name="numero_salon" class="u-full-width">
                    </div>
                    <div class="six columns">
                        <label for="capacidad">Capacidad</label>
                        <input type="text" name="capacidad" class="u-full-width">
                    </div>
                </div>
                <div class="row">
                    <div class="twelve columns">
                        <label for="departamento">Departamento</label>
                        <input type="text" name="departamento" class="u-full-width">
                    </div>
                </div>
                <div class="row">
                    <input type="submit" value="Crear" class="button-primary">
                </div>
            </form>
        </div>
    </body>
</html>
