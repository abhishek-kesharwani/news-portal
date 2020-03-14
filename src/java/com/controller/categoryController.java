
package com.controller;

import com.Daos.CategoryDao;
import com.beans.Category;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "categoryController", urlPatterns = {"/categoryController"})
public class categoryController extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String op=request.getParameter("op");
        
       if (op != null && op.equals("add")) {
           HttpSession session = request.getSession();
           Category category=(Category) session.getAttribute("category");
           System.out.println("name "+category.getName());
           CategoryDao cd=new CategoryDao();
           if(cd.add(category))
           {
               session.removeAttribute("category");
               System.out.println("SUccefully Inserted");
               response.sendRedirect("Category.jsp");
           }
    }

   
}
}