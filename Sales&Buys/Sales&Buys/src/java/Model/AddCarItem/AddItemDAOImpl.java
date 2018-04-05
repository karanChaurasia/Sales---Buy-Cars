/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.AddCarItem;


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
public class AddItemDAOImpl implements AddItemDAO{

    @Override
    public void insert(AddItemG_S a) {
          try
        {
            Connection con=Singletonclass.getInstance().getConnection();
            String query="insert into car_info_table(car_name_model, car_version, fuel_type, mileage, amount, city, short_description, uiid, date, carsrating) values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps,ps1,ps2;
            ps=con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
       
            ps.setString(1, a.getNamemodel());
            ps.setString(2, a.getVersion());
            ps.setString(3, a.getFuel_type());
            ps.setString(4, a.getMileage());
            ps.setString(5, a.getRoadprice());
            ps.setString(6, a.getCity());
            ps.setString(7, a.getShort_description());
            ps.setInt(8, a.getUiid());
            ps.setString(9, a.getDate());
            ps.setInt(10, a.getRating());
            int rowsinserted=ps.executeUpdate();
            if(rowsinserted>0)
            {
            System.out.println("A new car 50% data was inserted successfully!");
            }
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next())
            {
                a.setCid(rs.getInt(1));
            
            }
            
            String query1="insert into new_car_table(cid,firstrange,secondrange,rangepriceinword ,rto,insurance ,otherprice ,otherpriceindetail,actualprice, color, summary) values(?,?,?,?,?,?,?,?,?,?,?)"; 
            ps1=con.prepareStatement(query1);
      
            ps1.setInt(1, a.getCid());
            ps1.setInt(2, a.getFirstrange());
            ps1.setInt(3, a.getSecondrange());
            ps1.setString(4, a.getRangepriceinword());
            ps1.setInt(5, a.getRto());
            ps1.setInt(6, a.getInsurance());
            ps1.setInt(7, a.getOtherprice());
            ps1.setString(8, a.getOtherpriceindetail());
            ps1.setInt(9, a.getActualamount());
            ps1.setString(10, a.getColor());

            ps1.setString(11, a.getSummary());
            
            int rowsinserted1=ps1.executeUpdate();
            if(rowsinserted1>0)
            {
            System.out.println("A new car 75% data was inserted successfully!");
            }
            
            String query2="insert into image_table(cid, pic_name) values(?,?)"; 
            ps2=con.prepareStatement(query2);
            System.out.println("ImageURL:"+a.getPic_name());
            ps2.setInt(1, a.getCid());
            ps2.setString(2, a.getPic_name());
            
            int rowsinserted2=ps2.executeUpdate();
            if(rowsinserted2>0)
            {
            System.out.println("An new car 100% data was inserted successfully!");
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void update(AddItemG_S a) {
                
        try
        {
            Connection con=Singletonclass.getInstance().getConnection();
           PreparedStatement ps,ps1,ps2;  
           String query="update car_info_table set car_name_model=?, car_version=?, fuel_type=?, mileage=? ,amount=? ,city=? ,short_description=?, carsrating=? where cid=?";
           
           ps=con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
       
            ps.setString(1, a.getNamemodel());
            ps.setString(2, a.getVersion());
            ps.setString(3, a.getFuel_type());
            ps.setString(4, a.getMileage());
            ps.setString(5, a.getRoadprice());
            ps.setString(6, a.getCity());
            ps.setString(7, a.getShort_description());
            ps.setInt(8, a.getRating());
            ps.setInt(9, a.getCid());
                        
            int rowsinserted=ps.executeUpdate();
            if(rowsinserted>0)
            {
            System.out.println("A existing car 50% data was update successfully!");
            }
            
           String query1="update new_car_table set firstrange=?,secondrange=?,rangepriceinword=? ,rto=?,insurance=? ,otherprice=? ,otherpriceindetail=?,actualprice=?,color=?, summary=? where cid=?";
            ps1=con.prepareStatement(query1);
          
            
             ps1.setInt(1, a.getFirstrange());
            ps1.setInt(2, a.getSecondrange());
            ps1.setString(3, a.getRangepriceinword());
            ps1.setInt(4, a.getRto());
            ps1.setInt(5, a.getInsurance());
            ps1.setInt(6, a.getOtherprice());
            ps1.setString(7, a.getOtherpriceindetail());
            ps1.setInt(8, a.getActualamount());
            ps1.setString(9, a.getColor());

            ps1.setString(10, a.getSummary());
            
           ps1.setInt(11, a.getCid());
            int rowsinserted1=ps1.executeUpdate();
            if(rowsinserted1>0)
            {
            System.out.println("A existing car 75% data was update successfully!");
            }
           
           String query2="update image_table set pic_name=? where cid=?";
                ps2=con.prepareStatement(query2);
            System.out.println("ImageURL:"+a.getPic_name());
            ps2.setString(1, a.getPic_name());
            ps2.setInt(2, a.getCid());

            int rowsinserted2=ps2.executeUpdate();
            if(rowsinserted2>0)
            {
            System.out.println("A existing car 100% data was update successfully!");
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
    public AddItemG_S getDetailbyCarId(int cid) {
        AddItemG_S a=new AddItemG_S();
        try
        {
            Connection con=Singletonclass.getInstance().getConnection();
            String query="select * from Car_info_table inner join new_car_table using(cid) inner join image_table using(cid) where cid=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,cid);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
                System.out.println("Found");
            a.setCid(rs.getInt("cid"));
            a.setNamemodel(rs.getString("car_name_model"));
            a.setVersion(rs.getString("car_version"));
            a.setFuel_type(rs.getString("fuel_type"));
            a.setMileage(rs.getString("mileage"));
            a.setRoadprice(rs.getString("amount"));
            a.setCity(rs.getString("city"));
            a.setShort_description(rs.getString("short_description"));    
            a.setUiid(rs.getInt("uiid"));
            a.setDate(rs.getString("date")); 
            a.setRating(rs.getInt("carsrating"));
            
            a.setFirstrange(rs.getInt("firstrange"));
            a.setSecondrange(rs.getInt("secondrange"));
            a.setRangepriceinword(rs.getString("rangepriceinword"));
            a.setRto(rs.getInt("rto"));
            a.setInsurance(rs.getInt("insurance"));
            a.setOtherprice(rs.getInt("otherprice"));
            a.setOtherpriceindetail(rs.getString("otherpriceindetail"));
            a.setActualamount(rs.getInt("actualprice"));
            
            a.setColor(rs.getString("color"));
            a.setSummary(rs.getString("summary"));
            
            a.setPic_name(rs.getString("pic_name"));
                                  
            }
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return a;   
    }

    @Override
    public List<AddItemG_S> getDetail() {
        List<AddItemG_S> list=new ArrayList<AddItemG_S>();
        System.out.println("data");
         try
        {
            Connection con=Singletonclass.getInstance().getConnection();
            String query="select * from Car_info_table inner join new_car_table using(cid) inner join image_table using(cid) order by cid desc";
            PreparedStatement ps=con.prepareStatement(query);                        
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
            AddItemG_S a=new AddItemG_S();
        
            System.out.println("data in AddItemDaoImp");    
            a.setCid(rs.getInt("cid"));
            a.setNamemodel(rs.getString("car_name_model"));
            a.setVersion(rs.getString("car_version"));
            a.setFuel_type(rs.getString("fuel_type"));
            a.setMileage(rs.getString("mileage"));
            a.setRoadprice(rs.getString("amount"));
            a.setCity(rs.getString("city"));
            a.setShort_description(rs.getString("short_description"));    
            a.setUiid(rs.getInt("uiid"));
            a.setRating(rs.getInt("carsrating"));
            a.setDate(rs.getString("date")); 
                     
            a.setFirstrange(rs.getInt("firstrange"));
            a.setSecondrange(rs.getInt("secondrange"));
            a.setRangepriceinword(rs.getString("rangepriceinword"));
            a.setRto(rs.getInt("rto"));
            a.setInsurance(rs.getInt("insurance"));
            a.setOtherprice(rs.getInt("otherprice"));
            a.setOtherpriceindetail(rs.getString("otherpriceindetail"));
            a.setActualamount(rs.getInt("actualprice"));
            a.setColor(rs.getString("color"));
            a.setSummary(rs.getString("summary"));
            
            a.setPic_name(rs.getString("pic_name"));
             
        System.out.println("data transfer from database");    
                        
        list.add(a);
            }                        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
        
    }

    @Override
    public List<AddItemG_S> getNewCarMinDetail() {
        List<AddItemG_S> list=new ArrayList<AddItemG_S>();
        try
        {
            Connection con=Singletonclass.getInstance().getConnection();
            String query="select * from Car_info_table inner join new_car_table using(cid) inner join image_table using(cid) order by cid desc fetch first 3 rows only";
            PreparedStatement ps=con.prepareStatement(query);                        
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
            AddItemG_S a=new AddItemG_S();
            
            
            a.setCid(rs.getInt("cid"));
           a.setNamemodel(rs.getString("car_name_model"));
            a.setVersion(rs.getString("car_version"));
            a.setFuel_type(rs.getString("fuel_type"));
            a.setMileage(rs.getString("mileage"));
            a.setRoadprice(rs.getString("amount"));
            a.setCity(rs.getString("city"));
            a.setShort_description(rs.getString("short_description"));    
            a.setUiid(rs.getInt("uiid"));
            a.setRating(rs.getInt("carsrating"));
            a.setDate(rs.getString("date")); 
            
            a.setFirstrange(rs.getInt("firstrange"));
            a.setSecondrange(rs.getInt("secondrange"));
            a.setRangepriceinword(rs.getString("rangepriceinword"));
            a.setRto(rs.getInt("rto"));
            a.setInsurance(rs.getInt("insurance"));
            a.setOtherprice(rs.getInt("otherprice"));
            a.setOtherpriceindetail(rs.getString("otherpriceindetail"));
            a.setActualamount(rs.getInt("actualprice"));
            a.setColor(rs.getString("color"));
            a.setSummary(rs.getString("summary"));
            
            a.setPic_name(rs.getString("pic_name"));
            
            list.add(a);
            
                    
            }                        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
        
    }

    @Override
    public List<AddItemG_S> getallDetailbyUserId(int uiid) {
        List<AddItemG_S> list=new ArrayList<AddItemG_S>();
        System.out.println("data");
         try
        {
            Connection con=Singletonclass.getInstance().getConnection();
            String query="select c.CID, c.car_name_model, c.car_version, n.firstrange, n.secondrange, n.rangepriceinword, i.PIC_NAME from car_info_table c join user_info_table u using(uiid) join new_car_table n using(cid) join image_table i using(cid) where uiid=?";
            PreparedStatement ps=con.prepareStatement(query);                        
            ps.setInt(1,uiid);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
            AddItemG_S a=new AddItemG_S();
        
            System.out.println("data in AddItemDaoImp");    
            a.setCid(rs.getInt("cid"));
            a.setNamemodel(rs.getString("car_name_model"));
            a.setVersion(rs.getString("car_version"));
            a.setFirstrange(rs.getInt("firstrange"));            
            a.setSecondrange(rs.getInt("secondrange"));            
            a.setRangepriceinword(rs.getString("rangepriceinword"));            
            a.setPic_name(rs.getString("pic_name"));
              
                
            System.out.println("ADD car data transfer from database");    
                        
        list.add(a);
            }                        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
        
    }

    @Override
    public ArrayList<AddItemG_S> new_dta() {
         ArrayList list= new ArrayList();
        
        String query="select * from Car_info_table inner join new_car_table using(cid) inner join image_table using(cid) order by cid desc";
        try {
            Connection con=Singletonclass.getInstance().getConnection();
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
             while(rs.next())
             {
                AddItemG_S a=new AddItemG_S();
            a.setCid(rs.getInt("cid"));
            a.setNamemodel(rs.getString("car_name_model"));
            a.setVersion(rs.getString("car_version"));
            a.setFuel_type(rs.getString("fuel_type"));
            a.setMileage(rs.getString("mileage"));
            a.setRoadprice(rs.getString("amount"));
            a.setCity(rs.getString("city"));
                     
            a.setFirstrange(rs.getInt("firstrange"));
            a.setSecondrange(rs.getInt("secondrange"));
            a.setRangepriceinword(rs.getString("rangepriceinword"));
            a.setActualamount(rs.getInt("actualprice"));
            a.setColor(rs.getString("color"));
            
            a.setPic_name(rs.getString("pic_name"));
            
            list.add(a);
                
            }
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        
        return list;

    }
    
}
