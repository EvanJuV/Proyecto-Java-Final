package mgmt;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        String url = "/response.jsp"; //mueve esto muchacho
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        String[] req = request.getRequestURI().split("/");
        System.out.println(req);
        dispatcher.forward(request, response);
    }
}
