package Controller.Profile;


import java.io.IOException;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author badree.tiwari
 */
@WebServlet(urlPatterns = "/SessionKilled")
public class SessionKilled extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession hs=req.getSession();
                hs.invalidate();
        out.println("You are successfully LOGGED out!");
         resp.sendRedirect("Index.jsp");
        
    }
    
    
}
