/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Profile;

import Model.Profile.ProfileDAO;
import Model.Profile.ProfileDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ANITA-PC
 */
@WebServlet(urlPatterns = "/Changepassword")
public class Changepassword extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        PrintWriter out=resp.getWriter();    
        HttpSession hs=req.getSession();
        String pass=(String)hs.getAttribute("pass");
        Integer uiid=(Integer)hs.getAttribute("id");
            
        String insrtpass=req.getParameter("txt_oldpass");
        String newpass=req.getParameter("txt_newpass");
            if(pass.equals(insrtpass))
            {   
                ProfileDAO pdao=new ProfileDAOImpl();
                pdao.changepassword(uiid,newpass);
                
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Password change successfully');");

                out.println("location='ProfileHandler.jsp';");
                out.println("</script>");
            }
            else
            {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Your Password is inncorrect try again');");

                out.println("location='ProfileHandler.jsp';");
                out.println("</script>");
            }
            
    }
}
