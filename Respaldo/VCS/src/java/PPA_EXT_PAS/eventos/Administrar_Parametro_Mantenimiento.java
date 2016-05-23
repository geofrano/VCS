/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPA_EXT_PAS.eventos;

import PPA_EXT_PAS.dominio.Empresa;
import PPA_EXT_PAS.dominio.Menu_principal;
import PPA_EXT_PAS.dominio.Parametro_Mantenimiento;
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
public class Administrar_Parametro_Mantenimiento {
    
    private Parametro_Mantenimiento parametro;
    
    private Administrar_Parametro_Mantenimiento(){
        super();
    }
    
    public Administrar_Parametro_Mantenimiento(HttpServletRequest request) {
        this.parametro = new Parametro_Mantenimiento();
        this.parametro.setId_parametro((String) request.getParameter("txt_id_parametro"));
        this.parametro.setDescripcion((String) request.getParameter("txt_descripcion"));
        this.parametro.setValor((String) request.getParameter("txt_valor"));
        this.parametro.setTipo((String) request.getParameter("cmb_tipo_para"));
    }
    
    public String procesar_parametro(String accion) {
        ArrayList<Parametro> parametros = new ArrayList<>();
        String res = "";
        String sql = "select f_inserta_parametro(?,?,?,?,?)";
        parametros.add(new Parametro(1, this.parametro.getId_parametro()));
        parametros.add(new Parametro(2, this.parametro.getDescripcion()));
        parametros.add(new Parametro(3, this.parametro.getValor()));
        parametros.add(new Parametro(4, this.parametro.getTipo()));
        parametros.add(new Parametro(5, accion));
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
    
    public String elimina_parametro() {
        ArrayList<Parametro> parametros = new ArrayList<>();
        String res = "NO";
        String sql = "DELETE FROM \"MPP_PARAMETROS\" \n" +
                      "WHERE trim(pa_id) = trim(?)";
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
    
    public static List<Parametro_Mantenimiento> consulta_parametro(String descripcion, String tipo) throws IOException{
        List<Parametro_Mantenimiento> datos = new LinkedList<Parametro_Mantenimiento>();
        
        ArrayList<Parametro> parametro = new ArrayList<>();
        String sql = "select pa_id,\n" +
                     "       pa_descripcion,\n" +
                     "       pa_valor,\n" +
                     "       pa_tipo,\n" +
                     "       pt_descripcion\n" +
                     "  from \"MPP_PARAMETROS\",\n" +
                     "       \"MPP_PARAMETROS_TIPOS\"\n" +
                     " where pa_tipo = pt_tipo\n" +
                     "   and upper(trim(pa_descripcion)) like upper('%'||trim(?)||'%')\n" +
                     "   and case when ? = 'TD' then\n" +
                     "      pa_tipo = pa_tipo\n" +
                     "   else\n" +
                     "      pa_tipo = ? \n" +
                     "   end \n" +
                     "   and pa_tipo <> 'TT' \n" +
                     " order by 5, 1";
        
        
        parametro.add(new Parametro(1, descripcion));
        parametro.add(new Parametro(2, tipo));
        parametro.add(new Parametro(3, tipo));
        Parametro_Mantenimiento par_mante;
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, parametro);
  
            while (cres.next()) {
                par_mante = new Parametro_Mantenimiento();
                par_mante.setId_parametro(cres.getString(0).trim());
                par_mante.setDescripcion(cres.getString(1).trim());
                par_mante.setValor(cres.getString(2).trim());
                par_mante.setTipo(cres.getString(3).trim());
                par_mante.setTipo_des(cres.getString(4).trim());
                datos.add(par_mante);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return datos;
    }
    
    public static List<Parametro_Mantenimiento> consulta_tutor(String nombre, String carrera) throws IOException{
        List<Parametro_Mantenimiento> datos = new LinkedList<Parametro_Mantenimiento>();
        
        ArrayList<Parametro> parametro = new ArrayList<>();
        String sql = "select pa_id,\n" +
                     "       pa_descripcion,\n" +
                     "       pa_valor,\n" +
                     "       a.id_carrera,\n" +
                     "       a.carrera_desc\n" +
                     "  from \"MPP_PARAMETROS\",\n" +
                     "       \"MPP_PARAMETROS_TIPOS\",\n" +
                     "       (select pa_id id_carrera,\n" +
                     "               trim(pa_descripcion) carrera_desc\n" +
                     "          from \"MPP_PARAMETROS\" \n" +
                     "         where pa_tipo = 'CA' \n" +
                     "           and case when ? = 'TD' then\n" +
                     "                 pa_id = pa_id\n" +
                     "               else\n" +
                     "                 pa_id = ?\n" +
                     "               end) a\n" +
                     "  where pa_tipo = 'TUTOR_'||a.id_carrera\n" +
                     "    and pa_tipo = pt_tipo\n" +
                     "    and upper(trim(pa_valor)) like upper('%'||trim(?)||'%')\n" +
                     "    and case when ? = 'TD' then\n" +
                     "          pa_id = pa_id\n" +
                     "        else\n" +
                     "          pa_id = 'TUTOR_'||?\n" +
                     "        end\n" +
                     "  order by 5, 1";
        
        parametro.add(new Parametro(1, carrera));
        parametro.add(new Parametro(2, carrera));
        parametro.add(new Parametro(3, nombre));
        parametro.add(new Parametro(4, carrera));
        parametro.add(new Parametro(5, carrera));
        Parametro_Mantenimiento par_mante;
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, parametro);
  
            while (cres.next()) {
                par_mante = new Parametro_Mantenimiento();
                par_mante.setId_parametro(cres.getString(0).trim());
                par_mante.setDescripcion(cres.getString(1).trim());
                par_mante.setValor(cres.getString(2).trim());
                par_mante.setTipo(cres.getString(3).trim());
                par_mante.setTipo_des(cres.getString(4).trim());
                datos.add(par_mante);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return datos;
    }
    
    public static JSONObject toJSONObject(Parametro_Mantenimiento par_mante) {
        JSONObject json = new JSONObject();
        try {
            json.put("id_parametro", par_mante.getId_parametro());
            json.put("descripcion", par_mante.getDescripcion());
            json.put("valor", par_mante.getValor());
            json.put("tipo", par_mante.getTipo());
            json.put("tipo_desc", par_mante.getTipo_des());
        } catch (JSONException ex) {
            Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }

    public static JSONObject toJSON(List<Parametro_Mantenimiento> dato) {
        JSONObject json = new JSONObject();
        try {
            JSONArray jsonItems = new JSONArray();
            for (Iterator<Parametro_Mantenimiento> it = dato.iterator(); it.hasNext();) {
                Parametro_Mantenimiento campo = it.next();
                jsonItems.put(toJSONObject(campo));
            }

            json.put("items", jsonItems);

        } catch (JSONException ex) {
            Logger.getLogger(Menu_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
}
