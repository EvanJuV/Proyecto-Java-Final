/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgmt;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Usuario;

/**
 *
 * @author Evan
 */
public class ManageUsuariosServlet extends HttpServlet {
     
    // Función que maneja la entrada de requests al servlet
    public void service(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String url = "";
        
        if(Usuario.validate(username, password)) {
            HttpSession newSession = request.getSession();
            url = "menu.jsp";
            response.sendRedirect(url);
        }
        else {
            request.setAttribute("error_msg", "Error, la combinación de contraseña y usuario no es válida");
            url = "/login.jsp";
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }
    }
}
