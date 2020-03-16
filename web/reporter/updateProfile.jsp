<%-- 
    Document   : dashboard
    Created on : 07-Mar-2020, 08:44:47
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
     <title>Reporter Home</title>
     <jsp:include page="base.jsp"></jsp:include>
  <!-- Custom styles for this template -->
   <script>

                function readURL(input,preview) {
                    if (input.files && input.files[0]) {
                        var reader = new FileReader();

                        reader.onload = function (e) {
                            preview.src = e.target.result;
                        };

                        reader.readAsDataURL(input.files[0]);
                    }
                }
                </script>
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
          <jsp:useBean class="com.beans.Reporter" id="reporter" scope="session"></jsp:useBean>
    <center>
        <div class="container">
            <div class="row">
                <div class="col-md-3" style="position: fixed;right:0px;">
                    <%if (request.getParameter("submit")!=null){%>
                    <jsp:setProperty name="reporter" property="*"></jsp:setProperty>
                    <form action="../ReporterController?op=update" method="post" enctype="multipart/form-data">
                    <img src="../${reporter.photo}" style="width:200px; height: 200px;" id="preview" class="form-control"/> <br/>
                    <input type="file" name="image" value="${reporter.photo}" onchange="readURL(this,preview);" class="form-control btn btn-success"/> <br/>
                    <input type="submit" value="Save to Data base " class="btn btn-primary" name="submit"/>
                    </form>
                    <%
                }%>
                </div>
                
                
                
                <div class="col col-md-9">
                    <form method="post" class="form">
                        <table class="table">
                            <tr><th colspan="2"><center><h2>Update Profile Here</h2></center></th></tr>
                            <tr>
                                <td>Enter Reporter Name </td>
                                <td><input type="text" name="name" class="form-control" value="${reporter.name}"/></td>
                            </tr> 
                             <tr>
                                <td>Enter Reporter DOB </td>
                                <td><input type="date" name="dob" class="form-control" value="${reporter.dob}"/></td>
                            </tr> 
                             <tr>
                                <td>Select Gender  </td>
                                <td><input type="radio" name="gender" value="Male" ${reporter.gender eq "Male" ? "checked" : ""}/> Male 
                                <input type="radio" name="gender" value="Female" ${reporter.gender eq "Female" ? "checked" : ""}/> Female 
                                </td>
                            </tr> 
                            <tr>
                                <td>Enter Reporter's Contact </td>
                                <td><input type="text" name="contact" class="form-control" value="${reporter.contact}"/></td>
                            </tr> 
                            
                             <tr>
                                <td>Enter Reporter's Email </td>
                                <td><input type="email" name="email" class="form-control" value="${reporter.email}"/></td>
                            </tr> 
                            
                             <tr>
                                <td>Enter Reporter's Address </td>
                                <td><input type="text" name="address" class="form-control" value="${reporter.address}"/></td>
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
</html>
