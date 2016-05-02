<%-- 
    Document   : edit_maestro
    Created on : May 2, 2016, 5:55:13 AM
    Author     : Evan
--%>

<%@page import="models.Maestro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/skeleton.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
        <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">
        <title>Editar maestro</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        
        <% Maestro maestro = (Maestro) request.getAttribute("maestro"); %>
        
        <div class="container push-top">
            <h2>Editar maestro</h2>
            <form method="POST" action="${pageContext.request.contextPath}/maestros/crear">
                <div class="row">
                    <div class="six columns">
                        <label for="username">Nómina</label>
                        <input type="text" name="nomina" class="u-full-width" value="<%=maestro.getNomina()%>">
                    </div>
                    <div class="six columns">
                        <label for="username">Nombre completo</label>
                        <input type="text" name="nombre" class="u-full-width" value="<%=maestro.getNombre()%>">
                    </div>
                </div>
                <div class="row">
                    <div class="six columns">
                        <label for="telefono">Teléfono</label>
                        <input type="text" name="telefono" class="u-full-width" value="<%=maestro.getTelefono()%>">
                    </div>
                    <div class="six columns">
                        <label for="email">Email</label>
                        <input type="text" name="email" class="u-full-width" value="<%=maestro.getEmail()%>">
                    </div>
                </div>
                <div class="row">
                    <input type="submit" value="Guardar" class="button-primary">
                </div>
            </form>
        </div>
    </body>
</html>
