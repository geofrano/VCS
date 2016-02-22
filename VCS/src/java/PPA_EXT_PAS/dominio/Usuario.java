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
  private String us_cargo;//Identificador del cargo al que pertenece el usuario
  private String us_cedula;//Identificacion del usuario CI
  private Date us_fecha_nacimiento;//Fecha de Nacimiento del Usuario
  private String us_celular;//Celular del usuario
  private String us_email;//Email del usuario
  private String us_usuario;//Usuario con el que se logoneara primera letra del nombre y apellido Usar el mismo definido por UPS
  private String us_contrasena;//password del usuario encriptada
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

    public String getUs_cargo() {
        return us_cargo;
    }

    public void setUs_cargo(String us_cargo) {
        this.us_cargo = us_cargo;
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

    public String getUs_estado() {
        return us_estado;
    }

    public void setUs_estado(String us_estado) {
        this.us_estado = us_estado;
    }
  
  
  
  
  
  
}
