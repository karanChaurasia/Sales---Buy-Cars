package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.json.simple.JSONArray;
import java.util.ArrayList;
import Model.SellUsedCar.UsedCarG_S;
import java.util.List;
import Model.SellUsedCar.UsedCarDAOImpl;
import Model.SellUsedCar.UsedCarDao;

public final class UsedCar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_import_url_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_import_url_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_c_import_url_nobody.release();
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Used Car Page</title>\n");
      out.write("    \n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js\"></script>  \n");
      out.write("    <style>\n");
      out.write("            .jumbotron {\n");
      out.write("                            margin-bottom: 0px;\n");
      out.write("                            background-image: url(carjumbo.jpg);\n");
      out.write("                            background-position: 0% 25%;\n");
      out.write("                            background-size: cover;\n");
      out.write("                            background-repeat: no-repeat;\n");
      out.write("                            color: white;\n");
      out.write("                            \n");
      out.write("                        }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    ");

    
    UsedCarDao ucdao=new UsedCarDAOImpl();
    List<UsedCarG_S> list=ucdao.getOldCarDetail();
    request.setAttribute("List",list);
    
    
              
        ArrayList<UsedCarG_S> list1=(ArrayList)ucdao.used_dta();
        JSONArray  json=new JSONArray();
        for (UsedCarG_S u: list1) {
            json.add(u.getJSONObject());
        }
        String jsonData=json.toString();

  
        
      out.write("\n");
      out.write("        \n");
      out.write("                    ");
      //  c:set
      org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
      _jspx_th_c_set_0.setPageContext(_jspx_page_context);
      _jspx_th_c_set_0.setParent(null);
      _jspx_th_c_set_0.setVar("used_dta");
      _jspx_th_c_set_0.setValue(jsonData);
      int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
      if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
        return;
      }
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      out.write("\n");
      out.write("    <script>\n");
      out.write("            var app=angular.module(\"myApp\",[]);\n");
      out.write("            app.controller(\"myController\",function($scope) {\n");
      out.write("    $scope.data=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${used_dta}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(";\n");
      out.write("    $scope.checkjson=function()\n");
      out.write("    $scope.message=\"\";\n");
      out.write("    {\n");
      out.write("        if(data.length==0)\n");
      out.write("        {\n");
      out.write("            message=\"No data found\";        }\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("});\n");
      out.write("     </script>\n");
      out.write("    <body ng-app=\"myApp\" ng-controller=\"myController\">\n");
      out.write("        ");
      if (_jspx_meth_c_import_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"jumbotron\">    \n");
      out.write("            <h1 class=\"well\" align=\"center\">ALL USED CAR\n");
      out.write("                <input class=\"form-control\" ng-model=\"sea.name\" type=\"text\" placeholder=\"Search..\"></h1>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("            \n");
      out.write("        <div class=\"container\">    \n");
      out.write("        <hr>\n");
      out.write(" \n");
      out.write("             <div  id=\"UsedCarG_S\" class=\"container-fluid\"   >\n");
      out.write("                   \n");
      out.write("                 \n");
      out.write("                 {{data | filter:sea}}\n");
      out.write("                 {{message}}\n");
      out.write("                 <div class=\"row\"> \n");
      out.write("                     \n");
      out.write("                      <div class=\"col-md-4\" ng-repeat=\"x in data| filter:sea\" >\n");
      out.write("                <div class=\"panel panel-default\">\n");
      out.write("                    \n");
      out.write("                    <a href=\"ProductView.jsp?id={{x.cid}}\">\n");
      out.write("                        <img src=\"{{x.picname}}\" width=\"100%\" height=\"250px\"></a>\n");
      out.write("                <div class=\"panel-body text-capitalize\">   \n");
      out.write("                <a href=\"ProductView.jsp?id={{x.cid}}\" target=\"_blank\">\n");
      out.write("                <h4><p align=\"left\">{{x.name}}</p></h4></a>\n");
      out.write("                \n");
      out.write("                <span class=\"text-warning\">\n");
      out.write("                               \n");
      out.write("                <p align=\"left\"><b>&nbsp;{{x.version}}</b></p>\n");
      out.write("                <p align=\"left\"><b>&nbsp;{{x.fuel}}</b></p>\n");
      out.write("                <p align=\"left\"><b>&nbsp;{{x.city}}</b></p>\n");
      out.write("                 \n");
      out.write("                <h4> <p align=\"left\" >Expected amount<b>&nbsp;₹ {{x.amount}}{{x.amountinword}}</b></p></h4>\n");
      out.write("                </span>\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                <p align=\"right\"> <a href=\"ProductView.jsp?id={{x.cid}}\" class=\"btn btn-success\">Read More</a></p>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("              </div>\n");
      out.write("              </div>\n");
      out.write("                 </div>\n");
      out.write("                  \n");
      out.write("             </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("</div> \n");
      out.write("          \n");
      out.write("        </div>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Footer Page</title>\n");
      out.write("                <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        <style>\n");
      out.write("               \n");
      out.write("            .foot\n");
      out.write("            {\n");
      out.write("                /*height: 100vh;*/\n");
      out.write("                height: 100%;\n");
      out.write("            }\n");
      out.write("        \n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("            <footer>\n");
      out.write("\n");
      out.write("            <ul class=\"list-inline text-center\">\n");
      out.write("                    <li><a href=\"\">Twitter</a></li>\n");
      out.write("                    <li><a href=\"\">Facebook</a></li>\n");
      out.write("                    <li><a href=\"\">YouTube</a></li>\n");
      out.write("\n");
      out.write("                    <p>&copy;Copyright @ 2017</p></ul></footer>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_import_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_import_0 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _jspx_tagPool_c_import_url_nobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_import_0.setPageContext(_jspx_page_context);
    _jspx_th_c_import_0.setParent(null);
    _jspx_th_c_import_0.setUrl("Header.jsp");
    int[] _jspx_push_body_count_c_import_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_import_0 = _jspx_th_c_import_0.doStartTag();
      if (_jspx_th_c_import_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_import_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_import_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_import_0.doFinally();
      _jspx_tagPool_c_import_url_nobody.reuse(_jspx_th_c_import_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${List}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("x");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                    \n");
          out.write("                <div class=\"col-md-4\">\n");
          out.write("                <div class=\"panel panel-default\">\n");
          out.write("                \n");
          out.write("                    <a href=\"ProductView.jsp?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${x.getCid()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                        <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${x.getPic_name()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" width=\"100%\" height=\"250px\"></a>\n");
          out.write("                <div class=\"panel-body text-capitalize\">   \n");
          out.write("                <a href=\"ProductView.jsp?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${x.getCid()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" target=\"_blank\">\n");
          out.write("                <h4><p align=\"left\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${x.getNamemodel()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p></h4></a>\n");
          out.write("                \n");
          out.write("                <span class=\"text-warning\">\n");
          out.write("                               \n");
          out.write("                <p align=\"left\"><b>&nbsp;");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${x.getVersion()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</b></p>\n");
          out.write("                <p align=\"left\"><b>&nbsp;");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${x.getFuel_type()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</b></p>\n");
          out.write("                <p align=\"left\"><b>&nbsp;");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${x.getCity()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</b></p>\n");
          out.write("                 \n");
          out.write("                <h4> <p align=\"left\" >Expected amount<b>&nbsp;₹ ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${x.getAmount()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${x.getAmountinword()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</b></p></h4>\n");
          out.write("                </span>\n");
          out.write("                        \n");
          out.write("                        \n");
          out.write("                <p align=\"right\"> <a href=\"ProductView.jsp?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${x.getCid()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"btn btn-success\">Read More</a></p>\n");
          out.write("\n");
          out.write("                    </div>\n");
          out.write("              </div>\n");
          out.write("              </div>\n");
          out.write("            \n");
          out.write("                 \n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
