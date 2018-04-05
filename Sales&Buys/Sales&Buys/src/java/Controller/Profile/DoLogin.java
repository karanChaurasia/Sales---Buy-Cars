package Controller.Profile;

import Model.Profile.ProfileDAO;
import Model.Profile.ProfileDAOImpl;
import Model.Profile.ProfileG_S;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = "/DoLogin")

public class DoLogin extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try
        {
            ProfileDAO pdao=new ProfileDAOImpl();
            ProfileG_S p=new ProfileG_S();

            String email=req.getParameter("email");
            String pass=req.getParameter("txt_Password");
        
            p.setEmail(email);
            p.setPassword(pass);
            pdao.login(p);

            String email1=p.getEmail();
            String pass1=p.getPassword();
           
            
            System.out.println(email+" == "+email1);
            System.out.println(pass+" == "+pass1);
            
            if(email.equalsIgnoreCase(email1) && pass.equals(pass1))
            {
                    System.out.println("Data is matched");
                    HttpSession mysession=req.getSession(true);
                    String name=p.getName();
                    int uiid=p.getUiid();
                    int uid=p.getUid();

                    System.out.println("Name: "+name);
                    System.out.println("User_ID: "+uiid);
                    System.out.println("User_TYPE: "+uid);

                    System.out.println("ClientID " +mysession.getId());
                    mysession.setAttribute("pass", pass1);
                    mysession.setAttribute("name", name);
                    mysession.setAttribute("id", uiid);
                    mysession.setAttribute("uid", uid);

                    resp.sendRedirect("Index.jsp");
            }
            else
            {
                  System.out.println("Data isn't matched");
                  PrintWriter out=resp.getWriter();     
                  out.println("<script type=\"text/javascript\">");
                  out.println("alert('Invalid ID and Password');");

                  out.println("location='Login.jsp';");
                    out.println("</script>");
    
                  
            }
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
