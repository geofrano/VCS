/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPA_EXT_PAS.dominio;

/**
 *
 * @author lpita
 */
public class Estudiante {
    private String id_carta_compromiso;
    private int id_secuencial;
    private String nombre_estudiante;
    private String empresa;
    private String estado;
    private String lugar_suscripcion;
    private String fecha_suscripcion;

    public String getId_carta_compromiso() {
        return id_carta_compromiso;
    }

    public void setId_carta_compromiso(String id_carta_compromiso) {
        this.id_carta_compromiso = id_carta_compromiso;
    }

    public int getId_secuencial() {
        return id_secuencial;
    }

    public void setId_secuencial(int id_secuencial) {
        this.id_secuencial = id_secuencial;
    }

    public String getNombre_estudiante() {
        return nombre_estudiante;
    }

    public void setNombre_estudiante(String nombre_estudiante) {
        this.nombre_estudiante = nombre_estudiante;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLugar_suscripcion() {
        return lugar_suscripcion;
    }

    public void setLugar_suscripcion(String lugar_suscripcion) {
        this.lugar_suscripcion = lugar_suscripcion;
    }

    public String getFecha_suscripcion() {
        return fecha_suscripcion;
    }

    public void setFecha_suscripcion(String fecha_suscripcion) {
        this.fecha_suscripcion = fecha_suscripcion;
    }
}
