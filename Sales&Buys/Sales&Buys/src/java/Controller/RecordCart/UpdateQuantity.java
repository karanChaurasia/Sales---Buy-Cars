/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller.RecordCart;

import Model.RecordInfoProcess.RecordInfoDAO;
import Model.RecordInfoProcess.RecordInfoDAOImpl;
import Model.RecordInfoProcess.RecordInfoG_S;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucky
 */
@WebServlet(urlPatterns = "/UpdateQuantity")
public class UpdateQuantity extends HttpServlet{
        @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int riid=Integer.parseInt(req.getParameter("riid"));
        String noofcar=req.getParameter("txt_quantity");
            System.out.println(noofcar);
        RecordInfoDAO rdao=new RecordInfoDAOImpl();
        RecordInfoG_S r=new RecordInfoG_S();
        r.setRiid(riid);
        r.setNoofcar(noofcar);
        System.out.println("now Record pass to the DAOImpl");
        
        rdao.update(r);
        resp.sendRedirect("Cart.jsp");
    }

}
