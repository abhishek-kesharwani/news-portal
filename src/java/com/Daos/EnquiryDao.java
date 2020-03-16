
package com.Daos;

import com.beans.Enquiry;

import com.pool.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class EnquiryDao {
    public boolean add(Enquiry add) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();

        if (con != null) {
            try {
                String sql = "Insert into enquiry(name,email,mobile,message) values(?,?,?,?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, add.getName());
                smt.setString(2, add.getEmail());
                smt.setString(3, add.getMobile());
                smt.setString(4, add.getMessage());
                smt.executeUpdate();
                status = true;
                cp.putConnection(con);
                smt.close();
                //cp.putConnection(con);
            } catch (Exception e) {
                System.out.println("DBError :" + e.getMessage());
            }
        }

        return status;
    }
    public ArrayList<Enquiry> getAllRecords()
    {
        ArrayList<Enquiry> enq = new ArrayList<Enquiry>();
         ConnectionPool cp=ConnectionPool.getInstance();
        cp.initialize();
        Connection con=cp.getConnection();
        if(con!=null)
        {
            try{
                String sql="select * from enquiry ";
                PreparedStatement smt=con.prepareStatement(sql);
                
                ResultSet rs=smt.executeQuery();
                while(rs.next())
                {
                    Enquiry enquiry=new Enquiry();
                    enquiry.setId(rs.getInt("id"));
                    enquiry.setName(rs.getString("name"));
                    enquiry.setEmail(rs.getString("email"));
                    enquiry.setMobile(rs.getString("mobile"));
                    enquiry.setMessage(rs.getString("message"));
                    enq.add(enquiry);
                    
                    
                }
                smt.close();
                    cp.putConnection(con);
            }catch(Exception e)
            {
                System.out.println("Error : "+e.getMessage());
            }
        }
        return enq;
    }
}
