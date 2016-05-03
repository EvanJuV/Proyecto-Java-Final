<%-- 
    Document   : addToDatabase
    Created on : May 3, 2016, 12:58:23 AM
    Author     : thorben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ page import="database.*"%>
        <%
            String waslos ="ganix";
            String nomina = request.getParameter("nomina");
            String nombre = request.getParameter("nombre");
            String telefono = request.getParameter("telefono");
            String email = request.getParameter("email");
            String query = "INSERT INTO maestros VALUES('"+nomina+"','"+nombre+"','"+telefono+"','"+email+"')";
            try{
            DbConnection.query(query);
            }
            catch(Exception e){
             waslos = "Es war was: "+e.getMessage();
            }
            
        %>
        <jsp:forward page = "maestros.jsp" />
    </head>
    <body>
        <h1>Hello World!</h1>
        <%= nomina%>
        </br>
        <%= waslos%>
        </br>
        <%= query%>
    </body>
</html>
