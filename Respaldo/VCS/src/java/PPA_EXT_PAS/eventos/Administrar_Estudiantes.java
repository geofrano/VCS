/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPA_EXT_PAS.eventos;

import PPA_EXT_PAS.dominio.Estudiantes;
import PPA_EXT_PAS.dominio.Ficha_Estudiante;
import PPA_EXT_PAS.dominio.Menu_principal;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Geovanny Barrera
 */
public class Administrar_Estudiantes {

    public static List<Ficha_Estudiante> mostrar_estudiantes(String estudiante,String cedula) {
        List< Ficha_Estudiante> estudiantes = new LinkedList< Ficha_Estudiante>();

        String sql= "SELECT es_id, es_nombre, es_apellido, es_cedula, \n" +
                    "       trim(carrera.pa_descripcion),trim(a.es_id_carrera), " +
                    "       trim(ciclo.pa_descripcion),trim(es_id_ciclo)\n" +
                    "   FROM \"MPP_ESTUDIANTES\" a,\n" +
                    "	\"MPP_PARAMETROS\" carrera,\n" +
                    "	\"MPP_PARAMETROS\" ciclo\n" +
                    " WHERE trim(a.es_id_carrera) = trim(carrera.pa_id)\n" +
                    "   and trim(a.es_id_ciclo) = trim(ciclo.pa_id)\n" +
                    "   and (\n" +
                    "	UPPER(trim(a.es_nombre)) like UPPER('%' || ? || '%') or\n" +
                    "	UPPER(trim(a.es_apellido)) like UPPER('%' || ? || '%')\n" +
                    "        )\n"+
                    "   and es_cedula = case when COALESCE(?,es_cedula) = '' then es_cedula else COALESCE(?,es_cedula) end";
        
        //System.out.println("SQL: " +sql);
        //System.out.println("CEDULA "+cedula);

        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, estudiante));
        lstPar.add(new Parametro(2, estudiante));
        lstPar.add(new Parametro(3, cedula));
        lstPar.add(new Parametro(4, cedula));
        Ficha_Estudiante adm_est;
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                adm_est = new Ficha_Estudiante();
                adm_est.setId_estudiante(cres.getString(0).trim());
                adm_est.setNombre_estudiante(cres.getString(2).trim()+" "+cres.getString(1).trim());                                
                adm_est.setCedula(cres.getString(3).trim());
                adm_est.setCarrera(cres.getString(4).trim());
                adm_est.setId_carrera(cres.getString(5).trim());
                adm_est.setCiclo(cres.getString(6).trim());
                adm_est.setId_ciclo(cres.getString(7).trim());
                
                estudiantes.add(adm_est);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return estudiantes;
    }

    public static JSONObject toJSONObject(Ficha_Estudiante estudiantes) {
        JSONObject json = new JSONObject();
        try {
            json.put("id_est", estudiantes.getId_estudiante());
            json.put("nomb_est", estudiantes.getNombre_estudiante());
            json.put("cedula", estudiantes.getCedula());
            json.put("carrera", estudiantes.getCarrera());
            json.put("id_carrera", estudiantes.getId_carrera());
            json.put("ciclo", estudiantes.getCiclo());
            json.put("id_ciclo", estudiantes.getId_ciclo());

        } catch (JSONException ex) {
            Logger.getLogger(Menu_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }

    public static JSONObject toJSON(List< Ficha_Estudiante> est) {
        JSONObject json = new JSONObject();
        try {
            JSONArray jsonItems = new JSONArray();
            for (Iterator<Ficha_Estudiante> it = est.iterator(); it.hasNext();) {
                Ficha_Estudiante opciones = it.next();
                jsonItems.put(toJSONObject(opciones));
            }

            json.put("items", jsonItems);
        } catch (JSONException ex) {
            Logger.getLogger(Menu_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
}
