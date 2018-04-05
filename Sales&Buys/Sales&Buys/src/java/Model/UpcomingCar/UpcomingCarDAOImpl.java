/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.UpcomingCar;

import Singleton.Singletonclass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANITA-PC
 */
public class UpcomingCarDAOImpl implements UpcomingCarDAO{

    @Override
    public void insert(UpcomingCarG_S up) {
        try
        {
            Connection con=Singletonclass.getInstance().getConnection();
         
            String query="insert into car_info_table(car_name_model, car_version, fuel_type, mileage, amount, city, short_description, uiid, date, carsrating) values(?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps=con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
       
            ps.setString(1, up.getNamemodel());
            ps.setString(2, up.getVersion());
            ps.setString(3, up.getFuel_type());
            ps.setString(4, up.getMileage());
            ps.setString(5, up.getRoadprice());
            ps.setString(6, up.getCity());
            ps.setString(7, up.getShort_description());
            ps.setInt(8, up.getUiid());
            ps.setString(9, up.getDate());
            ps.setInt(10, up.getRating());
            
            
            int rowsinserted=ps.executeUpdate();
            if(rowsinserted>0)
            {
            System.out.println("An new upcoming car half data was inserted successfully!");
            }
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next())
            {
                up.setCid(rs.getInt(1));
            
            }
            
            String query1="insert into upcoming_car_table(cid,firstrange,secondrange,rangepriceinword ,rto,insurance ,otherprice ,otherpriceindetail,actualprice, color, summary) values(?,?,?,?,?,?,?,?,?,?,?)"; 
            PreparedStatement ps1=con.prepareStatement(query1);
            ps1.setInt(1, up.getCid());
            ps1.setInt(2, up.getFirstrange());
            ps1.setInt(3, up.getSecondrange());
            ps1.setString(4, up.getRangepriceinword());
            ps1.setInt(5, up.getRto());
            ps1.setInt(6, up.getInsurance());
            ps1.setInt(7, up.getOtherprice());
            ps1.setString(8, up.getOtherpriceindetail());
            ps1.setInt(9, up.getActualamount());
            ps1.setString(10, up.getColor());

            ps1.setString(11, up.getSummary());
            
            int rowsinserted1=ps1.executeUpdate();
            if(rowsinserted1>0)
            {
            System.out.println("An new upcoming car full data was inserted successfully!");
            }
            
            String query2="insert into image_table(cid, pic_name) values(?,?)"; 
            PreparedStatement ps2=con.prepareStatement(query2);
            System.out.println("ImageURL:"+up.getPic_name());
            ps2.setInt(1, up.getCid());
            ps2.setString(2, up.getPic_name());
            
            int rowsinserted2=ps2.executeUpdate();
            if(rowsinserted2>0)
            {
            System.out.println("An new Used car image data was inserted successfully!");
            }

            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void update(UpcomingCarG_S up) {
        try
        {
            Connection con=Singletonclass.getInstance().getConnection();
         
            String query="update car_info_table set car_name_model=?, car_version=?, fuel_type=?, mileage=? ,amount=? ,city=? ,short_description=?, carsrating=? where cid=?";
            PreparedStatement ps,ps1,ps2;  
            ps=con.prepareStatement(query);
                   
            ps.setString(1, up.getNamemodel());
            ps.setString(2, up.getVersion());
            ps.setString(3, up.getFuel_type());
            ps.setString(4, up.getMileage());
            ps.setString(5, up.getRoadprice());
            ps.setString(6, up.getCity());
            ps.setString(7, up.getShort_description());
            ps.setInt(8, up.getRating());
            ps.setInt(9, up.getCid());
            
            
            int rowsinserted=ps.executeUpdate();
            if(rowsinserted>0)
            {
            System.out.println("An new upcoming car 50% data was updated successfully!");
            }
          
            String query1="update upcoming_car_table set firstrange=?,secondrange=?,rangepriceinword=? ,rto=?,insurance=? ,otherprice=? ,otherpriceindetail=?,actualprice=?,color=?, summary=? where cid=?";
            ps1=con.prepareStatement(query1);
            
            ps1.setInt(1, up.getFirstrange());
            ps1.setInt(2, up.getSecondrange());
            ps1.setString(3, up.getRangepriceinword());
            ps1.setInt(4, up.getRto());
            ps1.setInt(5, up.getInsurance());
            ps1.setInt(6, up.getOtherprice());
            ps1.setString(7, up.getOtherpriceindetail());
            ps1.setInt(8, up.getActualamount());
            ps1.setString(9, up.getColor());

            ps1.setString(10, up.getSummary());
            
            ps1.setInt(11, up.getCid());
            
            int rowsinserted1=ps1.executeUpdate();
            if(rowsinserted1>0)
            {
            System.out.println("An new upcoming car 75% data was updated successfully!");
            }
            
            String query2="update image_table set pic_name=? where cid=?"; 
            ps2=con.prepareStatement(query2);
            System.out.println("ImageURL:"+up.getPic_name());
            ps2.setString(1, up.getPic_name());
            ps2.setInt(2, up.getCid());
            
            int rowsinserted2=ps2.executeUpdate();
            if(rowsinserted2>0)
            {
            System.out.println("An new upcming car image 100% data was Updated successfully!");
            }

            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int cid) {
           try
        {
            Connection con=Singletonclass.getInstance().getConnection();
            
            String query="Delete from car_info_table where cid=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,cid);
            
            int rowsDeleted=ps.executeUpdate();
            if (rowsDeleted > 0) 
            {
                System.out.println("Item was deleted successfully!");
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public UpcomingCarG_S getUpcomingById(int cid) {
                UpcomingCarG_S up=new UpcomingCarG_S();
        try
        {
            Connection con=Singletonclass.getInstance().getConnection();
            String query="select * from Car_info_table inner join upcoming_car_table using(cid) inner join image_table using(cid) where cid=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,cid);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
            
            System.out.println("Found");
                
            up.setCid(rs.getInt("cid"));
            up.setNamemodel(rs.getString("car_name_model"));
            up.setVersion(rs.getString("car_version"));
            up.setFuel_type(rs.getString("fuel_type"));
            up.setMileage(rs.getString("mileage"));
            up.setRoadprice(rs.getString("amount"));
            up.setCity(rs.getString("city"));
            up.setShort_description(rs.getString("short_description"));    
            up.setUiid(rs.getInt("uiid"));
            up.setRating(rs.getInt("carsrating"));
            up.setDate(rs.getString("date")); 
                
            up.setFirstrange(rs.getInt("firstrange"));
            up.setSecondrange(rs.getInt("secondrange"));
            up.setRangepriceinword(rs.getString("rangepriceinword"));
            up.setRto(rs.getInt("rto"));
            up.setInsurance(rs.getInt("insurance"));
            up.setOtherprice(rs.getInt("otherprice"));
            up.setOtherpriceindetail(rs.getString("otherpriceindetail"));
            up.setActualamount(rs.getInt("actualprice"));
            up.setColor(rs.getString("color"));
            up.setSummary(rs.getString("summary"));
            
            up.setPic_name(rs.getString("pic_name"));
                
                
            }
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return up;    
    }

    @Override
    public List<UpcomingCarG_S> getUpcoming() {
        List<UpcomingCarG_S> list=new ArrayList<UpcomingCarG_S>();
        
         try
        {
            Connection con=Singletonclass.getInstance().getConnection();
            String query="select c.CID, c.car_name_model, c.car_version, i.PIC_NAME from Car_info_table c inner join upcoming_car_table using(cid) inner join image_table i using(cid)";
            PreparedStatement ps=con.prepareStatement(query);                        
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
            UpcomingCarG_S u=new UpcomingCarG_S();
            
            
            u.setCid(rs.getInt("cid"));
            u.setNamemodel(rs.getString("car_name_model"));
            u.setVersion(rs.getString("car_version"));
            
            u.setPic_name(rs.getString("pic_name"));
            
            list.add(u);
            
                    System.out.println(list);
            }                        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
      } 

    @Override
    public List<UpcomingCarG_S> getUpcomingByUiid(int uiid) {
        List<UpcomingCarG_S> list=new ArrayList<UpcomingCarG_S>();
        
         try
        {
            Connection con=Singletonclass.getInstance().getConnection();
            String query="select c.CID, c.car_name_model, c.car_version,i.PIC_NAME, u.firstrange, u.secondrange, u.rangepriceinword  from Car_info_table c inner join upcoming_car_table u using(cid) inner join image_table i using(cid) where uiid=?";
            PreparedStatement ps=con.prepareStatement(query);                        
            ps.setInt(1,uiid);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
            UpcomingCarG_S u=new UpcomingCarG_S();
            
            
            u.setCid(rs.getInt("cid"));
            u.setNamemodel(rs.getString("car_name_model"));
            u.setVersion(rs.getString("car_version"));
            
            u.setPic_name(rs.getString("pic_name"));
            u.setFirstrange(rs.getInt("firstrange"));
            u.setSecondrange(rs.getInt("secondrange"));
            u.setRangepriceinword(rs.getString("rangepriceinword"));
            list.add(u);
            
                    System.out.println(list);
            }                        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
        
    }
    }
    

