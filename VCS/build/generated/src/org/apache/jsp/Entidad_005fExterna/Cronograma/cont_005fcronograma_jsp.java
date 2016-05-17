package org.apache.jsp.Entidad_005fExterna.Cronograma;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cont_005fcronograma_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<br>\n");
      out.write("<form method=\"POST\" id=\"frm_ficha\" name=\"frm_ficha\" target=\"_new\">\n");
      out.write("<fieldset>\n");
      out.write("    <legend><h1 class=\"alineado3\">CRONOGRAMA DE ACTIVIDADES</h1></legend>\n");
      out.write("\n");
      out.write("    <fieldset class=\"legendas2\"><legend class=\"legendas opcion_iluminada\">CRONOGRAMA DE ACTIVIDADES</legend>\n");
      out.write("\n");
      out.write("        <table class=\"table table-hover table-responsive\" >\n");
      out.write("            <tr>\n");
      out.write("                <td rowspan=\"2\" align=\"center\"><label>ACTIVIDADES</label></td>\n");
      out.write("                <td colspan=\"7\" align=\"center\"><label>SEMANAS</label></td>\n");
      out.write("                <td></td>\n");
      out.write("                <td></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><label>1</label></td>\n");
      out.write("                <td><label>2</label></td>\n");
      out.write("                <td><label>3</label></td>\n");
      out.write("                <td><label>4</label></td>\n");
      out.write("                <td><label>5</label></td>\n");
      out.write("                <td><label>6</label></td>\n");
      out.write("                <td><label>7</label></td>\n");
      out.write("                <td><label>TOTAL</label></td>\n");
      out.write("                <td><label></label></td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("        </table>\n");
      out.write("    </fieldset>\n");
      out.write("    <br><br>\n");
      out.write("    \n");
      out.write("</fieldset>\n");
      out.write("\n");
      out.write("<input type=\"hidden\" value=\"0\" id=\"cod_proy\" name=\"cod_proy\"/>\n");
      out.write("<input type=\"hidden\" value=\"I\" id=\"accion_form\" name=\"accion_form\"/>\n");
      out.write("<br><br><center><button type=\"button\" class=\"btn btn-primary\" onclick=\"graba();\"><span class=\"glyphicon glyphicon-ok\"></span> Grabar</button>\n");
      out.write("</center>\n");
      out.write("</form>");
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
