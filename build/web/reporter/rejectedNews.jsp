<%-- 
    Document   : dashboard
    Created on : 07-Mar-2020, 08:44:47
    Author     : Dell
--%>

<%@page import="com.Daos.ReporterDao"%>
<%@page import="com.beans.News"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Daos.NewsDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
            <h1 class="h2">All Rejected News</h1>
                <%-- <jsp:include page="reportbar.jsp"></jsp:include>--%>
          </div>
             <table class="table">
              <tr>
                  <td>Title</td>
                  <td>Uploaded By </td>
                  <td>Uploaded On</td>
                  <td>Status</td>
                  <td>View and Change Status</td>
              </tr>
              
          <%
              NewsDao nd = new NewsDao();
              ArrayList<News> newsList = nd.getAllRejectedNews();
              ReporterDao rd = new ReporterDao();
              for(News news : newsList){%>
              <tr>
                  <td><%=news.getTitle()%></td>
                  <td><%=rd.getById(news.getPosted_by()).getName()%> </td>
                  <td><%=news.getPosted_on()%></td>
                  <td><%=news.getStatus()%></td>
                  <td><a href="showDetailNews.jsp?newsid=<%=news.getId()%>" class="btn btn-success">View and Change Status</a></td>
              </tr>
             <%} %>
          </table>
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
