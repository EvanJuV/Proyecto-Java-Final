<%-- 
    Document   : grupos
    Created on : May 2, 2016, 1:13:24 AM
    Author     : Administrator
--%>


<%@page import="models.DetalleGrupo"%>
<%@page import="models.Maestro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Grupo"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/skeleton.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
        <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">
        <title>Grupos</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container push-top" style="max-width: initial;">
            <h2>Grupos</h2>
            <div class="row">
                <a href="nuevo_grupo.jsp" class="button button-primary">Nuevo grupo</a>
                <button id="changeClassroom" class="button u-pull-right">Intercambio de salón</button>
            </div>
            <table class="u-full-width">
                <thead>
                    <tr>
                        <th>Clave</th>
                        <th>Materia</th>
                        <th>Grupo</th>
                        <th>Idioma</th>
                        <th>Honors</th>
                        <th>Maestro</th>
                        <th>Horario</th>
                        <th>Salón</th>
                        <th>Laboratorio</th>
                        <th>Editar</th>
                        <th>Eliminar</th>
                    </tr>
                </thead>
                <tbody>
                    <% ArrayList<Grupo> A;
                        A = Grupo.getAll();
                        
                        String[] idiomas = {"Español", "Inglés", "Alemán"};
                        
                        for(Grupo n : A){ 
                            for(DetalleGrupo d : n.getDetalle()) {%>
                    <tr>
                        <td><%=n.getMateria().getClave()%></td>
                        <td><%=n.getMateria().getNombre()%></td>
                        <td><%=n.getGrupo()%></td>
                        <td><%=idiomas[n.getIdioma()]%></td>
                        <td><%=n.getHonors() ? "Sí" : "No"%></td>

                        <td><%=d.getMaestro().getNombre()%></td>
                        <td><%=d.getHorario().getHora() + "/" + d.getHorario().getDuracion() + " " + d.getHorario().getDias()%></td>
                        <td><%=d.getSalon().getDepartamento() + " " + d.getSalon().getNumeroSalon() %></td>

                        <td><%=d.isLaboratorio() ? "Sí" : "No" %></td>
                        
                        <td>
                            <form method="GET" action="${pageContext.request.contextPath}/grupos/edit">
                                <input name="id" value="<%=n.getId()%>" hidden/>
                                <input type="submit" class="button" value="Edit"/> 
                            </form>
                        </td>
                        <td>
                            <form method="DELETE" action="${pageContext.request.contextPath}/grupos/delete">
                                <input name="id" value="<%=n.getId()%>" hidden/>
                                <input type="submit" class="button" value="X"/>
                            </form>
                        </td>              
                    </tr>
                    <% }
                    } %>
                </tbody>
            </table>
        </div>
    </body>
    <script>
        
    </script>
</html>
