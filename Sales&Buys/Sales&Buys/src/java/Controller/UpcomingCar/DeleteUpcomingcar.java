/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.UpcomingCar;

import Model.UpcomingCar.UpcomingCarDAO;
import Model.UpcomingCar.UpcomingCarDAOImpl;
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
@WebServlet(urlPatterns = "/DeleteUpcomingcar")
public class DeleteUpcomingcar extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          int cid=Integer.parseInt(req.getParameter("cid"));
        
        UpcomingCarDAO updao=new UpcomingCarDAOImpl();
        System.out.println("Data transfer to Upcoming Impliementation");
        updao.delete(cid);
        
        resp.sendRedirect("AWCarDetail.jsp");
    }
    
}
