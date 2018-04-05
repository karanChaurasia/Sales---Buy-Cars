/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ANITA-PC
 */
public class Singletonclass {
 
    private static Singletonclass obj=new Singletonclass();
    private Connection con;
    
    private Singletonclass()
    {
    try
    {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con=DriverManager.getConnection("jdbc:derby://localhost:1527/prodb","pro","pro");
        if (con != null)
        {
        System.out.println("Singleton is Connected");
        }
        
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    }
    
    public static Singletonclass getInstance()
    {
        return obj;
    
    }
    
    public Connection getConnection()
    {
        return con;
        
    
    }
    

}
