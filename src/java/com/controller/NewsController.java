 
package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.beans.News;
import com.Daos.NewsDao;
import com.Daos.ReporterDao;
import com.utilities.FileUploader;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
 
public class NewsController extends HttpServlet {
 

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
         String op=request.getParameter("op");
          if(op!=null && op.equalsIgnoreCase("filter")){
         int rid = Integer.parseInt(request.getParameter("rid"));
          int cid = Integer.parseInt(request.getParameter("cid"));
               String output = " <tr>\n" +
                " <td>Title</td>\n" +
                "   <td>Uploaded By </td>\n" +
                "  <td>Uploaded On</td>\n" +
                "  <td>Status</td>\n" +
                "  <td>View and Change Status</td>\n" +
                "   </tr>";
                         
              NewsDao nd = new NewsDao();
              ArrayList<News> newsList = nd.getNewsfilter(rid,cid);
              ReporterDao rd = new ReporterDao();
              for(News news : newsList){
               output+="<tr>\n" +
"                  <td>"+news.getTitle()+"</td>\n" +
"                  <td>"+rd.getById(news.getPosted_by()).getName()+"</td>\n" +
"                  <td>"+news.getPosted_on()+"</td>\n" +
"                  <td>"+news.getStatus()+"</td>\n" +
"                  <td><a href=\"showDetailNews.jsp?newsid="+news.getId()+"\" class=\"btn btn-success\">View and Change Status</a></td>\n" +
"              </tr>";
              }
              out.println(output); 
                                 
                               
          }    
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out = response.getWriter();
       response.setContentType("text/html");
       String op=request.getParameter("op");
       
       if(op!=null && op.equalsIgnoreCase("add")){
           HttpSession session = request.getSession();
           News news = (News)session.getAttribute("news");
           String catids[] = (String[])session.getAttribute("catids");
           String imagePath="";
           imagePath = FileUploader.getUploadedPath(getServletContext(), "media/news", request);
           
           System.out.println("imagepath="+imagePath);
           news.setImage(imagePath);
           NewsDao nd = new NewsDao();
           if(nd.add(news, catids)){
               session.removeAttribute("news");
               session.removeAttribute("catids");
              
               response.sendRedirect("reporter/Dashboard.jsp");
                out.println("<script> alert('News Succesfully Added');</script>");
           }
       }
    }

    
}
