
package com.controller;

import com.beans.Reporter;
import com.Daos.ReporterDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.utilities.FileUploader;
import java.util.Base64;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ReporterController extends HttpServlet {

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String op= request.getParameter("op");
        
        if(op!=null&& op.equalsIgnoreCase("add")){
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            String encodedPassword = "";
            String imagePath = "";
            HttpSession session = request.getSession();
            Reporter reporter=(Reporter) session.getAttribute("reporter");

            if (isMultipart)  
               imagePath = FileUploader.getUploadedPath(getServletContext(), "media/reporter", request);
             System.out.println("imagepath"+ imagePath);
            //JDBC Code 
            reporter.setPhoto(imagePath);
            encodedPassword = Base64.getEncoder().encodeToString(reporter.getPassword().getBytes("UTF-8"));
            reporter.setPassword(encodedPassword);
            ReporterDao rd = new ReporterDao();
            if (rd.add(reporter)) {
                session.removeAttribute("reporter");
                response.sendRedirect("admin/reporterReg.jsp?msg=Succesfully Added");
               // out.println("Reporter Added !!");
            }
        } 
         if(op!=null&& op.equalsIgnoreCase("update")){
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            String encodedPassword = "";
            String imagePath = "";
            HttpSession session = request.getSession();
            Reporter reporter=(Reporter) session.getAttribute("reporter");
            
            if (isMultipart)  
               imagePath = FileUploader.getUploadedPath(getServletContext(), "media/reporter", request);
             System.out.println("imagepath"+ imagePath);
            //JDBC Code 
            if(imagePath=="")
            {
                encodedPassword = Base64.getEncoder().encodeToString(reporter.getPassword().getBytes("UTF-8"));
                 reporter.setPassword(encodedPassword);
                 ReporterDao rd = new ReporterDao();
                 if (rd.update1(reporter)) {
                
                response.sendRedirect("reporter/addNews.jsp");
               // out.println("Reporter Added !!");
            }
            }else
            {
            reporter.setPhoto(imagePath);
            encodedPassword = Base64.getEncoder().encodeToString(reporter.getPassword().getBytes("UTF-8"));
            reporter.setPassword(encodedPassword);
            ReporterDao rd = new ReporterDao();
            if (rd.update(reporter)) {
                
                response.sendRedirect("reporter/addNews.jsp");
               // out.println("Reporter Added !!");
            }
            }
        } 
        }
    
 

}
