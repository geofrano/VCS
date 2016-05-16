/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPA_EXT_PAS.eventos;

import PPA_EXT_PAS.dominio.Carta_Compromiso;
import PPA_EXT_PAS.dominio.Estudiante;
import PPA_EXT_PAS.dominio.Menu_principal;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author lpita
 */
public class Administrar_Estudiante {
    String existe_data;
    
    public Administrar_Estudiante(){
        super();
    }
    public static List<Carta_Compromiso> consulta_carta_compro(String nombre_estudiante) throws IOException{
        List<Carta_Compromiso> datos = new LinkedList<Carta_Compromiso>();
        
        ArrayList<Parametro> parametro = new ArrayList<>();
        String sql = "SELECT cc_id, \n" +
                     "   es_apellido||' '||es_nombre,\n" +
                     "       'PEND',\n" +
                     "       cc_lugar_suscripcion, \n" +
                     "       to_char(cc_fecha_suscripcion,'dd/mm/yyyy'), \n" +
                     "       cc_estado,\n" +
                     "    tipo_act.pa_valor"+
                     "  FROM \"MPP_CARTA_COMPROMISO\" CC,\n" +
                     "       \"MPP_ESTUDIANTES\" ES,\n" +
                     "       \"MPP_PARAMETROS\" tipo_act"+
                     " WHERE CC.es_id = ES.es_id\n" +
                     "   AND cc.cc_tipo_actividad = tipo_act.pa_id "+
                     "   AND tipo_act.pa_tipo = 'AC'"+
                     "   AND (UPPER(es_nombre) LIKE UPPER('%' || ? || '%') \n" +
                     "	OR UPPER(es_apellido) LIKE UPPER('%' || ? || '%'))";
        
        
        parametro.add(new Parametro(1, nombre_estudiante));
        parametro.add(new Parametro(2, nombre_estudiante));
        Carta_Compromiso carta_comp;
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, parametro);
  
            while (cres.next()) {
                carta_comp = new Carta_Compromiso();
                carta_comp.setId_carta_compromiso(cres.getString(0).trim());
                carta_comp.setNomb_estudiante(cres.getString(1).trim());
                carta_comp.setNomb_empresa(cres.getString(2).trim());
                carta_comp.setLugar_suscripcion(cres.getString(3).trim());
                carta_comp.setFecha_suscripcion(cres.getString(4).trim());
                carta_comp.setEstado(cres.getString(5).trim());
                carta_comp.setTipo_actividad(cres.getString(6).trim());
                System.out.println("EST: "+cres.getString(1).trim());
                datos.add(carta_comp);
                
            }

            //out.println("</table>");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return datos;
    }
    public static JSONObject toJSONObject(Carta_Compromiso carta_comp) {
        JSONObject json = new JSONObject();
        try {
            json.put("id_cc", carta_comp.getId_carta_compromiso());
            json.put("nomb_est", carta_comp.getNomb_estudiante());
            json.put("emp_nombre", carta_comp.getNomb_empresa());
            json.put("lugar_suscrip", carta_comp.getLugar_suscripcion());
            json.put("fecha_suscrip", carta_comp.getFecha_suscripcion());
            json.put("cc_estado", carta_comp.getEstado());
            json.put("cc_tipo_act", carta_comp.getTipo_actividad());
        } catch (JSONException ex) {
            Logger.getLogger(Carta_Compromiso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
    public static JSONObject toJSON(List< Carta_Compromiso >  dato) {
        JSONObject json = new JSONObject();
        try {
            JSONArray jsonItems = new JSONArray();
            for (Iterator<Carta_Compromiso> it = dato.iterator(); it.hasNext();) {
                Carta_Compromiso campo = it.next();
                jsonItems.put( toJSONObject( campo ) );
            }

            json.put("items", jsonItems);
            
        } catch (JSONException ex) {
            Logger.getLogger(Menu_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
}
