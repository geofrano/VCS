package org.apache.jsp.Administracion_005fde_005fCarrera.Ficha_005fdel_005fEstudiante;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ficha_005festudiante_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"cache-control\" content=\"max-age=0\" />\n");
      out.write("        <meta http-equiv=\"cache-control\" content=\"no-cache\" />\n");
      out.write("        <meta http-equiv=\"expires\" content=\"0\" />\n");
      out.write("        <meta http-equiv=\"pragma\" content=\"no-cache\" />\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Sistema Administrativo VCS - UPS</title>\n");
      out.write("        ");
 String ruta = request.getContextPath();
      out.write("\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../css/bootstrap.min.css\" >\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../css/principal.css\" >\n");
      out.write("\n");
      out.write("        <script src=\"../../js/angular.min.js\"></script>\n");
      out.write("        <!-- This is what you need -->\n");
      out.write("  <script src=\"../../js/sweetalert-dev.js\"></script>\n");
      out.write("  <link rel=\"stylesheet\" href=\"../../css/sweetalert.css\">\n");
      out.write("  <!--.......................-->\n");
      out.write("        <script src=\"ficha_estudiante.js\"></script>\n");
      out.write("        <script src=\"../../js/jquery.js\"></script>\n");
      out.write("        <script src=\"../../js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body ng-controller=\"ControladorVCS\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../vistas/cabecera_pagina.jsp", out, false);
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-3\">\n");
      out.write("                    <div class=\"list-group\" id=\"ajaxResponse\" ng-open=\"carga2()\"></div>\n");
      out.write("                </div>\n");
      out.write("            <div class=\"col-md-9\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "consultar_ficha_estudiante.jsp", out, false);
      out.write("\n");
      out.write("            </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-12\">\n");
      out.write("                    <br>\n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../vistas/pie_pagina.jsp", out, false);
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <form action=\"\" method=\"POST\" id=\"frm_carga\" name=\"frm_carga\">\n");
      out.write("                <input type=\"hidden\" value=\"");
      out.print(ruta);
      out.write("\" id=\"ruta_principal\" name=\"ruta_principal\" />\n");
      out.write("                <input type=\"hidden\" value=\"blank\" id=\"nombre_pagina\" name=\"nombre_pagina\" />\n");
      out.write("                <input type=\"hidden\" value=\"1\" id=\"id_modulo_padre\" name=\"id_modulo_padre\" />\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
