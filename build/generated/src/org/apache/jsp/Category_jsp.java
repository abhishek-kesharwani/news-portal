package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.Daos.CategoryDao;
import com.beans.Category;

public final class Category_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("         ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("  \n");
      out.write("        <form method=\"post\">\n");
      out.write("            <center>\n");
      out.write("            <h2>Please Enter Category </h2>\n");
      out.write("            <table border=\"2\" width=\"60%\" class=\"table table-striped  text-dark text-center\" >\n");
      out.write("              \n");
      out.write("                <tr>\n");
      out.write("                    <th>Enter Category</th><td>\n");
      out.write("                        <input type=\"text\" name=\"name\" placeholder=\"Category\" class=\"form-control\"/>\n");
      out.write("                       </td>\n");
      out.write("                 </tr>\n");
      out.write("         <th class=\"text-center\" colspan=\"2\">\n");
      out.write("          \n");
      out.write("                    <input type=\"submit\" value=\"Save\" name=\"submit\"  class=\" btn btn-success col col-md-10\"/>\n");
      out.write("                 </th>\n");
      out.write("            </table>\n");
      out.write("            </center>\n");
      out.write("        </form>\n");
      out.write("     \n");
      out.write("    <center>\n");
      out.write("        <hr><hr>\n");
      out.write("       <!-- <table class=\"table table-striped table-dark\" width=\"60%\" border=\"1\" cellspacing=\"0\">\n");
      out.write("            <tr>\n");
      out.write("                <th > ID</th>\n");
      out.write("                 <th>Category NAME</th>\n");
      out.write("                 <th>Oprations</th>\n");
      out.write("                  <th>Oprations</th>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("                <td>a</td>\n");
      out.write("                <td>b</td> \n");
      out.write("                <td><a><i class=\"fa fa-edit btn btn-success\"  aria-hidden=\"true\"> Delete</i></a></td>\n");
      out.write("                <td><a><i class=\"fa fa-trash btn btn-success\"  aria-hidden=\"true\"> Delete</i></a></td>   \n");
      out.write("            </tr>\n");
      out.write("        </table>-->\n");
      out.write("        <br>\n");
      out.write("    </center>\n");
      out.write("  ");

      if(request.getParameter("submit")!=null)
      {
      out.write("\n");
      out.write("     ");
      com.beans.Category category = null;
      synchronized (session) {
        category = (com.beans.Category) _jspx_page_context.getAttribute("category", PageContext.SESSION_SCOPE);
        if (category == null){
          category = new com.beans.Category();
          _jspx_page_context.setAttribute("category", category, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("category"), request);
      out.write("\n");
      out.write("    \n");
      out.write("    ");
 CategoryDao cd = new CategoryDao();  cd.add(category); out.println("Added to db"); }
      out.write("\n");
      out.write("    \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
