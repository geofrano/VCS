/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPA_EXT_PAS.eventos;

import PPA_EXT_PAS.dominio.Menu_principal;
import PPA_EXT_PAS.dominio.Parametros;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Geovanny Barrera
 */
public class Administrar_combos {

    public Administrar_combos() {
        super();
    }
    
    //PINTA EL COMBO DE LAS CARRERAS
    public List<Parametros> obtiene_carreras() throws IOException {
        String sql = "SELECT PA_ID, PA_VALOR FROM \"MPP_PARAMETROS\" WHERE trim(PA_TIPO) = 'CA'";
        List< Parametros > opciones = new LinkedList< Parametros >();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);
            Parametros p;
            while (cres.next()) {
                p = new Parametros();
                p.setDescripcion(cres.getString(1).trim());
                p.setValor(cres.getString(0).trim());
                opciones.add(p);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return opciones;
    }

    //PINTA EL COMBO DE LOS PROGRAMAS
    public List<Parametros> obtiene_programas() throws IOException {
        String sql = "SELECT PA_ID, PA_VALOR FROM \"MPP_PARAMETROS\" WHERE trim(PA_TIPO) = 'PR'";
        List< Parametros > opciones = new LinkedList< Parametros >();
        
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);
            //out.println("<select name=\"cmb_programas\" id=\"cmb_programas\" class=\"form-control\" >\n");
            Parametros p;
            while (cres.next()) {
                /*out.println("<option  value=\"" + cres.getString(0).trim() + "\">\n");
                out.println(cres.getString(1).trim());
                out.println("</option>");*/
                p = new Parametros();
                p.setDescripcion(cres.getString(1).trim());
                p.setValor(cres.getString(0).trim());
                opciones.add(p);
            }
            //out.println("</select>");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return opciones;
    }
    //PINTA EL COMBO DE LAS HORAS
    public List<Parametros> obtiene_horas() throws IOException {
        String sql = "SELECT PA_ID, PA_VALOR FROM \"MPP_PARAMETROS\" WHERE trim(PA_TIPO) = 'HO'";
        List< Parametros > opciones = new LinkedList< Parametros >();
        try {    
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);
            //out.println("<select name=\"cmb_horas\" id=\"cmb_horas\" class=\"form-control\" >\n");
            Parametros p;
            while (cres.next()) {
                p = new Parametros();
                p.setDescripcion(cres.getString(1).trim());
                p.setValor(cres.getString(0).trim());
                opciones.add(p);
            }
            //out.println("</select>");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return opciones;
    }
    //PINTA EL COMBO DE LOS CICLOS
    public List<Parametros> obtiene_ciclos() throws IOException {
        String sql = "SELECT PA_ID, PA_VALOR FROM \"MPP_PARAMETROS\" WHERE trim(PA_TIPO) = 'CI'";
        List< Parametros > opciones = new LinkedList< Parametros >();
        try {             
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);
            //out.println("<select name=\"cmb_ciclos\" id=\"cmb_ciclos\" class=\"form-control\" >\n");
            Parametros p;
            while (cres.next()) {
                p = new Parametros();
                p.setDescripcion(cres.getString(1).trim());
                p.setValor(cres.getString(0).trim());
                opciones.add(p);
            }
            //out.println("</select>");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return opciones;
    }
    //PINTA EL COMBO DE LAS ACTIVIDADES
    public List<Parametros> obtiene_tipo_actividad() throws IOException {
        String sql = "SELECT PA_ID, PA_VALOR FROM \"MPP_PARAMETROS\" WHERE trim(PA_TIPO) = 'AC'";
        List< Parametros > opciones = new LinkedList< Parametros >();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);
            //out.println("<select name=\"cmb_tipo_actividad\" id=\"cmb_tipo_actividad\" class=\"form-control\" onchange=\"carga_codigo()\">\n");
            Parametros p;
            while (cres.next()) {
                p = new Parametros();
                p.setDescripcion(cres.getString(1).trim());
                p.setValor(cres.getString(0).trim());
                opciones.add(p);
            }
            //out.println("</select>");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return opciones;
    }
    //PINTA EL COMBO DE LAS CARRERAS
    public List<Parametros> obtiene_tutores(String carrera) throws IOException {
        String sql = "select us_nombre || ' ' || us_apellido as nombre, us_cargo from \"MAU_USUARIO\" where trim(us_cargo) = 'TUTOR_' || trim(?)";
        List< Parametros > opciones = new LinkedList< Parametros >();
        ArrayList<Parametro> parametro = new ArrayList<>();
        parametro.add(new Parametro(1, carrera));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,parametro);
            Parametros p;
            while (cres.next()) {
                p = new Parametros();
                p.setDescripcion(cres.getString(0).trim());
                p.setValor(cres.getString(1).trim());
                opciones.add(p);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return opciones;
    }
    //PINTA EL COMBO DE LOS TIPOS DE EMPRESA
    public List<Parametros> obtiene_tipo_empresa() throws IOException {
        String sql = "SELECT PA_ID, PA_VALOR FROM \"MPP_PARAMETROS\" WHERE trim(PA_TIPO) = 'TP'";
        List< Parametros > opciones = new LinkedList< Parametros >();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);
            Parametros p;
            while (cres.next()) {
                p = new Parametros();
                p.setDescripcion(cres.getString(1).trim());
                p.setValor(cres.getString(0).trim());
                opciones.add(p);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return opciones;
    }
    public static JSONObject toJSONObject(Parametros parametro) {
        JSONObject json = new JSONObject();
        try {
            json.put("valor", parametro.getValor());
            json.put("descripcion", parametro.getDescripcion());
            
        } catch (JSONException ex) {
            Logger.getLogger(Menu_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
    public static JSONObject toJSON(List< Parametros >  parametro) {
        JSONObject json = new JSONObject();
        try {
            JSONArray jsonItems = new JSONArray();
            for (Iterator<Parametros> it = parametro.iterator(); it.hasNext();) {
                Parametros opciones = it.next();
                jsonItems.put( toJSONObject( opciones ) );
            }
            json.put("items", jsonItems);
        } catch (JSONException ex) {
            Logger.getLogger(Menu_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
}
