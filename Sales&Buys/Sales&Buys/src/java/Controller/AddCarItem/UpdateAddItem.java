/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.AddCarItem;

import Model.AddCarItem.AddItemDAO;
import Model.AddCarItem.AddItemDAOImpl;
import Model.AddCarItem.AddItemG_S;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author ANITA-PC
 */
@WebServlet(urlPatterns = "/UpdateAddItem")
@MultipartConfig(maxFileSize = 10*1024*1024,maxRequestSize = 20*1024*1024,fileSizeThreshold = 5*1024*1024)
public class UpdateAddItem extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        int cid=Integer.parseInt(req.getParameter("cid"));
      String namemodel=req.getParameter("txt_namemodel");
      String version=req.getParameter("txt_version");
      String fuel=req.getParameter("txt_fuel");
      String mileage=req.getParameter("txt_mileage");
      String amount=req.getParameter("txt_roadprice");
      String city=req.getParameter("txt_city");
      String sd=req.getParameter("txt_sd");
      
      int first=Integer.parseInt(req.getParameter("txt_fir"));
      int second=Integer.parseInt(req.getParameter("txt_sec"));
      String rangeinword=req.getParameter("amountinword");
      int rto=Integer.parseInt(req.getParameter("txt_rto"));
      int insurance=Integer.parseInt(req.getParameter("txt_insurance"));
      int otherprice=Integer.parseInt(req.getParameter("txt_otherprice"));
      String otherpricename=req.getParameter("txt_nameofprice");
      int actualprice=Integer.parseInt(req.getParameter("txt_actualamount"));
      int carsrating=Integer.parseInt(req.getParameter("txt_star"));
      String color=req.getParameter("txt_color");
      String summary=req.getParameter("txt_sum");
      
        AddItemDAO adao=new AddItemDAOImpl();
        AddItemG_S a=new AddItemG_S();
        
        
        
        // Now Cloudnary Image
          System.out.println(this.getServletContext().getRealPath("/"));
       
        Part p=req.getPart("txt_image");
        
        byte b[]=new byte[ p.getInputStream().available()];
        p.getInputStream().read(b);
        
        File f=new File(this.getServletContext().getRealPath("/") + "/image.jpg");
        
        FileOutputStream fos=new FileOutputStream(f);
        fos.write(b);
        fos.close();
        
        //cloudinary access through
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "bobcloud",
                "api_key", "665597775829698",
                "api_secret", "WijvB87Gvky-yAlrsHN9-74Q4m0"));
        
        Map uploadResult = cloudinary.uploader().upload(f, ObjectUtils.emptyMap());
        System.out.println(uploadResult.get("secure_url"));
        String imageurl=uploadResult.get("secure_url").toString();
           a.setCid(cid);
           a.setPic_name(imageurl);
        a.setNamemodel(namemodel);
        a.setVersion(version);
        a.setFuel_type(fuel);
        a.setMileage(mileage);
        a.setRoadprice(amount);
        a.setCity(city);
        a.setShort_description(sd);
        
        a.setColor(color);
        a.setFirstrange(first);
        a.setSecondrange(second);
        a.setRangepriceinword(rangeinword);
        a.setRto(rto);
        a.setInsurance(insurance);
        a.setOtherprice(otherprice);
        a.setOtherpriceindetail(otherpricename);
        a.setActualamount(actualprice);
        a.setRating(carsrating);
        a.setSummary(summary);
      
                   
        System.out.println("UpdateNewItem data get transfer");
        adao.update(a);
        resp.sendRedirect("AWCarDetail.jsp");
  }
    
}
