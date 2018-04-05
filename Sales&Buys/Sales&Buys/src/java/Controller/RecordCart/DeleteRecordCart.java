/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.RecordCart;

import Model.RecordInfoProcess.RecordInfoDAO;
import Model.RecordInfoProcess.RecordInfoDAOImpl;
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
@WebServlet(urlPatterns = "/DeleteRecordCart")
public class DeleteRecordCart extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int riid=Integer.parseInt(req.getParameter("riid"));
        
        RecordInfoDAO rdao=new RecordInfoDAOImpl();
        System.out.println("now RIID pass to the DAOImpl");
        rdao.delete(riid);
        resp.sendRedirect("Cart.jsp");
    }

    

   
    
}
