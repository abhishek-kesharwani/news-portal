<%-- 
    Document   : categoryBasedNews
    Created on : Mar 15, 2020, 3:16:57 PM
    Author     : abhishek
--%>


<%@page import="com.beans.News"%>
<%@page import="com.Daos.NewsDao"%>
<%@page import="com.beans.Reporter"%>
<%@page import="com.beans.Reporter"%>
<%@page import="com.Daos.ReporterDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.beans.Category"%>
<%@page import="com.Daos.CategoryDao"%>
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
            <h1 class="h3 mb-0 text-gray-800">Category Based News</h1>
         </div>
          <div class="row">
         <%
               NewsDao nd = new NewsDao();
               ArrayList<News> newsList =null;
               //System.out.println("CAt id ="+ request.getParameter("catid"));
               int catid = Integer.parseInt(request.getParameter("catid"));
               
                newsList = nd.getNewsByCategory(catid);
               for(News news:newsList){%>
               
          <div class="col-lg-3 col-md-4 mb-4">
            <div class="card h-100">
              <a href="#"><img class="card-img-top" src="../<%=news.getImage()%>" alt=""></a>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="#"><%=news.getTitle()%></a>
                </h4>
                
                  <p class="card-text"><% if(news.getDescription().trim().length()>100) out.println(news.getDescription().trim().substring(0,99)+"..."); else out.println(news.getDescription().trim()); %> </p>
              </div>
              <div class="card-footer">
                  <a href="showDetailNews1.jsp?newsid=<%=news.getId()%>" class="btn btn-primary">View More</a>
              </div>
            </div>
          </div>
        <%}%>

          <!-- Content Row -->
          </div>

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
          <a class="btn btn-primary" href="logout.jsp">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Custom scripts for all pages-->
  <script src="assets/js/sb-admin-2.min.js"></script>

  
</body>

</html>

