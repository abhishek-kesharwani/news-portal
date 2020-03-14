/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Daos;

import com.beans.News;
import com.beans.Reporter;

import com.pool.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
public class ReporterDao {
    public boolean add(Reporter reporter)
    {
         boolean status=false;
         ConnectionPool cp=ConnectionPool.getInstance();
         cp.initialize();
         Connection con=cp.getConnection();
         if(con!=null)
         {
             try{
                 String sql="insert into reporter(name,contact,email,userid,password,photo,dob,address,gender,status) values(?,?,?,?,?,?,?,?,?,?)";
                 PreparedStatement smt=con.prepareStatement(sql);
                 smt.setString(1,reporter.getName());
                 smt.setString(2, reporter.getContact());
                  smt.setString(3,reporter.getEmail());
                   smt.setString(4,reporter.getUserid());
                    smt.setString(5,reporter.getPassword());
                     smt.setString(6,reporter.getPhoto());
                      smt.setString(7,reporter.getDob());
                       smt.setString(8,reporter.getAddress());
                        smt.setString(9,reporter.getGender());
                         smt.setString(10,reporter.getStatus());
                 if(smt.executeUpdate()>0)
                     status=true;
                 smt.close();
                 cp.putConnection(con);
             }catch(Exception e)
             {
                 System.out.println("Error : "+e.getMessage());
             }
         }
         return status;
    }
    public boolean remove(int id)
    {
         boolean status=false;
         ConnectionPool cp=ConnectionPool.getInstance();
         cp.initialize();
         Connection con=cp.getConnection();
         if(con!=null)
         {
             try{
                 String sql="delete from reporter where id=?";
                 PreparedStatement smt=con.prepareStatement(sql);
                 smt.setInt(1, id);
                 if(smt.executeUpdate()>0)
                     status=true;
                 smt.close();
                 cp.putConnection(con);
             }catch(Exception e)
             {
                 System.out.println("Error : "+e.getMessage());
             }
         }
         return status;
    }
    public Reporter getById(int id)
    {
        Reporter reporter=null;
        ConnectionPool cp=ConnectionPool.getInstance();
        cp.initialize();
        Connection con=cp.getConnection();
        if(con!=null)
        {
            try{
                String sql="select * from reporter where id=?";
                PreparedStatement smt=con.prepareStatement(sql);
                smt.setInt(1,id);
                ResultSet rs=smt.executeQuery();
                if(rs.next())
                {
                  reporter=new Reporter();
                  reporter.setName(rs.getString("name"));
                  reporter.setEmail(rs.getString("email"));
                  reporter.setAddress(rs.getString("address"));
                  reporter.setContact(rs.getString("contact"));
                  reporter.setDob(rs.getString("dob"));
                  reporter.setGender(rs.getString("gender"));
                  reporter.setPassword(rs.getString("password"));
                  reporter.setPhoto(rs.getString("photo"));
                  reporter.setUserid(rs.getString("userid"));
                }
                smt.close();
                    cp.putConnection(con);
            }catch(Exception e)
            {
                System.out.println("Error : "+e.getMessage());
            }
        }
        return reporter;
        
    }
    public ArrayList<Reporter> getAllRecords()
    {
        ArrayList<Reporter> reporters=new ArrayList<Reporter>();
         ConnectionPool cp=ConnectionPool.getInstance();
        cp.initialize();
        Connection con=cp.getConnection();
        if(con!=null)
        {
            try{
                String sql="select * from reporter ";
                PreparedStatement smt=con.prepareStatement(sql);
                
                ResultSet rs=smt.executeQuery();
                while(rs.next())
                {
                    Reporter reporter=new Reporter();
                   reporter=new Reporter();
                  reporter.setName(rs.getString("name"));
                  reporter.setEmail(rs.getString("email"));
                  reporter.setAddress(rs.getString("address"));
                  reporter.setContact(rs.getString("contact"));
                  reporter.setDob(rs.getString("dob"));
                  reporter.setGender(rs.getString("gender"));
                  reporter.setPassword(rs.getString("password"));
                  reporter.setPhoto(rs.getString("photo"));
                  reporter.setUserid(rs.getString("userid"));
                  reporters.add(reporter);
                }
                smt.close();
                    cp.putConnection(con);
            }catch(Exception e)
            {
                System.out.println("Error : "+e.getMessage());
            }
        }
        return reporters;
    }
    public ArrayList<Reporter> getRecordByLimit(int start,int stop)
    {
        ArrayList<Reporter> reporters=new ArrayList<Reporter>();
         ConnectionPool cp=ConnectionPool.getInstance();
        cp.initialize();
        Connection con=cp.getConnection();
        if(con!=null)
        {
            try{
                String sql="select * from reporter limit ?,?";
                PreparedStatement smt=con.prepareStatement(sql);
                smt.setInt(1,start);
                smt.setInt(2,stop);
                ResultSet rs=smt.executeQuery();
                while(rs.next())
                {
                     Reporter reporter=new Reporter();
                   reporter=new Reporter();
                  reporter.setName(rs.getString("name"));
                  reporter.setEmail(rs.getString("email"));
                  reporter.setAddress(rs.getString("address"));
                  reporter.setContact(rs.getString("contact"));
                  reporter.setDob(rs.getString("dob"));
                  reporter.setGender(rs.getString("gender"));
                  reporter.setPassword(rs.getString("password"));
                  reporter.setPhoto(rs.getString("photo"));
                  reporter.setUserid(rs.getString("userid"));
                  reporters.add(reporter);
                }
                smt.close();
                    cp.putConnection(con);
            }catch(Exception e)
            {
                System.out.println("Error : "+e.getMessage());
            }
        }
        return reporters; 
    }
    public int getRecordCount()
    {
        int total=0;
        ConnectionPool cp=ConnectionPool.getInstance();
        cp.initialize();
        Connection con=cp.getConnection();
        if(con!=null)
        {
            try{
                String sql="select count(*) from reporter";
                PreparedStatement smt=con.prepareStatement(sql);
                ResultSet rs=smt.executeQuery();
                if(rs.next())
                    total=rs.getInt(1);
                smt.close();
                cp.putConnection(con);
            }catch(Exception e)
            {
                System.out.println("Error : "+e.getMessage());
            }
        }
        return total;
    }
     public boolean  update(Reporter reporter){
       boolean status=false;
       ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "update reporter set name=?,dob=?,gender=?,contact=?,email=?,address=?,photo=?  where id=?";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, reporter.getName());
            smt.setString(2, reporter.getDob());
            smt.setString(3, reporter.getGender());
            smt.setString(4, reporter.getContact());
            smt.setString(5, reporter.getEmail());
            smt.setString(6, reporter.getAddress());
            smt.setString(7,reporter.getPhoto());
           smt.setInt(8, reporter.getId());
            if(smt.executeUpdate()>0)
                status=true;
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("DBError :"+e.getMessage());
        }
       }
       
    return status;
   }
   
   public boolean  isUserIdExist(String userid){
       boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "select * from reporter where userid=?";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, userid);
            ResultSet rs= smt.executeQuery();
            if(rs.next()){
                status=true;
            }
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("Error :"+e.getMessage());
        }
       }
       
       return status;
   }
      public boolean  isContactExist(String contact){
       boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "select * from reporter where contact=?";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, contact);
            ResultSet rs= smt.executeQuery();
            if(rs.next()){
                status=true;
            }
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("Error :"+e.getMessage());
        }
       }
       
       return status;
   }
       public boolean  isValid(String userid,String password){
       boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "select * from reporter where userid=? and password=?";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, userid);
            smt.setString(2, password);
            ResultSet rs= smt.executeQuery();
            if(rs.next()){
                status=true;
            }
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("DBError :"+e.getMessage());
        }
       }
       
       return status;
   }  
       public Reporter  getByLoginData(String userid,String password){
      Reporter reporter=null;
        ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "select * from reporter where userid=? and password=? and status='approved'";
            PreparedStatement smt = con.prepareStatement(sql);
            String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes("UTF-8"));
            smt.setString(1, userid);
            smt.setString(2, encodedPassword);
            ResultSet rs= smt.executeQuery();
            if(rs.next()){
                reporter =new Reporter();
                reporter.setId(rs.getInt("id"));
                reporter.setName(rs.getString("name"));
                reporter.setDob(rs.getString("dob"));
                reporter.setGender(rs.getString("gender"));
                reporter.setUserid(rs.getString("userid"));
                reporter.setPassword(rs.getString("password"));
                reporter.setPhoto(rs.getString("photo"));
                reporter.setContact(rs.getString("contact"));
                reporter.setEmail(rs.getString("email"));
                reporter.setStatus(rs.getString("status"));
                reporter.setAddress(rs.getString("address"));
            }
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("DBError :"+e.getMessage());
        }
       }
       
       return reporter;
   }  
        public ArrayList<Reporter>  getAllPendingReporter(){
    
       ArrayList<Reporter> reporters =new ArrayList<Reporter>();
       ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "select * from reporter where status='pending' order by id desc";
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs= smt.executeQuery();
            while(rs.next()){
                Reporter  reporter =new Reporter();
               reporter.setId(rs.getInt("id"));
                reporter.setName(rs.getString("name"));
                reporter.setDob(rs.getString("dob"));
                reporter.setGender(rs.getString("gender"));
                reporter.setUserid(rs.getString("userid"));
                reporter.setPassword(rs.getString("password"));
                reporter.setPhoto(rs.getString("photo"));
                reporter.setContact(rs.getString("contact"));
                reporter.setEmail(rs.getString("email"));
                reporter.setStatus(rs.getString("status"));
                reporter.setAddress(rs.getString("address"));
                reporters.add(reporter);
            }
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("Error :"+e.getMessage());
        }
       }
       
    return reporters;
   }
}
