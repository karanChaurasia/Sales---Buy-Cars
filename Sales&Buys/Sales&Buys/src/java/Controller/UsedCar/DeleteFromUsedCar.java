/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.UsedCar;

import Model.SellUsedCar.UsedCarDAOImpl;
import Model.SellUsedCar.UsedCarDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ANITA-PC
 */
@WebServlet(urlPatterns = "/DeleteFromUsedCar")
public class DeleteFromUsedCar extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cid=Integer.parseInt(req.getParameter("cid"));
        
        UsedCarDao udao=new UsedCarDAOImpl();
        System.out.println("Data transfer to UsedCar Impliementation");
        udao.delete(cid);
        
        resp.sendRedirect("AWCarDetail.jsp");
    }
    
}
