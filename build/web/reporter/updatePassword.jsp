<%-- 
    Document   : dashboard
    Created on : 07-Mar-2020, 08:44:47
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.Daos.ReporterDao"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
     <title>Reporter Home</title>
     <jsp:include page="base.jsp"></jsp:include>
  <!-- Custom styles for this template -->
  
  </head>

  <body>
<%
if(session.getAttribute("reporter")==null){
    response.sendRedirect("../newslogin.jsp");
    return ;
} 
%>  

      
      
  <jsp:include page="navbar.jsp"></jsp:include>

    <div class="container-fluid">
      <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
        <jsp:include page="sidebar.jsp"></jsp:include>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
         
    <center>
        <div class="container">
            <div class="row">
               
                
                
                
                <div class="col col-md-9">
                    <form method="post" class="form" >
                        <table class="table">
                            <tr><th colspan="2"><center><h2>Update Password Here</h2></center></th></tr>
                           
                            
                             <tr>
                                <td>Update Password </td>
                                <td><input type="password" name="password" class="form-control" value=""/></td>
                            </tr> 
                            <tr>
                                <td>Confirm Password </td>
                                <td><input type="password" name="password" class="form-control" value=""/></td>
                            </tr> 
                             
                           
                            <input type="hidden" name="status" value="approved"/>
                        </table>
                            <input type="submit" value="save and Next" name="submit" id ="submit" class="form-control btn btn-primary"/>
                    </form>
                </div>
                
                 
            </div>
        </div>
    </center>
 
        </main>
      </div>
    </div>
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
     
    <!-- Icons -->
    <script>
      feather.replace()
    </script>
 </body>
 <%if(request.getParameter("submit")!=null){%>
 <jsp:useBean class="com.beans.Reporter" id="reporter" scope="session"></jsp:useBean>
 <jsp:setProperty name="reporter" property="*"></jsp:setProperty>
 <% ReporterDao rd=new ReporterDao();
    if(rd.update2(reporter))
            out.println("<script>alert('You have successfully change your password');</script>");
        else
            out.println("<script>alert('Password and Confirm Password Not Matched !');</script>");

 
 }%>
</html>
