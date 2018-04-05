package Controller.Profile;


import Model.Profile.ProfileDAO;
import Model.Profile.ProfileDAOImpl;
import Model.Profile.ProfileG_S;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
 * @author ANITA-PC
 */
@WebServlet(urlPatterns = "/Dowholesignup")
public class Dowholesignup extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Do signup post");
        String date=req.getParameter("currentDate");
        int uid=Integer.parseInt(req.getParameter("uid"));
        String a[]=req.getParameterValues("txt");
        
        ProfileDAO pdao=new ProfileDAOImpl();
        ProfileG_S p=new ProfileG_S();
        for(int i=0; i<a.length; i++)
        {
            switch(i)
            {
                case 0 :p.setName(a[i]); break;
                case 1 :p.setPhone(a[i]);break;
                case 2 :p.setEmail(a[i]);break;
                case 3 :p.setPassword(a[i]);break;
                case 4 :p.setAddress(a[i]);break;      
            }
        }
        p.setUid(uid);
        p.setDate(date);
        System.out.println("Wholeseller Signup data get transfer");
        pdao.insert(p);
        resp.sendRedirect("viewprofile.jsp");
        
    }
    
}
