/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.RecordInfoProcess;

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
public class RecordInfoDAOImpl implements RecordInfoDAO{

    @Override
    public void insert(RecordInfoG_S r) {
        try
        {
            Connection con=Singletonclass.getInstance().getConnection();
            String query="insert into Record_Info_table(uiid, cid, rid,noofcar) values(?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1, r.getUiid());
            ps.setInt(2, r.getCid());
            ps.setInt(3, r.getRid());
            ps.setString(4, r.getNoofcar());
            int rowsinserted=ps.executeUpdate();
            if(rowsinserted>0)
            {
            System.out.println("An new Register record info data was inserted successfully!");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }

    @Override
    public void update(RecordInfoG_S r) {
        try
        {   System.out.println("I'm in Record DAO Impl");
            Connection con=Singletonclass.getInstance().getConnection();
            String query="UPDATE record_info_table SET noofcar=? WHERE riid =?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, r.getNoofcar());
            ps.setInt(2, r.getRiid());
            
            int rowsDeleted=ps.executeUpdate();
            if (rowsDeleted > 0) 
            {
                System.out.println("A RegisterCar was Update successfully!");
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int riid) {
        try
        {   System.out.println("im in DAO impl");
            Connection con=Singletonclass.getInstance().getConnection();
            String query="Delete from record_info_table where riid=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,riid);
            
            int rowsDeleted=ps.executeUpdate();
            if (rowsDeleted > 0) 
            {
                System.out.println("A RegisterCar was deleted successfully!");
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public RecordInfoG_S getrecordbyId(int rid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RecordInfoG_S> getrecord() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RecordInfoG_S> getallCarrecordbyId(int uiid, int rid) {
                List<RecordInfoG_S> list=new ArrayList<RecordInfoG_S>();
                try
        {
            Connection con=Singletonclass.getInstance().getConnection();
            String query="select c.CID, c.car_name_model, c.car_version, c.AMOUNT, rr.noofcar, i.PIC_NAME, rr.RIID from record_info_table rr join car_info_table c using(cid) join image_table i using(cid) where rr.UIID=? and rr.RID=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,uiid);
            ps.setInt(2,rid);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
            RecordInfoG_S r=new RecordInfoG_S();
                System.out.println("User UpComing/New/Used Car Record Found");
            r.setCid(rs.getInt("cid"));
            r.setNamemodel(rs.getString("car_name_model"));    
            r.setVersion(rs.getString("car_version"));
            r.setAmount(rs.getString("amount"));    
            r.setNoofcar(rs.getString("noofcar"));
            r.setPic_name(rs.getString("pic_name"));
            r.setRiid(rs.getInt("riid"));
         
            list.add(r);
            }
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
    
}
