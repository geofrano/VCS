package org.apache.jsp.Login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html ng-app=\"VCS\">\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Sistema único de autenticación VCS</title>\n");
      out.write("        ");
 String ruta = request.getContextPath();
      out.write("\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/bootstrap.min.css\" >\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/login.css\" >\n");
      out.write("        <script src=\"../js/angular.min.js\"></script>\n");
      out.write("        <script src=\"../js/login.js\"></script>\n");
      out.write("        <script src=\"../js/jquery.js\"></script>\n");
      out.write("        <script src=\"../js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body  ng-controller=\"ControladorLogin\">\n");
      out.write("        <header>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <h1>Sistema único de Autenticación VCS</h1>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("            <div class=\"main row\"></div>    \n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-8\">\n");
      out.write("                    <div class=\"panel panel-default\">\n");
      out.write("                        <div class=\"panel-body\">");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../vistas/logo_login.jsp", out, false);
      out.write("</div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4\">\n");
      out.write("                    <div class=\"panel panel-default\">\n");
      out.write("                        <div class=\"panel-body\">\n");
      out.write("                            ");
      out.write("\n");
      out.write("                            <form role=\"form\" action=\"\"  method=\"POST\" id=\"frm_login\" name=\"frm_login\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"txt_usuario\">Usuario</label>\n");
      out.write("                                    <div class=\"input-group\">\n");
      out.write("                                        <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-user\"></span></span>\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" id=\"txt_usuario\" name=\"txt_usuario\" maxlength=\"20\" placeholder=\"Ingrese su usuario\" ng-model=\"txt_usuario\" required=\"\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    \n");
      out.write("                                    <label for=\"txt_clave\">Contraseña</label>\n");
      out.write("                                    <div class=\"input-group\">\n");
      out.write("                                        <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-star\"></span></span>\n");
      out.write("                                        <input type=\"password\" class=\"form-control\" id=\"txt_clave\" name=\"txt_clave\" maxlength=\"20\" placeholder=\"Ingrese su contraseña\" ng-model=\"txt_clave\" required=\"\" >\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <hr/>\n");
      out.write("                                ");
      out.write("\n");
      out.write("                                <button ng-click=\"valida()\" ng-submit=\"valida()\" type=\"submit\" class=\"btn btn-primary\" onclick=\"valida();\" onsubmit=\"valida();\" ng-disabled=\"frm_login.txt_clave.$invalid || frm_login.txt_usuario.$invalid \"><span class=\"glyphicon glyphicon-lock\"></span> Iniciar Sesión</button>\n");
      out.write("                                <p><br/></p>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>{{institucion}}\n");
      out.write("        <input type=\"hidden\" value=\"");
      out.print(ruta);
      out.write("\" id=\"ruta_principal\" name=\"ruta_principal\" />\n");
      out.write("        \n");
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
