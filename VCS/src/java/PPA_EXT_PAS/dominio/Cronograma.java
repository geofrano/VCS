/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPA_EXT_PAS.dominio;

/**
 *
 * @author Geovanny Barrera - Luis Pita
 */
public class Cronograma {

    private String id_carta_compromiso;     //Identificador de la Ficha del Estudiante
    private int id_cronograma;
    private int numero_horas_1;
    private int numero_horas_2;
    private int numero_horas_3;
    private int numero_horas_4;
    private int numero_horas_5;
    private int numero_horas_6;
    private String estado;

    public String getId_carta_compromiso() {
        return id_carta_compromiso;
    }

    public void setId_carta_compromiso(String id_carta_compromiso) {
        this.id_carta_compromiso = id_carta_compromiso;
    }

    public int getId_cronograma() {
        return id_cronograma;
    }

    public void setId_cronograma(int id_cronograma) {
        this.id_cronograma = id_cronograma;
    }

    public int getNumero_horas_1() {
        return numero_horas_1;
    }

    public void setNumero_horas_1(int numero_horas_1) {
        this.numero_horas_1 = numero_horas_1;
    }

    public int getNumero_horas_2() {
        return numero_horas_2;
    }

    public void setNumero_horas_2(int numero_horas_2) {
        this.numero_horas_2 = numero_horas_2;
    }

    public int getNumero_horas_3() {
        return numero_horas_3;
    }

    public void setNumero_horas_3(int numero_horas_3) {
        this.numero_horas_3 = numero_horas_3;
    }

    public int getNumero_horas_4() {
        return numero_horas_4;
    }

    public void setNumero_horas_4(int numero_horas_4) {
        this.numero_horas_4 = numero_horas_4;
    }

    public int getNumero_horas_5() {
        return numero_horas_5;
    }

    public void setNumero_horas_5(int numero_horas_5) {
        this.numero_horas_5 = numero_horas_5;
    }

    public int getNumero_horas_6() {
        return numero_horas_6;
    }

    public void setNumero_horas_6(int numero_horas_6) {
        this.numero_horas_6 = numero_horas_6;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
