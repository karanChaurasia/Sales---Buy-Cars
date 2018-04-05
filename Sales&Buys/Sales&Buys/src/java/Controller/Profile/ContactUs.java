/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author ANITA-PC
 */
@WebServlet(urlPatterns = "/ContactUs")
public class ContactUs extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession hs=req.getSession();
        int uiid=(Integer)hs.getAttribute("id");
            
        String name=req.getParameter("txt_name");
        String email=req.getParameter("txt_email");
        String msg=req.getParameter("txt_msg");
        String date=req.getParameter("currentDate");
        
        System.out.println(uiid);
        System.out.println(name);
        System.out.println(email);
        System.out.println(msg);
        System.out.println(date);
         ProfileDAO pdao=new ProfileDAOImpl();
         ProfileG_S p=new ProfileG_S();
         p.setUiid(uiid);
         p.setName(name);
         p.setEmail(email);
         p.setMessage(msg);
         p.setDate(date);
         pdao.insertcontactinfo(p);
                    PrintWriter out=resp.getWriter();     
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Thank you for ContantUs.......');");

                    out.println("location='Index.jsp';");
                    out.println("</script>");
    
         
          }
    
}
