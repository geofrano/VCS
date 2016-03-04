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
    
    public Administrar_Ficha_Estudiante(){
        super();
    }
    public Administrar_Ficha_Estudiante(HttpServletRequest request) {
        this.ficha_estudiante = new Ficha_Estudiante();
        this.ficha_estudiante.setId_carta_compromiso((String) request.getParameter("txt_id_carta_comp"));
        this.ficha_estudiante.setNombre_proyecto((String) request.getParameter("txt_nomb_proy"));
        this.ficha_estudiante.setTwiter((String) request.getParameter("txt_twitter"));
        this.ficha_estudiante.setFacebook((String) request.getParameter("txt_facebook"));
        this.ficha_estudiante.setLinkedin((String) request.getParameter("txt_linkedin"));
        this.ficha_estudiante.setTipo_documento((String) request.getParameter("txt_tipo_doc"));
        this.ficha_estudiante.setDireccion((String) request.getParameter("txt_direccion_est"));
        this.ficha_estudiante.setCod_proy((String) request.getParameter("cod_proy"));

    }

    public String procesar_peticion(String accion) {
        ArrayList<Parametro> parametros = new ArrayList<>();
        String res = "";
        String sql = "select f_inserta_ficha_est(?,?,?,?,?,?,?,?,?)";
        parametros.add(new Parametro(1, this.ficha_estudiante.getNombre_proyecto()));
        parametros.add(new Parametro(2, this.ficha_estudiante.getTwiter()));
        parametros.add(new Parametro(3, this.ficha_estudiante.getFacebook()));
        parametros.add(new Parametro(4, this.ficha_estudiante.getLinkedin()));
        parametros.add(new Parametro(5, this.ficha_estudiante.getId_carta_compromiso()));
        parametros.add(new Parametro(6, this.ficha_estudiante.getTipo_documento()));
        parametros.add(new Parametro(7, this.ficha_estudiante.getDireccion()));
        System.out.println("cod_proy "+this.ficha_estudiante.getCod_proy());
        parametros.add(new Parametro(8, this.ficha_estudiante.getCod_proy()));
        parametros.add(new Parametro(9, accion));
        try {
             ConjuntoResultado cres
                    = AccesoDatos.ejecutaQuery(sql, parametros);
            while (cres.next()) {
                res = cres.getString(0);
            }
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }
    
    public String elimina(String cc_id) {
        ArrayList<Parametro> parametros = new ArrayList<>();
        String res = "NO";
        String sql = "delete FROM \"MPP_FICHA_ESTUDIANTE\" where trim(cc_id) = ?";
        parametros.add(new Parametro(1, cc_id.trim()));
        try {
             boolean cres = AccesoDatos.ejecutaComando(sql, parametros);
             String act=actualiza_estado_cc(cc_id,"A");
             if (cres){
                 res="SI";
             }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }
    public String actualiza_estado_cc(String cc_id,String estado) {
        ArrayList<Parametro> parametros = new ArrayList<>();
        String res = "NO";
        String sql = "update \"MPP_CARTA_COMPROMISO\" set cc_estado=?\n" +
                     " where trim(cc_id) = ?";
        parametros.add(new Parametro(1, estado));
        parametros.add(new Parametro(2, cc_id.trim()));
        try {
             boolean cres = AccesoDatos.ejecutaComando(sql, parametros);
             if (cres){
                 res="SI";
             }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }
    public static List<Carta_Compromiso> mostrar_carta_compromiso(String id_carta_comp) {
        List< Carta_Compromiso> opciones = new LinkedList< Carta_Compromiso>();
        String sql = "select id_cc, tipo_actividad, dia_ini,\n"
                + " mes_ini, anio_ini, dia_fin, mes_fin, anio_fin,\n"
                + " ced_est, nombre_estudiante, cel_est, correo_est,\n"
                + " carrera_est, ciclo_est, institucion, rep_leg, cc_area_actividad, cc_responsable_area,\n"
                + " cc_horario_previsto, cargo_rep_leg, ar_telefono, ue_direccion, programa, coalesce(proyecto, 'NA') proyecto,\n"
                + " nombre_tutor, actividades, coalesce(cod_proy, 0) cod_proy\n"
                + "from view_datos_cc\n"
                + "where trim(id_cc) = ? ";

        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id_carta_comp));
        Carta_Compromiso carta_comp;
        try {
            ConjuntoResultado cres
                    = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                carta_comp = new Carta_Compromiso();
                carta_comp.setId_carta_compromiso(cres.getString(0));
                carta_comp.setTipo_actividad(cres.getString(1));
                carta_comp.setDia_inicio(cres.getString(2));
                carta_comp.setMes_inicio(cres.getString(3));
                carta_comp.setAnio_inicio(cres.getString(4));
                carta_comp.setDia_fin(cres.getString(5));
                carta_comp.setMes_fin(cres.getString(6));
                carta_comp.setAnio_fin(cres.getString(7));
                carta_comp.setCed_estudiante(cres.getString(8));
                carta_comp.setNomb_estudiante(cres.getString(9).trim());
                carta_comp.setFono_estudiante(cres.getString(10).trim());
                carta_comp.setMail_estudiante(cres.getString(11).trim());
                carta_comp.setCarrera_grado(cres.getString(12).trim());
                carta_comp.setCiclo_curso(cres.getString(13).trim());
                carta_comp.setNomb_empresa(cres.getString(14).trim());
                carta_comp.setNombre_representante(cres.getString(15).trim());
                carta_comp.setArea_actividad(cres.getString(16).trim());
                carta_comp.setResponsable_area(cres.getString(17).trim());
                carta_comp.setHorario_previsto(cres.getString(18).trim());
                carta_comp.setCargo_representante(cres.getString(19).trim());
                carta_comp.setTelf_representante(cres.getString(20).trim());
                carta_comp.setDir_empresa(cres.getString(21).trim());
                carta_comp.setNombre_programa(cres.getString(22).trim());
                if (cres.getString(23).trim().equals("NA")) {
                    carta_comp.setProyecto("");
                } else {
                    carta_comp.setProyecto(cres.getString(23).trim());
                }
                carta_comp.setNombre_tutor(cres.getString(24).trim());
                carta_comp.setActividad_1(cres.getString(25).trim());
                carta_comp.setActividad_2(cres.getString(26).trim());
                opciones.add(carta_comp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return opciones;
    }
    
    public static List<Carta_Compromiso> mostrar_carta_compromiso2(String id_carta_comp) {
        List< Carta_Compromiso> opciones = new LinkedList< Carta_Compromiso>();
        String sql = "select id_cc, tipo_actividad, dia_ini,\n"
                + " mes_ini, anio_ini, dia_fin, mes_fin, anio_fin,\n"
                + " ced_est, nombre_estudiante, cel_est, correo_est,\n"
                + " carrera_est, ciclo_est, institucion, rep_leg, cc_area_actividad, cc_responsable_area,\n"
                + " cc_horario_previsto, cargo_rep_leg, ar_telefono, ue_direccion, programa, coalesce(proyecto, 'NA') proyecto,\n"
                + " nombre_tutor, actividades, coalesce(cod_proy, 0) cod_proy, coalesce(fe_nombre_proyecto, 'NA') ,coalesce( b.fe_twitter, 'NA') , "
                + " coalesce(b.fe_facebook, 'NA'), coalesce(b.fe_linked_in, 'NA'), b.fe_direccion, to_char(a.cc_fecha_suscripcion,'dd/mm/yyyy'), \n"
                + " cc_lugar_suscripcion, cargo_director_carr, director_carrera, cargo_dir_tecnico, director_tecnico \n"
                + " from view_datos_cc a, \"MPP_FICHA_ESTUDIANTE\" b\n" 
                + " where a.id_cc = b.cc_id and \n"
                + " trim(a.id_cc) = ? ";

        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id_carta_comp));
        Carta_Compromiso carta_comp;
        try {
            ConjuntoResultado cres
                    = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                carta_comp = new Carta_Compromiso();
                carta_comp.setId_carta_compromiso(cres.getString(0));
                carta_comp.setTipo_actividad(cres.getString(1));
                carta_comp.setDia_inicio(cres.getString(2));
                carta_comp.setMes_inicio(cres.getString(3));
                carta_comp.setAnio_inicio(cres.getString(4));
                carta_comp.setDia_fin(cres.getString(5));
                carta_comp.setMes_fin(cres.getString(6));
                carta_comp.setAnio_fin(cres.getString(7));
                carta_comp.setCed_estudiante(cres.getString(8));
                carta_comp.setNomb_estudiante(cres.getString(9).trim());
                carta_comp.setFono_estudiante(cres.getString(10).trim());
                carta_comp.setMail_estudiante(cres.getString(11).trim());
                carta_comp.setCarrera_grado(cres.getString(12).trim());
                carta_comp.setCiclo_curso(cres.getString(13).trim());
                carta_comp.setNomb_empresa(cres.getString(14).trim());
                carta_comp.setNombre_representante(cres.getString(15).trim());
                carta_comp.setArea_actividad(cres.getString(16).trim());
                carta_comp.setResponsable_area(cres.getString(17).trim());
                carta_comp.setHorario_previsto(cres.getString(18).trim());
                carta_comp.setCargo_representante(cres.getString(19).trim());
                carta_comp.setTelf_representante(cres.getString(20).trim());
                carta_comp.setDir_empresa(cres.getString(21).trim());
                carta_comp.setNombre_programa(cres.getString(22).trim());
                if (cres.getString(23).trim().equals("NA")) {
                    carta_comp.setProyecto("");
                } else {
                    carta_comp.setProyecto(cres.getString(23).trim());
                }
                carta_comp.setNombre_tutor(cres.getString(24).trim());
                carta_comp.setActividad_1(cres.getString(25).trim());
                carta_comp.setActividad_2(cres.getString(26).trim());
                if (cres.getString(27).trim().equals("NA")) {
                    carta_comp.setNombre_proyecto("");
                } else {
                    carta_comp.setNombre_proyecto(cres.getString(27).trim());
                }
                
                if (cres.getString(28).trim().equals("NA")) {
                    carta_comp.setTwitter_est("");
                } else {
                    carta_comp.setTwitter_est(cres.getString(28).trim());
                }
                if (cres.getString(29).trim().equals("NA")) {
                    carta_comp.setFacebook_est("");
                } else {
                    carta_comp.setFacebook_est(cres.getString(29).trim());
                }
                
                if (cres.getString(30).trim().equals("NA")) {
                    carta_comp.setLinked_in_est("");
                } else {
                    carta_comp.setLinked_in_est(cres.getString(30).trim());
                }
                if (cres.getString(31).trim().equals("NA")) {
                    carta_comp.setDireccion_est("");
                } else {
                    carta_comp.setDireccion_est(cres.getString(31).trim());
                }
                carta_comp.setFecha_suscripcion(cres.getString(32).trim());
                carta_comp.setLugar_suscripcion(cres.getString(33).trim());
                carta_comp.setCargo_dir_carrera(cres.getString(34).trim());
                carta_comp.setDir_carrera(cres.getString(35).trim());
                carta_comp.setCargo_dir_tec(cres.getString(36).trim());
                carta_comp.setDir_tecnico(cres.getString(37).trim());
                opciones.add(carta_comp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return opciones;
    }

    public static JSONObject toJSONObject(Carta_Compromiso carta_comp,String accion) {
        JSONObject json = new JSONObject();
        try {
            json.put("id_carta_comp", carta_comp.getId_carta_compromiso());
            json.put("tipo_act", carta_comp.getTipo_actividad());
            json.put("dia_ini", carta_comp.getDia_inicio());
            json.put("mes_ini", carta_comp.getMes_inicio());
            json.put("anio_ini", carta_comp.getAnio_inicio());
            json.put("dia_fin", carta_comp.getDia_fin());
            json.put("mes_fin", carta_comp.getMes_fin());
            json.put("anio_fin", carta_comp.getAnio_fin());
            json.put("est_ced", carta_comp.getCed_estudiante());
            json.put("est_nombre", carta_comp.getNomb_estudiante());
            json.put("est_fono", carta_comp.getFono_estudiante());
            json.put("est_mail", carta_comp.getMail_estudiante());
            json.put("est_carrera", carta_comp.getCarrera_grado());
            json.put("est_ciclo", carta_comp.getCiclo_curso());
            json.put("empresa", carta_comp.getNomb_empresa());
            json.put("emp_rep", carta_comp.getNombre_representante());
            json.put("area_act", carta_comp.getArea_actividad());
            json.put("resp_area", carta_comp.getResponsable_area());
            json.put("horario", carta_comp.getHorario_previsto());
            json.put("cargo_rep", carta_comp.getCargo_representante());
            json.put("fono_rep", carta_comp.getTelf_representante());
            json.put("emp_dir", carta_comp.getDir_empresa());
            json.put("programa", carta_comp.getNombre_programa());
            json.put("proyecto", carta_comp.getProyecto());
            json.put("tutor", carta_comp.getNombre_tutor());
            json.put("actividades", carta_comp.getActividad_1());
            json.put("cod_proy", carta_comp.getActividad_2());
            
            if (accion.equals("M")){//Solo si es modificacion se agregan los siguientes campos al json
                json.put("nom_proy", carta_comp.getNombre_proyecto());
                json.put("twitter", carta_comp.getTwitter_est());
                json.put("facebook", carta_comp.getFacebook_est());
                json.put("linked_in", carta_comp.getLinked_in_est());
                json.put("dir_est", carta_comp.getDireccion_est());
            }
            
            
        } catch (JSONException ex) {
            Logger.getLogger(Carta_Compromiso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }

    public static JSONObject toJSON(List< Carta_Compromiso> carta_comp,String accion) {
        JSONObject json = new JSONObject();
        try {
            JSONArray jsonItems = new JSONArray();
            for (Iterator<Carta_Compromiso> it = carta_comp.iterator(); it.hasNext();) {
                Carta_Compromiso opciones = it.next();
                jsonItems.put(toJSONObject(opciones,accion));
            }

            json.put("items", jsonItems);
        } catch (JSONException ex) {
            Logger.getLogger(Menu_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }

}
