/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.SellUsedCar;

import Singleton.Singletonclass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author badree.tiwari
 */
public class UsedCarDAOImpl implements UsedCarDao{

    @Override
    public void insert(UsedCarG_S u) {
        try
        {
            Connection con=Singletonclass.getInstance().getConnection();
           String query="insert into car_info_table(car_name_model, car_version, fuel_type, mileage, amount, city, short_description, uiid, date,carsrating) values(?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps=con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
       
            ps.setString(1, u.getNamemodel());
            ps.setString(2, u.getVersion());
            ps.setString(3, u.getFuel_type());
            ps.setString(4, u.getMileage());
            ps.setString(5, u.getAmount());
            ps.setString(6, u.getCity());
            ps.setString(7, u.getShort_description());
            ps.setInt(8, u.getUiid());
            ps.setString(9, u.getDate());
            ps.setInt(10, u.getRating());
            int rowsinserted=ps.executeUpdate();
            if(rowsinserted>0)
            {
            System.out.println("An new Used car 50% data was inserted successfully!");
            }
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next())
            {
                u.setCid(rs.getInt(1));
            
            }
            
            String query1="insert into used_car_table(cid, location, year_manufacture, no_of_owner,amountinword) values(?,?,?,?,?)"; 
            PreparedStatement ps1=con.prepareStatement(query1);
            System.out.println(u.getLocation());
            ps1.setInt(1, u.getCid());
            ps1.setString(2, u.getLocation());
            ps1.setString(3, u.getYear_manufacture());
            ps1.setString(4, u.getNo_of_owner());
            ps1.setString(5, u.getAmountinword());
            int rowsinserted1=ps1.executeUpdate();
            if(rowsinserted1>0)
            {
            System.out.println("An new Used car 75% data was inserted successfully!");
            }
            
            String query2="insert into image_table(cid, pic_name) values(?,?)"; 
            PreparedStatement ps2=con.prepareStatement(query2);
            System.out.println("ImageURL:"+u.getPic_name());
            ps2.setInt(1, u.getCid());
            ps2.setString(2, u.getPic_name());
            
            int rowsinserted2=ps2.executeUpdate();
            if(rowsinserted2>0)
            {
            System.out.println("An new Used car 100% data was inserted successfully!");
            }


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void update(UsedCarG_S u) {
        try
        {
            Connection con=Singletonclass.getInstance().getConnection();
            String query="update car_info_table set car_name_model=?, car_version=?, fuel_type=?, mileage=? ,amount=? ,city=? ,short_description=?,carsrating=? where cid=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, u.getNamemodel());
            ps.setString(2, u.getVersion());
            ps.setString(3, u.getFuel_type());
            ps.setString(4, u.getMileage());
            ps.setString(5, u.getAmount());
            ps.setString(6, u.getCity());
            ps.setString(7, u.getShort_description());
            ps.setInt(8, u.getRating());
            ps.setInt(9, u.getCid());
            
                       
            int rowsUpdated=ps.executeUpdate();
            if(rowsUpdated>0)
            {
            System.out.println("An existing usercar 50% was updated successfully!");
            }
            
            String query1="update used_car_table set location=?, year_manufacture=?, no_of_owner=?,amountinword=? where cid=?";
            PreparedStatement ps1=con.prepareStatement(query1);
            
            
            ps1.setString(1, u.getLocation());
            ps1.setString(2, u.getYear_manufacture());
            ps1.setString(3, u.getNo_of_owner());
            ps1.setString(4, u.getAmountinword());
            ps1.setInt(5, u.getCid());           
            
            int rowsUpdated1=ps1.executeUpdate();
            if(rowsUpdated1>0)
            {
            System.out.println("An existing usercar 75% was updated successfully!");
            }
            
            String query2="update image_table set pic_name=? where cid=?";
            PreparedStatement ps2=con.prepareStatement(query2);
            
            ps2.setString(1, u.getPic_name());
            ps2.setInt(2, u.getCid());           
            
            int rowsUpdated2=ps2.executeUpdate();
            if(rowsUpdated2>0)
            {
            System.out.println("An existing usercar 100% was updated successfully!");
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
            
            String query="Delete from Car_info_table where cid=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,cid);
            
            int rowsDeleted=ps.executeUpdate();
            if (rowsDeleted > 0) 
            {
                System.out.println("Car Item was deleted successfully!");
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
  
    }

    @Override
    public UsedCarG_S getOldCarDetailByID(int cid) {
        UsedCarG_S u=new UsedCarG_S();
        try
        {
            Connection con=Singletonclass.getInstance().getConnection();
            String query="select * from Car_info_table inner join used_car_table using(cid) inner join image_table using(cid) where cid=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,cid);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
            
            System.out.println("Found");
                
            u.setCid(rs.getInt("cid"));
            u.setNamemodel(rs.getString("car_name_model"));
            u.setVersion(rs.getString("car_version"));
            u.setFuel_type(rs.getString("fuel_type"));
            u.setMileage(rs.getString("mileage"));
            u.setAmount(rs.getString("amount"));
            u.setCity(rs.getString("city"));
            u.setShort_description(rs.getString("short_description"));    
            u.setUiid(rs.getInt("uiid"));
            u.setDate(rs.getString("date")); 
            u.setRating(rs.getInt("carsrating"));
            u.setAmountinword(rs.getString("amountinword")); 
            
            u.setLocation(rs.getString("location"));
            u.setYear_manufacture(rs.getString("year_manufacture"));
            u.setNo_of_owner(rs.getString("no_of_owner"));
            
            u.setPic_name(rs.getString("pic_name"));
                
                
            }
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return u;    
    }

    
    @Override
    public List<UsedCarG_S> getOldCarMinDetail() {
        List<UsedCarG_S> list=new ArrayList<UsedCarG_S>();
        
         try
        {
            Connection con=Singletonclass.getInstance().getConnection();
            String query="select * from Car_info_table inner join used_car_table using(cid) inner join image_table using(cid) order by cid desc fetch first 3 rows only";
            PreparedStatement ps=con.prepareStatement(query);                        
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
            UsedCarG_S u=new UsedCarG_S();
                       
            u.setCid(rs.getInt("cid"));
            u.setNamemodel(rs.getString("car_name_model"));
            u.setVersion(rs.getString("car_version"));
            u.setFuel_type(rs.getString("fuel_type"));
            u.setMileage(rs.getString("mileage"));
            u.setAmount(rs.getString("amount"));
            u.setCity(rs.getString("city"));
            u.setShort_description(rs.getString("short_description"));    
            u.setUiid(rs.getInt("uiid"));
            u.setDate(rs.getString("date")); 
            u.setRating(rs.getInt("carsrating"));
            
            u.setAmountinword(rs.getString("amountinword")); 
            u.setLocation(rs.getString("location"));
            u.setYear_manufacture(rs.getString("year_manufacture"));
            u.setNo_of_owner(rs.getString("no_of_owner"));
            
            u.setPic_name(rs.getString("pic_name"));
            
            list.add(u);
            
                    
            }                        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<UsedCarG_S> getallrecordbyUserId(int uiid) {
       List<UsedCarG_S> list=new ArrayList<UsedCarG_S>();
       
          try
        {
            Connection con=Singletonclass.getInstance().getConnection();
            String query="select * from Car_info_table inner join used_car_table using(cid) inner join image_table using(cid) where uiid=?";
            PreparedStatement ps=con.prepareStatement(query);                        
            ps.setInt(1,uiid);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
            UsedCarG_S u=new UsedCarG_S();
            
            
            u.setCid(rs.getInt("Cid"));
                System.out.println(u.getCid());
            u.setNamemodel(rs.getString("car_name_model"));
            u.setVersion(rs.getString("car_version"));
            u.setFuel_type(rs.getString("fuel_type"));
            u.setMileage(rs.getString("mileage"));
            u.setAmount(rs.getString("amount"));
            u.setCity(rs.getString("city"));
            u.setShort_description(rs.getString("short_description"));    
            u.setUiid(rs.getInt("uiid"));
            u.setDate(rs.getString("date")); 
            u.setRating(rs.getInt("carsrating"));
                System.out.println(u.getUiid());
            u.setAmountinword(rs.getString("amountinword")); 
            u.setLocation(rs.getString("location"));
            u.setYear_manufacture(rs.getString("year_manufacture"));
            u.setNo_of_owner(rs.getString("no_of_owner"));
            
            u.setPic_name(rs.getString("pic_name"));
            
            list.add(u);
            
                    
            }                        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       
        return list;
     
    }

    @Override
    public ArrayList<UsedCarG_S> used_dta() {
        ArrayList list= new ArrayList();
        
        String query="select * from Car_info_table inner join used_car_table using(cid) inner join image_table using(cid) order by cid desc";
        try {
            Connection con=Singletonclass.getInstance().getConnection();
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
             while(rs.next())
             {
                 UsedCarG_S u=new UsedCarG_S();
                u.setCid(rs.getInt("cid"));
            u.setNamemodel(rs.getString("car_name_model"));
            u.setVersion(rs.getString("car_version"));
            u.setFuel_type(rs.getString("fuel_type"));
            u.setMileage(rs.getString("mileage"));
            u.setAmount(rs.getString("amount"));
            u.setCity(rs.getString("city"));
            u.setShort_description(rs.getString("short_description"));    
            u.setRating(rs.getInt("carsrating"));
            
            u.setAmountinword(rs.getString("amountinword")); 
            u.setLocation(rs.getString("location"));
            u.setYear_manufacture(rs.getString("year_manufacture"));
            u.setNo_of_owner(rs.getString("no_of_owner"));
            
            u.setPic_name(rs.getString("pic_name"));
            
                list.add(u);
                
             }
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        
        return list;

    }
    }
    
