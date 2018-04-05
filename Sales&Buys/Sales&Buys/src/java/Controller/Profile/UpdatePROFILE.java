/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Profile;

import Model.Profile.ProfileG_S;
import Model.Profile.ProfileDAO;
import Model.Profile.ProfileDAOImpl;
import java.io.IOException;
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

@WebServlet(urlPatterns = "/UpdatePROFILE")
public class UpdatePROFILE extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          
        HttpSession hs=req.getSession();
        int uid=(Integer)hs.getAttribute("uid");
        System.out.println(uid+"dsnkndcsn");
        
        int id=Integer.parseInt(req.getParameter("hid"));
        String phone=req.getParameter("txtPhoneno");
        String name=req.getParameter("txtName");
        String address=req.getParameter("txtAddress");
                      
        ProfileDAO pdao=new ProfileDAOImpl();
        ProfileG_S p=new ProfileG_S();
        p.setUiid(id);
        p.setName(name);
        p.setPhone(phone);
        p.setAddress(address);
        
        System.out.println("Update Profile data is transfer");
        pdao.update(p);
        if(uid==1)
            resp.sendRedirect("viewprofile.jsp");   
        else
            resp.sendRedirect("ProfileHandler.jsp");
        
        
    }
      
}
