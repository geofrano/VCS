/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPA_EXT_PAS.eventos;

import PPA_EXT_PAS.dominio.Empresa;
import PPA_EXT_PAS.dominio.Menu_principal;
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
public class Administrar_Empresa {

    private Empresa empresa;

    public Administrar_Empresa() {
        super();

    }

    public Administrar_Empresa(HttpServletRequest request) {
        this.empresa = new Empresa();
        this.empresa.setUe_id((String) request.getParameter("id_ue"));
        this.empresa.setAr_id((String) request.getParameter("id_ar"));
        this.empresa.setNombre_empresa((String) request.getParameter("txt_nom_empresa_ing"));
        this.empresa.setDireccion((String) request.getParameter("txt_direccion_ing"));
        this.empresa.setTelefono((String) request.getParameter("txt_telefono_ing"));
        this.empresa.setActividad((String) request.getParameter("txt_actividad_empresa_ing"));
        this.empresa.setTipo_empresa((String) request.getParameter("cmb_tipo_emp"));
        this.empresa.setNombre_repre((String) request.getParameter("txt_nombre_repr_legal_ing"));
        this.empresa.setApellido_repre((String) request.getParameter("txt_apellido_repr_legal_ing"));
        this.empresa.setCargo_repre((String) request.getParameter("txt_cargo_repr_legal_ing"));
        this.empresa.setTelefono_repre((String) request.getParameter("txt_fono_repr_legal_ing"));
    }

