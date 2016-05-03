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
            String elemType = request.getParameter("elemType");
            String monthString = "";
            String query = "";
            String forward ="";
            switch (elemType) {
            case "maestro":  
                
                String nomina = request.getParameter("nomina");
                String nombre = request.getParameter("nombre");
                String telefono = request.getParameter("telefono");
                String email = request.getParameter("email");
                       query = "INSERT INTO maestros VALUES('"+nomina+"','"+nombre+"','"+telefono+"','"+email+"')";
                       forward = "maestros.jsp";
                     break;
            case "materia":
                String clave = request.getParameter("clave");
                String nombreM = request.getParameter("nombre");
                String horasLab = request.getParameter("horas_laboratorio");
                       query = "INSERT INTO materias VALUES('"+clave+"','"+nombreM+"','"+horasLab+"')";
                       forward = "materias.jsp";
                     break;
            case "b":  monthString = "March";
                     break;
            case "c":  monthString = "April";
                     break;
            case "d":  monthString = "May";
                     break;
            case "e":  monthString = "June";
                     break;
            default: monthString = "Invalid month";
                     break;
            }        

            
            
            try{
            DbConnection.query(query);
            }
            catch(Exception e){
             waslos = "Es war was: "+e.getMessage();
            }
            
        %>
        <jsp:forward page = "<%=forward%>" />
    </head>
    <body>
        <h1>Hello World!</h1>
        
        </br>
        <%= waslos%>
        </br>
        <%= query%>
    </body>
</html>
