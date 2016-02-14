/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPA_EXT_PAS.eventos;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.PageContext;
import PPA_EXT_PAS.dominio.GBB_SolRetiroDetalle_ret_new;
import PPA_EXT_PAS.dominio.Informe_Peticion_Verbal_cab;
import PPA_EXT_PAS.dominio.Informe_Peticion_Verbal_det;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;

/**
 *
 * @author lpita
 */
public class Informe_Peticion_Verbal {
    Informe_Peticion_Verbal_cab informe_cab;
    Informe_Peticion_Verbal_det informe_det;
        
    public Informe_Peticion_Verbal(PageContext p_pc) throws IOException {
        super();
    }

    public Informe_Peticion_Verbal() throws IOException {
    }

    /**
     * Obtener campos de Retiro
     */
    public Informe_Peticion_Verbal_cab obtenerListaPdfCab() throws SQLException {
        //List l = new ArrayList();
        String sql ="SELECT nomb_empresa,\"Tipo_actividad\",\"Nombre_representante\", \"Nombre_delegado\", \n" +
                    "       \"Cargo_delegado\", \"Lugar_suscripcion\"||' '||\"Fecha_suscripcion\"\n" +
                    "  FROM \"VCS_CARTA_COMPROMISO\" WHERE id_carta_comp = ? and \"Estado\" = 'A'";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,"CC001.PA-GIS"));//quemado
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstPar);
            while(cres.next()){
                this.informe_cab = new Informe_Peticion_Verbal_cab();
                this.informe_cab.setNombre_empresa(cres.getString(0));
                this.informe_cab.setTipo_actividad(cres.getString(1));
                this.informe_cab.setNombre_representante(cres.getString(2));
                this.informe_cab.setNombre_delegado(cres.getString(3));
                this.informe_cab.setCargo_delegado(cres.getString(4));
                this.informe_cab.setCc_fecha_suscripcion(cres.getString(5));
                /*
                this.informe_cab.setPa_cargo(cres.getString(1));
                this.informe_cab.setPa_director_vinculacion(cres.getString(2));
                this.informe_cab.setPa_institucion_sede(cres.getString(3));*/
            }
            //l.add(this.informe_cab);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.informe_cab;
    }
    public List obtenerListaPdfDet() throws SQLException {
        List l = new ArrayList();
        String sql ="SELECT valor\n" +
                    "  FROM \"VCS_PARAMETROS\" where id_parametro = ?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,"peticion_verbal_cuerpo"));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstPar);
            while(cres.next()){
                //this.informe_det = new Informe_Peticion_Verbal_det();
                this.informe_cab = new Informe_Peticion_Verbal_cab();
                this.informe_cab.setValor(cres.getString(0));
            }
            l.add(this.informe_cab);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }
}
