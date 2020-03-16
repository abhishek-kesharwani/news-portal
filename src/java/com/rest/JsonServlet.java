
package com.rest;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;


public class JsonServlet extends HttpServlet {

   class Student{
       private String name;
       private int rollno,age;
       public Student()
       {
          
       }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRollno() {
            return rollno;
        }

        public void setRollno(int rollno) {
            this.rollno = rollno;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
   }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Student s=new Student();
        s.setName("madan lal");
        s.setAge(20);
        s.setRollno(101);
        ObjectMapper mapper= new ObjectMapper();
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
   
}
