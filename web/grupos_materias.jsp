<%-- 
    Document   : grupos_materias
    Created on : May 4, 2016, 3:29:28 PM
    Author     : Evan
--%>

<%@page import="models.Materia"%>
<%@page import="models.DetalleGrupo"%>
<%@page import="models.Grupo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/skeleton.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
        <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">
        <title>Grupos de materia</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>

        <% Materia materia = (Materia) request.getAttribute("materia");%>

        <div class="container push-top">
            <h2>Grupos asignados de: <%=materia.getNombre()%></h2>
            <table class="u-full-width">
                <thead>
                    <tr>
                        <th>Clave</th>
                        <th>Grupo</th>
                        <th>Profesor</th>
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
                            for (DetalleGrupo dg : g.getDetalle()) {%>

                    <tr>
                        <td><%= g.getMateria().getClave()%></td>
                        <td><%= g.getGrupo()%></td>
                        <td><%= dg.getMaestro().getNombre() %></td>
                        <td><%= dg.getHorario().getHora() + "/" + dg.getHorario().getDuracion() + " " + dg.getHorario().getDias()%></td>
                        <td><%= dg.getSalon().getDepartamento() + " " + dg.getSalon().getNumeroSalon()%></td>
                        <td><%= idiomas[g.getIdioma()]%></td>
                        <td><%= g.getHonors() ? "Sí" : "No"%></td>
                    </tr>
                </tbody>
                <% }
                    }%>
            </table>
        </div>
    </body>
</html>
