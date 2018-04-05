/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.AddCarItem;

import Model.AddCarItem.AddItemDAO;
import Model.AddCarItem.AddItemDAOImpl;
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
@WebServlet(urlPatterns = "/DeleteFromAddItem")
public class DeleteFromAddItem extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         int cid=Integer.parseInt(req.getParameter("cid"));
        
        AddItemDAO adao=new AddItemDAOImpl();
        System.out.println("Data transfer to AddItem Impliementation");
        adao.delete(cid);
        
        resp.sendRedirect("AWCarDetail.jsp");
    }
    
}
