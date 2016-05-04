<%-- 
    Document   : nuevo_salon
    Created on : May 2, 2016, 3:57:47 AM
    Author     : Evan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/skeleton.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
        <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">
        <title>Nuevo salón</title>
         <script>
            window.onload = function() {
                document.forms['salon-form'].onsubmit = function () {
                    var numero_salon = document.getElementById('numero_salon');
                    var capacidad = document.getElementById('capacidad');
                    var departamento = document.getElementById('departamento');                    
                    var error = document.getElementById('error');
                    var msg = '';
                    var run = true;
                    
                    if (!numero_salon.value.match(/([0-9])/)) {
                        run = false;
                        msg += 'Clave debe ser Numeros';
                    }
                    if (!capacidad.value.match(/([0-9])/)) {
                        run = false;
                        msg += '<br>Las capacidades deben ser numeros';
                    }
                    if (!departamento.value.match(/^[a-zA-Z]+$/)) {
                        run = false;
                        msg += '<br>Solamente letras';
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
        <div class="container push-top">            
            <h2>Nuevo salón</h2>
            <span style="color:red; font-weight: bold;" id="error"></span>
            <form name="salon-form" method="POST" action="${pageContext.request.contextPath}/salones/crear">
                <div class="row">
                    <div class="six columns">
                        <label for="numero_salon">Número de salón</label>
                        <input id="numero_salon" type="text" name="numero_salon" class="u-full-width">
                    </div>
                    <div class="six columns">
                        <label for="capacidad">Capacidad</label>
                        <input id="capacidad" type="text" name="capacidad" class="u-full-width">
                    </div>
                </div>
                <div class="row">
                    <div class="twelve columns">
                        <label for="departamento">Departamento</label>
                        <input id="departamento" type="text" name="departamento" class="u-full-width">
                    </div>
                </div>
                <div class="row">
                    <input type="submit" value="Crear" class="button-primary">
                </div>
            </form>
        </div>
    </body>
</html>
