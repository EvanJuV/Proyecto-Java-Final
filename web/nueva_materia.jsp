<%-- 
    Document   : nueva_materia
    Created on : May 2, 2016, 6:10:49 AM
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
        <title>Nueva materia</title>
        <script>
            window.onload = function() {
                document.forms['materia-form'].onsubmit = function () {
                    var clave = document.getElementById('clave');
                    var horas_laboratorio = document.getElementById('horas_laboratorio');
                    var nombre = document.getElementById('nombre');                    
                    var error = document.getElementById('error');
                    var msg = '';
                    var run = true;
                    
                    if (!clave.value.match(/([0-9a-zA-Z]+$)/)) {
                        run = false;
                        msg += 'Clave debe ser Numeros y Letras';
                    }
                    if (!horas_laboratorio.value.match(/([0-9])/)) {
                        run = false;
                        msg += '<br>Las horas de laboratorio deben ser numeros';
                    }
                    if (!nombre.value.match(/^[a-zA-Z]+$/)) {
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
            <h2>Nueva materia</h2>
            <span style="color:red; font-weight: bold;" id="error"></span>
            <form name="materia-form" method="POST" action="${pageContext.request.contextPath}/materias/crear">
                <div class="row">
                    <div class="six columns">
                        <label for="clave">Clave</label>
                        <input id="clave" type="text" name="clave" class="u-full-width">
                    </div>
                    <div class="six columns">
                        <label for="horas_laboratorio">Horas Laboratorio</label>
                        <input id="horas_laboratorio" type="text" name="horas_laboratorio" class="u-full-width">
                    </div>
                </div>
                <div class="row">
                    <div class="twelve columns">
                        <label for="nombre">Nombre</label>
                        <input id="nombre" type="text" name="nombre" class="u-full-width">
                    </div>
                </div>
                <div class="row">
                    <input type="submit" value="Crear" class="button-primary">
                </div>
            </form>
        </div>
    </body>
</html>

