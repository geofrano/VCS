/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PPA_EXT_PAS.eventos;

import PPA_EXT_PAS.dominio.Usuario;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.util.ArrayList;

//import org.json.JSONException;
//import org.json.JSONObject;

/**
 *
 * @author Geovanny Barrera
 */
public class Autentificar_Usuario {

    private Usuario admin;
    private String mensaje;
    private boolean lb_valida_login;


    public Autentificar_Usuario() {
        this.admin = new Usuario();
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public Usuario getAdmin() {
        return admin;
    }
    
    public boolean autenticaUsuario(String usuario, String clave){
        //AccesoDatos datos = new AccesoDatos();
        boolean lb_valida_login=false;
        
        this.admin.setUs_usuario(usuario);
        this.admin.setUs_contrasena(clave);
        
        String sql ="SELECT us_nombre, us_apellido, us_direccion, \n" +
                    "       us_cargo \n" +
                    "  FROM \"MAU_USUARIO\" where upper(us_usuario)=upper(?) and us_contrasena=(select md5(?)) and "+
                    " us_estado = 'A'";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,this.admin.getUs_usuario()));
        lstPar.add(new Parametro(2,this.admin.getUs_contrasena()));
        try {
            ConjuntoResultado cres=
            AccesoDatos.ejecutaQuery(sql,lstPar);
            while(cres.next()){
               
                this.admin.setUs_nombre(cres.getString(0));
                this.admin.setUs_apellido(cres.getString(1));
                this.admin.setUs_direccion(cres.getString(2));
                this.admin.setUs_cargo(cres.getString(3));
                //this.admin.setUs_email(cres.getString(4));
                lb_valida_login = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (lb_valida_login) {
            this.mensaje = "OK:registro";
        } else {
            this.mensaje = "ERROR:registro";
        }
        return lb_valida_login;
    }
    /*/
    public static JSONObject obtener_mensaje(String mensaje, AC_Usuario usuario, String lang) {
        String valores[] = new String[2];
        valores = mensaje.split(":", 2);
        
        JSONObject json = new JSONObject();
        try {
            if (valores[0].equals("OK")) {
                if (valores[1].equals("registro") || valores[1].equals("verificar")) {
                    json.put("tipo", "OK");
                    json.put("usuario", AC_Usuario.toJSONObject(usuario));
                }
            } else if (valores[0].equals("ERROR")) {
                if (valores[1].equals("registro")) {
                    json.put("tipo", "ERROR");
                    json.put("mensaje", Lenguaje.ERROR_EMAIL_CLAVE[ Lenguaje.parse(lang) ]);
                }
            }
        } catch (JSONException ex) {
            Logger.getLogger(Autentificar_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }*/
    public boolean getLb_valida_login() {
        return lb_valida_login;
    }

    public void setLb_valida_login(boolean lb_valida_login) {
        this.lb_valida_login = lb_valida_login;
    }
}
