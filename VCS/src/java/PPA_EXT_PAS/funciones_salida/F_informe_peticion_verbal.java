/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPA_EXT_PAS.funciones_salida;

import PPA_EXT_PAS.dominio.Informe_Peticion_Verbal_cab;
import PPA_EXT_PAS.eventos.GCB_GeneraPdf_ret_new;
import PPA_EXT_PAS.eventos.Informe_Peticion_Verbal;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lpita
 */
public class F_informe_peticion_verbal extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        //try (PrintWriter out = response.getWriter()) {
            
            Informe_Peticion_Verbal infor = new Informe_Peticion_Verbal();
            Informe_Peticion_Verbal_cab listaMovCab = null;
            java.util.List listaMovDet = new ArrayList();
            listaMovCab = infor.obtenerListaPdfCab();
            listaMovDet = infor.obtenerListaPdfDet();
            
            Informe_Peticion_Verbal_cab datos[]=null;  
            
            //String[] ls_cadena= new String[1];
            float[] ls_dimension = new float[1];
            
            /*datos=new Informe_Peticion_Verbal_cab[4];
            datos[0]=new Informe_Peticion_Verbal_cab();        
            datos[1]=new Informe_Peticion_Verbal_cab();
            datos[2]=new Informe_Peticion_Verbal_cab();
            datos[3]=new Informe_Peticion_Verbal_cab();
            
            datos[0].tipo=""; 
            datos[0].dato=listaMovCab.getCc_fecha_suscripcion();
            datos[1].tipo=""; 
            datos[1].dato=listaMovCab.getPa_director_vinculacion();
            datos[2].tipo="";
            datos[2].dato=listaMovCab.getPa_cargo();
            datos[3].tipo=""; 
            datos[3].dato=listaMovCab.getPa_institucion_sede();*/
            
            //ls_cadena[0]="";
            ls_dimension[0]=0.9f;
            if ((listaMovDet.size() != 0)) {
                try {
                    //
                    // Template JSP file for iText
                    // by Tal Liron
                    //
                    response.setContentType("application/pdf");
                    
                    //Para que se muestre
                    response.setHeader("Content-Disposition", "inline; filename=recep_estados.pdf");

                    // step 1: creation of a document-object
                    Document document = new Document(PageSize.A4.rotate());

                    // step 2:
                    // we create a writer that listens to the document
                    // and directs a PDF-stream to a temporary buffer
                    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                    PdfWriter.getInstance(document, buffer);

                    // step 3: we open the document
                    

                    // step 4: envio el objeto para llenar las tablas en el pdf
                    GCB_GeneraPdf_ret_new objTable = new GCB_GeneraPdf_ret_new();

                    objTable.dibujaPdfsolRetiroEstado(document, datos/*, ls_cadena*/, ls_dimension, listaMovDet, "B:\\Proyectos_Luis_Pita");

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
        //}
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(F_informe_peticion_verbal.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(F_informe_peticion_verbal.class.getName()).log(Level.SEVERE, null, ex);
        }
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
