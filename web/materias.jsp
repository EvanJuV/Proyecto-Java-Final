<%-- 
    Document   : materias
    Created on : May 2, 2016, 6:00:21 AM
    Author     : Evan
--%>

<%@page import="models.Materia"%>
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
        <title>Materias</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container push-top">
            <h2>Materias</h2>
            <a href="nueva_materia.jsp" class="button button-primary">Nueva materia</a>
            <table class="u-full-width">
                <thead>
                    <tr>
                        <th>Clave</th>
                        <th>Nombre</th>
                        <th>Horas Laboratorio</th>
                        <th>Editar</th>
                        <th>Elimina</th>
                    </tr>
                </thead>
                <tbody>
                    <% ArrayList<Materia> A;
                    try{ A = Materia.getAll();
                   
                    for (Materia m : A) {%>

                    <tr>
                        <td><%=m.getClave()%></td>
                        <td><%=m.getNombre()%></td>
                        <td><%=m.getHorasLaboratorio()%></td>
                        <td>
                            <form method="GET" action="${pageContext.request.contextPath}/materias/edit">
                                <input name="clave" value="<%=m.getClave()%>" hidden/>
                                <input type="submit" class="button" value="Edit"/> 
                            </form>
                        </td>
                        <td>
                            <form method="DELETE" action="${pageContext.request.contextPath}/materias/delete">
                                <input name="clave" value="<%=m.getClave()%>" hidden/>
                                <input type="submit" class="button" value="X"/>
                            </form>  
                        </td>
                    </tr>
                </tbody>
                <% }
                }
                catch(Exception e){ %>
                <p> Database access did not work!</p>
                <% }%>
            </table>
        </div>
    </body>
</html>
