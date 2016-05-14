package org.apache.jsp.Mantenimiento.Parametro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cont_005fparametro_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<div id=\"frm_consulta\" name=\"frm_consulta\">\n");
      out.write("    <form id=\"frm_datos\" name=\"frm_datos\" action=\"\" method=\"POST\">\n");
      out.write("        <fieldset>\n");
      out.write("            <legend><h1 class=\"alineado3\">Mantenimiento - Parámetros</h1></legend>\n");
      out.write("            <br>\n");
      out.write("            <div class=\"list-group\" id=\"div_datos\"></div>\n");
      out.write("            <table class=\"table table-hover table-responsive\">\n");
      out.write("                <tr>\n");
      out.write("                    <td><label>Descripción</label></td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" class=\"text-primary form-control\" id=\"txt_nombre_para\" title=\"Descripción del parametro\" name=\"txt_nombre_para\" maxlength=\"800\">\n");
      out.write("                    </td>\n");
      out.write("                    <td><label>Tipo</label></td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"cmb_tipo\" id=\"cmb_tipo\" class=\"form-control\"></select>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <div id=\"div_consulta\" name=\"div_consulta\">\n");
      out.write("                            <img width=\"30px\" height=\"30px\" id=\"img_consulta\" name=\"img_consulta\" class=\"img-circle\" title=\"Consultar\" src=\"../../images/consultar.jpg\" ng-click=\"consulta_parametro()\"/></div>\n");
      out.write("                        <div id=\"div_consulta2\" name=\"div_consulta2\" style=\"display:none\">\n");
      out.write("                            <img width=\"30px\" height=\"30px\" id=\"img_cargando\" name=\"img_cargando\" title=\"Cargando...\" src=\"../../images/cargando.svg\" /></div>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <img width=\"30px\" height=\"30px\" class=\"img-circle\" src=\"../../images/agregar.jpg\" title=\"Agregar Parametro\" data-toggle=\"modal\" data-target=\"#campos_parametro\" onclick=\"asigna_accion_ingreso();\" />\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </fieldset>\n");
      out.write("        <input type=\"hidden\" id=\"existe_data\" value=\"0\"/>\n");
      out.write("        <div id=\"div_datos\"></div>\n");
      out.write("        <table id=\"tbl_parametro\" class=\"table table-hover table-responsive\">\n");
      out.write("            <tr>\n");
      out.write("                <th colspan=\"2\">Id Parametro</th>\n");
      out.write("                <th colspan=\"2\">Descripción</th>\n");
      out.write("                <th colspan=\"2\">Valor</th>\n");
      out.write("                <th colspan=\"4\">Tipo</th>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        <div class=\"modal fade\" id=\"campos_parametro\" role=\"dialog\">\n");
      out.write("            <div class=\"modal-dialog modal-open\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                        <h4 class=\"title-c\">Modificar Parametro</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <input type=\"hidden\" value=\"I\" id=\"tipo_accion\" name=\"tipo_accion\"/>\n");
      out.write("                        <input type=\"hidden\" value=\"\" id=\"cont\" name=\"cont\"/>\n");
      out.write("                        <div class=\"list-group\" id=\"div_datos\"></div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <table class=\"table table-hover table-responsive\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>\n");
      out.write("                                        <label>Id Parametro: </label><label class=\"text-danger\"></label>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td class=\"tamanio1\">\n");
      out.write("                                        <input type=\"text\" readonly=\"readonly\" class=\"text-primary form-control\" id=\"txt_id_parametro\" name=\"txt_id_parametro\" maxlength=\"100\">\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>\n");
      out.write("                                        <label>Descripción: </label><label class=\"text-danger\">(*)</label>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td class=\"tamanio1\">\n");
      out.write("                                        <input type=\"text\" class=\"text-primary form-control\" id=\"txt_descripcion\" name=\"txt_descripcion\" maxlength=\"200\">\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>\n");
      out.write("                                        <label>Valor: </label><label class=\"text-danger\">(*)</label>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td class=\"tamanio1\">\n");
      out.write("                                        <input type=\"text\" class=\"text-primary form-control\" id=\"txt_valor\" name=\"txt_valor\" maxlength=\"4000\">\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>\n");
      out.write("                                        <label>Tipo: </label><label class=\"text-danger\">(*)</label>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <select name=\"cmb_tipo_para\" id=\"cmb_tipo_para\" class=\"form-control\" ng-open=\"carga_cmb_tipo_parametro()\"></select>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                            </table>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group center-block text-center\">\n");
      out.write("                            <button type=\"button\" class=\"btn btn-success\" onclick=\"modificar_parametro();\">Guardar</button>\n");
      out.write("                            <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\" ng-click=\"consulta_parametro()\">Cerrar</button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </form>\n");
      out.write("</div>\n");
      out.write("<div id=\"div_consul\" style=\"display:none\">\n");
      out.write("\n");
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
