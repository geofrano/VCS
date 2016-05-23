/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PPA_EXT_PAS.funciones_salida;

import PPA_EXT_PAS.dominio.Carta_Compromiso;
import PPA_EXT_PAS.eventos.Administrar_Ficha_Estudiante;
import PPA_EXT_PAS.eventos.Genera_pdf;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Geovanny Barrera
 */
public class F_genera_pdf_informe_estudiante extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String cod_carta_comp = request.getParameter("txt_id_carta_comp").toString();
            String institucion = request.getParameter("txt_institucion").toString();
            String sede = request.getParameter("txt_sede").toString();
            ServletContext servletContext = request.getSession().getServletContext();
            String relativeWebPath = "images";
            String relativeWebPathArchivos = "archivos";
            String ruta_imagenes = servletContext.getRealPath(relativeWebPath);
            System.out.println("ruta_imagenes: " + ruta_imagenes);
            Administrar_Ficha_Estudiante ficha_est = new Administrar_Ficha_Estudiante();
            //out.print(Administrar_Ficha_Estudiante.toJSON(Administrar_Ficha_Estudiante.mostrar_carta_compromiso2(cod_carta_comp),tipo_accion));
            List< Carta_Compromiso> carta_comp = ficha_est.mostrar_carta_compromiso2(cod_carta_comp);
            float[] ls_dimension = new float[1];
            ls_dimension[0] = 0.9f;
            if ((carta_comp.size() != 0)) {
                try {
                    response.setContentType("application/pdf");

                    //Para que se muestre
                    response.setHeader("Content-Disposition", "inline; filename=Informe_Estudiante.pdf");

                    // Creamos el documento con formato A4 vertical
                    Document document = new Document(PageSize.A4/*,100, 100, 45, 40*/);

                    // Asignamos a un buffer temporal el documento
                    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                    PdfWriter.getInstance(document, buffer);

                    //Llamo a la clase que genera el pdf
                    Genera_pdf objTable = new Genera_pdf();
                    /*File directorio = new File("c:\\VCS\\");//Se guarda el documento en el repositorio local
                     if (!directorio.exists()){
                     directorio.mkdir();
                     }*/

                    objTable.dibujaPdfInformeEstudiante(document, ruta_imagenes, ls_dimension, carta_comp, relativeWebPathArchivos, cod_carta_comp, institucion, sede);

                    //Abrimos el pdf en el navegador para que se pueda visualizar
                    byte[] bytes = buffer.toByteArray();
                    response.setContentLength(bytes.length);

                    ServletOutputStream output = response.getOutputStream();
                    output.write(bytes, 0, bytes.length);

                    output.flush();
                    output.close();
                    Administrar_Ficha_Estudiante ficha = new Administrar_Ficha_Estudiante();
                    
                    String estado=ficha.obtiene_estadoCartaCompromiso(cod_carta_comp);
                    if (estado.equals("8")){
                        String actualiza = ficha.actualiza_estado_cc(cod_carta_comp, "9");
                    }
                } catch (DocumentException e) {
                    // No se muestra nada 
                    //output.print("<script>alert('Error Interno')</script>");
                    e.printStackTrace();
                    System.out.println("ERROR " + e);
                }
            } else {
                System.out.println("ERROR");
                //out.print("<div align = \"center\" > <font size = \"4\" face = \"Arial\" color = \"black\" > <b> < font size = \"2\" > No se encontró ningún registro</font > < / b > < / font > < / div>");
            }
        } catch (Exception e) {
            response.sendRedirect(response.encodeRedirectURL("/VCS/Administracion_de_Carrera/Informe_del_Estudiante/informe_estudiante.jsp"));
        }
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
