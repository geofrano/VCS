/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PPA_EXT_PAS.funciones_entrada;

import PPA_EXT_PAS.eventos.Autentificar_Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Geovanny Barrera
 */
public class F_autenticar_usuario extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public F_autenticar_usuario(){
        super();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession sesion = request.getSession();
            String usuario=request.getParameter("txt_usuario").toString();
            String clave=request.getParameter("txt_clave").toString();
            boolean lb_login=false;
            
            if (sesion.getAttribute("usuario") == null){
                Autentificar_Usuario autentica = new Autentificar_Usuario();
                
                lb_login=autentica.autenticaUsuario(usuario,clave);

                if (lb_login){
                    sesion.setAttribute("usuario", autentica.getAdmin().getUs_usuario());
                    sesion.setAttribute("nombre_usuario", autentica.getAdmin().getUs_nombre());
                    sesion.setAttribute("direccion_usuario", autentica.getAdmin().getUs_direccion());
                    sesion.setAttribute("apellido_usuario", autentica.getAdmin().getUs_apellido());
                    sesion.setAttribute("cargo_usuario", autentica.getAdmin().getUs_cargo());
                    //sesion.setAttribute("email_usuario", autentica.getAdmin().getUs_email());
                    
                    System.out.println("SE CONECTO");
                    response.sendRedirect(response.encodeRedirectURL("Home.jsp"));
                    //sesion.setAttribute("nombre_usuario", "administrador");
                    //sesion.setAttribute("apellido_usuario", "de VCS");
                }else{
                    sesion.setAttribute("usuario", null);
                    sesion.setAttribute("nombre_usuario", null);
                    sesion.setAttribute("direccion_usuario", null);
                    sesion.setAttribute("apellido_usuario", null);
                    sesion.setAttribute("cargo_usuario", null);
                    //response.getWriter().write("NO");
                }
                
                
                /*RequestDispatcher a=request.getRequestDispatcher("Index2.jsp");
				a.forward(request, response);*/
            }else{
                System.out.println("YA ESTA CONECTADO");
                response.sendRedirect(response.encodeRedirectURL("Home.jsp"));
            }
            
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
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
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
