package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.AddCarItem.AddItemG_S;
import Model.AddCarItem.AddItemDAOImpl;
import java.util.List;
import Model.AddCarItem.AddItemDAO;

public final class ViewAddCar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        \n");
      out.write("\t<link href=\"viewproduct.css\" rel=\"stylesheet\"> \n");
      out.write("    <link href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,700\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("\t        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    ");
       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    AddItemDAO aidao=new AddItemDAOImpl();
    List<AddItemG_S> list=aidao.getDetail();
    request.setAttribute("List",list);
    
    
      out.write("\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<div class=\"card\">\n");
      out.write("\t\t\t<div class=\"container-fliud\">\n");
      out.write("\t\t\t\t<div class=\"wrapper row\">\n");
      out.write("\t\t\t\t\t<div class=\"preview col-md-6\">\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t<div class=\"preview-pic tab-content\">\n");
      out.write("\t\t\t\t\t\t  <div class=\"tab-pane active\" id=\"pic-1\"><img src=\"http://placekitten.com/400/252\" /></div>\n");
      out.write("\t\t\t\t\t\t  <div class=\"tab-pane\" id=\"pic-2\"><img src=\"http://placekitten.com/400/252\" /></div>\n");
      out.write("\t\t\t\t\t\t  <div class=\"tab-pane\" id=\"pic-3\"><img src=\"http://placekitten.com/400/252\" /></div>\n");
      out.write("\t\t\t\t\t\t  <div class=\"tab-pane\" id=\"pic-4\"><img src=\"http://placekitten.com/400/252\" /></div>\n");
      out.write("\t\t\t\t\t\t  <div class=\"tab-pane\" id=\"pic-5\"><img src=\"http://placekitten.com/400/252\" /></div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<ul class=\"preview-thumbnail nav nav-tabs\">\n");
      out.write("\t\t\t\t\t\t  <li class=\"active\"><a data-target=\"#pic-1\" data-toggle=\"tab\"><img src=\"http://placekitten.com/200/126\" /></a></li>\n");
      out.write("\t\t\t\t\t\t  <li><a data-target=\"#pic-2\" data-toggle=\"tab\"><img src=\"http://placekitten.com/200/126\" /></a></li>\n");
      out.write("\t\t\t\t\t\t  <li><a data-target=\"#pic-3\" data-toggle=\"tab\"><img src=\"http://placekitten.com/200/126\" /></a></li>\n");
      out.write("\t\t\t\t\t\t  <li><a data-target=\"#pic-4\" data-toggle=\"tab\"><img src=\"http://placekitten.com/200/126\" /></a></li>\n");
      out.write("\t\t\t\t\t\t  <li><a data-target=\"#pic-5\" data-toggle=\"tab\"><img src=\"http://placekitten.com/200/126\" /></a></li>\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"details col-md-6\">\n");
      out.write("\t\t\t\t\t\t<h3 class=\"product-title\">men's shoes fashion</h3>\n");
      out.write("\t\t\t\t\t\t<div class=\"rating\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"stars\">\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"fa fa-star checked\"></span>\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"fa fa-star checked\"></span>\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"fa fa-star checked\"></span>\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"fa fa-star\"></span>\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"fa fa-star\"></span>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<span class=\"review-no\">41 reviews</span>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<p class=\"product-description\">Suspendisse quos? Tempus cras iure temporibus? Eu laudantium cubilia sem sem! Repudiandae et! Massa senectus enim minim sociosqu delectus posuere.</p>\n");
      out.write("\t\t\t\t\t\t<h4 class=\"price\">current price: <span>$180</span></h4>\n");
      out.write("\t\t\t\t\t\t<p class=\"vote\"><strong>91%</strong> of buyers enjoyed this product! <strong>(87 votes)</strong></p>\n");
      out.write("\t\t\t\t\t\t<h5 class=\"sizes\">sizes:\n");
      out.write("\t\t\t\t\t\t\t<span class=\"size\" data-toggle=\"tooltip\" title=\"small\">s</span>\n");
      out.write("\t\t\t\t\t\t\t<span class=\"size\" data-toggle=\"tooltip\" title=\"medium\">m</span>\n");
      out.write("\t\t\t\t\t\t\t<span class=\"size\" data-toggle=\"tooltip\" title=\"large\">l</span>\n");
      out.write("\t\t\t\t\t\t\t<span class=\"size\" data-toggle=\"tooltip\" title=\"xtra large\">xl</span>\n");
      out.write("\t\t\t\t\t\t</h5>\n");
      out.write("\t\t\t\t\t\t<h5 class=\"colors\">colors:\n");
      out.write("\t\t\t\t\t\t\t<span class=\"color orange not-available\" data-toggle=\"tooltip\" title=\"Not In store\"></span>\n");
      out.write("\t\t\t\t\t\t\t<span class=\"color green\"></span>\n");
      out.write("\t\t\t\t\t\t\t<span class=\"color blue\"></span>\n");
      out.write("\t\t\t\t\t\t</h5>\n");
      out.write("\t\t\t\t\t\t<div class=\"action\">\n");
      out.write("\t\t\t\t\t\t\t<button class=\"add-to-cart btn btn-default\" type=\"button\">Booked ME</button>\n");
      out.write("\t\t\t\t\t\t\t<button class=\"like btn btn-default\" type=\"button\"><span class=\"fa fa-heart\"></span></button>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
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
