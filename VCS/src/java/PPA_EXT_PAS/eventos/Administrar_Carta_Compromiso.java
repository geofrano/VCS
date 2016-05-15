/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPA_EXT_PAS.eventos;

import PPA_EXT_PAS.dominio.Carta_Compromiso;
import accesodatos.AccesoDatos;
import accesodatos.Parametro;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Geovanny Barrera - Luis Pita
 */
public class Administrar_Carta_Compromiso {

    private Carta_Compromiso carta_compromiso;
    public Administrar_Carta_Compromiso(){
        super();
    }
    public Administrar_Carta_Compromiso(HttpServletRequest request) {
        SimpleDateFormat formato_fecha = new SimpleDateFormat("DD/MM/YYYY");
        this.carta_compromiso = new Carta_Compromiso();
        try {
            this.carta_compromiso.setId_carta_compromiso((String) request.getParameter("txt_codigo"));
            this.carta_compromiso.setNomb_empresa((String) request.getParameter("id_empresa").trim());
            //this.carta_compromiso.setDir_empresa((String) request.getParameter("txt_direccion").trim());
            //this.carta_compromiso.setAct_empresa((String) request.getParameter("txt_actividad_empresa").trim());
            this.carta_compromiso.setNomb_estudiante((String) request.getParameter("txt_id_est").trim());
            //this.carta_compromiso.setCarrera_grado((String) request.getParameter("cmb_carrera"));
            //this.carta_compromiso.setCiclo_curso((String) request.getParameter("cmb_ciclos").trim());
            this.carta_compromiso.setTipo_actividad((String) request.getParameter("cmb_tipo_actividad").trim());
            this.carta_compromiso.setTotal_horas((String) request.getParameter("cmb_horas"));
            this.carta_compromiso.setObjetivo_actividad((String) request.getParameter("txt_obj_act_academica").trim());
            this.carta_compromiso.setFecha_inicio((String) request.getParameter("txt_fecha_ini"));
            this.carta_compromiso.setFecha_fin((String) request.getParameter("txt_fecha_fin"));
            this.carta_compromiso.setHorario_previsto((String) request.getParameter("txt_horario").trim());
            this.carta_compromiso.setNombre_programa((String) request.getParameter("cmb_programa").trim());
            this.carta_compromiso.setArea_actividad((String) request.getParameter("txt_area_academica").trim());
            this.carta_compromiso.setResponsable_area((String) request.getParameter("txt_respon_area").trim());
            this.carta_compromiso.setActividad_1((String) request.getParameter("txt_actividad_1").trim());
            this.carta_compromiso.setActividad_2((String) request.getParameter("txt_actividad_2").trim());
            this.carta_compromiso.setActividad_3((String) request.getParameter("txt_actividad_3").trim());
            this.carta_compromiso.setActividad_4((String) request.getParameter("txt_actividad_4").trim());
            this.carta_compromiso.setActividad_5((String) request.getParameter("txt_actividad_5").trim());
            this.carta_compromiso.setActividad_6((String) request.getParameter("txt_actividad_6").trim());
            this.carta_compromiso.setResultado_1((String) request.getParameter("txt_resultado_1").trim());
            this.carta_compromiso.setResultado_2((String) request.getParameter("txt_resultado_2").trim());
            this.carta_compromiso.setResultado_3((String) request.getParameter("txt_resultado_3").trim());
            this.carta_compromiso.setResultado_4((String) request.getParameter("txt_resultado_4").trim());
            this.carta_compromiso.setResultado_5((String) request.getParameter("txt_resultado_5").trim());
            this.carta_compromiso.setResultado_6((String) request.getParameter("txt_resultado_6").trim());
            this.carta_compromiso.setProducto_1((String) request.getParameter("txt_producto_1").trim());
            this.carta_compromiso.setProducto_2((String) request.getParameter("txt_producto_2").trim());
            this.carta_compromiso.setProducto_3((String) request.getParameter("txt_producto_3").trim());
            this.carta_compromiso.setProducto_4((String) request.getParameter("txt_producto_4").trim());
            this.carta_compromiso.setProducto_5((String) request.getParameter("txt_producto_5").trim());
            this.carta_compromiso.setProducto_6((String) request.getParameter("txt_producto_6").trim());
            this.carta_compromiso.setNombre_tutor((String) request.getParameter("cmb_tutor").trim());
            //this.carta_compromiso.setNombre_delegado((String) request.getParameter("txt_nombre_deleg_ups").trim());
            this.carta_compromiso.setLugar_suscripcion((String) request.getParameter("txt_ciudad").trim());
            //this.carta_compromiso.setFecha_suscripcion("15/01/2016");
            //this.carta_compromiso.setFecha_suscripcion((String)request.getParameter("txt_lugar_fecha_suscrip"));
            this.carta_compromiso.setEstado("A");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String procesar_peticion(String accion) {
        ArrayList<Parametro> parametros = new ArrayList<>();
        Administrar_Carta_Compromiso adm_cc= new Administrar_Carta_Compromiso();
        String res = "";
        String sql = "SELECT f_inserta_carta_comp(\n" +
                                            "    ?,\n" +//ID_CC
                                            "    ?,\n" +//ID DEL ESTUDIANTE
                                            "    ?,\n" +//TIPO DE ACTIVIDAD
                                            "    ?,\n" +//NUMERO DE HORAS
                                            "    ?,\n" +//OBJETIVO DE LA ACTIVIDAD
                                            "    ?,\n" +//FECHA DE INICIO
                                            "    ?,\n" +//FECHA DE FIN
                                            "    ?,\n" +//HORARIO
                                            "    ?,\n" +//ID DEL PROGRAMA
                                            "    ?,\n" +//AREA
                                            "    ?,\n" +//RESPONASABLE DE AREA
                                            "    ?,\n" +//CIUDAD
                                            "    ?,\n" +//ESTADO DE LA CC
                                            "    ?,\n" +//ID DE LA EMPRESA
                                            "    ?,\n" +//ID DEL TUTOR RESPECTO A LA TABLA DE USUARIOS
                                            "    ?,\n" +//ACTIVIDAD 1
                                            "    ?,\n" +//RECURSO 1
                                            "    ?,\n" +//RESULTADO 1
                                            "    ?,\n" +//ACTIVIDAD 2
                                            "    ?,\n" +//RECURSO 2
                                            "    ?,\n" +//RESULTADO 2
                                            "    ?,\n" +//ACTIVIDAD 3
                                            "    ?,\n" +//RECURSO 3
                                            "    ?,\n" +//RESULTADO 3
                                            "    ?,\n" +//ACTIVIDAD 4
                                            "    ?,\n" +//RECURSO 4
                                            "    ?,\n" +//RESULTADO 4
                                            "    ?,\n" +//ACTIVIDAD 5
                                            "    ?,\n" +//RECURSO 5
                                            "    ?,\n" +//RESULTADO 5
                                            "    ?,\n" +//ACTIVIDAD 6
                                            "    ?,\n" +//RECURSO 6
                                            "    ?,\n" +//RESULTADO 6
                                            "    ? \n" +//ACCION
                                            ")";
        parametros.add(new Parametro(1, this.carta_compromiso.getId_carta_compromiso()));
        parametros.add(new Parametro(2, this.carta_compromiso.getNomb_estudiante()));
        parametros.add(new Parametro(3, this.carta_compromiso.getTipo_actividad()));
        parametros.add(new Parametro(4, adm_cc.devuelveParametroCC(this.carta_compromiso.getTotal_horas())));
        parametros.add(new Parametro(5, this.carta_compromiso.getObjetivo_actividad()));
        parametros.add(new Parametro(6, this.carta_compromiso.getFecha_inicio()));
        parametros.add(new Parametro(7, this.carta_compromiso.getFecha_fin()));
        parametros.add(new Parametro(8, this.carta_compromiso.getHorario_previsto()));
        parametros.add(new Parametro(9, this.carta_compromiso.getNombre_programa()));
        parametros.add(new Parametro(10, this.carta_compromiso.getArea_actividad()));
        parametros.add(new Parametro(11, this.carta_compromiso.getResponsable_area()));
        parametros.add(new Parametro(12, this.carta_compromiso.getLugar_suscripcion()));
        parametros.add(new Parametro(13, "A"));
        parametros.add(new Parametro(14, this.carta_compromiso.getNomb_empresa()));
        parametros.add(new Parametro(15, this.carta_compromiso.getNombre_tutor()));
        parametros.add(new Parametro(16, this.carta_compromiso.getActividad_1()));
        parametros.add(new Parametro(17, this.carta_compromiso.getProducto_1()));
        parametros.add(new Parametro(18, this.carta_compromiso.getResultado_1()));
        parametros.add(new Parametro(19, this.carta_compromiso.getActividad_2()));
        parametros.add(new Parametro(20, this.carta_compromiso.getProducto_2()));
        parametros.add(new Parametro(21, this.carta_compromiso.getResultado_2()));
        parametros.add(new Parametro(22, this.carta_compromiso.getActividad_3()));
        parametros.add(new Parametro(23, this.carta_compromiso.getProducto_3()));
        parametros.add(new Parametro(24, this.carta_compromiso.getResultado_3()));
        parametros.add(new Parametro(25, this.carta_compromiso.getActividad_4()));
        parametros.add(new Parametro(26, this.carta_compromiso.getProducto_4()));
        parametros.add(new Parametro(27, this.carta_compromiso.getResultado_4()));
        parametros.add(new Parametro(28, this.carta_compromiso.getActividad_5()));
        parametros.add(new Parametro(29, this.carta_compromiso.getProducto_5()));
        parametros.add(new Parametro(30, this.carta_compromiso.getResultado_5()));
        parametros.add(new Parametro(31, this.carta_compromiso.getActividad_6()));
        parametros.add(new Parametro(32, this.carta_compromiso.getProducto_6()));
        parametros.add(new Parametro(33, this.carta_compromiso.getResultado_6()));
        parametros.add(new Parametro(34, accion));
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
             //String act=actualiza_estado_cc(cc_id,"A");
             if (cres){
                 res="SI";
             }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }
    public String devuelveSecuencia(String id_carrera){
        String sql="SELECT to_number(COALESCE(max(trim(substr(cc_id,14))),'0'),'099999999') + 1 sec\n" +
                    "  FROM \"MPP_CARTA_COMPROMISO\" \n" +
                    " WHERE trim(substr(cc_id,10,3)) = ?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,id_carrera.trim()));
        String secuencia="";
        
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstPar);
            
            if (cres.next()) {
                secuencia=cres.getString(0).trim();
            }else{
                secuencia="001";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return secuencia;
    }
    
    private String devuelveParametroCC(String id_parametro){
        String sql="SELECT pa_valor \n" +
                    "  FROM \"MPP_PARAMETROS\" \n" +
                    " WHERE trim(pa_id) = ?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,id_parametro.trim()));
        String parametro="";
        
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstPar);
            
            if (cres.next()) {
                parametro=cres.getString(0).trim();
            }else{
                parametro="";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return parametro;
    }
    
    public String devuelveFechaSuscripcion(){
        String sql="select (select extract(day from current_date)) || ' de ' || to_char(now(), 'TMMonth') || ' del ' || (select extract(year from current_date))";
        
        String parametro="";
        
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);
            
            if (cres.next()) {
                parametro=cres.getString(0).trim();
            }else{
                parametro="";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return parametro;
    }
    
    
    public static List<Carta_Compromiso> consulta_cc(String cc_carrera, String cc_actividad) {
        List<Carta_Compromiso> codigo = new LinkedList<Carta_Compromiso>();

        Administrar_Carta_Compromiso admCC = new Administrar_Carta_Compromiso();
        
        Carta_Compromiso cartaCompromiso;
        String nombre_delegadoUPS="";
        String cargo_delegadoUPS="";
        String telefono_delegadoUPS="";
        String fecha_suscripcion="";
        
        try {
            
            cartaCompromiso = new Carta_Compromiso();
            
            String secuencia_cc=admCC.devuelveSecuencia(cc_carrera);
            String secuencia_completa="CC001."+cc_actividad+"-"+cc_carrera+"-"+secuencia_cc;
            nombre_delegadoUPS=admCC.devuelveParametroCC("DIR_TEC_VCS");
            cargo_delegadoUPS=admCC.devuelveParametroCC("CARGO_DIR_TEC_VCS");
            telefono_delegadoUPS=admCC.devuelveParametroCC("TELEF_DIR_TEC_VCS");
            fecha_suscripcion=admCC.devuelveFechaSuscripcion();
            
            cartaCompromiso.setId_carta_compromiso(secuencia_completa);
            cartaCompromiso.setNumero(secuencia_cc);
            cartaCompromiso.setNombre_delegado(nombre_delegadoUPS);
            cartaCompromiso.setCargo_delegado(cargo_delegadoUPS);
            cartaCompromiso.setTelf_delegado(telefono_delegadoUPS);
            cartaCompromiso.setFecha_suscripcion(fecha_suscripcion);
            codigo.add(cartaCompromiso);
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return codigo;
    }
    public static JSONObject toJSONObject(Carta_Compromiso cc) {
        JSONObject json = new JSONObject();
        try {
            json.put("codigo", cc.getId_carta_compromiso());
            json.put("numero", cc.getNumero());
            json.put("nombre_delegado", cc.getNombre_delegado());
            json.put("cargo_delegado", cc.getCargo_delegado());
            json.put("telefono_delegado", cc.getTelf_delegado());
            json.put("fecha", cc.getFecha_suscripcion());
            System.out.println("Fecha de suscripcion:   "+cc.getFecha_suscripcion());
        } catch (JSONException ex) {
            Logger.getLogger(Carta_Compromiso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
    public static JSONObject toJSON(List< Carta_Compromiso >  codigo) {
        JSONObject json = new JSONObject();
        try {
            JSONArray jsonItems = new JSONArray();
            for (Iterator<Carta_Compromiso> it = codigo.iterator(); it.hasNext();) {
                Carta_Compromiso opciones = it.next();
                jsonItems.put( toJSONObject( opciones ) );
            }

            json.put("items", jsonItems);
        } catch (JSONException ex) {
            Logger.getLogger(Carta_Compromiso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
}
