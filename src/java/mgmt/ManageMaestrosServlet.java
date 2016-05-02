package mgmt;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            case "materias":
                materiasMaestro(request, response);
                break;
        }
    }
    
//    public void maestros(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
//        String url = "/maestros.jsp";
//        ArrayList<Maestro> maestros;
//        maestros = Maestro.getAll();
//        
//        request.setAttribute("maestros", maestros);
//        
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
//        dispatcher.forward(request, response);
//    }
    
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
    
    public void materiasMaestro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/materias_de_maestro.jsp";
        ArrayList<Materia> materias;
        
        int nomina = parseInt(request.getParameter("nomina"));
        materias = Maestro.getMaterias(nomina);
        Maestro maestro = Maestro.get(nomina);

        request.setAttribute("materias", materias);
        request.setAttribute("maestro", maestro);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    public void editMaestro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    
//    public void 
}
