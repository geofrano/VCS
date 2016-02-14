/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PPA_EXT_PAS.dominio;

import java.util.Date;

/**
 *
 * @author Geovanny Barrera
 */
public class Usuario {
  private String us_nombre;//Nombre del Usuario
  private String us_apellido;//Apellidos del usuario
  private String us_direccion;//Direccion del Usuario
  private String us_casilla_postal;//Casilla postal del usuario
  private Integer id_carrera;//Identificador de la Carrera
  private Integer id_cargo;//Identificador del cargo al que pertenece el usuario
  private String us_nacionalidad;//Nacionalidad del usuario
  private String us_cedula;//Identificacion del usuario CI
  private Date us_fecha_nacimiento;//Fecha de Nacimiento del Usuario
  private String us_telefono_trabajo;//Telefono de la oficina
  private String us_telefono_casa;//Telefono de la casa
  private String us_celular;//Celular del usuario
  private String us_email;//Email del usuario
  private String us_usuario;//Usuario con el que se logoneara primera letra del nombre y apellido Usar el mismo definido por UPS
  private String us_contrasena;//password del usuario encriptada
  private String us_sexo;//Sexo del usuario M - Masculino y F - Femenino
  private String us_tutor;//Identifica si el usuario es tutor S - SI y N - NO
  private String us_estado;//Estado del usuario A - activo e I - inactivo

    public String getUs_nombre() {
        return us_nombre;
    }

    public void setUs_nombre(String us_nombre) {
        this.us_nombre = us_nombre;
    }

    public String getUs_apellido() {
        return us_apellido;
    }

    public void setUs_apellido(String us_apellido) {
        this.us_apellido = us_apellido;
    }

    public String getUs_direccion() {
        return us_direccion;
    }

    public void setUs_direccion(String us_direccion) {
        this.us_direccion = us_direccion;
    }

    public String getUs_casilla_postal() {
        return us_casilla_postal;
    }

    public void setUs_casilla_postal(String us_casilla_postal) {
        this.us_casilla_postal = us_casilla_postal;
    }

    public Integer getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(Integer id_carrera) {
        this.id_carrera = id_carrera;
    }

    public Integer getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(Integer id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getUs_nacionalidad() {
        return us_nacionalidad;
    }

    public void setUs_nacionalidad(String us_nacionalidad) {
        this.us_nacionalidad = us_nacionalidad;
    }

    public String getUs_cedula() {
        return us_cedula;
    }

    public void setUs_cedula(String us_cedula) {
        this.us_cedula = us_cedula;
    }

    public Date getUs_fecha_nacimiento() {
        return us_fecha_nacimiento;
    }

    public void setUs_fecha_nacimiento(Date us_fecha_nacimiento) {
        this.us_fecha_nacimiento = us_fecha_nacimiento;
    }

    public String getUs_telefono_trabajo() {
        return us_telefono_trabajo;
    }

    public void setUs_telefono_trabajo(String us_telefono_trabajo) {
        this.us_telefono_trabajo = us_telefono_trabajo;
    }

    public String getUs_telefono_casa() {
        return us_telefono_casa;
    }

    public void setUs_telefono_casa(String us_telefono_casa) {
        this.us_telefono_casa = us_telefono_casa;
    }

    public String getUs_celular() {
        return us_celular;
    }

    public void setUs_celular(String us_celular) {
        this.us_celular = us_celular;
    }

    public String getUs_email() {
        return us_email;
    }

    public void setUs_email(String us_email) {
        this.us_email = us_email;
    }

    public String getUs_usuario() {
        return us_usuario;
    }

    public void setUs_usuario(String us_usuario) {
        this.us_usuario = us_usuario;
    }

    public String getUs_contrasena() {
        return us_contrasena;
    }

    public void setUs_contrasena(String us_contrasena) {
        this.us_contrasena = us_contrasena;
    }

    public String getUs_sexo() {
        return us_sexo;
    }

    public void setUs_sexo(String us_sexo) {
        this.us_sexo = us_sexo;
    }

    public String getUs_tutor() {
        return us_tutor;
    }

    public void setUs_tutor(String us_tutor) {
        this.us_tutor = us_tutor;
    }

    public String getUs_estado() {
        return us_estado;
    }

    public void setUs_estado(String us_estado) {
        this.us_estado = us_estado;
    }
  
  
  
  
  
  
}
