/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PPA_EXT_PAS.dominio;

/**
 *
 * @author Geovanny Barrera
 */
public class Menu_principal {
    
    private String id_modulo;
    private String nombre_modulo;
    private String pagina_modulo;
    private String id_modulo_padre;
    private String estado;
    private String icono;
    private String es_padre;
    
    public Menu_principal(){
        super();
    }

    public String getId_modulo() {
        return id_modulo;
    }

    public void setId_modulo(String id_modulo) {
        this.id_modulo = id_modulo;
    }

    public String getNombre_modulo() {
        return nombre_modulo;
    }

    public void setNombre_modulo(String nombre_modulo) {
        this.nombre_modulo = nombre_modulo;
    }

    public String getPagina_modulo() {
        return pagina_modulo;
    }

    public void setPagina_modulo(String pagina_modulo) {
        this.pagina_modulo = pagina_modulo;
    }

    public String getId_modulo_padre() {
        return id_modulo_padre;
    }

    public void setId_modulo_padre(String id_modulo_padre) {
        this.id_modulo_padre = id_modulo_padre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEs_padre() {
        return es_padre;
    }

    public void setEs_padre(String es_padre) {
        this.es_padre = es_padre;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
    
    
    
}
