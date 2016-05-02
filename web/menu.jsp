<%-- 
    Document   : menu.jsp
    Created on : May 1, 2016, 3:35:11 PM
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
        <title>Sistema de manejo de inscripciones</title>
    </head>
    <body>
        <div class="container">
            <div class="header">
                <h2>Menú principal</h2>
                <nav class="navbar">
                    <ul class="navbar-list">
                        <li class="navbar-item">
                            <a href="#">Inicio</a>
                        </li>
                        <li class="navbar-item">
                            <a href="maestros">Maestros</a>
                        </li>
                        <li class="navbar-item">
                            <a href="salones">Salones</a>
                        </li>
                        <li class="navbar-item">
                            <a href="materias">Materias</a>
                        </li>
                        <li class="navbar-item">
                            <a href="grupos">Grupos</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </body>
</html>
