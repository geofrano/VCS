/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPA_EXT_PAS.eventos;

import PPA_EXT_PAS.dominio.Estudiante;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lpita
 */
public class Administrar_Estudiante {
    
    public Administrar_Estudiante(){
        super();
    }
    public void consulta_carta_compro(HttpServletResponse response, HttpServletRequest request) throws IOException{
        PrintWriter out = response.getWriter();
        ArrayList<Parametro> parametro = new ArrayList<>();
        String sql = "SELECT id_carta_comp, \n" +
                     "       secuencial, \n" +
                     "       \"Nomb_estudiante\",\n" +
                     "       nomb_empresa, \n" +
                     "       \"Lugar_suscripcion\",\n" +
                     "       \"Fecha_suscripcion\",\n" +
                     "       \"Estado\"\n" +
                     "  FROM \"VCS_CARTA_COMPROMISO\"\n" +
                     " WHERE UPPER(\"Nomb_estudiante\") LIKE UPPER('%' || ? || '%')";
        String nombre_estudiante=(String)request.getParameter("id_est");
        parametro.add(new Parametro(1, nombre_estudiante));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, parametro);
            out.println("<table class=\"table table-hover table-responsive\">\n");
            out.println("<tr>\n");
            out.println("<td>Id Carta Compromiso</td>\n");
            out.println("<td>No</td>\n");
            out.println("<td>Nombre Estudiante</td>\n");
            out.println("<td>Nombre Empresa</td>\n");
            out.println("<td>Lugar SuscripciÃ³n</td>\n");
            out.println("<td>Fecha SuscripciÃ³n</td>\n");
            out.println("<td>Estado del Tramite</td>\n");
            out.println("<td></td><td></td></tr>\n");
            while (cres.next()) {
                out.println("<tr>\n");
                out.println("<td>" + cres.getString(0) + "</td>\n");
                out.println("<td class=\"alineado3\">" + cres.getInt(1) + "</td>\n");
                out.println("<td>" + cres.getString(2) + "</td>\n");
                out.println("<td>" + cres.getString(3) + "</td>\n");
                out.println("<td>" + cres.getString(4) + "</td>\n");
                out.println("<td class=\"alineado3\">" + cres.getDate(5) + "</td>\n");
                out.println("<td class=\"alineado3\">" + cres.getString(6) + "</td>\n");
                out.println("<td class=\"alineado3\">"
                            + "<img width=\"20px\" height=\"20px\" src=\"../../images/icono_modifica.png\"/>"
                            + "</td>\n");
                out.println("<td class=\"alineado3\">"
                            + "<img width=\"20px\" height=\"20px\" src=\"../../images/eliminar.jpg\"/>"
                            + "</td>\n");
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (Exception e) {
            out.close();
            throw new RuntimeException(e);
        }
        
    }
}
