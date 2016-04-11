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
public class Ficha_Estudiante {
    
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private String id_estudiante;           //Identificador del estudiante
    private String id_carta_compromiso;     //Identificador de la Ficha del Estudiante
    private String direccion;               //Direccion del Estudiante
    private String telefono;                //Número de Telefono del Estudiante
    private String email;                   //Email del Estudiante
    private String facebook;                //Pagina de Facebook del Estudiante
    private String twiter;                  //Pagina de twiter del Estdiante
    private String linkedin;                //Pagina de Linkedin del Estudiante
    private String responsable_proyecto;    //Responsable del Proyecto
    private String nombre_proyecto;         //Nombre del Proyecto
    private String descripcion_actividades; //Descripcion de las actividades a Realizar
    private String estado;                  //Estado de la Ficha del Estudiante
    private String tipo_documento;          //Tipo de documento del estudiante
    private String fecha_ini;               //Fecha de inicio de la actividad
    private String fecha_fin;               //Fecha de finalizacion de la actividad
    private String actividad;               //Tipo de actividad a realizar
    private String cedula;                  //Cedula del estudiante
    private String nombre_estudiante;       //Nombre del estudiante
    private String carrera;                 //Carrera del estudiante
    private String id_carrera;              //Identificador de la carrera
    private String ciclo;                   //Ciclo o semestre del estudiante
    private String id_ciclo;                //Identificador del ciclo
    private String empresa;                 //Nombre de la empresa
    private String responsable_emp;         //Responsable de la empresa
    private String area_interes;            //Area de interes de la actividad
    private String responsable_area;        //Responsable del area de la empresa
    private String horario_previsto;        //Horario previsto a realizar
    private String cargo_responsable_emp;   //Cargo del responsable de la empresa
    private String fono_emp;                //Telefono de la empresa
    private String direccion_emp;           //Direccion de la empresa
    private String nomb_programa;           //Nombre del programa
    private String nomb_tutor;              //Nnombre del Tutor asignado
    private String cod_proy;                //Codigo del proyecto
    
    
    public String getId_estudiante() {
        return id_estudiante;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Setters & Getters">
    public void setId_estudiante(String id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getCod_proy() {
        return cod_proy;
    }

    public void setCod_proy(String cod_proy) {
        this.cod_proy = cod_proy;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getId_carta_compromiso() {
        return id_carta_compromiso;
    }

    public void setId_carta_compromiso(String id_carta_compromiso) {
        this.id_carta_compromiso = id_carta_compromiso;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwiter() {
        return twiter;
    }

    public void setTwiter(String twiter) {
        this.twiter = twiter;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getResponsable_proyecto() {
        return responsable_proyecto;
    }

    public void setResponsable_proyecto(String responsable_proyecto) {
        this.responsable_proyecto = responsable_proyecto;
    }

    public String getNombre_proyecto() {
        return nombre_proyecto;
    }

    public void setNombre_proyecto(String nombre_proyecto) {
        this.nombre_proyecto = nombre_proyecto;
    }

    public String getDescripcion_actividades() {
        return descripcion_actividades;
    }

    public void setDescripcion_actividades(String descripcion_actividades) {
        this.descripcion_actividades = descripcion_actividades;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(String fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre_estudiante() {
        return nombre_estudiante;
    }

    public void setNombre_estudiante(String nombre_estudiante) {
        this.nombre_estudiante = nombre_estudiante;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getResponsable_emp() {
        return responsable_emp;
    }

    public void setResponsable_emp(String responsable_emp) {
        this.responsable_emp = responsable_emp;
    }

    public String getArea_interes() {
        return area_interes;
    }

    public void setArea_interes(String area_interes) {
        this.area_interes = area_interes;
    }

    public String getResponsable_area() {
        return responsable_area;
    }

    public void setResponsable_area(String responsable_area) {
        this.responsable_area = responsable_area;
    }

    public String getHorario_previsto() {
        return horario_previsto;
    }

    public void setHorario_previsto(String horario_previsto) {
        this.horario_previsto = horario_previsto;
    }

    public String getCargo_responsable_emp() {
        return cargo_responsable_emp;
    }

    public void setCargo_responsable_emp(String cargo_responsable_emp) {
        this.cargo_responsable_emp = cargo_responsable_emp;
    }

    public String getFono_emp() {
        return fono_emp;
    }

    public void setFono_emp(String fono_emp) {
        this.fono_emp = fono_emp;
    }

    public String getDireccion_emp() {
        return direccion_emp;
    }

    public void setDireccion_emp(String direccion_emp) {
        this.direccion_emp = direccion_emp;
    }

    public String getNomb_programa() {
        return nomb_programa;
    }

    public void setNomb_programa(String nomb_programa) {
        this.nomb_programa = nomb_programa;
    }

    public String getNomb_tutor() {
        return nomb_tutor;
    }

    public void setNomb_tutor(String nomb_tutor) {
        this.nomb_tutor = nomb_tutor;
    }
    
    public String getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(String id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getId_ciclo() {
        return id_ciclo;
    }

    public void setId_ciclo(String id_ciclo) {
        this.id_ciclo = id_ciclo;
    }
    // </editor-fold>
}
