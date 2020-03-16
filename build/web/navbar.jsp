<%
    String url = request.getRequestURI();
    request.setAttribute("url", url);
    %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">News Portal</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item ">
              <a class="nav-link ${url.contains("index1.jsp")?" active":""}" href="index1.jsp"><i class="fa fa-home"></i>&nbsp;&nbsp;Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="#">&nbsp;About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Services</a>
          </li>
          <li class="nav-item">
              <a class="nav-link ${url.contains("contact.jsp")?" active":""}" href="contact.jsp"><i class="fa fa-address-book"></i>&nbsp;&nbsp;Contact</a>
          </li>
          <li class="nav-item">
              <a class="nav-link ${url.contains("newslogin.jsp")?" active":""}" href="newslogin.jsp"><i class="fa fa-lock"></i>&nbsp;&nbsp;Login</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>