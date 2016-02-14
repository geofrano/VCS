/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPA_EXT_PAS.eventos;

import PPA_EXT_PAS.dominio.Cronograma;
import accesodatos.AccesoDatos;
import accesodatos.Parametro;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author lpita
 */
public class Administrar_Cronograma {

    private Cronograma cronograma;

    public Administrar_Cronograma(HttpServletRequest request) {
        this.cronograma = new Cronograma();
        this.cronograma.setId_carta_compromiso((String) request.getParameter("id_carta_compromiso"));
        this.cronograma.setId_cronograma(Integer.parseInt(request.getParameter("id_cronograma")));
        this.cronograma.setNumero_horas_1(Integer.parseInt(request.getParameter("numero_horas_1")));
        this.cronograma.setNumero_horas_2(Integer.parseInt(request.getParameter("numero_horas_2")));
        this.cronograma.setNumero_horas_3(Integer.parseInt(request.getParameter("numero_horas_3")));
        this.cronograma.setNumero_horas_4(Integer.parseInt(request.getParameter("numero_horas_4")));
        this.cronograma.setNumero_horas_5(Integer.parseInt(request.getParameter("numero_horas_5")));
        this.cronograma.setNumero_horas_5(Integer.parseInt(request.getParameter("numero_horas_6")));
        this.cronograma.setEstado((String) request.getParameter("estado"));
    }

    public boolean ingresar_cronograma() {
        ArrayList<Parametro> parametro = new ArrayList<>();
        boolean res = false;
        String sql = "INSERT INTO \"VCS_CRONOGRAMA_ACT\"(\n"
                + "            id_cronograma_act, numero_horas_1, numero_horas_2, \n"
                + "            numero_horas_3, numero_horas_4, numero_horas_5, numero_horas_6, \n"
                + "            estado)\n"
                + "    VALUES (?, ?, ?, ?, \n"
                + "            ?, ?, ?, ?);";
        parametro.add(new Parametro(1,this.cronograma.getId_carta_compromiso()));
        parametro.add(new Parametro(2,this.cronograma.getId_cronograma()));
        parametro.add(new Parametro(3,this.cronograma.getNumero_horas_1()));
        parametro.add(new Parametro(4,this.cronograma.getNumero_horas_2()));
        parametro.add(new Parametro(5,this.cronograma.getNumero_horas_3()));
        parametro.add(new Parametro(6,this.cronograma.getNumero_horas_4()));
        parametro.add(new Parametro(7,this.cronograma.getNumero_horas_5()));
        parametro.add(new Parametro(8,this.cronograma.getNumero_horas_6()));
        parametro.add(new Parametro(9,this.cronograma.getEstado()));
        try {
            res = AccesoDatos.ejecutaComando(sql,parametro);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }
}
