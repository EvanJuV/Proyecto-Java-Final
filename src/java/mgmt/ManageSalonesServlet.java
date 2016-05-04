/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgmt;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Salon;

/**
 *
 * @author erick
 */
public class ManageSalonesServlet extends HttpServlet{
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] uri = request.getRequestURI().split("/");

        switch (uri[uri.length - 1]) {
            case "crear":
                crearSalon(request, response);
                break;
            case "edit":
                editSalon(request, response);
                break;
            case "update":
                updateSalon(request, response);
                break;
            case "delete":
                deleteSalon(request, response);
                break;
        }
    }

    public void crearSalon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getContextPath() + "/salones.jsp";

        Salon newSalon = new Salon();

        newSalon.setNumeroSalon(parseInt(request.getParameter("numero_salon")));
        newSalon.setCapacidad(parseInt(request.getParameter("capacidad")));
        newSalon.setDepartamento(request.getParameter("departamento"));

        newSalon.save();

        response.sendRedirect(url);
    }

    public void editSalon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/edit_salon.jsp";

        Salon salon = Salon.get(parseInt(request.getParameter("id")));
        
        request.setAttribute("salon", salon);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    public void deleteSalon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getContextPath() + "/salones.jsp";
        
        Salon salon = Salon.get(parseInt(request.getParameter("id")));
        
        salon.remove();
        
        response.sendRedirect(url);
    }
    
    public void updateSalon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getContextPath() + "/salones.jsp";

        Salon newSalon = new Salon();
        
        newSalon.setId(parseInt(request.getParameter("salon_id")));
        newSalon.setNumeroSalon(parseInt(request.getParameter("numero_salon")));
        newSalon.setCapacidad(parseInt(request.getParameter("capacidad")));
        newSalon.setDepartamento(request.getParameter("departamento"));

        newSalon.update();
        
        response.sendRedirect(url);
    }
}
