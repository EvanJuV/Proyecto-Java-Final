/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgmt;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.DetalleGrupo;
import models.Grupo;
import models.Horario;
import models.Maestro;
import models.Materia;
import models.Salon;

/**
 *
 * @author erick
 */
public class ManageGruposServlet extends HttpServlet{
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] uri = request.getRequestURI().split("/");

        switch (uri[uri.length - 1]) {
            case "crear":
                crearGrupo(request, response);
                break;
            case "edit":
                editGrupo(request, response);
                break;
            case "update":
                updateGrupo(request, response);
                break;
            case "delete":
                deleteGrupo(request, response);
                break;
        }
    }

    public void crearGrupo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getContextPath() + "/grupos.jsp";

        ArrayList<DetalleGrupo> detalles = new ArrayList<>();
        Grupo newGrupo = new Grupo();

        newGrupo.setGrupo(parseInt(request.getParameter("grupo")));
        newGrupo.setIdioma(parseInt(request.getParameter("idioma")));
        newGrupo.setMateria(Materia.get(request.getParameter("materia_id")));
        newGrupo.setHonors(Boolean.parseBoolean(request.getParameter("honors") != null ? "true" : "false"));

        String[] maestrosId = request.getParameterValues("maestro_id[]");
        String[] horariosId = request.getParameterValues("horario_id[]");
        String[] salonesId = request.getParameterValues("salon_id[]");
        String[] porcentajes = request.getParameterValues("porcentaje[]");
        String[] laboratorios = request.getParameterValues("laboratorio[]");
        
        for(int i = 0; i < maestrosId.length; i++) {
            DetalleGrupo grupoDetalle = new DetalleGrupo();
            
            grupoDetalle.setHorario(Horario.get(parseInt(horariosId[i])));
            grupoDetalle.setMaestro(Maestro.get(parseInt(maestrosId[i])));
            grupoDetalle.setSalon(Salon.get(parseInt(salonesId[i])));
            grupoDetalle.setPorcentaje(Double.parseDouble(porcentajes[i]));
            grupoDetalle.setLaboratorio(Boolean.parseBoolean(laboratorios != null && laboratorios[i] != null ? "true" : "false"));
            
            detalles.add(grupoDetalle);
        }
        
        newGrupo.setDetalle(detalles);

        newGrupo.save();

        response.sendRedirect(url);
    }

//    public void materiasGrupo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String url = "/materias_de_maestro.jsp";
//        ArrayList<Materia> materias;
//
//        int nomina = parseInt(request.getParameter("nomina"));
//        materias = Grupo.getMaterias(nomina);
//        Grupo maestro = Grupo.get(nomina);
//
//        request.setAttribute("materias", materias);
//        request.setAttribute("maestro", maestro);
//
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
//        dispatcher.forward(request, response);
//    }

    public void editGrupo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/edit_maestro.jsp";

        Grupo maestro = Grupo.get(parseInt(request.getParameter("nomina")));

        request.setAttribute("maestro", maestro);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    private void updateGrupo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = request.getContextPath() + "/grupos.jsp";

        Grupo newGrupo = new Grupo();

//        newGrupo.setNomina(parseInt(request.getParameter("nomina")));
//        newGrupo.setNombre(request.getParameter("nombre"));
//        newGrupo.setNombre(request.getParameter("nombre"));
//        newGrupo.setTelefono(request.getParameter("telefono"));

        newGrupo.update();

        response.sendRedirect(url);
    }

    private void deleteGrupo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = request.getContextPath() + "/grupos.jsp";

        Grupo maestro = Grupo.get(parseInt(request.getParameter("nomina")));

        maestro.remove();

        response.sendRedirect(url);
    }
}
