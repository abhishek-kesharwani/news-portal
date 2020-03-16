<%-- 
    Document   : dashboard
    Created on : 07-Mar-2020, 08:44:47
    Author     : Dell
--%>

<%@page import="com.beans.News"%>
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
            <h1 class="h2">View More Details</h1>
                <%-- <jsp:include page="reportbar.jsp"></jsp:include>--%>
          </div>
                         <div class="container-fluid">

                            <!-- Page Heading -->
                        <%
                            int newsid = Integer.parseInt(request.getParameter("newsid"));
                            NewsDao nd = new NewsDao();
                            News news = nd.getById(newsid);
                        %>

                        <div class="card col col-md-12">
                            <div class="card-body">
                                <h4 class="card-title"><%=news.getTitle()%></h4>
                                <p class="card-text"><%=news.getDescription()%></p>
                            </div>
                            <img class="card-img-bottom" src="../<%=news.getImage()%>" alt="Card image" style="width:350px;height: 350px;">
                           
                            </form>
                            </div>
                     </div>

 
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
