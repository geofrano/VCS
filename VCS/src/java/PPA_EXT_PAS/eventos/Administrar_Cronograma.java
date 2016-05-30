/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPA_EXT_PAS.eventos;

import PPA_EXT_PAS.dominio.Cronograma;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author lpita
 */
public class Administrar_Cronograma {

    private Cronograma cronograma;
    public Administrar_Cronograma(){
        super();
    }
    public Administrar_Cronograma(HttpServletRequest request) {
        this.cronograma = new Cronograma();
        this.cronograma.setId_carta_compromiso((String) request.getParameter("txt_id_carta_comp"));
        this.cronograma.setCod_actividad_1((String) request.getParameter("txt_cod_act_1"));
        this.cronograma.setCod_actividad_2((String) request.getParameter("txt_cod_act_2"));
        this.cronograma.setCod_actividad_3((String)request.getParameter("txt_cod_act_3"));
        this.cronograma.setCod_actividad_4((String) request.getParameter("txt_cod_act_4"));
        this.cronograma.setCod_actividad_5((String) request.getParameter("txt_cod_act_5"));
        this.cronograma.setCod_actividad_6((String) request.getParameter("txt_cod_act_6"));
        
        this.cronograma.setSemana_1_act_1((String) request.getParameter("txt_semana_1_1"));//Numero de hora por semana
        this.cronograma.setSemana_2_act_1((String) request.getParameter("txt_semana_1_2"));
        this.cronograma.setSemana_3_act_1((String) request.getParameter("txt_semana_1_3"));
        this.cronograma.setSemana_4_act_1((String) request.getParameter("txt_semana_1_4"));
        this.cronograma.setSemana_5_act_1((String) request.getParameter("txt_semana_1_5"));
        this.cronograma.setSemana_6_act_1((String) request.getParameter("txt_semana_1_6"));
        this.cronograma.setSemana_7_act_1((String) request.getParameter("txt_semana_1_7"));
        this.cronograma.setSemana_8_act_1((String) request.getParameter("txt_semana_1_8"));
        this.cronograma.setSemana_9_act_1((String) request.getParameter("txt_semana_1_9"));
        this.cronograma.setSemana_10_act_1((String) request.getParameter("txt_semana_1_10"));
        this.cronograma.setSemana_11_act_1((String) request.getParameter("txt_semana_1_11"));
        this.cronograma.setSemana_12_act_1((String) request.getParameter("txt_semana_1_12"));
        this.cronograma.setSemana_13_act_1((String) request.getParameter("txt_semana_1_13"));
        this.cronograma.setSemana_14_act_1((String) request.getParameter("txt_semana_1_14"));
	this.cronograma.setSemana_15_act_1((String) request.getParameter("txt_semana_1_15"));
                
        this.cronograma.setSemana_1_act_2((String) request.getParameter("txt_semana_2_1"));//Numero de hora por semana
        this.cronograma.setSemana_2_act_2((String) request.getParameter("txt_semana_2_2"));
        this.cronograma.setSemana_3_act_2((String) request.getParameter("txt_semana_2_3"));
        this.cronograma.setSemana_4_act_2((String) request.getParameter("txt_semana_2_4"));
        this.cronograma.setSemana_5_act_2((String) request.getParameter("txt_semana_2_5"));
        this.cronograma.setSemana_6_act_2((String) request.getParameter("txt_semana_2_6"));
        this.cronograma.setSemana_7_act_2((String) request.getParameter("txt_semana_2_7"));
        this.cronograma.setSemana_8_act_2((String) request.getParameter("txt_semana_2_8"));
        this.cronograma.setSemana_9_act_2((String) request.getParameter("txt_semana_2_9"));
        this.cronograma.setSemana_10_act_2((String) request.getParameter("txt_semana_2_10"));
        this.cronograma.setSemana_11_act_2((String) request.getParameter("txt_semana_2_11"));
        this.cronograma.setSemana_12_act_2((String) request.getParameter("txt_semana_2_12"));
        this.cronograma.setSemana_13_act_2((String) request.getParameter("txt_semana_2_13"));
        this.cronograma.setSemana_14_act_2((String) request.getParameter("txt_semana_2_14"));
	this.cronograma.setSemana_15_act_2((String) request.getParameter("txt_semana_2_15"));
        
        this.cronograma.setSemana_1_act_3((String) request.getParameter("txt_semana_3_1"));//Numero de hora por semana
        this.cronograma.setSemana_2_act_3((String) request.getParameter("txt_semana_3_2"));
        this.cronograma.setSemana_3_act_3((String) request.getParameter("txt_semana_3_3"));
        this.cronograma.setSemana_4_act_3((String) request.getParameter("txt_semana_3_4"));
        this.cronograma.setSemana_5_act_3((String) request.getParameter("txt_semana_3_5"));
        this.cronograma.setSemana_6_act_3((String) request.getParameter("txt_semana_3_6"));
        this.cronograma.setSemana_7_act_3((String) request.getParameter("txt_semana_3_7"));
        this.cronograma.setSemana_8_act_3((String) request.getParameter("txt_semana_3_8"));
        this.cronograma.setSemana_9_act_3((String) request.getParameter("txt_semana_3_9"));
        this.cronograma.setSemana_10_act_3((String) request.getParameter("txt_semana_3_10"));
        this.cronograma.setSemana_11_act_3((String) request.getParameter("txt_semana_3_11"));
        this.cronograma.setSemana_12_act_3((String) request.getParameter("txt_semana_3_12"));
        this.cronograma.setSemana_13_act_3((String) request.getParameter("txt_semana_3_13"));
        this.cronograma.setSemana_14_act_3((String) request.getParameter("txt_semana_3_14"));
	this.cronograma.setSemana_15_act_3((String) request.getParameter("txt_semana_3_15"));
        
        this.cronograma.setSemana_1_act_4((String) request.getParameter("txt_semana_4_1"));//Numero de hora por semana
        this.cronograma.setSemana_2_act_4((String) request.getParameter("txt_semana_4_2"));
        this.cronograma.setSemana_3_act_4((String) request.getParameter("txt_semana_4_3"));
        this.cronograma.setSemana_4_act_4((String) request.getParameter("txt_semana_4_4"));
        this.cronograma.setSemana_5_act_4((String) request.getParameter("txt_semana_4_5"));
        this.cronograma.setSemana_6_act_4((String) request.getParameter("txt_semana_4_6"));
        this.cronograma.setSemana_7_act_4((String) request.getParameter("txt_semana_4_7"));
        this.cronograma.setSemana_8_act_4((String) request.getParameter("txt_semana_4_8"));
        this.cronograma.setSemana_9_act_4((String) request.getParameter("txt_semana_4_9"));
        this.cronograma.setSemana_10_act_4((String) request.getParameter("txt_semana_4_10"));
        this.cronograma.setSemana_11_act_4((String) request.getParameter("txt_semana_4_11"));
        this.cronograma.setSemana_12_act_4((String) request.getParameter("txt_semana_4_12"));
        this.cronograma.setSemana_13_act_4((String) request.getParameter("txt_semana_4_13"));
        this.cronograma.setSemana_14_act_4((String) request.getParameter("txt_semana_4_14"));
	this.cronograma.setSemana_15_act_4((String) request.getParameter("txt_semana_4_15"));
        
        this.cronograma.setSemana_1_act_5((String) request.getParameter("txt_semana_5_1"));//Numero de hora por semana
        this.cronograma.setSemana_2_act_5((String) request.getParameter("txt_semana_5_2"));
        this.cronograma.setSemana_3_act_5((String) request.getParameter("txt_semana_5_3"));
        this.cronograma.setSemana_4_act_5((String) request.getParameter("txt_semana_5_4"));
        this.cronograma.setSemana_5_act_5((String) request.getParameter("txt_semana_5_5"));
        this.cronograma.setSemana_6_act_5((String) request.getParameter("txt_semana_5_6"));
        this.cronograma.setSemana_7_act_5((String) request.getParameter("txt_semana_5_7"));
        this.cronograma.setSemana_8_act_5((String) request.getParameter("txt_semana_5_8"));
        this.cronograma.setSemana_9_act_5((String) request.getParameter("txt_semana_5_9"));
        this.cronograma.setSemana_10_act_5((String) request.getParameter("txt_semana_5_10"));
        this.cronograma.setSemana_11_act_5((String) request.getParameter("txt_semana_5_11"));
        this.cronograma.setSemana_12_act_5((String) request.getParameter("txt_semana_5_12"));
        this.cronograma.setSemana_13_act_5((String) request.getParameter("txt_semana_5_13"));
        this.cronograma.setSemana_14_act_5((String) request.getParameter("txt_semana_5_14"));
	this.cronograma.setSemana_15_act_5((String) request.getParameter("txt_semana_5_15"));
        
        this.cronograma.setSemana_1_act_6((String) request.getParameter("txt_semana_6_1"));//Numero de hora por semana
        this.cronograma.setSemana_2_act_6((String) request.getParameter("txt_semana_6_2"));
        this.cronograma.setSemana_3_act_6((String) request.getParameter("txt_semana_6_3"));
        this.cronograma.setSemana_4_act_6((String) request.getParameter("txt_semana_6_4"));
        this.cronograma.setSemana_5_act_6((String) request.getParameter("txt_semana_6_5"));
        this.cronograma.setSemana_6_act_6((String) request.getParameter("txt_semana_6_6"));
        this.cronograma.setSemana_7_act_6((String) request.getParameter("txt_semana_6_7"));
        this.cronograma.setSemana_8_act_6((String) request.getParameter("txt_semana_6_8"));
        this.cronograma.setSemana_9_act_6((String) request.getParameter("txt_semana_6_9"));
        this.cronograma.setSemana_10_act_6((String) request.getParameter("txt_semana_6_10"));
        this.cronograma.setSemana_11_act_6((String) request.getParameter("txt_semana_6_11"));
        this.cronograma.setSemana_12_act_6((String) request.getParameter("txt_semana_6_12"));
        this.cronograma.setSemana_13_act_6((String) request.getParameter("txt_semana_6_13"));
        this.cronograma.setSemana_14_act_6((String) request.getParameter("txt_semana_6_14"));
	this.cronograma.setSemana_15_act_6((String) request.getParameter("txt_semana_6_15"));
        
    }

