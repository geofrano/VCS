/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPA_EXT_PAS.eventos;

import PPA_EXT_PAS.dominio.Estudiantes;
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

    public static List<Estudiantes> mostrar_estudiantes() {
        List< Estudiantes> estudiantes = new LinkedList< Estudiantes>();

        String sql = "SELECT nombre_completo, identificacion\n"
                + "  FROM \"VCS_ESTUDIANTES\"";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        //lstPar.add(new Parametro(1, "0"));
        Estudiantes adm_est;
        try {
            ConjuntoResultado cres
                    = AccesoDatos.ejecutaQuery(sql/*,lstPar*/);
            while (cres.next()) {
                adm_est = new Estudiantes();
                adm_est.setNombre_completo(cres.getString(0).trim());
                adm_est.setCedula(cres.getString(1).trim());

                estudiantes.add(adm_est);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return estudiantes;
    }

    public static JSONObject toJSONObject(Estudiantes estudiantes) {
        JSONObject json = new JSONObject();
        try {
            json.put("nomb_est", estudiantes.getNombre_completo());
            json.put("cedula", estudiantes.getCedula());

        } catch (JSONException ex) {
            Logger.getLogger(Menu_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }

    public static JSONObject toJSON(List< Estudiantes> est) {
        JSONObject json = new JSONObject();
        try {
            JSONArray jsonItems = new JSONArray();
            for (Iterator<Estudiantes> it = est.iterator(); it.hasNext();) {
                Estudiantes opciones = it.next();
                jsonItems.put(toJSONObject(opciones));
            }

            json.put("items", jsonItems);
        } catch (JSONException ex) {
            Logger.getLogger(Menu_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
}
