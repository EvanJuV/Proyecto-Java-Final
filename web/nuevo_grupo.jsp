<%@page import="models.Maestro"%>
<%@page import="models.Salon"%>
<%@page import="models.Horario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Materia"%>
<%-- 
    Document   : nuevo_grupo
    Created on : May 3, 2016, 10:09:36 PM
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
        <title>Nuevo grupo</title>
        <script>
            window.onload = function() {
                document.forms['GrupoEdit-form'].onsubmit = function () {
                    var grupo = document.getElementById('grupo');
                    var porcentaje = document.getElementById('porcentaje');
                    var msg = '';
                    var run = true;
                    
                    if (!grupo.value.match(/([0-9])/)) {
                        run = false;
                        msg += 'Grupo debe ser Numeros';
                    }
                    if (!porcentaje.value.match(/([0-9])/)) {
                        run = false;
                        msg += '<br>Los porcentajes deben ser numeros';
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
            <h2>Nuevo grupo</h2>
            <span style="color:red; font-weight: bold;" id="error"></span>
            <form name="GrupoEdit-form" method="POST" action="${pageContext.request.contextPath}/grupos/crear" id="group-form">
                <div class="row">
                    <div class="four columns">
                        <label for="materia_id">Materia</label>
                        <select name="materia_id" class="u-full-width">
                            <% ArrayList<Materia> materias = Materia.getAll(); %>
                            <% for(Materia m : materias) { %>
                            <option value="<%=m.getClave()%>"><%=m.getNombre()%></option>
                            <% } %>
                        </select>
                    </div>
                    <div class="four columns">
                        <label for="grupo">Grupo</label>
                        <input id="grupo" type="text" name="grupo" class="u-full-width">
                    </div>
                    <div class="four columns">
                        <label for="idioma">Idioma</label>
                        <select name="idioma" class="u-full-width">
                            <% String[] idiomas = {"Español", "Inglés", "Alemán"}; %>
                            <% for (int i=0; i < idiomas.length; i++) {%>
                            <option value="<%=i%>"><%=idiomas[i]%></option>
                            <% }%>
                        </select>
                    </div>
                    <div class="row">
                        <label for="honors" class="two columns">
                            <input type="checkbox" name="honors" />
                            <span class="label-body">Honors</span>
                        </label>
                    </div>
                </div>
                <h5>Detalles de clase</h5>
                <div id="classContainer">
                    <div class="row">
                        <div class="four columns">
                            <label for="horario_id[]">Horario</label>
                            <select name="horario_id[]" class="u-full-width">
                                <% ArrayList<Horario> horarios = Horario.getAll(); %>
                                <% for (Horario h : horarios) {%>
                                <option value="<%=h.getId()%>"><%=h.getHora() + "/" + h.getDuracion() + " " + h.getDias()%></option>
                                <% }%>
                            </select>
                        </div>
                        <div class="eight columns">
                            <label for="salon_id[]">Salón</label>
                            <select name="salon_id[]" class="u-full-width">
                                <% ArrayList<Salon> salones = Salon.getAll(); %>
                                <% for (Salon s : salones) {%>
                                <option value="<%=s.getId()%>"><%=s.getDepartamento() + " " + s.getNumeroSalon() %></option>
                                <% }%>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="four columns">
                            <label for="porcentaje[]">Porcentaje</label>
                            <input id="porcentaje" type="text" name="porcentaje[]" class="u-full-width"/>
                        </div>
                        <div class="eight columns">
                            <label for="maestro_id[]">Maestro</label>
                            <select name="maestro_id[]"class="u-full-width">
                                <% ArrayList<Maestro> maestros = Maestro.getAll(); %>
                                <% for (Maestro m : maestros) {%>
                                <option value="<%=m.getNomina()%>"><%=m.getNombre()%></option>
                                <% }%>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <label for="laboratorio[]" class="two columns">
                            <input type="checkbox" name="laboratorio[]" />
                            <span class="label-body">Laboratorio</span>
                        </label>
                    </div>
                </div>
                <div class="row">
                    <button id="add-btn" class="button three columns">Añadir clase</button>
                    <input type="submit" value="Crear" class="button-primary two columns">
                </div>
            </form>
        </div>
    </body>
    <script>
        var container = document.getElementById("classContainer");
        var newNode = container.innerHTML;
        var hr = document.createElement("hr");
        
        document.getElementById("add-btn").addEventListener("click", function(event) {
           event.preventDefault(); 
           container.appendChild(hr);
           container.innerHTML += newNode;
        });
    </script>
</html>
