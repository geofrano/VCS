package org.apache.jsp.Administracion_005fde_005fCarrera.Ficha_005fdel_005fEstudiante;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class imprime_005fficha_005festudiante_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        ");
 String ruta=request.getContextPath(); 
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Ficha del Estudiante - Impresion</title>\n");
      out.write("        ");
 String id_cc = request.getParameter("txt_id_carta_comp").toString();
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function imprime()\n");
      out.write("            {\n");
      out.write("                var ruta=document.getElementById(\"ruta_principal\").value; \n");
      out.write("                document.getElementById(\"frm_imprime\").action=ruta+\"/F_genera_pdf_ficha_estudiante\";\n");
      out.write("                document.frm_imprime.submit();\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"imprime()\">\n");
      out.write("        <form action=\"\" method=\"POST\" id=\"frm_imprime\" name=\"frm_imprime\">\n");
      out.write("            <input type=\"hidden\" value=\"");
      out.print(ruta);
      out.write("\" id=\"ruta_principal\" name=\"ruta_principal\" />\n");
      out.write("            <input type=\"hidden\" value=\"");
      out.print(id_cc);
      out.write("\" id=\"txt_id_carta_comp\" name=\"txt_id_carta_comp\" />\n");
      out.write("        </form>\n");
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
