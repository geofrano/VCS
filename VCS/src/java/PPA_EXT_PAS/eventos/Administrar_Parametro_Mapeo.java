/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPA_EXT_PAS.eventos;

import PPA_EXT_PAS.dominio.Empresa;
import PPA_EXT_PAS.dominio.Menu_principal;
import PPA_EXT_PAS.dominio.Parametro_Mantenimiento;
import PPA_EXT_PAS.dominio.Parametro_Mapeo;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Hp
 */
public class Administrar_Parametro_Mapeo {
    
    private Parametro_Mapeo parametro;
    
    private Administrar_Parametro_Mapeo(){
        super();
    }
    
    public Administrar_Parametro_Mapeo(HttpServletRequest request) {
        this.parametro = new Parametro_Mapeo();
        this.parametro.setId_parametro((String) request.getParameter("txt_id_parametro"));
        this.parametro.setId_actividad((String) request.getParameter("cmb_actividad_in"));
        this.parametro.setId_horas((String) request.getParameter("cmb_horas_in"));
    }
    
    public String procesar_mapeo(String accion) {
        ArrayList<Parametro> parametros = new ArrayList<>();
        String res = "";
        String sql = "select f_inserta_mapeo(?,?,?,?)";
        parametros.add(new Parametro(1, this.parametro.getId_parametro()));
        parametros.add(new Parametro(2, this.parametro.getId_actividad()));
        parametros.add(new Parametro(3, this.parametro.getId_horas()));
        parametros.add(new Parametro(4, accion));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, parametros);
            while (cres.next()) {
                res = cres.getString(0);
            }
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            throw new RuntimeException(e);
        }
        return res;
    }
    
    public static List<Parametro_Mapeo> consulta_mapeo(String actividad, String hora) throws IOException{
        List<Parametro_Mapeo> datos = new LinkedList<Parametro_Mapeo>();
        
        ArrayList<Parametro> parametro = new ArrayList<>();
        String sql = "select M.mp_id,\n" +
                     "       M.mp_id_actividad,\n" +
                     "       A.pa_valor desc_actividad,\n" +
                     "       M.mp_id_horas,\n" +
                     "       B.pa_valor desc_horas\n" +
                     "  from \"MPP_MAPEO_PARAMETROS\" M,\n" +
                     "       \"MPP_PARAMETROS\" A,\n" +
                     "       \"MPP_PARAMETROS\" B\n" +
                     " where A.pa_id = M.mp_id_actividad\n" +
                     "   and A.pa_tipo = 'AC'\n" +
                     "   and case when ? = 'TD' then\n" +
                     "         A.pa_id = A.pa_id\n" +
                     "       else\n" +
                     "         A.pa_id = ? \n" +
                     "       end\n" +
                     "   and B.pa_id = M.mp_id_horas\n" +
                     "   and B.pa_tipo = 'HO'\n" +
                     "   and case when ? = 'TD' then\n" +
                     "         B.pa_id = B.pa_id\n" +
                     "       else\n" +
                     "         B.pa_id = ? \n" +
                     "       end";
        
        
        parametro.add(new Parametro(1, actividad));
        parametro.add(new Parametro(2, actividad));
        parametro.add(new Parametro(3, hora));
        parametro.add(new Parametro(4, hora));
        Parametro_Mapeo par_mapeo;
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, parametro);
  
            while (cres.next()) {
                par_mapeo = new Parametro_Mapeo();
                par_mapeo.setId_parametro(cres.getString(0).trim());
                par_mapeo.setId_actividad(cres.getString(1).trim());
                par_mapeo.setDesc_actividad(cres.getString(2).trim());
                par_mapeo.setId_horas(cres.getString(3).trim());
                par_mapeo.setDesc_horas(cres.getString(4).trim());
                datos.add(par_mapeo);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return datos;
    }
    
    public static List<Parametro_Mapeo> consulta_codigo_mapeo() throws IOException{
        List<Parametro_Mapeo> datos = new LinkedList<Parametro_Mapeo>();
        
        ArrayList<Parametro> parametro = new ArrayList<>();
        String sql = "select coalesce(to_number(max(trim(mp_id)),'099999999') + 1, 1)\n" +
                     "  from \"MPP_MAPEO_PARAMETROS\"\n" +
                     " group by mp_id;";
        
        Parametro_Mapeo par_mante;
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);
  
            while (cres.next()) {
                par_mante = new Parametro_Mapeo();
                par_mante.setId_parametro(cres.getString(0).trim());
                datos.add(par_mante);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return datos;
    }
    
    public String elimina_mapeo() {
        ArrayList<Parametro> parametros = new ArrayList<>();
        String res = "NO";
        String sql = "DELETE FROM \"MPP_MAPEO_PARAMETROS\" \n" +
                      "WHERE trim(mp_id) = trim(?)";
        parametros.add(new Parametro(1, this.parametro.getId_parametro()));
        try {
            boolean cres = AccesoDatos.ejecutaComando(sql, parametros);
            System.out.println("Boolean: "+cres);
            if (cres == true) {
                res = "SI";
            }
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            throw new RuntimeException(e);
        }
        return res;
    }
    
    public static JSONObject toJSONObject(Parametro_Mapeo par_mante) {
        JSONObject json = new JSONObject();
        try {
            json.put("id_parametro", par_mante.getId_parametro());
            json.put("id_actividad", par_mante.getId_actividad());
            json.put("desc_actividad", par_mante.getDesc_actividad());
            json.put("id_horas", par_mante.getId_horas());
            json.put("desc_horas", par_mante.getDesc_horas());
        } catch (JSONException ex) {
            Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }

    public static JSONObject toJSON(List<Parametro_Mapeo> dato) {
        JSONObject json = new JSONObject();
        try {
            JSONArray jsonItems = new JSONArray();
            for (Iterator<Parametro_Mapeo> it = dato.iterator(); it.hasNext();) {
                Parametro_Mapeo campo = it.next();
                jsonItems.put(toJSONObject(campo));
            }

            json.put("items", jsonItems);

        } catch (JSONException ex) {
            Logger.getLogger(Menu_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
}
