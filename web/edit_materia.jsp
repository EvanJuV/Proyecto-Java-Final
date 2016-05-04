<%-- 
    Document   : edit_materia
    Created on : May 2, 2016, 6:11:26 AM
    Author     : Evan
--%>

<%@page import="models.Materia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/skeleton.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
        <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">
        <title>Editar materia</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        
        <% Materia materia = (Materia) request.getAttribute("materia"); %>
        <div class="container push-top">
            <h2>Editar materia</h2>
            <form method="POST" action="${pageContext.request.contextPath}/materias/edit">
                <div class="row">
                    <div class="six columns">
                        <label for="clave">Clave</label>
                        <input type="text" name="clave" class="u-full-width" value="<%=materia.getClave()%>">
                    </div>
                    <div class="six columns">
                        <label for="horas_laboratorio">Horas Laboratorio</label>
                        <input type="text" name="horas_laboratorio" class="u-full-width" value="<%=materia.getHorasLaboratorio()%>">
                    </div>
                </div>
                <div class="row">
                    <div class="twelve columns">
                        <label for="nombre">Nombre</label>
                        <input type="text" name="nombre" class="u-full-width" value="<%=materia.getNombre()%>">
                    </div>
                </div>
                <div class="row">
                    <input type="submit" value="Crear" class="button-primary">
                </div>
            </form>
        </div>
    </body>
</html>

