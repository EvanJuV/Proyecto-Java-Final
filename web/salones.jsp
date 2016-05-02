<%-- 
    Document   : salones
    Created on : May 2, 2016, 3:54:22 AM
    Author     : Evan
--%>

<%@page import="models.Salon"%>
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
        <title>Salones</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container push-top">
            <h2>Salones</h2>
            <a href="nuevo_salon.jsp" class="button button-primary">Nuevo salón</a>
            <table class="u-full-width">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Número de salón</th>
                        <th>Departamento</th>
                        <th>Capacidad</th>
                        <th>Editar</th>
                        <th>Eliminar</th>
                    </tr>
                </thead>
                <tbody>
                    <% ArrayList<Salon> A;
                    A = Salon.getAll();

                    for (Salon s : A) {%>

                    <tr>
                        <td><%=s.getId()%></td>
                        <td><%=s.getNumeroSalon()%></td>
                        <td><%=s.getDepartamento()%></td>
                        <td><%=s.getCapacidad()%></td>
                        <td>
                            <form method="GET" action="${pageContext.request.contextPath}/salones/edit">
                                <input name="id" value="<%=s.getId()%>" hidden/>
                                <input type="submit" class="button" value="Edit"/> 
                            </form>
                        </td>
                        <td>
                            <form method="DELETE" action="${pageContext.request.contextPath}/salones/delete">
                                <input name="id" value="<%=s.getId()%>" hidden/>
                                <input type="submit" class="button" value="X"/>
                            </form>  
                        </td>
                    </tr>
                </tbody>
                <% }%>
            </table>
        </div>
    </body>
</html>
