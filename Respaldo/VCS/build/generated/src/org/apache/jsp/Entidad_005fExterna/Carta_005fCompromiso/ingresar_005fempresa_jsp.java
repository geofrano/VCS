package org.apache.jsp.Entidad_005fExterna.Carta_005fCompromiso;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ingresar_005fempresa_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Empresa o Institución</title>\n");
      out.write("        ");
 String ruta = request.getContextPath();
      out.write("\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../css/principal.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../css/sweetalert.css\">\n");
      out.write("        <script src=\"../../js/angular.min.js\"></script>\n");
      out.write("        <script src=\"carta_compromiso.js\"></script>\n");
      out.write("        <script src=\"../../js/jquery.js\"></script>\n");
      out.write("        <script src=\"../../js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"../../js/sweetalert-dev.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body ng-controller=\"ControladorVCS\" onload=\"modif_empr()\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\" align=\"center\">\n");
      out.write("                <h4 class=\"title-c\">Empresa o Institución</h4>\n");
      out.write("            </div>\n");
      out.write("            <br>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-12\">\n");
      out.write("                    <form id=\"frm_empresa_ingreso\" name=\"frm_empresa_ingreso\" action=\"\" method=\"POST\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <fieldset class=\"legendas2\"><legend class=\"legendas opcion_iluminada\">Información de la Empresa</legend>\n");
      out.write("                                <table class=\"table table-hover table-responsive\">\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>\n");
      out.write("                                            <label>Nombre de la Empresa: </label><label class=\"text-danger\">(*)</label>\n");
      out.write("                                        </td>\n");
      out.write("                                        <td class=\"tamanio1\" colspan=\"3\">\n");
      out.write("                                            <input type=\"text\" class=\"text-primary form-control\" id=\"txt_nom_empresa_ing\" name=\"txt_nom_empresa_ing\" maxlength=\"250\">\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>\n");
      out.write("                                            <label>Dirección: </label><label class=\"text-danger\">(*)</label>\n");
      out.write("                                        </td>\n");
      out.write("                                        <td class=\"tamanio1\" colspan=\"3\">\n");
      out.write("                                            <input type=\"text\" class=\"text-primary form-control\" id=\"txt_direccion_ing\" name=\"txt_direccion_ing\" maxlength=\"500\">\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>\n");
      out.write("                                            <label>Teléfono: </label><label class=\"text-danger\">(*)</label>\n");
      out.write("                                        </td>\n");
      out.write("                                        <td class=\"tamanio4\">\n");
      out.write("                                            <input type=\"text\" class=\"text-primary form-control\" id=\"txt_telefono_ing\" name=\"txt_telefono_ing\" maxlength=\"10\">\n");
      out.write("                                        </td>\n");
      out.write("                                        <td>\n");
      out.write("                                            <label>Tipo: </label><label class=\"text-danger\">(*)</label>\n");
      out.write("                                        </td>\n");
      out.write("                                        <td>\n");
      out.write("                                            <select name=\"cmb_tipo_emp\" id=\"cmb_tipo_emp\" class=\"form-control\" ng-open=\"carga_combo_tipo_empr()\"></select>\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>\n");
      out.write("                                            <label>Actividad Principal: </label><label class=\"text-danger\">(*)</label>\n");
      out.write("                                        </td>\n");
      out.write("                                        <td class=\"tamanio1\" colspan=\"3\">\n");
      out.write("                                            <input type=\"text\" class=\"text-primary form-control\" id=\"txt_actividad_empresa_ing\" name=\"txt_actividad_empresa_ing\" maxlength=\"250\">\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                </table>\n");
      out.write("                            </fieldset>\n");
      out.write("                            <br>\n");
      out.write("                            <fieldset class=\"legendas2\"><legend class=\"legendas opcion_iluminada\">Representante Legal</legend>\n");
      out.write("                                <table class=\"table table-hover table-responsive\">\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>\n");
      out.write("                                            <label>Apellidos: </label><label class=\"text-danger\">(*)</label>\n");
      out.write("                                        </td>\n");
      out.write("                                        <td class=\"tamanio1\">\n");
      out.write("                                            <input type=\"text\" class=\"text-primary form-control\" id=\"txt_apellido_repr_legal_ing\" name=\"txt_apellido_repr_legal_ing\" maxlength=\"250\">\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>\n");
      out.write("                                            <label>Nombres: </label><label class=\"text-danger\">(*)</label>\n");
      out.write("                                        </td>\n");
      out.write("                                        <td class=\"tamanio1\">\n");
      out.write("                                            <input type=\"text\" class=\"text-primary form-control\" id=\"txt_nombre_repr_legal_ing\" name=\"txt_nombre_repr_legal_ing\" maxlength=\"250\">\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>\n");
      out.write("                                            <label>Cargo: </label><label class=\"text-danger\">(*)</label>\n");
      out.write("                                        </td>\n");
      out.write("                                        <td class=\"tamanio1\">\n");
      out.write("                                            <input type=\"text\" class=\"text-primary form-control\" id=\"txt_cargo_repr_legal_ing\" name=\"txt_cargo_repr_legal_ing\" maxlength=\"250\">\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>\n");
      out.write("                                            <label>Teléfono: </label><label class=\"text-danger\">(*)</label>\n");
      out.write("                                        </td>\n");
      out.write("                                        <td class=\"tamanio1\">\n");
      out.write("                                            <input type=\"text\" class=\"text-primary form-control\" id=\"txt_fono_repr_legal_ing\" name=\"txt_fono_repr_legal_ing\" maxlength=\"15\">\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td colspan=\"2\">\n");
      out.write("                                            <input type=\"hidden\" value=\"");
      out.print(ruta);
      out.write("\" id=\"ruta_principal\" name=\"ruta_principal\" />\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                </table>\n");
      out.write("                            </fieldset>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group center-block text-center\">\n");
      out.write("                            <button type=\"button\" class=\"btn btn-success\" onclick=\"carga_modifica_empr2()\">Guardar</button>\n");
      out.write("                            <button type=\"button\" class=\"btn btn-danger\" onclick=\"window.close()\">Cerrar</button>\n");
      out.write("                        </div>\n");
      out.write("                        <input type=\"hidden\" id=\"id_ue\" name=\"id_ue\" value=\"\" />\n");
      out.write("                        <input type=\"hidden\" id=\"id_ar\" name=\"id_ar\" value=\"\" />\n");
      out.write("                        <input type=\"hidden\" id=\"accion\" name=\"accion\" value=\"\" />\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
