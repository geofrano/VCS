package PPA_EXT_PAS.dominio;

/**
 *
 * @author lpita
 */
public class Informe_Peticion_Verbal_cab {
    
    public String tipo=null;
    public String dato=null;
    public String valor=null;
    
    
    public Informe_Peticion_Verbal_cab() {
        this.tipo=null;
        this.dato=null;
    }
    
    private String cc_fecha_suscripcion;
    private String pa_director_vinculacion;
    private String pa_cargo;
    private String pa_institucion_sede;
    private String nombre_empresa;
    private String tipo_actividad;
    private String nombre_representante;
    private String nombre_delegado;
    private String cargo_delegado;
    private String lugar_suscripcion;

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getTipo_actividad() {
        return tipo_actividad;
    }

    public void setTipo_actividad(String tipo_actividad) {
        this.tipo_actividad = tipo_actividad;
    }

    public String getNombre_representante() {
        return nombre_representante;
    }

    public void setNombre_representante(String nombre_representante) {
        this.nombre_representante = nombre_representante;
    }

    public String getNombre_delegado() {
        return nombre_delegado;
    }

    public void setNombre_delegado(String nombre_delegado) {
        this.nombre_delegado = nombre_delegado;
    }

    public String getCargo_delegado() {
        return cargo_delegado;
    }

    public void setCargo_delegado(String cargo_delegado) {
        this.cargo_delegado = cargo_delegado;
    }

    public String getLugar_suscripcion() {
        return lugar_suscripcion;
    }

    public void setLugar_suscripcion(String lugar_suscripcion) {
        this.lugar_suscripcion = lugar_suscripcion;
    }
    
            
    
    
    
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getCc_fecha_suscripcion() {
        return cc_fecha_suscripcion;
    }

    public void setCc_fecha_suscripcion(String cc_fecha_suscripcion) {
        this.cc_fecha_suscripcion = cc_fecha_suscripcion;
    }

    public String getPa_director_vinculacion() {
        return pa_director_vinculacion;
    }

    public void setPa_director_vinculacion(String pa_director_vinculacion) {
        this.pa_director_vinculacion = pa_director_vinculacion;
    }

    public String getPa_cargo() {
        return pa_cargo;
    }

    public void setPa_cargo(String pa_cargo) {
        this.pa_cargo = pa_cargo;
    }

    public String getPa_institucion_sede() {
        return pa_institucion_sede;
    }

    public void setPa_institucion_sede(String pa_institucion_sede) {
        this.pa_institucion_sede = pa_institucion_sede;
    }
    
}
