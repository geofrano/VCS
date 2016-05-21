/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPA_EXT_PAS.eventos;

import PPA_EXT_PAS.dominio.Menu_principal;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Geovanny Barrera
 */
public class Administrar_Menu_Principal {

    private Menu_principal menu_principal;

    public Administrar_Menu_Principal() {
        this.menu_principal = new Menu_principal();
    }

    public void recorre_paginas(Integer id_modulo, HttpServletResponse response,HttpServletRequest request) throws IOException {
        PrintWriter out = response.getWriter();
        String nomb_pagina=request.getParameter("nombre_pagina").toString();
        
        String sql = "SELECT id_modulo, nombre_modulo, id_modulo_padre, \"Pagina_modulo\",estado\n"
                + "  FROM \"VCS_MODULOS\" where coalesce(id_modulo_padre, 0)=? and estado='A'";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id_modulo));
        Administrar_Menu_Principal adm_menu;
        try {

            out.println("<!DOCTYPE html><html ng-app=\"VCS\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n"
                    + "        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" >\n"
                    + "        <link rel=\"stylesheet\" href=\"css/principal.css\" >\n"
                    + "<title>Sistema Administrativo VCS - UPS</title>"
                    + "        <script src=\"js/angular.min.js\"></script>\n"
                    + "        <script src=\"js/carga_pagina.js\"></script>\n"
                    + "        <script src=\"js/jquery.js\"></script>\n"
                    + "        <script src=\"js/bootstrap.min.js\"></script></head><body ng-controller=\"ControladorVCS\">");
            out.println("<div class=\"container\"><div class=\"row\">");
            RequestDispatcher a=request.getRequestDispatcher("vistas/cabecera_pagina.jsp");//Pinta la cabecera de la Pagina
	    //a.forward(request, response);
            a.include(request, response);
            //out.println("<jsp:include page=\"vistas/cabecera_pagina.jsp\" />");
            out.println("</div><div class=\"row\"><div class=\"col-md-3\">");
            out.println("<ul class=\"nav nav-pills nav-stacked\">");
            ConjuntoResultado cres
                    = AccesoDatos.ejecutaQuery(sql, lstPar);

            while (cres.next()) {
                adm_menu = new Administrar_Menu_Principal();

                out.println("<li class=\"dropdown\">\n"
                        + "    <a href=\"" + cres.getString(3).trim() + "\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" data-hover=\"dropdown\">\n"
                        + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + cres.getString(1).trim() + " <b class=\"caret\"></b>\n"
                        + "    </a>");
                //out.println("<div class=\"col-md-4\">"+cres.getString(3).trim()+"</div>");
                out.println("<ul class=\"dropdown-menu\">");
                //out.println(cres.getString(0) + " " + cres.getString(1) + cres.getString(3) + "<br>");
                adm_menu.recorre_paginas2(cres.getObject(0), response);
                //out.println("<ul class=\"dropdown-menu\"></li> ");
                //this.menu_principal.setUs_nombre(cres.getString(0));
            }
            out.println("</ul></ul></li></div><div class=\"col-md-9\">");
            RequestDispatcher b=request.getRequestDispatcher("vistas/"+nomb_pagina+".jsp");//pagina hija
            b.include(request, response);
            
            
            out.println("</div></div>");
            
            out.println("<div class=\"row\"><div class=\"col-md-12\">");
            RequestDispatcher c=request.getRequestDispatcher("vistas/pie_pagina.jsp");//Pinta el pie de la pagina
            c.include(request, response);
            out.println("</div></div>");
            
            out.println("</div></body></html>");
            out.close();
        } catch (Exception e) {
            out.close();
            throw new RuntimeException(e);
        }

    }

    public void recorre_paginas2(Object id_modulo, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String sql = "SELECT id_modulo, nombre_modulo, id_modulo_padre, \"Pagina_modulo\",estado\n"
                + "  FROM \"VCS_MODULOS\" where id_modulo_padre=? and estado='A';";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id_modulo));
        Administrar_Menu_Principal adm_menu;
        try {
            ConjuntoResultado cres
                    = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                adm_menu = new Administrar_Menu_Principal();
                if (cres.getString(3).trim().equals("#")) {//Es un
                    out.println("<li class=\"active\"><a href=\"" + cres.getString(3).trim() + "\">" + cres.getString(1).trim() + "</a></li>\n"
                            + "        <li class=\"divider\"></li>");
                } else {
                    out.println("<li><a href=\"" + cres.getString(3).trim() + "\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + cres.getString(1).trim() + "</a></li>\n"
                            + "        <li class=\"divider\"></li>");
                }
                //out.println(cres.getString(0) + " " + cres.getString(1) + cres.getString(3) + "<br>");
                recorre_paginas2(cres.getObject(0), response);
                //this.menu_principal.setUs_nombre(cres.getString(0));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public String total_menus(String usuario,String id_menu_padre) {

        String sql = "SELECT count(c.me_id)\n" +
                        "FROM \"MAU_USUARIO\" a, \"MAU_ROL\" b, \"MAU_MENU\" c, \"MAU_MENU_ROL\" d\n" +
                        "where upper(trim(a.us_usuario)) = ? \n" +
                        "and c.me_menu_padre = CAST(? AS integer) \n"+
                        "and a.ro_id = b.ro_id\n" +
                        "and c.me_id = d.me_id\n" +
                        "and d.ro_id = b.ro_id\n" +
                        "and c.me_estado='A'\n" +
                        "order by 1";
        String res="";
        
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, usuario.toUpperCase()));
        lstPar.add(new Parametro(2, id_menu_padre));
        try {
            ConjuntoResultado cres
                    = AccesoDatos.ejecutaQuery(sql,lstPar);
            while (cres.next()) {
                res=cres.getString(0);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }
    public static List<Menu_principal> mostrar_menu(String usuario) {
        List< Menu_principal > opciones = new LinkedList< Menu_principal >();

        String sql = "SELECT c.me_id, c.me_nombre, c.me_menu_padre, c.me_pagina, c.me_icono,c.me_es_padre\n" +
                        "FROM \"MAU_USUARIO\" a, \"MAU_ROL\" b, \"MAU_MENU\" c, \"MAU_MENU_ROL\" d\n" +
                        "where upper(trim(a.us_usuario)) = ? \n" +
                        "and a.ro_id = b.ro_id\n" +
                        "and c.me_id = d.me_id\n" +
                        "and d.ro_id = b.ro_id\n" +
                        "and c.me_estado='A'\n" +
                        "order by 1";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, usuario.toUpperCase()));
        Menu_principal adm_menu;
        try {
            ConjuntoResultado cres
                    = AccesoDatos.ejecutaQuery(sql,lstPar);
            while (cres.next()) {
                adm_menu = new Menu_principal();
                adm_menu.setId_modulo(cres.getString(0).trim());
                adm_menu.setNombre_modulo(cres.getString(1).trim());
                adm_menu.setId_modulo_padre(cres.getString(2).trim());
                adm_menu.setPagina_modulo(cres.getString(3).trim());
                adm_menu.setIcono(cres.getString(4).trim());
                adm_menu.setEs_padre(cres.getString(5).trim());
                
                opciones.add(adm_menu);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return opciones;
    }

    public static JSONObject toJSONObject(Menu_principal menu) {
        JSONObject json = new JSONObject();
        try {
            json.put("id_modulo", menu.getId_modulo());
            json.put("nombre_modulo", menu.getNombre_modulo());
            json.put("id_modulo_padre", menu.getId_modulo_padre());
            json.put("pagina_modulo", menu.getPagina_modulo());
            json.put("icono_modulo", menu.getIcono());
            
        } catch (JSONException ex) {
            Logger.getLogger(Menu_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
    public static JSONObject toJSON(List< Menu_principal >  menu) {
        JSONObject json = new JSONObject();
        try {
            JSONArray jsonItems = new JSONArray();
            for (Iterator<Menu_principal> it = menu.iterator(); it.hasNext();) {
                Menu_principal opciones = it.next();
                jsonItems.put( toJSONObject( opciones ) );
            }

            json.put("items", jsonItems);
        } catch (JSONException ex) {
            Logger.getLogger(Menu_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
}
