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

/**
 *
 * @author Evan
 */
public class ManageMateriasServlet extends HttpServlet {
    public void service(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String[] uri = request.getRequestURI().split("/");
        
        
    }
}
