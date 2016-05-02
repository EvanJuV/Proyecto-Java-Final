<%-- 
    Document   : grupos
    Created on : May 2, 2016, 1:13:24 AM
    Author     : Administrator
--%>


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
        <div class="container">
            <h1>Grupos</h1>
           <table class="u-full-width">
  <thead>
    <tr>
      <th>ID</th>
      <th>Grupo</th>
      <th>Idioma</th>
      <th>Honors</th>
      <th>Editar</th>
      <th>Eliminar</th>
    </tr>
  </thead>
  <tbody>
      <jsp:include page="navbar.jsp"/>
      <% ArrayList<Grupo> A;
           A = Grupo.getAll();
           
           for(Grupo n : A){ %>
            
   <tr>
                <td><%=n.getMateriaId()%></td>
                <td><%=n.getGrupo()%></td>
                <td><%=n.getIdioma()%></td>
                <td></td>
                <td><a class="button" href="Eliminar">Editar</a></td>
                <td><a class="button" href="Eliminar">X</a></td>
              
               
           </tr>
        
  </tbody>
   <% } %>
</table>
        </div>
    </body>
</html>
