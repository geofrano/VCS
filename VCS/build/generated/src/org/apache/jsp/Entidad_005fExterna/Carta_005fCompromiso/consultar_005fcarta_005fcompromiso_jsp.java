package org.apache.jsp.Entidad_005fExterna.Carta_005fCompromiso;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class consultar_005fcarta_005fcompromiso_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("<div id=\"frm_consulta\" name=\"frm_consulta\">\r\n");
      out.write("    <form id=\"frm_datos\" name=\"frm_datos\" action=\"\" method=\"POST\">\r\n");
      out.write("        <input type=\"hidden\" id=\"id_cc_consulta\" name=\"id_cc_consulta\"/>\r\n");
      out.write("        <fieldset>\r\n");
      out.write("            <legend><h1 class=\"alineado3\">Consultar Carta Compromiso</h1></legend>\r\n");
      out.write("            <br>\r\n");
      out.write("            <div class=\"list-group\" id=\"div_datos\"></div>\r\n");
      out.write("            <table class=\"table table-hover table-responsive\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><label>Nombre del Estudiante:</label></td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <input type=\"text\" class=\"text-primary form-control\" id=\"txt_nombre_est\" title=\"Nombre del estudiante\" name=\"txt_nombre_est\" maxlength=\"800\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td><div id=\"div_consulta\" name=\"div_consulta\">\r\n");
      out.write("                            <img width=\"30px\" height=\"30px\" id=\"img_consulta\" name=\"img_consulta\" class=\"img-circle\" title=\"Consultar\" src=\"../../images/consultar.jpg\" ng-click=\"consultar_estudiante_cc()\"/></div>\r\n");
      out.write("                        <div id=\"div_consulta2\" name=\"div_consulta2\" style=\"display:none\">\r\n");
      out.write("                            <img width=\"30px\" height=\"30px\" id=\"img_cargando\" name=\"img_cargando\" title=\"Cargando...\" src=\"../../images/cargando.svg\" /></div>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <img width=\"30px\" height=\"30px\" class=\"img-circle\" src=\"../../images/agregar.jpg\" title=\"Agregar una Carta Compromiso\" ng-click=\"carga_ingreso()\"/>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </fieldset>\r\n");
      out.write("        <input type=\"hidden\" id=\"existe_data\" value=\"0\"/>\r\n");
      out.write("        <div id=\"div_datos\"></div>\r\n");
      out.write("        <table id=\"tbl_estudiante\" class=\"table table-hover table-responsive\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>Id Carta Compromiso</th>\r\n");
      out.write("                <th>Tipo de Actividad</th>\r\n");
      out.write("                <th colspan=\"2\">Nombre Estudiante</th>\r\n");
      out.write("                <th>Lugar Suscripción</th>\r\n");
      out.write("                <th>Fecha Suscripción</th>\r\n");
      out.write("                <th colspan=\"4\"></th>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("<form method=\"POST\" action=\"\" id=\"frm_cc\" name=\"frm_cc\">\r\n");
      out.write("    <input type=\"hidden\" readonly=\"readonly\" id=\"txt_codigo\" name=\"txt_codigo\"/>\r\n");
      out.write("    <input type=\"hidden\" readonly=\"readonly\" id=\"txt_institucion\" name=\"txt_institucion\" ng-value=\"institucion\"/>\r\n");
      out.write("    <input type=\"hidden\" readonly=\"readonly\" id=\"txt_sede\" name=\"txt_sede\" ng-value=\"sede\"/>\r\n");
      out.write("</form>\r\n");
      out.write("<div id=\"div_consul\" style=\"display:none\">\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"div_ingreso\" style=\"display:none\">\r\n");
      out.write("</div>");
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
