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
                + " nombre_tutor, actividades, coalesce(cod_proy, 0) cod_proy, to_char(cc_fecha_suscripcion,'dd/mm/yyyy'), \n"
                + " cc_lugar_suscripcion, cargo_director_carr, director_carrera, cargo_dir_tecnico, director_tecnico, total_horas,cc_objetivo_actividad, \n"
                + " resp_vcs,resp_act, ue_actividad_principal,telefono_dir_tec, ue_telefono,ue_id,es_id \n"
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
                carta_comp.setFecha_suscripcion(cres.getString(27).trim());
                carta_comp.setLugar_suscripcion(cres.getString(28).trim());
                carta_comp.setCargo_dir_carrera(cres.getString(29).trim());
                carta_comp.setDir_carrera(cres.getString(30).trim());
                carta_comp.setCargo_dir_tec(cres.getString(31).trim());
                carta_comp.setDir_tecnico(cres.getString(32).trim());
                carta_comp.setTotal_horas(cres.getString(33).trim());
                carta_comp.setObjetivo_actividad(cres.getString(34).trim());
                carta_comp.setNombre_delegado(cres.getString(35).trim());
                carta_comp.setActividad_3(cres.getString(36).trim());
                carta_comp.setAct_empresa(cres.getString(37).trim());
                carta_comp.setTelf_delegado(cres.getString(38).trim());
                carta_comp.setTelef_empresa(cres.getString(39).trim());
                carta_comp.setId_empresa(cres.getString(40).trim());
                carta_comp.setId_estudiante(cres.getString(41).trim());
                opciones.add(carta_comp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return opciones;
    }
    public static String obtiene_estadoCartaCompromiso(String id_carta_comp){
        String sql="SELECT cc_estado\n" +
                    "  FROM \"MPP_CARTA_COMPROMISO\" where trim(cc_id) = trim(?)";
        String estado="0" ;
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id_carta_comp));
        try {
            ConjuntoResultado cres
                    = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                estado=cres.getString(0).trim();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return estado;
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
                + " cc_lugar_suscripcion, cargo_director_carr, director_carrera, cargo_dir_tecnico, director_tecnico, total_horas,cc_objetivo_actividad, \n"
                + " resp_vcs,resp_act, ue_actividad_principal,telefono_dir_tec, ue_telefono,ue_id,es_id \n"
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
                carta_comp.setTotal_horas(cres.getString(38).trim());
                carta_comp.setObjetivo_actividad(cres.getString(39).trim());
                carta_comp.setNombre_delegado(cres.getString(40).trim());
                
                carta_comp.setActividad_3(cres.getString(41).trim());
                carta_comp.setAct_empresa(cres.getString(42).trim());
                carta_comp.setTelf_delegado(cres.getString(43).trim());
                carta_comp.setTelef_empresa(cres.getString(44).trim());
                carta_comp.setId_empresa(cres.getString(45).trim());
                carta_comp.setId_estudiante(cres.getString(46).trim());
                
                
                opciones.add(carta_comp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return opciones;
    }
    public static List<Carta_Compromiso> obtiene_elemento(String id_carta_comp, String tipo_elemento) {
        List< Carta_Compromiso> opciones = new LinkedList< Carta_Compromiso>();
        String sql = "SELECT ae_orden||'. '||ae_descripcion elemento,sum(b.ca_num_hora) as tot_hora\n" +
                        "  FROM \"MPP_ASIGNAR_ELEMENTO\" a,\n" +
                        "      \"MPP_CRONOGRAMA_ACT\" b \n" +
                        " where a.ae_id=b.ae_id\n" +
                        "   AND trim(a.cc_id) = trim(?)\n" +
                        "   AND a.ae_tipo = ? group by ae_orden,ae_descripcion order by a.ae_orden";
        
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id_carta_comp));
        lstPar.add(new Parametro(2, tipo_elemento));
        Carta_Compromiso carta_comp;
        try {
            ConjuntoResultado cres
                    = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                carta_comp = new Carta_Compromiso();
                carta_comp.setActividad_1(cres.getString(0));
                carta_comp.setActividad_2(cres.getString(1));
                //System.out.println("ACT "+cres.getString(0));
                opciones.add(carta_comp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return opciones;
    }
    public static List<Carta_Compromiso> obtiene_elemento2(String id_carta_comp, String tipo_elemento) {
        List< Carta_Compromiso> opciones = new LinkedList< Carta_Compromiso>();
        String sql = "SELECT ae_orden||'. '||ae_descripcion elemento, ae_id\n" +
                        "  FROM \"MPP_ASIGNAR_ELEMENTO\" a\n" +
                        " where trim(a.cc_id) = trim(?)\n" +
                        "   AND a.ae_tipo = ? order by a.ae_orden";
        
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id_carta_comp));
        lstPar.add(new Parametro(2, tipo_elemento));
        Carta_Compromiso carta_comp;
        try {
            ConjuntoResultado cres
                    = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                carta_comp = new Carta_Compromiso();
                carta_comp.setActividad_1(cres.getString(0));
                carta_comp.setActividad_2(cres.getString(1));
                //System.out.println("ACT "+cres.getString(0));
                opciones.add(carta_comp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return opciones;
    }
    public static List<Carta_Compromiso> obtiene_elemento3(String id_carta_comp, String tipo_elemento) {
        List< Carta_Compromiso> opciones = new LinkedList< Carta_Compromiso>();
        String sql = "SELECT a.ae_orden||'. '||a.ae_descripcion elemento, \n" +
                            "a.ae_id,\n" +
                            "sem_1.ca_num_hora, \n" +
                            "sem_2.ca_num_hora,\n" +
                            "sem_3.ca_num_hora, \n" +
                            "sem_4.ca_num_hora,\n" +
                            "sem_5.ca_num_hora, \n" +
                            "sem_6.ca_num_hora, \n" +
                            "sem_7.ca_num_hora\n" +
                            "     FROM \"MPP_ASIGNAR_ELEMENTO\" a, \n" +
                            "          \"MPP_CRONOGRAMA_ACT\" sem_1,\n" +
                            "          \"MPP_CRONOGRAMA_ACT\" sem_2,\n" +
                            "          \"MPP_CRONOGRAMA_ACT\" sem_3,\n" +
                            "          \"MPP_CRONOGRAMA_ACT\" sem_4,\n" +
                            "          \"MPP_CRONOGRAMA_ACT\" sem_5,\n" +
                            "          \"MPP_CRONOGRAMA_ACT\" sem_6,\n" +
                            "          \"MPP_CRONOGRAMA_ACT\" sem_7\n" +
                            "   where a.ae_id=sem_1.ae_id\n" +
                            "     AND a.ae_id=sem_2.ae_id\n" +
                            "     AND a.ae_id=sem_3.ae_id\n" +
                            "     AND a.ae_id=sem_4.ae_id\n" +
                            "     AND a.ae_id=sem_5.ae_id\n" +
                            "     AND a.ae_id=sem_6.ae_id\n" +
                            "     AND a.ae_id=sem_7.ae_id\n" +
                            "     AND sem_1.ca_semana = 1\n" +
                            "     AND sem_2.ca_semana = 2\n" +
                            "     AND sem_3.ca_semana = 3\n" +
                            "     AND sem_4.ca_semana = 4\n" +
                            "     AND sem_5.ca_semana = 5\n" +
                            "     AND sem_6.ca_semana = 6\n" +
                            "     AND sem_7.ca_semana = 7\n" +
                            "     AND trim(a.cc_id) = trim(?)\n" +
                            "     AND a.ae_tipo = ? order by a.ae_orden";
        
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id_carta_comp));
        lstPar.add(new Parametro(2, tipo_elemento));
        Carta_Compromiso carta_comp;
        try {
            ConjuntoResultado cres
                    = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                carta_comp = new Carta_Compromiso();
                carta_comp.setActividad_1(cres.getString(0));
                carta_comp.setActividad_2(cres.getString(1));
                carta_comp.setProducto_1(cres.getString(2));
                carta_comp.setProducto_2(cres.getString(3));
                carta_comp.setProducto_3(cres.getString(4));
                carta_comp.setProducto_4(cres.getString(5));
                carta_comp.setProducto_5(cres.getString(6));
                carta_comp.setProducto_6(cres.getString(7));
                carta_comp.setActividad_3(cres.getString(8));
                //System.out.println("ACT "+cres.getString(0));
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
    public static JSONObject toJSONObject2(Carta_Compromiso carta_comp,String accion) {
        JSONObject json = new JSONObject();
        try {
            json.put("id_cc", carta_comp.getId_carta_compromiso());
            json.put("num_cc", carta_comp.getId_carta_compromiso().substring(13));
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
            json.put("empresa_fono", carta_comp.getTelef_empresa());
            json.put("empresa", carta_comp.getNomb_empresa());
            json.put("act_emp", carta_comp.getAct_empresa());
            json.put("emp_dir", carta_comp.getDir_empresa());
            json.put("emp_rep", carta_comp.getNombre_representante());
            json.put("cargo_rep", carta_comp.getCargo_representante());
            json.put("fono_rep", carta_comp.getTelf_representante());
            json.put("duracion", carta_comp.getTotal_horas());
            json.put("objetivo_act", carta_comp.getObjetivo_actividad());
            json.put("horario", carta_comp.getHorario_previsto());
            json.put("programa", carta_comp.getNombre_programa());
            json.put("area_act", carta_comp.getArea_actividad());
            json.put("resp_area", carta_comp.getResponsable_area());
            json.put("tutor", carta_comp.getNombre_tutor());
            json.put("dir_tec", carta_comp.getDir_tecnico());
            json.put("cargo_dir_tec", carta_comp.getCargo_dir_tec());
            json.put("fono_dir_tec", carta_comp.getTelf_delegado());
            json.put("id_est", carta_comp.getId_estudiante());
            json.put("id_empr", carta_comp.getId_empresa());
            json.put("suscripcion", carta_comp.getLugar_suscripcion()+", "+carta_comp.getFecha_suscripcion());
            
            Administrar_Ficha_Estudiante adm_ficha_est = new Administrar_Ficha_Estudiante();
            List< Carta_Compromiso> carta_comp2_act = adm_ficha_est.obtiene_elemento2(carta_comp.getId_carta_compromiso(),"AC");
            
            int contador=0;
            for (Iterator<Carta_Compromiso> it2 = carta_comp2_act.iterator(); it2.hasNext();) {
                Carta_Compromiso elemento = it2.next();
                contador = contador +1;
                json.put("act_"+contador, elemento.getActividad_1().substring(2).replace(".", "").trim());
            }
            contador=0;
            List< Carta_Compromiso> carta_comp2_res = adm_ficha_est.obtiene_elemento2(carta_comp.getId_carta_compromiso(),"RE");
                
            for (Iterator<Carta_Compromiso> it2 = carta_comp2_res.iterator(); it2.hasNext();) {
                Carta_Compromiso elemento = it2.next();
                contador = contador +1;
                json.put("res_"+contador, elemento.getActividad_1().substring(2).replace(".", "").trim());
            }
            contador=0;
            List< Carta_Compromiso> carta_comp2_rec = adm_ficha_est.obtiene_elemento2(carta_comp.getId_carta_compromiso(),"RC");
                
            for (Iterator<Carta_Compromiso> it2 = carta_comp2_rec.iterator(); it2.hasNext();) {
                Carta_Compromiso elemento = it2.next();
                contador = contador +1;
                json.put("rec_"+contador, elemento.getActividad_1().substring(2).replace(".", "").trim());
            }
            
        } catch (JSONException ex) {
            Logger.getLogger(Carta_Compromiso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }

    public static JSONObject toJSON2(List< Carta_Compromiso> carta_comp,String accion) {
        JSONObject json = new JSONObject();
        try {
            JSONArray jsonItems = new JSONArray();
            for (Iterator<Carta_Compromiso> it = carta_comp.iterator(); it.hasNext();) {
                Carta_Compromiso opciones = it.next();
                jsonItems.put(toJSONObject2(opciones,accion));
            }

            json.put("items", jsonItems);
        } catch (JSONException ex) {
            Logger.getLogger(Menu_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
    public static JSONObject toJSON3(String id_carta_compromiso) {
        JSONObject json = new JSONObject();
        try {
            JSONArray jsonItems = new JSONArray();

                jsonItems.put(toJSONObject3(id_carta_compromiso));

            json.put("items", jsonItems);
        } catch (JSONException ex) {
            Logger.getLogger(Menu_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
    public static JSONObject toJSONObject3(String id_carta_compromiso) {
        JSONObject json = new JSONObject();
        try {
            
            Administrar_Ficha_Estudiante adm_ficha_est = new Administrar_Ficha_Estudiante();
            Administrar_Carta_Compromiso adm_cc = new Administrar_Carta_Compromiso();
            String num_horas=adm_cc.devuelveDatoCC(id_carta_compromiso,"cc_total_horas");
            List< Carta_Compromiso> carta_comp2_act = adm_ficha_est.obtiene_elemento2(id_carta_compromiso,"AC");
            
            int contador=0;
            for (Iterator<Carta_Compromiso> it2 = carta_comp2_act.iterator(); it2.hasNext();) {
                Carta_Compromiso elemento = it2.next();
                contador = contador +1;
                json.put("act_"+contador, elemento.getActividad_1().trim());
                json.put("cod_act_"+contador, elemento.getActividad_2().trim());
            }
            json.put("num_horas", num_horas);
            
            
        } catch (JSONException ex) {
            Logger.getLogger(Carta_Compromiso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
    public static JSONObject toJSON4(String id_carta_compromiso) {
        JSONObject json = new JSONObject();
        try {
            JSONArray jsonItems = new JSONArray();

                jsonItems.put(toJSONObject4(id_carta_compromiso));

            json.put("items", jsonItems);
        } catch (JSONException ex) {
            Logger.getLogger(Menu_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
    public static JSONObject toJSONObject4(String id_carta_compromiso) {
        JSONObject json = new JSONObject();
        try {
            
            Administrar_Ficha_Estudiante adm_ficha_est = new Administrar_Ficha_Estudiante();
            Administrar_Carta_Compromiso adm_cc = new Administrar_Carta_Compromiso();
            String num_horas=adm_cc.devuelveDatoCC(id_carta_compromiso,"cc_total_horas");
            List< Carta_Compromiso> carta_comp2_act = adm_ficha_est.obtiene_elemento2(id_carta_compromiso,"AC");
            
            int contador=0;
            for (Iterator<Carta_Compromiso> it2 = carta_comp2_act.iterator(); it2.hasNext();) {
                Carta_Compromiso elemento = it2.next();
                contador = contador +1;
                json.put("act_"+contador, elemento.getActividad_1().trim());
                json.put("cod_act_"+contador, elemento.getActividad_2().trim());
            }
            json.put("num_horas", num_horas);
            
            
            contador=0;
            List< Carta_Compromiso> carta_comp3_act = adm_ficha_est.obtiene_elemento3(id_carta_compromiso,"AC");
                int num_h_sem1=0;
                int num_h_sem2=0;
                int num_h_sem3=0;
                int num_h_sem4=0;
                int num_h_sem5=0;
                int num_h_sem6=0;
                int num_h_sem7=0;
                String valor_sem1="";
                String valor_sem2="";
                String valor_sem3="";
                String valor_sem4="";
                String valor_sem5="";
                String valor_sem6="";
                String valor_sem7="";
                int sum_act=0;
                int sum_tot=0;
                
                for (Iterator<Carta_Compromiso> it2 = carta_comp3_act.iterator(); it2.hasNext();) {
                    Carta_Compromiso elemento = it2.next();
                    contador = contador +1;
                    valor_sem1="";
                    valor_sem2="";
                    valor_sem3="";
                    valor_sem4="";
                    valor_sem5="";
                    valor_sem6="";
                    valor_sem7="";
                    num_h_sem1=0;
                    num_h_sem2=0;
                    num_h_sem3=0;
                    num_h_sem4=0;
                    num_h_sem5=0;
                    num_h_sem6=0;
                    num_h_sem7=0;
                    
                    
                    num_h_sem1=Integer.parseInt(elemento.getProducto_1());
                    num_h_sem2=Integer.parseInt(elemento.getProducto_2());
                    num_h_sem3=Integer.parseInt(elemento.getProducto_3());
                    num_h_sem4=Integer.parseInt(elemento.getProducto_4());
                    num_h_sem5=Integer.parseInt(elemento.getProducto_5());
                    num_h_sem6=Integer.parseInt(elemento.getProducto_6());
                    num_h_sem7=Integer.parseInt(elemento.getActividad_3());
                    
                    sum_act=num_h_sem1+num_h_sem2+num_h_sem3+num_h_sem4+num_h_sem5+num_h_sem6+num_h_sem7;
                    sum_tot= sum_tot +sum_act;
                    if(num_h_sem1 > 0){
                        valor_sem1="X";
                    }
                    if(num_h_sem2 > 0){
                        valor_sem2="X";
                    }
                    if(num_h_sem3 > 0){
                        valor_sem3="X";
                    }
                    if(num_h_sem4 > 0){
                        valor_sem4="X";
                    }
                    if(num_h_sem5 > 0){
                        valor_sem5="X";
                    }
                    if(num_h_sem6 > 0){
                        valor_sem6="X";
                    }
                    if(num_h_sem7 > 0){
                        valor_sem7="X";
                    }
                    
                    json.put("act_"+contador+"_sem1", valor_sem1);
                    json.put("act_"+contador+"_sem2", valor_sem2);
                    json.put("act_"+contador+"_sem3", valor_sem3);
                    json.put("act_"+contador+"_sem4", valor_sem4);
                    json.put("act_"+contador+"_sem5", valor_sem5);
                    json.put("act_"+contador+"_sem6", valor_sem6);
                    json.put("act_"+contador+"_sem7", valor_sem7);
                    json.put("act_"+contador+"_sum", sum_act);
                    
                    
                }
                json.put("total_gnral", sum_tot);
            
            
            
            
        } catch (JSONException ex) {
            Logger.getLogger(Carta_Compromiso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
}
