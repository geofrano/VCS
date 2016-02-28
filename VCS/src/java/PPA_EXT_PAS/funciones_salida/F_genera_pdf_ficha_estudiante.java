/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PPA_EXT_PAS.funciones_salida;

import PPA_EXT_PAS.dominio.Carta_Compromiso;
import PPA_EXT_PAS.eventos.Administrar_Ficha_Estudiante;
import PPA_EXT_PAS.eventos.GCB_GeneraPdf_ret_new;
import PPA_EXT_PAS.eventos.Genera_pdf;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import static java.util.Collections.list;
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
public class F_genera_pdf_ficha_estudiante extends HttpServlet {

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
        String cod_carta_comp=request.getParameter("txt_id_carta_comp").toString();
         ServletContext servletContext = request.getSession().getServletContext();
        String relativeWebPath = "images";
        String ruta_imagenes = servletContext.getRealPath(relativeWebPath);
        System.out.println("ruta_imagenes: " + ruta_imagenes);
        Administrar_Ficha_Estudiante ficha_est = new Administrar_Ficha_Estudiante();
        //out.print(Administrar_Ficha_Estudiante.toJSON(Administrar_Ficha_Estudiante.mostrar_carta_compromiso2(cod_carta_comp),tipo_accion));
        List< Carta_Compromiso> carta_comp= ficha_est.mostrar_carta_compromiso2(cod_carta_comp);
        float[] ls_dimension = new float[1];
         ls_dimension[0]=0.9f;
        if ((carta_comp.size() != 0)) {
                try {
                    //
                    // Template JSP file for iText
                    // by Tal Liron
                    //
                    response.setContentType("application/pdf");
                    
                    //Para que se muestre
                    response.setHeader("Content-Disposition", "inline; filename=Ficha_estudiante.pdf");

                    // step 1: creation of a document-object
                    Document document = new Document(PageSize.A4);

                    // step 2:
                    // we create a writer that listens to the document
                    // and directs a PDF-stream to a temporary buffer
                    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                    PdfWriter.getInstance(document, buffer);

                    // step 3: we open the document
                    

                    // step 4: envio el objeto para llenar las tablas en el pdf
                    Genera_pdf objTable = new Genera_pdf();
                    File directorio = new File("c:\\VCS\\");
                    if (!directorio.exists()){
                        directorio.mkdir();
                    }
                    
                    objTable.dibujaPdfsolRetiroEstado(document,ruta_imagenes, ls_dimension, carta_comp, "c:\\VCS\\");
                    
                    // step 5: we close the document
                    //document.close();

                    // step 6: we output the writer as bytes to the response output
                    byte[] bytes = buffer.toByteArray();
                    response.setContentLength(bytes.length);
                    
                    ServletOutputStream output = response.getOutputStream();
                    output.write(bytes, 0, bytes.length);
                    
                    output.flush();
                    output.close();
                    
                    
                    
                    
                    
                    
                    
                    
                    
                } catch (DocumentException e) {
                    // No se muestra nada 
                    //output.print("<script>alert('Error Interno')</script>");
                    //e.printStackTrace();
                    System.out.println("ERROR23");
                }
            } else {
                System.out.println("ERROR");
                //out.print("<div align = \"center\" > <font size = \"4\" face = \"Arial\" color = \"black\" > <b> < font size = \"2\" > No se encontró ningún registro</font > < / b > < / font > < / div>");
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
