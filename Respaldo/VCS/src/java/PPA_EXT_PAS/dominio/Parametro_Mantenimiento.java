/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPA_EXT_PAS.dominio;

/**
 *
 * @author Hp
 */
public class Parametro_Mantenimiento {
    String id_parametro;
    String descripcion;
    String valor;
    String tipo_des;
    String tipo;

    public String getId_parametro() {
        return id_parametro;
    }

    public void setId_parametro(String id_parametro) {
        this.id_parametro = id_parametro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo_des() {
        return tipo_des;
    }

    public void setTipo_des(String tipo_des) {
        this.tipo_des = tipo_des;
    }
    
    
}
