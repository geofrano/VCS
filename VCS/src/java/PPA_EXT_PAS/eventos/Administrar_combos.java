/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPA_EXT_PAS.eventos;

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
 * @author Geovanny Barrera
 */
public class Administrar_combos {

    public Administrar_combos() {
        super();
    }

    //PINTA EL COMBO DE LAS CARRERAS
    public void obtiene_carreras(HttpServletResponse response, HttpServletRequest request) throws IOException {
        PrintWriter out = response.getWriter();
        String sql = "SELECT id_carrera, \"Nombre\"\n"
                + "  FROM \"VCS_CARRERAS\" where estado=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, "A"));
        try {

            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            //out.println("<td><label for=\"cmb_carrera\">Carrera de Grado: </label></td>\n");
            out.println("<select name=\"cmb_carrera\" id=\"cmb_carrera\" class=\"form-control\" >\n");
            while (cres.next()) {
                out.println("<option  value=\"" + cres.getInt(0) + "\">\n");
                out.println(cres.getString(1).trim());
                out.println("</option>");
            }
            out.println("</select>");
        } catch (Exception e) {
            out.close();
            throw new RuntimeException(e);
        }
    }

    //PINTA EL COMBO DE LOS PROGRAMAS
    public void obtiene_programas(HttpServletResponse response, HttpServletRequest request) throws IOException {
        PrintWriter out = response.getWriter();
        String sql = "SELECT valor\n"
                + "  FROM \"VCS_PARAMETROS\" WHERE id_parametro like 'PROGAMA_%'";

        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);
            out.println("<select name=\"cmb_programas\" id=\"cmb_programas\" class=\"form-control\" >\n");
            while (cres.next()) {
                out.println("<option  value=\"" + cres.getString(0).trim() + "\">\n");
                out.println(cres.getString(0).trim());
                out.println("</option>");
            }
            out.println("</select>");
        } catch (Exception e) {
            out.close();
            throw new RuntimeException(e);
        }
    }
    //PINTA EL COMBO DE LAS HORAS
    public void obtiene_horas(HttpServletResponse response, HttpServletRequest request) throws IOException {
        PrintWriter out = response.getWriter();
        String sql = "SELECT descripcion,valor\n"
                + "  FROM \"VCS_PARAMETROS\" WHERE id_parametro like 'HORAS_%'";

        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);
            out.println("<select name=\"cmb_horas\" id=\"cmb_horas\" class=\"form-control\" >\n");
            while (cres.next()) {
                out.println("<option  value=\"" + cres.getString(1).trim() + "\">\n");
                out.println(cres.getString(0).trim());
                out.println("</option>");
            }
            out.println("</select>");
        } catch (Exception e) {
            out.close();
            throw new RuntimeException(e);
        }
    }
    //PINTA EL COMBO DE LOS CICLOS
    public void obtiene_ciclos(HttpServletResponse response, HttpServletRequest request) throws IOException {
        PrintWriter out = response.getWriter();
        String sql = "SELECT valor\n"
                + "  FROM \"VCS_PARAMETROS\" WHERE id_parametro like 'CICLO_%'";

        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);
            out.println("<select name=\"cmb_ciclos\" id=\"cmb_ciclos\" class=\"form-control\" >\n");
            while (cres.next()) {
                out.println("<option  value=\"" + cres.getString(0).trim() + "\">\n");
                out.println(cres.getString(0).trim());
                out.println("</option>");
            }
            out.println("</select>");
        } catch (Exception e) {
            out.close();
            throw new RuntimeException(e);
        }
    }
    //PINTA EL COMBO DE LOS CICLOS
    public void obtiene_tipo_actividad(HttpServletResponse response, HttpServletRequest request) throws IOException {
        PrintWriter out = response.getWriter();
        String sql = "SELECT valor\n"
                + "  FROM \"VCS_PARAMETROS\" WHERE id_parametro like 'ACTIVIDAD_%'";

        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);
            out.println("<select name=\"cmb_tipo_actividad\" id=\"cmb_tipo_actividad\" class=\"form-control\" >\n");
            while (cres.next()) {
                out.println("<option  value=\"" + cres.getString(0).trim() + "\">\n");
                out.println(cres.getString(0).trim());
                out.println("</option>");
            }
            out.println("</select>");
        } catch (Exception e) {
            out.close();
            throw new RuntimeException(e);
        }
    }
}
