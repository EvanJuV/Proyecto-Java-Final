<%-- 
    Document   : navbar
    Created on : May 1, 2016, 6:56:28 PM
    Author     : Evan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar">
    <ul class="navbar-list">
        <li class="navbar-item">
            <a href="${pageContext.request.contextPath}/menu.jsp">Inicio</a>
        </li>
        <li class="navbar-item">
            <a href="${pageContext.request.contextPath}/maestros.jsp">Maestros</a>
        </li>
        <li class="navbar-item">
            <a href="${pageContext.request.contextPath}/salones.jsp">Salones</a>
        </li>
        <li class="navbar-item">
            <a href="${pageContext.request.contextPath}/materias.jsp">Materias</a>
        </li>
        <li class="navbar-item">
            <a href="${pageContext.request.contextPath}/grupos.jsp">Grupos</a>
        </li>
    </ul>
</nav>