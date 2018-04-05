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
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANITA-PC
 */
@WebServlet(urlPatterns = "/RecordInfo")
public class RecordInfo extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        
        HttpSession hs=req.getSession();
        int cid=Integer.parseInt(req.getParameter("cid"));
        int rid=Integer.parseInt(req.getParameter("rid"));
        int uiid=(Integer)hs.getAttribute("id");
        String noofcar=req.getParameter("txt_noofcar");
        
        
        RecordInfoDAO ridao=new RecordInfoDAOImpl();
        RecordInfoG_S r=new RecordInfoG_S();
        
        r.setCid(cid);
        r.setUiid(uiid);
        r.setRid(rid);
        r.setNoofcar(noofcar);
        
        System.out.println("Record data get ready to transfer daoimpl");
        
        ridao.insert(r);
        
        if(rid==3){
            System.out.println("now you going to Saler Detail page");
        resp.sendRedirect("UsedCarSellerDetail.jsp?cid="+cid);}
        else{
            System.out.println("now you going to thank you page");
            resp.sendRedirect("UpcomingCarThankYou.jsp");}
    }

   
}
