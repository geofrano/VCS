/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPA_EXT_PAS.dominio;

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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Hp
 */
public class Empresa {

    String ue_id;
    String ar_id;
    String nombre_empresa;
    String direccion;
    String telefono;
    String actividad;
    String tipo_empresa;
    String nombre_repre;
    String apellido_repre;
    String cargo_repre;
    String telefono_repre;  

    public String getTipo_empresa() {
        return tipo_empresa;
    }

    public void setTipo_empresa(String tipo_empresa) {
        this.tipo_empresa = tipo_empresa;
    }
    
    public String getNombre_repre() {
        return nombre_repre;
    }

    public void setNombre_repre(String nombre_repre) {
        this.nombre_repre = nombre_repre;
    }

    public String getApellido_repre() {
        return apellido_repre;
    }

    public void setApellido_repre(String apellido_repre) {
        this.apellido_repre = apellido_repre;
    }
    
    public String getUe_id() {
        return ue_id;
    }

    public void setUe_id(String ue_id) {
        this.ue_id = ue_id;
    }
    
    public String getAr_id() {
        return ar_id;
    }

    public void setAr_id(String ar_id) {
        this.ar_id = ar_id;
    }
    
    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getCargo_repre() {
        return cargo_repre;
    }

    public void setCargo_repre(String cargo_repre) {
        this.cargo_repre = cargo_repre;
    }

    public String getTelefono_repre() {
        return telefono_repre;
    }

    public void setTelefono_repre(String telefono_repre) {
        this.telefono_repre = telefono_repre;
    } 
}
