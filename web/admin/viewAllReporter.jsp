<%-- 
    Document   : dashboard
    Created on : 13-Mar-2020, 10:11:09
    Author     : Dell
--%>

<%@page import="com.beans.Reporter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Daos.ReporterDao"%>
<%@page import="com.beans.News"%>
<%@page import="com.Daos.NewsDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Dashboard</title>
  <jsp:include page="base.jsp"></jsp:include>
</head>

<body id="page-top">
 <%
        if(session.getAttribute("admin")==null)
        {
            response.sendRedirect("../newslogin.jsp");
            return;
        }
        %>

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
  <jsp:include page="sidebar.jsp"></jsp:include>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
      <jsp:include page="topbar.jsp"></jsp:include>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
           <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">All Reporters</h1>
         </div>
          <table class="table">
              <tr>
                  <td>Name</td>
                  <td>Contact </td>
                  <td>address</td>
                  <td>photo</td>
                  <td>status</td>
                  <td>View and Change Status</td>
              </tr>
 <%
            ReporterDao rd = new ReporterDao();
              ArrayList<Reporter> reporterList = rd.getAllRecords();
              
              for(Reporter reporter : reporterList){%>
              <tr>
                  <td><%=reporter.getName()%></td>
                  <td><%=reporter.getContact()%> </td>
                  <td><%=reporter.getAddress()%></td>
                  <td><img src="../<%=reporter.getPhoto()%>" style="width: 64px; height: 64px;"></td>
                  <td><%=reporter.getStatus()%></td>
                  <td><a href="showDetailReporter.jsp?reporterid=<%=reporter.getId()%>" class="btn btn-success">View and Show Status</a></td>
              </tr>
             <%} %>
          </table>
          <!-- Content Row -->
          

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <jsp:include page="footer.jsp"></jsp:include>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Custom scripts for all pages-->
  <script src="assets/js/sb-admin-2.min.js"></script>

  
</body>

</html>
