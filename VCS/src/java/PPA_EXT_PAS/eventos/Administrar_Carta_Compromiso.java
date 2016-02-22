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

    public Administrar_Carta_Compromiso(HttpServletRequest request) {
        SimpleDateFormat formato_fecha = new SimpleDateFormat("DD/MM/YYYY");
        this.carta_compromiso = new Carta_Compromiso();
        try {
            //this.carta_compromiso.setId_carta_compromiso((String) request.getParameter("txt_codigo"));
            this.carta_compromiso.setNomb_empresa((String) request.getParameter("txt_nombre_empresa").trim());
            this.carta_compromiso.setDir_empresa((String) request.getParameter("txt_direccion").trim());
            this.carta_compromiso.setAct_empresa((String) request.getParameter("txt_actividad_empresa").trim());
            this.carta_compromiso.setNomb_estudiante((String) request.getParameter("txt_nombre_estudiante").trim());
            this.carta_compromiso.setCarrera_grado((String) request.getParameter("cmb_carrera"));
            this.carta_compromiso.setCiclo_curso((String) request.getParameter("cmb_ciclos").trim());
            this.carta_compromiso.setTipo_actividad((String) request.getParameter("cmb_tipo_actividad").trim());
            System.out.println("cmb_tipo_actividad "+(String) request.getParameter("cmb_tipo_actividad"));
            this.carta_compromiso.setTotal_horas((String) request.getParameter("cmb_horas"));
            this.carta_compromiso.setObjetivo_actividad((String) request.getParameter("txt_obj_act_academica").trim());
            //this.carta_compromiso.setFecha_inicio(formato_fecha.parse(/*(String)*/request.getParameter("txt_fecha_inicio")));
            //this.carta_compromiso.setFecha_fin(formato_fecha.parse(/*(String)*/request.getParameter("txt_fecha_fin")));
            this.carta_compromiso.setFecha_inicio((String) request.getParameter("txt_fecha_inicio"));
            this.carta_compromiso.setFecha_fin((String) request.getParameter("txt_fecha_fin"));
            this.carta_compromiso.setHorario_previsto((String) request.getParameter("txt_horario").trim());
            this.carta_compromiso.setNombre_programa((String) request.getParameter("cmb_programas").trim());
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
            this.carta_compromiso.setNombre_tutor((String) request.getParameter("txt_nombre_tutor").trim());
            this.carta_compromiso.setNombre_representante((String) request.getParameter("txt_nombre_repr_legal").trim());
            this.carta_compromiso.setCargo_representante((String) request.getParameter("txt_cargo_repr_legal").trim());
            this.carta_compromiso.setTelf_representante((String) request.getParameter("txt_fono_repr_legal").trim());
            this.carta_compromiso.setNombre_delegado((String) request.getParameter("txt_nombre_deleg_ups").trim());
            this.carta_compromiso.setCargo_delegado((String) request.getParameter("txt_cargo_deleg_ups").trim());
            this.carta_compromiso.setTelf_delegado((String) request.getParameter("txt_fono_deleg_ups").trim());
            this.carta_compromiso.setLugar_suscripcion("Guayaquil");
            //this.carta_compromiso.setFecha_suscripcion("15/01/2016");
            this.carta_compromiso.setFecha_suscripcion((String)request.getParameter("txt_lugar_fecha_suscrip"));
            this.carta_compromiso.setEstado("A");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean ingresar_carta(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
 
        ArrayList<Parametro> parametro = new ArrayList<>();
        boolean res = false;
        String sql;
        String cod_actividad="";
        String codigo_cc="";
        
        switch (this.carta_compromiso.getTipo_actividad()) {
            case "EXTENSIONES":
                cod_actividad="EX";
                break;
            case "PASANTÍAS":
                cod_actividad="PA";
                break;
            case "PRÁCTICAS PRE PROFESIONALES":
                cod_actividad="PP";
                break;
        }
        codigo_cc="'CC'||nextval(\"secuencial)||'.'||'"+cod_actividad+"-GIS'";
        sql="INSERT INTO \"VCS_CARTA_COMPROMISO\"(\n"
                + "            id_carta_comp, nomb_empresa, \"Dir_empresa\", \"Act_empresa\", \n"
                + "            \"Nomb_estudiante\", \"Carrera_grado\", \"Ciclo_curso\", \"Tipo_actividad\", \n"
                + "            \"Total_horas\", \"Objetivo_actividad\", \"Fecha_inicio\", \"Fecha_fin\", \n"
                + "            \"Horario_previsto\", \"Nombre_programa\", \"Area_actividad\", \"Responsable_area\", \n"
                + "            \"Actividad_1\", \"Actividad_2\", \"Actividad_3\", \"Actividad_4\", \"Actividad_5\", \n"
                + "            \"Actividad_6\", \"Resultado_1\", \"Resultado_2\", \"Resultado_3\", \"Resultado_4\", \n"
                + "            \"Resultado_5\", \"Resultado_6\", \"Producto_1\", \"Producto_2\", \"Producto_3\", \n"
                + "            \"Producto_4\", \"Producto_5\", \"Producto_6\", \"Nombre_tutor\", \"Nombre_representante\", \n"
                + "            \"Cargo_representante\", \"Telf_representante\", \"Nombre_delegado\", \n"
                + "            \"Cargo_delegado\", \"Telf_delegado\", \"Lugar_suscripcion\", \"Fecha_suscripcion\", \n"
                + "            \"Estado\")\n"
                + "    VALUES (?, ?, ?, ?, \n"
                + "            ?, ?, ?, ?, \n"
                + "            ?, ?, to_date(?,'dd/mm/yyyy'), to_date(?,'dd/mm/yyyy'), \n"
                + "            ?, ?, ?, ?, \n"
                + "            ?, ?, ?, ?, ?, \n"
                + "            ?, ?, ?, ?, ?, \n"
                + "            ?, ?, ?, ?, ?, \n"
                + "            ?, ?, ?, ?, ?, \n"
                + "            ?, ?, ?, \n"
                + "            ?, ?, ?, to_date(?,'dd/mm/yyyy'), \n"
                + "            ?)";
        parametro.add(new Parametro(1, "CC03.EX-GIS"));
        parametro.add(new Parametro(2, this.carta_compromiso.getNomb_empresa()));
        parametro.add(new Parametro(3, this.carta_compromiso.getDir_empresa()));
        parametro.add(new Parametro(4, this.carta_compromiso.getAct_empresa()));
        parametro.add(new Parametro(5, this.carta_compromiso.getNomb_estudiante()));
        parametro.add(new Parametro(6, this.carta_compromiso.getCarrera_grado()));
        parametro.add(new Parametro(7, this.carta_compromiso.getCiclo_curso()));
        parametro.add(new Parametro(8, this.carta_compromiso.getTipo_actividad()));
        parametro.add(new Parametro(9, this.carta_compromiso.getTotal_horas()));
        parametro.add(new Parametro(10, this.carta_compromiso.getObjetivo_actividad()));
        parametro.add(new Parametro(11, this.carta_compromiso.getFecha_inicio()));
        parametro.add(new Parametro(12, this.carta_compromiso.getFecha_fin()));
        parametro.add(new Parametro(13, this.carta_compromiso.getHorario_previsto()));
        parametro.add(new Parametro(14, this.carta_compromiso.getNombre_programa()));
        parametro.add(new Parametro(15, this.carta_compromiso.getArea_actividad()));
        parametro.add(new Parametro(16, this.carta_compromiso.getResponsable_area()));
        parametro.add(new Parametro(17, this.carta_compromiso.getActividad_1()));
        parametro.add(new Parametro(18, this.carta_compromiso.getActividad_2()));
        parametro.add(new Parametro(19, this.carta_compromiso.getActividad_3()));
        parametro.add(new Parametro(20, this.carta_compromiso.getActividad_4()));
        parametro.add(new Parametro(21, this.carta_compromiso.getActividad_5()));
        parametro.add(new Parametro(22, this.carta_compromiso.getActividad_6()));
        parametro.add(new Parametro(23, this.carta_compromiso.getResultado_1()));
        parametro.add(new Parametro(24, this.carta_compromiso.getResultado_2()));
        parametro.add(new Parametro(25, this.carta_compromiso.getResultado_3()));
        parametro.add(new Parametro(26, this.carta_compromiso.getResultado_4()));
        parametro.add(new Parametro(27, this.carta_compromiso.getResultado_5()));
        parametro.add(new Parametro(28, this.carta_compromiso.getResultado_6()));
        parametro.add(new Parametro(29, this.carta_compromiso.getProducto_1()));
        parametro.add(new Parametro(30, this.carta_compromiso.getProducto_2()));
        parametro.add(new Parametro(31, this.carta_compromiso.getProducto_3()));
        parametro.add(new Parametro(32, this.carta_compromiso.getProducto_4()));
        parametro.add(new Parametro(33, this.carta_compromiso.getProducto_5()));
        parametro.add(new Parametro(34, this.carta_compromiso.getProducto_6()));
        parametro.add(new Parametro(35, this.carta_compromiso.getNombre_tutor()));
        parametro.add(new Parametro(36, this.carta_compromiso.getNombre_representante()));
        parametro.add(new Parametro(37, this.carta_compromiso.getCargo_representante()));
        parametro.add(new Parametro(38, this.carta_compromiso.getTelf_representante()));
        parametro.add(new Parametro(39, this.carta_compromiso.getNombre_delegado()));
        parametro.add(new Parametro(40, this.carta_compromiso.getCargo_delegado()));
        parametro.add(new Parametro(41, this.carta_compromiso.getTelf_delegado()));
        parametro.add(new Parametro(42, this.carta_compromiso.getLugar_suscripcion()));
        parametro.add(new Parametro(43, this.carta_compromiso.getFecha_suscripcion()));
        parametro.add(new Parametro(44, this.carta_compromiso.getEstado()));
        try {
            res = AccesoDatos.ejecutaComando(sql, parametro);
        } catch (Exception e) {
            out.println("<script>alert(\"No se pudo insertar el registro\")</script>");
            response.sendRedirect(response.encodeRedirectURL("Home.jsp"));
            throw new RuntimeException(e);
        }
        out.println("<script>alert(\"Se inserto el registro\")</script>");
        response.sendRedirect(response.encodeRedirectURL("Home.jsp"));
        return res;
    }
    public static List<Carta_Compromiso> consulta_cc() {
        List<Carta_Compromiso> codigo = new LinkedList<Carta_Compromiso>();

        String sql = "select id_carta_comp, (max(secuencial)+1) from \"VCS_CARTA_COMPROMISO\" where id_carta_comp = 'CC001.PA-GIS' group by id_carta_comp";
        Carta_Compromiso adm_cc;
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);
            while (cres.next()) {
                adm_cc = new Carta_Compromiso();
                adm_cc.setId_carta_compromiso(cres.getString(0).trim());
                adm_cc.setNumero(cres.getString(1).trim());
                codigo.add(adm_cc);
            }
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
