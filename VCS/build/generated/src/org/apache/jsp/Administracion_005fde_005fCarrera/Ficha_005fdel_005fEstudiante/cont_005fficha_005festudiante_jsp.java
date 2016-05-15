package org.apache.jsp.Administracion_005fde_005fCarrera.Ficha_005fdel_005fEstudiante;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cont_005fficha_005festudiante_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <legend><h1 class=\"alineado3\">FICHA DEL ESTUDIANTE PARA EL TUTOR</h1></legend>\n");
      out.write("\n");
      out.write("    <fieldset class=\"legendas2\"><legend class=\"legendas opcion_iluminada\">DATOS DEL ESTUDIANTE</legend>\n");
      out.write("\n");
      out.write("        <table class=\"table table-hover table-responsive\" >\n");
      out.write("            <tr>\n");
      out.write("                <td><label for=\"txt_id_carta_comp\">CARTA COMPROMISO:</label></td>\n");
      out.write("                <td><input type=\"text\" class=\"form-control\" readonly=\"readonly\" id=\"txt_id_carta_comp\" name=\"txt_id_carta_comp\" ng-model=\"txt_id_carta_comp\"/></td>\n");
      out.write("                <td align=\"right\"><label for=\"txt_actividad\">ACTIVIDAD:</label></td>\n");
      out.write("                <td><input type=\"text\" class=\"form-control\" readonly=\"readonly\" id=\"txt_actividad\" name=\"txt_actividad\" ng-model=\"txt_actividad\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><label for=\"txt_tipo_doc\">TIPO DE DOCUMENTO:</label></td>\n");
      out.write("                <td><input type=\"text\" class=\"form-control\" id=\"txt_tipo_doc\" readonly=\"readonly\" name=\"txt_tipo_doc\" ng-model=\"txt_tipo_doc\"/></td>\n");
      out.write("                <td align=\"right\"><label for=\"txt_fecha_ini\">INICIO:</label></td>\n");
      out.write("                <td>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" readonly=\"readonly\" id=\"txt_fecha_ini\" name=\"txt_fecha_ini\" ng-model=\"txt_fecha_ini\"/>\n");
      out.write("                    </div>\n");
      out.write("                    </div>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><label for=\"txt_cedula\">CEDULA DE CIUDADANÍA:</label></td>\n");
      out.write("                <td><input type=\"text\" class=\"form-control\" readonly=\"readonly\" id=\"txt_cedula\" name=\"txt_cedula\" ng-model=\"txt_cedula\"/></td>\n");
      out.write("                <td align=\"right\"><label for=\"txt_fecha_fin\">FIN:</label>\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" readonly=\"readonly\" id=\"txt_fecha_fin\" name=\"txt_fecha_fin\" ng-model=\"txt_fecha_fin\" ng-click=\"calendarios()\"/>\n");
      out.write("                </td>\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><label for=\"txt_nombre_completo\">APELLIDOS Y NOMBRES:</label></td>\n");
      out.write("                <td colspan=\"3\"><input type=\"text\" readonly=\"readonly\" id=\"txt_nombre_completo\" class=\"form-control\" name=\"txt_nombre_completo\" ng-model=\"txt_nombre_completo\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><label for=\"txt_direccion_est\">DIRECCION:</label><label class=\"text-danger\">(*)</label></td>\n");
      out.write("                <td colspan=\"3\"><input type=\"text\" id=\"txt_direccion_est\" required=\"required\" class=\"form-control\" name=\"txt_direccion_est\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><label for=\"txt_fono_est\">TELÉFONOS:</label></td>\n");
      out.write("                <td colspan=\"1\"><input type=\"text\" readonly=\"readonly\" id=\"txt_fono_est\" class=\"form-control\" name=\"txt_fono_est\" ng-model=\"txt_fono_est\"/></td>\n");
      out.write("                <td align=\"right\"><label for=\"txt_email_est\">E-MAIL:</label></td>\n");
      out.write("                <td><input type=\"text\" id=\"txt_email_est\" readonly=\"readonly\" class=\"form-control\" name=\"txt_email_est\" ng-model=\"txt_email_est\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><label for=\"txt_facebook\">FACEBOOK:</label></td>\n");
      out.write("                <td><input type=\"text\" id=\"txt_facebook\" class=\"form-control\" name=\"txt_facebook\" ng-model=\"txt_facebook\"/></td>\n");
      out.write("                <td align=\"right\"><label for=\"txt_twitter\">TWITTER:</label></td>\n");
      out.write("                <td><input type=\"text\" id=\"txt_twitter\" class=\"form-control\" name=\"txt_twitter\" ng-model=\"txt_twitter\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><label for=\"txt_linkedin\">LINKEDIN</label></td>\n");
      out.write("                <td colspan=\"3\"><input type=\"text\" id=\"txt_linkedin\" class=\"form-control\" name=\"txt_linkedin\" ng-model=\"txt_linkedin\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("            <table class=\"table table-hover table-responsive\">\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"3\" width=179px><label for=\"txt_carrera\">CARRERA:</label></td>\n");
      out.write("                    <td><input type=\"text\" id=\"txt_carrera\" readonly=\"readonly\" class=\"form-control\" name=\"txt_carrera\" ng-model=\"txt_carrera\"/></td>\n");
      out.write("                    <td colspan=\"1\" width=171px><label for=\"txt_semestre\">CICLO O SEMESTRE<br>QUE CURSA:</label></td>\n");
      out.write("                    <td colspan=\"1\"><input type=\"text\" readonly=\"readonly\" id=\"txt_semestre\" size=\"10\" class=\"form-control\" name=\"txt_semestre\" ng-model=\"txt_semestre\"/></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("    </fieldset>\n");
      out.write("    <br><br>\n");
      out.write("    <fieldset  class=\"legendas2\"><legend class=\"legendas opcion_iluminada\" >DATOS DE LA EMPRESA Y/O PROYECTO</legend>\n");
      out.write("        <table class=\"table table-hover table-responsive\">\n");
      out.write("            <tr>\n");
      out.write("                <td><label for=\"txt_empresa\">INSTITUCIÓN O EMPRESA DE INTERÉS:</label></td>\n");
      out.write("                <td colspan=\"3\"><input type=\"text\" readonly=\"readonly\" id=\"txt_empresa\" class=\"form-control\" name=\"txt_empresa\" ng-model=\"txt_empresa\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><label for=\"txt_responsable_empresa\">RESPONSABLE DE LA EMPRESA:</label></td>\n");
      out.write("                <td><input type=\"text\" id=\"txt_responsable_empresa\" readonly=\"readonly\" class=\"form-control\" name=\"txt_responsable_empresa\" ng-model=\"txt_responsable_empresa\"/></td>\n");
      out.write("                <td align=\"right\"><label for=\"txt_responsable_proy\">DEL PROYECTO:</label></td>\n");
      out.write("                <td><input type=\"text\" id=\"txt_responsable_proy\" class=\"form-control\" name=\"txt_responsable_proy\" ng-model=\"txt_responsable_proy\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><label for=\"txt_departamento\">ÁREA O DEPARTAMENTO DE INTERÉS:</label></td>\n");
      out.write("                <td colspan=\"3\"><input type=\"text\" readonly=\"readonly\" id=\"txt_departamento\" class=\"form-control\" name=\"txt_departamento\" ng-model=\"txt_departamento\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><label for=\"txt_responsable_area\">RESPONSABLE DEL ÁREA:</label></td>\n");
      out.write("                <td><input type=\"text\" class=\"form-control\" readonly=\"readonly\" id=\"txt_responsable_area\" name=\"txt_responsable_area\" ng-model=\"txt_responsable_area\"/></td>\n");
      out.write("                <td align=\"right\"><label for=\"txt_horario_previsto\">HORARIO<br>PREVISTO:</label></td>\n");
      out.write("                <td><input type=\"text\" class=\"form-control\" readonly=\"readonly\" id=\"txt_horario_previsto\" name=\"txt_horario_previsto\" ng-model=\"txt_horario_previsto\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><label for=\"txt_cargo_resp_cia\">CARGO DEL RESPONSABLE CIA:</label></td>\n");
      out.write("                <td><input type=\"text\" class=\"form-control\" readonly=\"readonly\" id=\"txt_cargo_resp_cia\" name=\"txt_cargo_resp_cia\" ng-model=\"txt_cargo_resp_cia\"/></td>\n");
      out.write("                <td align=\"right\"><label for=\"txt_telefono_cia\">TELÉFONOS:</label></td>\n");
      out.write("                <td><input type=\"text\" class=\"form-control\" readonly=\"readonly\" id=\"txt_telefono_cia\" name=\"txt_telefono_cia\" ng-model=\"txt_telefono_cia\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><label for=\"txt_dir_cia\">DIRECCIÓN DE LA COMPAÑÍA:</label></td>\n");
      out.write("                <td colspan=\"3\"><input type=\"text\" readonly=\"readonly\" class=\"form-control\" id=\"txt_dir_cia\" name=\"txt_dir_cia\" ng-model=\"txt_dir_cia\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><label for=\"txt_nomb_progama\">NOMBRE DEL PROGRAMA:</label></td>\n");
      out.write("                <td colspan=\"3\"><input type=\"text\" readonly=\"readonly\" class=\"form-control\" id=\"txt_nomb_progama\" name=\"txt_nomb_progama\" ng-model=\"txt_nomb_progama\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><label for=\"txt_nomb_proy\">NOMBRE DEL PROYECTO(en el caso de<br>\n");
      out.write("                        extensiones universitarias):\n");
      out.write("                    </label></td>\n");
      out.write("                <td colspan=\"3\"><textarea class=\"form-control\" id=\"txt_nomb_proy\" name=\"txt_nomb_proy\"></textarea></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><label for=\"txt_act_realizar\">DETALLE BREVEMENTE LAS ACTIVIDADES<br>\n");
      out.write("                        A REALIZAR (en el caso de Pasantías o<br>\n");
      out.write("                        Prácticas Pre profesionales):</label></td>\n");
      out.write("                <td colspan=\"3\"><textarea readonly=\"readonly\" class=\"form-control\" id=\"txt_act_realizar\" name=\"txt_act_realizar\"></textarea></td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("    </fieldset>\n");
      out.write("</fieldset>\n");
      out.write("<br>\n");
      out.write("<table>\n");
      out.write("    <tr>\n");
      out.write("        <td align=\"left\"><label for=\"txt_tutor\">Nombre del Tutor:&nbsp;&nbsp;</label></td>\n");
      out.write("        <td align=\"left\"><input type=\"text\" readonly=\"readonly\" class=\"form-control\" id=\"txt_tutor\" name=\"txt_tutor\" ng-model=\"txt_tutor\"></td>\n");
      out.write("    </tr>\n");
      out.write("</table>\n");
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
