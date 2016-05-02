<%-- 
    Document   : eliminar.jsp
    Created on : May 2, 2016, 12:33:24 AM
    Author     : thorben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@page import="models.*" %>
        <%@page import="database.*" %>
        <% String id = request.getParameter("id");
           DbConnection.query("DELETE FROM maestros WHERE nomina="+id);
        %>
        <jsp:forward page = "maestros.jsp" />
    </head>

</html>
