/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.UpcomingCar;

import Model.UpcomingCar.UpcomingCarDAO;
import Model.UpcomingCar.UpcomingCarDAOImpl;
import Model.UpcomingCar.UpcomingCarG_S;
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
@WebServlet(urlPatterns = "/UpdateUpcomingcar")
public class UpdateUpcomingcar extends HttpServlet{

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
      
        UpcomingCarDAO updao=new UpcomingCarDAOImpl();
        UpcomingCarG_S up=new UpcomingCarG_S();
        
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
        
        up.setCid(cid);
        up.setNamemodel(namemodel);
        up.setVersion(version);
        up.setFuel_type(fuel);
        up.setMileage(mileage);
        up.setRoadprice(amount);
        up.setCity(city);
        up.setShort_description(sd);
        
        up.setColor(color);
        up.setFirstrange(first);
        up.setSecondrange(second);
        up.setRangepriceinword(rangeinword);
        up.setRto(rto);
        up.setInsurance(insurance);
        up.setOtherprice(otherprice);
        up.setOtherpriceindetail(otherpricename);
        up.setActualamount(actualprice);
        up.setRating(carsrating);
        up.setSummary(summary);
       
        up.setPic_name(imageurl);    
        
        System.out.println("Upcoming Old car data get transfer DaoImpl");
        updao.update(up);
        resp.sendRedirect("AWCarDetail.jsp");
    }
    
}
