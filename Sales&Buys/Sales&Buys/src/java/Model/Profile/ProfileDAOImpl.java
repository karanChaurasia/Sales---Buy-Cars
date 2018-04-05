 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Profile;

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
public class ProfileDAOImpl implements ProfileDAO{
    

    @Override
    public void insert(ProfileG_S p) {
        try
        {
            Connection con=Singletonclass.getInstance().getConnection();
            String query="insert into User_Info_table(Name, Phone, Email, Password, Address,uid,date) values(?,?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, p.getName());
            ps.setString(2, p.getPhone());
            ps.setString(3, p.getEmail());
            ps.setString(4, p.getPassword());
            ps.setString(5, p.getAddress());
            ps.setInt(6, p.getUid());
            ps.setString(7, p.getDate());
            
            int rowsinserted=ps.executeUpdate();
            if(rowsinserted>0)
            {
            System.out.println("An new user data was inserted successfully!");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ProfileG_S p) {
            
        try
        {
            Connection con=Singletonclass.getInstance().getConnection();
            String query="update user_info_table set name=?,Phone=?, Address=? where uiid=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, p.getName());
            ps.setString(2, p.getPhone());
            ps.setString(3, p.getAddress());
            ps.setInt(4, p.getUiid());
            
            int rowsUpdated=ps.executeUpdate();
            if(rowsUpdated>0)
            {
            System.out.println("An existing user was updated successfully!");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int pid) {
        try
        {
            Connection con=Singletonclass.getInstance().getConnection();
            
            String query="Delete from user_info_table where uiid=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,pid);
            
            int rowsDeleted=ps.executeUpdate();
            if (rowsDeleted > 0) 
            {
                System.out.println("A user was deleted successfully!");
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public ProfileG_S getprofile(int pid) {
        ProfileG_S p=new ProfileG_S();
        try
        {
            Connection con=Singletonclass.getInstance().getConnection();
            String query="select * from user_info_table where uiid=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,pid);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
                System.out.println("Found");
            p.setUiid(rs.getInt("uiid"));
            p.setName(rs.getString("Name"));
            p.setPhone(rs.getString("Phone"));
            p.setEmail(rs.getString("Email"));
            
            p.setAddress(rs.getString("Address"));                        
            p.setUid(rs.getInt("uid"));
            }
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return p;   
    }

    @Override
    public List<ProfileG_S> getprofile() {
        List<ProfileG_S> list=new ArrayList<ProfileG_S>();
        
         try
        {
            Connection con=Singletonclass.getInstance().getConnection();
            String query="select * from user_info_table order by uiid desc";
            PreparedStatement ps=con.prepareStatement(query);                        
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
            ProfileG_S p=new ProfileG_S();
            
            p.setUiid(rs.getInt("uiid"));
            p.setName(rs.getString("Name"));
            p.setPhone(rs.getString("Phone"));
            p.setEmail(rs.getString("Email"));
            p.setPassword(rs.getString("Password"));
            p.setAddress(rs.getString("Address"));
            p.setUid(rs.getInt("uid"));
            p.setDate(rs.getString("date"));
            
            list.add(p);
            }                        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
        
    }

    @Override
    public void login(ProfileG_S p) {
       try
        {   
            String email1=p.getEmail();
            String pass1=p.getPassword();
            System.out.println(email1);
            System.out.println(pass1);
            
            Connection con=Singletonclass.getInstance().getConnection();
            String query="select name,email,password,uiid,uid from user_info_table where email='"+email1+"' and password='"+pass1+"'";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
            System.out.println("User Found");
            
            p.setName(rs.getString("name"));
            p.setEmail(rs.getString("email"));
            p.setPassword(rs.getString("password"));
            p.setUiid(rs.getInt("uiid"));
            p.setUid(rs.getInt("uid"));
   
            System.out.println("Login data successful!");
            
            }
            else
            {
                 System.out.println("Login data unsuccessful!");
                           p.setEmail(null);
                           p.setPassword(null);
  
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
    }

    @Override
    public ProfileG_S getprofileUsedCarSeller(int cid) {
        ProfileG_S p=new ProfileG_S();
        try
        {
            Connection con=Singletonclass.getInstance().getConnection();
            String query="select u.NAME,u.PHONE,u.EMAIL,uc.LOCATION, c.car_name_model, i.PIC_NAME from user_info_table u join car_info_table c using(uiid) join used_car_table uc using(cid) join image_table i using(cid) where CID=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,cid);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
                System.out.println("Found");
            
            p.setName(rs.getString("Name"));
            p.setPhone(rs.getString("Phone"));
            p.setEmail(rs.getString("Email"));
            p.setLocation(rs.getString("location"));
            p.setNamemodel(rs.getString("car_name_model"));
            p.setPic_name(rs.getString("pic_name"));
            }
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return p;   

    }

    @Override
    public void insertcontactinfo(ProfileG_S p) {
        try
        {
            Connection con=Singletonclass.getInstance().getConnection();
            String query="insert into contactus_table(uiid,name, email, message, date) values(?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1, p.getUiid());
            ps.setString(2, p.getName());
            ps.setString(3, p.getEmail());
            ps.setString(4, p.getMessage());
            ps.setString(5, p.getDate());
            
            int rowsinserted=ps.executeUpdate();
            if(rowsinserted>0)
            {
            System.out.println("An new contactus data was inserted successfully!");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProfileG_S> getbookedrecordbyuiid(int uiid, int rid) {
        List<ProfileG_S> list=new ArrayList<ProfileG_S>();
        
         try
        {
            Connection con=Singletonclass.getInstance().getConnection();
            String query="select i.PIC_NAME,u.NAME,u.EMAIL,u.PHONE,u.ADDRESS from user_info_table u join record_info_table r using(uiid) join image_table i using(cid) where r.CID in (select c.CID from record_info_table r join car_info_table c using(cid) where c.UIID=? and r.RID=?) order by r.rid";
            PreparedStatement ps=con.prepareStatement(query);                        
            ps.setInt(1,uiid);
            ps.setInt(2,rid);
            
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
            ProfileG_S p=new ProfileG_S();
            p.setImageofbookedcar(rs.getString("pic_name"));
            p.setName(rs.getString("Name"));
            p.setPhone(rs.getString("Phone"));
            p.setEmail(rs.getString("Email"));
            p.setAddress(rs.getString("Address"));
            
            list.add(p);
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
        
        
    }

    @Override
    public void changepassword(int uiid, String newpass) {
        try
        {
            Connection con=Singletonclass.getInstance().getConnection();
            String query="update user_info_table set Password=? where uiid=?";
            PreparedStatement ps=con.prepareStatement(query);
            
 
            ps.setString(1,newpass);
            ps.setInt(2,uiid);
            
            int rowsUpdated=ps.executeUpdate();
            if(rowsUpdated>0)
            {
            System.out.println("An existing user password has been changed successfully!");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

}