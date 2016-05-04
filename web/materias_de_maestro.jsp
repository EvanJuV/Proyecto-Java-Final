<%-- 
    Document   : materias_de_maestro
    Created on : May 2, 2016, 2:27:41 AM
    Author     : Evan
--%>

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
                        <th>Nombre</th>
                        <th>Nomina</th>
                        <th>Telefono</th>
                        <th>Correo</th>
                        <th>Materias Asignadas</th>
                    </tr>
                </thead>
                <tbody>
                    <% ArrayList<Materia> materias;
                    materias = (ArrayList<Materia>) request.getAttribute("materias");

                    for (Materia m : materias) {%>

                    <tr>
                        <td><%=m.getNombre()%></td>
                        
                    </tr>
                </tbody>
                <% }%>
            </table>
        </div>
    </body>
</html>
