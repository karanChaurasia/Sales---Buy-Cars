/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Profile;

import Model.Profile.ProfileDAO;
import Model.Profile.ProfileDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ANITA-PC\
 */
@WebServlet(urlPatterns={"/DeleteFromDB"})
public class DeleteFromDB extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        
        ProfileDAO pdao=new ProfileDAOImpl();
        pdao.delete(id);
        
        resp.sendRedirect("viewprofile.jsp");
    }
    
}
