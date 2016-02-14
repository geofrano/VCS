/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPA_EXT_PAS.eventos;

import PPA_EXT_PAS.dominio.Carta_Compromiso;
import PPA_EXT_PAS.dominio.Ficha_Estudiante;
import PPA_EXT_PAS.dominio.Menu_principal;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.math.BigDecimal;
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
 * @author Geovanny Barrera
 */
public class Administrar_Ficha_Estudiante {

    private Ficha_Estudiante ficha_estudiante;

    public Administrar_Ficha_Estudiante(HttpServletRequest request) {
        this.ficha_estudiante = new Ficha_Estudiante();
        this.ficha_estudiante.setId_ficha_estudiante((String) request.getParameter("txt_id_ficha_estudiante"));
        this.ficha_estudiante.setDireccion((String) request.getParameter("txt_direccion"));
        this.ficha_estudiante.setDescripcion_actividades((String) request.getParameter("txt_descripcion"));
        this.ficha_estudiante.setEmail((String) request.getParameter("txt_email"));
        this.ficha_estudiante.setEstado("A");
        this.ficha_estudiante.setFacebook((String) request.getParameter("txt_facebook"));
        this.ficha_estudiante.setLinkedin((String) request.getParameter("txt_linkedin"));
        this.ficha_estudiante.setTwiter((String) request.getParameter("txt_twiter"));
        this.ficha_estudiante.setResponsable_proyecto((String) request.getParameter("txt_responsable_proyecto"));
        this.ficha_estudiante.setTelefono((String) request.getParameter("txt_telefono"));

    }

    public boolean procesar_peticion() {
        ArrayList<Parametro> parametros = new ArrayList<>();
        boolean res = false;
        String sql = "INSERT INTO \"VCS_FICHA_ESTUDIANTE\"(\n"
                + "            \"ID_FICHA_ESTUDIANTE\",direccion, telefono, email, \n"
                + "            facebook, twiter, linkedin, responsable_proyecto, nombre_proyecto, \n"
                + "            descripcion_actividades, estado)\n"
                + "    VALUES (?, ?, ?, ?, \n"
                + "            ?, ?, ?, ?, ?, \n"
                + "            ?, ?);";
        parametros.add(new Parametro(1, this.ficha_estudiante.getId_ficha_estudiante()));
        parametros.add(new Parametro(2, this.ficha_estudiante.getDireccion()));
        parametros.add(new Parametro(3, this.ficha_estudiante.getTelefono()));
        parametros.add(new Parametro(4, this.ficha_estudiante.getEmail()));
        parametros.add(new Parametro(5, this.ficha_estudiante.getFacebook()));
        parametros.add(new Parametro(6, this.ficha_estudiante.getTwiter()));
        parametros.add(new Parametro(7, this.ficha_estudiante.getLinkedin()));
        parametros.add(new Parametro(8, this.ficha_estudiante.getResponsable_proyecto()));
        parametros.add(new Parametro(9, this.ficha_estudiante.getNombre_proyecto()));
        parametros.add(new Parametro(10, this.ficha_estudiante.getDescripcion_actividades()));
        parametros.add(new Parametro(11, this.ficha_estudiante.getEstado()));

        try {
            res = AccesoDatos.ejecutaComando(sql, parametros);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public static List<Carta_Compromiso> mostrar_carta_compromiso(String id_carta_comp,
            String nombre_est, String tipo_actividad) {
        List< Carta_Compromiso> opciones = new LinkedList< Carta_Compromiso >();

        String sql = "SELECT id_carta_comp ||'-'|| lpad(trim(to_char(a.secuencial,'99999999')),3,'0') id_cc, "
                + "trim(nomb_empresa) nombre_empresa,\n"
                + "       trim(\"Nomb_estudiante\") nombre_est, "
                + "trim(\"Ciclo_curso\") semestre, trim(\"Tipo_actividad\") tipo_act,"
                + "to_char(\"Fecha_inicio\",'dd/mm/yyyy') fecha_ini,\n"
                + "  to_char(\"Fecha_fin\",'dd/mm/yyyy') fecha_fin\n"
                + "  FROM \"VCS_CARTA_COMPROMISO\" a\n"
                + "  where lpad(trim(to_char(a.secuencial,'99999999')),3,'0') = lpad(?,3,'0')\n"
                + "  and   a.\"Nomb_estudiante\" like ?\n"
                + "  and   trim(a.\"Tipo_actividad\") =  trim(coalesce(?, a.\"Tipo_actividad\"))\n"
                + "  and exists(select 'X' FROM \"VCS_TRAMITES\" where id_carta_compromiso = id_carta_comp ||'-'|| lpad(trim(to_char(a.secuencial,'99999999')),3,'0')\n"
                + "  and trim(etapa_tramite) = trim('FICHA_ESTUDIANTE') and estado = 'P')\n"
                + "  and a.\"Estado\"='A'";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id_carta_comp));
        lstPar.add(new Parametro(2, nombre_est));
        lstPar.add(new Parametro(3, tipo_actividad));
        Carta_Compromiso carta_comp;
        try {
            ConjuntoResultado cres
                    = AccesoDatos.ejecutaQuery(sql,lstPar);
            while (cres.next()) {
                carta_comp = new Carta_Compromiso();
                carta_comp.setId_carta_compromiso(cres.getString(0).trim());
                carta_comp.setNomb_empresa(cres.getString(1).trim());
                carta_comp.setNomb_estudiante(cres.getString(2).trim());
                carta_comp.setCiclo_curso(cres.getString(3).trim());
                carta_comp.setTipo_actividad(cres.getString(4).trim());
                carta_comp.setFecha_inicio(cres.getString(5).trim());
                carta_comp.setFecha_fin(cres.getString(6).trim());
                
                opciones.add(carta_comp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return opciones;
    }

    public static JSONObject toJSONObject(Carta_Compromiso carta_comp) {
        JSONObject json = new JSONObject();
        try {
            json.put("id_carta_comp", carta_comp.getId_carta_compromiso());
            json.put("nombre_empresa", carta_comp.getNomb_empresa());
            json.put("nombre_est", carta_comp.getNomb_estudiante());
            json.put("ciclo_curso", carta_comp.getCiclo_curso());
            json.put("tipo_actividad", carta_comp.getTipo_actividad());
            json.put("fecha_ini", carta_comp.getFecha_inicio());
            json.put("fecha_fin", carta_comp.getFecha_fin());

        } catch (JSONException ex) {
            Logger.getLogger(Carta_Compromiso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }

    public static JSONObject toJSON(List< Carta_Compromiso> carta_comp) {
        JSONObject json = new JSONObject();
        try {
            JSONArray jsonItems = new JSONArray();
            for (Iterator<Carta_Compromiso> it = carta_comp.iterator(); it.hasNext();) {
                Carta_Compromiso opciones = it.next();
                jsonItems.put(toJSONObject(opciones));
            }

            json.put("items", jsonItems);
        } catch (JSONException ex) {
            Logger.getLogger(Menu_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }

}
