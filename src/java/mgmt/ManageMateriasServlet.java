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
import models.Materia;

/**
 *
 * @author Evan
 */
public class ManageMateriasServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] uri = request.getRequestURI().split("/");

        switch (uri[uri.length - 1]) {
            case "crear":
                crearMateria(request, response);
                break;
            case "edit":
                editMateria(request, response);
                break;
            case "update":
                updateMateria(request, response);
                break;
            case "delete":
                deleteMateria(request, response);
                break;
        }
    }

    public void crearMateria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getContextPath() + "/materias.jsp";

        Materia newMateria = new Materia();

        newMateria.setClave(request.getParameter("clave"));
        newMateria.setNombre(request.getParameter("nombre"));
        newMateria.setHorasLaboratorio(parseInt(request.getParameter("horas_laboratorio")));

        newMateria.save();

        response.sendRedirect(url);
    }

    public void editMateria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/edit_materia.jsp";

        Materia materia = Materia.get(request.getParameter("clave"));
        request.setAttribute("materia", materia);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    public void deleteMateria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getContextPath() + "/materias.jsp";

        Materia materia = Materia.get(request.getParameter("clave"));

        materia.remove();

        response.sendRedirect(url);
    }

    public void updateMateria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getContextPath() + "/materias.jsp";

        Materia newMateria = new Materia();

        newMateria.setClave(request.getParameter("clave"));
        newMateria.setNombre(request.getParameter("nombre"));
        newMateria.setHorasLaboratorio(parseInt(request.getParameter("horas_laboratorio")));

        newMateria.update();

        response.sendRedirect(url);
    }
}
