<%-- 
    Document   : materias_de_maestro
    Created on : May 2, 2016, 2:27:41 AM
    Author     : Evan
--%>

<%@page import="models.DetalleGrupo"%>
<%@page import="models.Grupo"%>
<%@page import="models.Materia"%>
<%@page import="java.util.ArrayList"%>
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
        <title>Materias</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        
        <% Maestro maestro = (Maestro) request.getAttribute("maestro"); %>
        
        <div class="container push-top">
            <h2>Grupos asignados de: <%=maestro.getNombre()%></h2>
            <table class="u-full-width">
                <thead>
                    <tr>
                        <th>Clave</th>
                        <th>Grupo</th>
                        <th>Horario</th>
                        <th>Salón</th>
                        <th>Idioma</th>
                        <th>Honors</th>
                    </tr>
                </thead>
                <tbody>
                    <% ArrayList<Grupo> grupos;
                    grupos = (ArrayList<Grupo>) request.getAttribute("grupos");
                    String[] idiomas = {"Español", "Inglés", "Alemán"};
                        
                    for (Grupo g : grupos) {
                        for(DetalleGrupo dg : g.getDetalle()) {%>

                    <tr>
                        <td><%= g.getMateria().getClave() %></td>
                        <td><%= g.getGrupo() %></td>
                        <td><%= dg.getHorario().getHora() + "/" + dg.getHorario().getDuracion() + " " + dg.getHorario().getDias() %></td>
                        <td><%= dg.getSalon().getDepartamento() + " " + dg.getSalon().getNumeroSalon() %></td>
                        <td><%= idiomas[g.getIdioma()] %></td>
                        <td><%= g.getHonors() ? "Sí" : "No" %></td>
                    </tr>
                </tbody>
                <% }
                }%>
            </table>
        </div>
    </body>
</html>
