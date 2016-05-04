package mgmt;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Grupo;
import models.Maestro;
import models.Materia;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Evan
 */

public class ManageMaestrosServlet  extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        String[] uri = request.getRequestURI().split("/");
        
        switch(uri[uri.length -1]) {
            case "crear":
                crearMaestro(request, response);
                break;
            case "edit":
                editMaestro(request, response);
                break;
            case "grupos":
                gruposMaestro(request, response);
                break;
            case "update":
                updateMaestro(request, response);
                break;
            case "delete":
                deleteMaestro(request, response);
                break;
        }
    }
    
    public void crearMaestro(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        String url = request.getContextPath() + "/maestros.jsp";
        
        Maestro newMaestro = new Maestro();
        
        newMaestro.setNomina(parseInt(request.getParameter("nomina")));
        newMaestro.setNombre(request.getParameter("nombre"));
        newMaestro.setTelefono(request.getParameter("telefono"));
        newMaestro.setEmail(request.getParameter("email"));
        
        newMaestro.save();
        
        response.sendRedirect(url);
    }
    
    public void gruposMaestro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/grupos_maestro.jsp";
        ArrayList<Grupo> grupos;
        
        int nomina = parseInt(request.getParameter("nomina"));
        grupos = Maestro.getGrupos(nomina);
        Maestro maestro = Maestro.get(nomina);

        request.setAttribute("grupos", grupos);
        request.setAttribute("maestro", maestro);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    public void editMaestro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/edit_maestro.jsp";

        Maestro maestro = Maestro.get(parseInt(request.getParameter("nomina")));

        request.setAttribute("maestro", maestro);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    private void updateMaestro(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = request.getContextPath() + "/maestros.jsp";

        Maestro newMaestro = new Maestro();

        newMaestro.setNomina(parseInt(request.getParameter("nomina")));
        newMaestro.setNombre(request.getParameter("nombre"));
        newMaestro.setTelefono(request.getParameter("telefono"));
        newMaestro.setEmail(request.getParameter("email"));

        newMaestro.update();

        response.sendRedirect(url);
    }

    private void deleteMaestro(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = request.getContextPath() + "/maestros.jsp";

        Maestro maestro = Maestro.get(parseInt(request.getParameter("nomina")));

        maestro.remove();

        response.sendRedirect(url);
    }
}
