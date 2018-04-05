/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.UsedCar;

import Model.SellUsedCar.UsedCarDAOImpl;
import Model.SellUsedCar.UsedCarDao;
import Model.SellUsedCar.UsedCarG_S;
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
@MultipartConfig(maxFileSize = 10*1024*1024,maxRequestSize = 20*1024*1024,fileSizeThreshold = 5*1024*1024)
@WebServlet(urlPatterns = "/UpdateUsedcar")
public class UpdateUsedcar extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      int cid=Integer.parseInt(req.getParameter("cid")); 
            String name_model=req.getParameter("txt_namemodel");
      String version=req.getParameter("txt_version");
      String fuel=req.getParameter("txt_fuel");
      String mileage=req.getParameter("txt_mileage");
      String amount=req.getParameter("txt_amount");
      String amountinword=req.getParameter("txt_inword");
      String city=req.getParameter("txt_city");
      
      
      String owner=req.getParameter("txt_owner");
      String location=req.getParameter("txt_location");
      String year=req.getParameter("txt_manufacture");
      String sd=req.getParameter("txt_sd");
      int rating =Integer.parseInt(req.getParameter("star"));
        UsedCarDao udao=new UsedCarDAOImpl();
        UsedCarG_S u=new UsedCarG_S();
        
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
        
        u.setCid(cid);
        u.setNamemodel(name_model);
        u.setVersion(version);
        u.setFuel_type(fuel);    
        u.setMileage(mileage);
        u.setAmount(amount);
        u.setCity(city);
        u.setShort_description(sd);
        
        u.setRating(rating);
        u.setAmountinword(amountinword);
        u.setLocation(location);
        u.setYear_manufacture(year);
        u.setNo_of_owner(owner);
        
        u.setPic_name(imageurl);
        
        System.out.println("Update in Used car data get transfer DaoImpl");
        udao.update(u);
     
        
        resp.sendRedirect("AWCarDetail.jsp");
    }
    
}