    public String procesar_peticion(String accion) {
        ArrayList<Parametro> parametros = new ArrayList<>();
        Administrar_Carta_Compromiso adm_cc= new Administrar_Carta_Compromiso();
        String res = "";
        String sql = "SELECT f_inserta_cronograma(\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ?,\n" +
                                                "  ? " +//ACCION
                                            ")";//CC001.PA-GIS-2
                
        parametros.add(new Parametro(1, this.cronograma.getId_carta_compromiso()));
        parametros.add(new Parametro(2, this.cronograma.getCod_actividad_1()));
        parametros.add(new Parametro(3, this.cronograma.getCod_actividad_2()));
        parametros.add(new Parametro(4, this.cronograma.getCod_actividad_3()));
        parametros.add(new Parametro(5, this.cronograma.getCod_actividad_4()));
        parametros.add(new Parametro(6, this.cronograma.getCod_actividad_5()));
        parametros.add(new Parametro(7, this.cronograma.getCod_actividad_6()));
        //mensaje==null?"":mensaje
        parametros.add(new Parametro(8, this.cronograma.getSemana_1_act_1()));
        parametros.add(new Parametro(9, this.cronograma.getSemana_2_act_1()));
        parametros.add(new Parametro(10, this.cronograma.getSemana_3_act_1()));
        parametros.add(new Parametro(11, this.cronograma.getSemana_4_act_1()));
        parametros.add(new Parametro(12, this.cronograma.getSemana_5_act_1()));
        parametros.add(new Parametro(13, this.cronograma.getSemana_6_act_1()));
        parametros.add(new Parametro(14, this.cronograma.getSemana_7_act_1()));
        parametros.add(new Parametro(15, this.cronograma.getSemana_8_act_1()));
        parametros.add(new Parametro(16, this.cronograma.getSemana_9_act_1()));
        parametros.add(new Parametro(17, this.cronograma.getSemana_10_act_1()));
        parametros.add(new Parametro(18, this.cronograma.getSemana_11_act_1()));
        parametros.add(new Parametro(19, this.cronograma.getSemana_12_act_1()));
        parametros.add(new Parametro(20, this.cronograma.getSemana_13_act_1()));
        parametros.add(new Parametro(21, this.cronograma.getSemana_14_act_1()));
	parametros.add(new Parametro(22, this.cronograma.getSemana_15_act_1()));
        
        parametros.add(new Parametro(23, this.cronograma.getSemana_1_act_2()));
        parametros.add(new Parametro(24, this.cronograma.getSemana_2_act_2()));
        parametros.add(new Parametro(25, this.cronograma.getSemana_3_act_2()));
        parametros.add(new Parametro(26, this.cronograma.getSemana_4_act_2()));
        parametros.add(new Parametro(27, this.cronograma.getSemana_5_act_2()));
        parametros.add(new Parametro(28, this.cronograma.getSemana_6_act_2()));
        parametros.add(new Parametro(29, this.cronograma.getSemana_7_act_2()));
        parametros.add(new Parametro(30, this.cronograma.getSemana_8_act_2()));
        parametros.add(new Parametro(31, this.cronograma.getSemana_9_act_2()));
        parametros.add(new Parametro(32, this.cronograma.getSemana_10_act_2()));
        parametros.add(new Parametro(33, this.cronograma.getSemana_11_act_2()));
        parametros.add(new Parametro(34, this.cronograma.getSemana_12_act_2()));
        parametros.add(new Parametro(35, this.cronograma.getSemana_13_act_2()));
        parametros.add(new Parametro(36, this.cronograma.getSemana_14_act_2()));
	parametros.add(new Parametro(37, this.cronograma.getSemana_15_act_2()));
        
        parametros.add(new Parametro(38, this.cronograma.getSemana_1_act_3()));
        parametros.add(new Parametro(39, this.cronograma.getSemana_2_act_3()));
        parametros.add(new Parametro(40, this.cronograma.getSemana_3_act_3()));
        parametros.add(new Parametro(41, this.cronograma.getSemana_4_act_3()));
        parametros.add(new Parametro(42, this.cronograma.getSemana_5_act_3()));
        parametros.add(new Parametro(43, this.cronograma.getSemana_6_act_3()));
        parametros.add(new Parametro(44, this.cronograma.getSemana_7_act_3()));
        parametros.add(new Parametro(45, this.cronograma.getSemana_8_act_3()));
        parametros.add(new Parametro(46, this.cronograma.getSemana_9_act_3()));
        parametros.add(new Parametro(47, this.cronograma.getSemana_10_act_3()));
        parametros.add(new Parametro(48, this.cronograma.getSemana_11_act_3()));
        parametros.add(new Parametro(49, this.cronograma.getSemana_12_act_3()));
        parametros.add(new Parametro(50, this.cronograma.getSemana_13_act_3()));
        parametros.add(new Parametro(51, this.cronograma.getSemana_14_act_3()));
	parametros.add(new Parametro(52, this.cronograma.getSemana_15_act_3()));
        
        parametros.add(new Parametro(53, this.cronograma.getSemana_1_act_4()));
        parametros.add(new Parametro(54, this.cronograma.getSemana_2_act_4()));
        parametros.add(new Parametro(55, this.cronograma.getSemana_3_act_4()));
        parametros.add(new Parametro(56, this.cronograma.getSemana_4_act_4()));
        parametros.add(new Parametro(57, this.cronograma.getSemana_5_act_4()));
        parametros.add(new Parametro(58, this.cronograma.getSemana_6_act_4()));
        parametros.add(new Parametro(59, this.cronograma.getSemana_7_act_4()));
        parametros.add(new Parametro(60, this.cronograma.getSemana_8_act_4()));
        parametros.add(new Parametro(61, this.cronograma.getSemana_9_act_4()));
        parametros.add(new Parametro(62, this.cronograma.getSemana_10_act_4()));
        parametros.add(new Parametro(63, this.cronograma.getSemana_11_act_4()));
        parametros.add(new Parametro(64, this.cronograma.getSemana_12_act_4()));
        parametros.add(new Parametro(65, this.cronograma.getSemana_13_act_4()));
        parametros.add(new Parametro(66, this.cronograma.getSemana_14_act_4()));
	parametros.add(new Parametro(67, this.cronograma.getSemana_15_act_4()));
        
        parametros.add(new Parametro(68, this.cronograma.getSemana_1_act_5()));
        parametros.add(new Parametro(69, this.cronograma.getSemana_2_act_5()));
        parametros.add(new Parametro(70, this.cronograma.getSemana_3_act_5()));
        parametros.add(new Parametro(71, this.cronograma.getSemana_4_act_5()));
        parametros.add(new Parametro(72, this.cronograma.getSemana_5_act_5()));
        parametros.add(new Parametro(73, this.cronograma.getSemana_6_act_5()));
        parametros.add(new Parametro(74, this.cronograma.getSemana_7_act_5()));
        parametros.add(new Parametro(75, this.cronograma.getSemana_8_act_5()));
        parametros.add(new Parametro(76, this.cronograma.getSemana_9_act_5()));
        parametros.add(new Parametro(77, this.cronograma.getSemana_10_act_5()));
        parametros.add(new Parametro(78, this.cronograma.getSemana_11_act_5()));
        parametros.add(new Parametro(79, this.cronograma.getSemana_12_act_5()));
        parametros.add(new Parametro(80, this.cronograma.getSemana_13_act_5()));
        parametros.add(new Parametro(81, this.cronograma.getSemana_14_act_5()));
	parametros.add(new Parametro(82, this.cronograma.getSemana_15_act_5()));
        
        parametros.add(new Parametro(83, this.cronograma.getSemana_1_act_6()));
        parametros.add(new Parametro(84, this.cronograma.getSemana_2_act_6()));
        parametros.add(new Parametro(85, this.cronograma.getSemana_3_act_6()));
        parametros.add(new Parametro(86, this.cronograma.getSemana_4_act_6()));
        parametros.add(new Parametro(87, this.cronograma.getSemana_5_act_6()));
        parametros.add(new Parametro(88, this.cronograma.getSemana_6_act_6()));
        parametros.add(new Parametro(89, this.cronograma.getSemana_7_act_6()));
        parametros.add(new Parametro(90, this.cronograma.getSemana_8_act_6()));
        parametros.add(new Parametro(91, this.cronograma.getSemana_9_act_6()));
        parametros.add(new Parametro(92, this.cronograma.getSemana_10_act_6()));
        parametros.add(new Parametro(93, this.cronograma.getSemana_11_act_6()));
        parametros.add(new Parametro(94, this.cronograma.getSemana_12_act_6()));
        parametros.add(new Parametro(95, this.cronograma.getSemana_13_act_6()));
        parametros.add(new Parametro(96, this.cronograma.getSemana_14_act_6()));
	parametros.add(new Parametro(97, this.cronograma.getSemana_15_act_6()));

        parametros.add(new Parametro(98, accion));
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
        String sql = "DELETE FROM \"MPP_CRONOGRAMA_ACT\"\n" +
                    " WHERE ae_id in (select ae_id from \"MPP_ASIGNAR_ELEMENTO\" where cc_id = ?)";
        parametros.add(new Parametro(1, cc_id.trim()));
        Administrar_Ficha_Estudiante adm_ficha = new Administrar_Ficha_Estudiante();
        try {
             boolean cres = AccesoDatos.ejecutaComando(sql, parametros);
             String act=adm_ficha.actualiza_estado_cc(cc_id,"A");
             if (cres){
                 res="SI";
             }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }
    
}
