/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PPA_EXT_PAS.funciones_salida;

import PPA_EXT_PAS.dominio.Carta_Compromiso;
import PPA_EXT_PAS.dominio.Empresa;
import PPA_EXT_PAS.eventos.Administrar_Empresa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Geovanny Barrera
 */
@WebServlet(name = "F_genera_excel_empresas", urlPatterns = {"/F_genera_excel_empresas"})
public class F_genera_excel_empresas extends HttpServlet {

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
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=\"Listado_empresas.xls\"");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listado_empresas</title>");            
            out.println("</head>");
            Administrar_Empresa emp = new Administrar_Empresa();
            List< Empresa> empresas= emp.consulta_empresa("");
            out.println("<body>");
            out.println("<h3>Listado de Empresas</h3><br>");
            out.println("<table>");
            out.println("<th>Nombre de la empresa</th>");
            out.println("<th>Direccion</th>");
            out.println("<th>Telefono</th>");
            out.println("<th>Actividad Principal</th>");
            out.println("<th>Representante legal</th>");
            out.println("<th>Cargo del representante</th>");
            out.println("<th>Telefono del representante</th>");
            
            for (Iterator<Empresa> it = empresas.iterator(); it.hasNext();) {
                Empresa opciones = it.next();
                out.println("<tr>");
                out.println("<td>"+opciones.getNombre_empresa()+"</td>");
                out.println("<td>"+opciones.getDireccion()+"</td>");
                out.println("<td>"+opciones.getTelefono()+"</td>");
                out.println("<td>"+opciones.getActividad()+"</td>");
                out.println("<td>"+opciones.getNombre_repre()+" "+opciones.getApellido_repre()+"</td>");
                out.println("<td>"+opciones.getCargo_repre()+"</td>");
                out.println("<td>"+opciones.getTelefono_repre()+"</td>");
                out.println("</tr>");
            }
            
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
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
