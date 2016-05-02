<%-- 
    Document   : maestros
    Created on : May 1, 2016, 11:09:38 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Maestro"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/skeleton.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
        <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">
        <title>Maestros</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container push-top">
            <h2>Maestros</h2>
            <a href="nuevo_maestro.jsp" class="button button-primary">Nuevo maestro</a>
            <table class="u-full-width">
                <thead>
                  <tr>
                    <th>Nombre</th>
                    <th>Nomina</th>
                    <th>Telefono</th>
                    <th>Correo</th>
                    <th>Materias Asignadas</th>
                    <th>Editar</th>
                    <th>Eliminar</th>
                  </tr>
                </thead>
                <tbody>
                <% ArrayList<Maestro> A;
                     A = Maestro.getAll();

                     for(Maestro m : A){ %>

                     <tr>
                        <td><%=m.getNombre()%></td>
                        <td><%=m.getNomina()%></td>
                        <td><%=m.getTelefono()%></td>
                        <td><%=m.getEmail()%></td>
                        <td>
                            <form method="GET" action="${pageContext.request.contextPath}/maestros/materias">
                                <input name="nomina" type="number" value="<%=m.getNomina()%>" hidden>
                                <input type="submit" class="button" value="Materias asignadas">
                            </form>
                        </td>
                        <td><a class="button" href="Eliminar">Editar</a></td>
                        <td><a class="button" href="Eliminar">X</a></td>
                    </tr>
                </tbody>
                <% } %>
            </table>
        </div>
    </body>
</html>