<%-- 
    Document   : edit_maestro
    Created on : May 2, 2016, 5:55:13 AM
    Author     : Evan
--%>

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
        <title>Editar maestro</title>
        <script>
            window.onload = function() {
                document.forms['EditMaestro-form'].onsubmit = function () {
                    var nomina = document.getElementById('nomina');
                    var nombre = document.getElementById('nombre');
                    var telefono = document.getElementById('telefono');
                    var email = document.getElementById('email');
                    var error = document.getElementById('error');
                    var msg = '';
                    var run = true;
                    
                    if (!nomina.value.match(/([0-9])/)) {
                        run = false;
                        msg += 'Nomina debe ser numero';
                    }
                    if (!nombre.value.match(/([a-zA-Z-])/)) {
                        run = false;
                        msg += '<br>El nombre debe solo contener letras';
                    }
                    if (!telefono.value.match(/([0-9])/)) {
                        run = false;
                        msg += '<br>Solamente numeros';
                    }
                    if (!email.value.match(/([a-zA-Z@-_.0-9])/)) {
                        run = false;
                        msg += '<br>Escribe un Email valido';
                    }
                       
                    if (!run) {
                        error.innerHTML = msg;
                        return false;
                    }
                }
            }
        </script>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        
        <% Maestro maestro = (Maestro) request.getAttribute("maestro"); %>
        
        <div class="container push-top">
            <h2>Editar maestro</h2>
            <span style="color:red; font-weight: bold;" id="error"></span>
            <form name ="EditMaestro-form" method="POST" action="${pageContext.request.contextPath}/maestros/crear">
                <div class="row">
                    <div class="six columns">
                        <label for="username">Nómina</label>
                        <input id="nomina" type="text" name="nomina" class="u-full-width" value="<%=maestro.getNomina()%>">
                    </div>
                    <div class="six columns">
                        <label for="username">Nombre completo</label>
                        <input id="nombre" type="text" name="nombre" class="u-full-width" value="<%=maestro.getNombre()%>">
                    </div>
                </div>
                <div class="row">
                    <div class="six columns">
                        <label for="telefono">Teléfono</label>
                        <input id="telefono" type="text" name="telefono" class="u-full-width" value="<%=maestro.getTelefono()%>">
                    </div>
                    <div class="six columns">
                        <label for="email">Email</label>
                        <input id="email" type="text" name="email" class="u-full-width" value="<%=maestro.getEmail()%>">
                    </div>
                </div>
                <div class="row">
                    <input type="submit" value="Guardar" class="button-primary">
                </div>
            </form>
        </div>
    </body>
</html>