    public String procesar_empresa(String accion) {
        ArrayList<Parametro> parametros = new ArrayList<>();
        String res = "";
        String sql = "select f_inserta_empresa(?,?,?,?,?,?,?,?,?,?,?,?)";
        parametros.add(new Parametro(1, this.empresa.getUe_id()));
        parametros.add(new Parametro(2, this.empresa.getAr_id()));
        parametros.add(new Parametro(3, this.empresa.getNombre_empresa()));
        parametros.add(new Parametro(4, this.empresa.getDireccion()));
        parametros.add(new Parametro(5, this.empresa.getTelefono()));
        parametros.add(new Parametro(6, this.empresa.getActividad()));
        parametros.add(new Parametro(7, this.empresa.getTipo_empresa()));
        parametros.add(new Parametro(8, this.empresa.getNombre_repre()));
        parametros.add(new Parametro(9, this.empresa.getApellido_repre()));
        parametros.add(new Parametro(10, this.empresa.getCargo_repre()));
        parametros.add(new Parametro(11, this.empresa.getTelefono_repre()));
        parametros.add(new Parametro(12, accion));
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

    public static List<Empresa> consulta_empresa(String empresa) throws IOException{
        List<Empresa> datos = new LinkedList<Empresa>();
        
        ArrayList<Parametro> parametro = new ArrayList<>();
        String sql = "select ue.ue_id,\n"+
                     "       ar.ar_id,\n" +
                     "       ue.ue_nombre,\n" +
                     "       ue.ue_direccion,\n" +
                     "       ue.ue_telefono,\n" +
                     "       ue.ue_actividad_principal,\n" +
                     "       ar.ar_nombre as nom_representante,\n" +
                     "       ar.ar_apellido as apell_representante,\n" +
                     "       ar.ar_cargo, \n" +
                     "       ar.ar_telefono as telefono_repre \n" +
                     "  from \"MPP_UNIDAD_EXTERNA\" ue,\n" +
                     "       \"MPP_AGREGAR_REPRESENTANTE\" ar\n" +
                     " where ue.ue_id = ar.ue_id\n" +
                     "   and upper(ue.ue_nombre) like upper('%'||trim(?)||'%')\n" +
                     "   and ue.ue_estado = 'A'";
        
        
        parametro.add(new Parametro(1, empresa));
        Empresa empr;
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, parametro);
  
            while (cres.next()) {
                empr = new Empresa();
                empr.setUe_id(cres.getString(0).trim());
                empr.setAr_id(cres.getString(1).trim());
                empr.setNombre_empresa(cres.getString(2).trim());
                empr.setDireccion(cres.getString(3).trim());
                empr.setTelefono(cres.getString(4).trim());
                empr.setActividad(cres.getString(5).trim());
                empr.setNombre_repre(cres.getString(6).trim());
                empr.setApellido_repre(cres.getString(7).trim());
                empr.setCargo_repre(cres.getString(8).trim());
                empr.setTelefono_repre(cres.getString(9).trim());
                datos.add(empr);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return datos;
    }
    
    public static List<Empresa> datos_empresa(String id_ue, String id_ar) throws IOException{
        List<Empresa> datos = new LinkedList<Empresa>();
        
        ArrayList<Parametro> parametro = new ArrayList<>();
        String sql = "select ue.ue_id,\n"+
                     "       ar.ar_id,\n" +
                     "       ue.ue_nombre,\n" +
                     "       ue.ue_direccion,\n" +
                     "       ue.ue_telefono,\n" +
                     "       ue.ue_actividad_principal,\n" +
                     "       ue.ue_tipo, \n" +
                     "       ar.ar_nombre as nom_representante,\n" +
                     "       ar.ar_apellido as apell_representante,\n" +
                     "       ar.ar_cargo,\n" +
                     "       ar.ar_telefono as telefono_repre\n" +
                     "  from \"MPP_UNIDAD_EXTERNA\" ue,\n" +
                     "       \"MPP_AGREGAR_REPRESENTANTE\" ar\n" +
                     " where ue.ue_id = ar.ue_id \n" +
                     "   and ue.ue_id = cast(? as integer) \n" +
                     "   and ar.ar_id = cast(? as integer) \n" +
                     "   and ue.ue_estado = 'A'";
        
        
        parametro.add(new Parametro(1, id_ue));
        parametro.add(new Parametro(2, id_ar));
        Empresa empr;
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, parametro);
  
            while (cres.next()) {
                empr = new Empresa();
                empr.setUe_id(cres.getString(0).trim());
                empr.setAr_id(cres.getString(1).trim());
                empr.setNombre_empresa(cres.getString(2).trim());
                empr.setDireccion(cres.getString(3).trim());
                empr.setTelefono(cres.getString(4).trim());
                empr.setActividad(cres.getString(5).trim());
                empr.setTipo_empresa(cres.getString(6).trim());
                empr.setNombre_repre(cres.getString(7).trim());
                empr.setApellido_repre(cres.getString(8).trim());
                empr.setCargo_repre(cres.getString(9).trim());
                empr.setTelefono_repre(cres.getString(10).trim());
                datos.add(empr);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return datos;
    }

    public static JSONObject toJSONObject(Empresa empr) {
        JSONObject json = new JSONObject();
        try {
            json.put("ue_id", empr.getUe_id());
            json.put("ar_id", empr.getAr_id());
            json.put("nombre_empresa", empr.getNombre_empresa());
            json.put("direccion", empr.getDireccion());
            json.put("telefono", empr.getTelefono());
            json.put("actividad", empr.getActividad());
            json.put("tipo", empr.getTipo_empresa());
            json.put("nombre", empr.getNombre_repre());
            json.put("apellido", empr.getApellido_repre());
            json.put("cargo", empr.getCargo_repre());
            json.put("tele_repre", empr.getTelefono_repre());
        } catch (JSONException ex) {
            Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }

    public static JSONObject toJSON(List< Empresa> dato) {
        JSONObject json = new JSONObject();
        try {
            JSONArray jsonItems = new JSONArray();
            for (Iterator<Empresa> it = dato.iterator(); it.hasNext();) {
                Empresa campo = it.next();
                jsonItems.put(toJSONObject(campo));
            }

            json.put("items", jsonItems);

        } catch (JSONException ex) {
            Logger.getLogger(Menu_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
}
