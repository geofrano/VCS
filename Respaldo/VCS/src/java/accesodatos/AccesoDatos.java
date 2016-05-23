
package accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * @author Paul
 */
/*
 * Modificado por: Geovanny Barrera - Luis Pita
 *                  Se agrego Pool de conexiones
 */
public class AccesoDatos {
    public static boolean ejecutaComando(String comando, ArrayList<Parametro> parametros) throws Exception
    {
        boolean respuesta      = false;
        PreparedStatement ptrs = null; 
        Connection con         = null; 
            
            //Class.forName(Global.DRIVER);
            try {
                con = Conexion.conexion().getConnection();
                con.setAutoCommit(false);
                ptrs = con.prepareStatement(comando);
                
                for (Parametro parametro : parametros) {
                    ptrs.setObject(parametro.getPosicion(), parametro.getValor());
                }
                int i= ptrs.executeUpdate();
                if(i>0)respuesta=true;
                ptrs.close();
                con.commit();
            } catch (SQLException exConec) {
                throw new RuntimeException(exConec);
            }
            finally
            {            
                try{
                    if(con!=null)
                    {
                        con.rollback();
                        if(!(con.isClosed()))
                            con.close();
                    }
                }catch(Exception ex)
                {throw new RuntimeException(ex);}
            }
        return respuesta;
    }



    public static ConjuntoResultado ejecutaQuery(String query) throws Exception 
    {            
        ResultSet rs = null;
        PreparedStatement pst=null;
        ConjuntoResultado conj= new ConjuntoResultado();
        Connection con=null;
            try {
                con = Conexion.conexion().getConnection();
                pst = con.prepareStatement(query);
                rs = pst.executeQuery();
                conj.Fill(rs);
                rs.close();
                pst.close();
            } catch (SQLException exConec) {
                throw new RuntimeException(exConec);
            }
            finally
            {
                try{
                    if(con!=null)
                    {
                        if(!(con.isClosed()))
                        con.close();
                }
                }catch(Exception ex)
                {throw new RuntimeException(ex);}
            }

        return conj;
    }

    public static ConjuntoResultado ejecutaQuery(String query, ArrayList<Parametro> parametros) throws Exception
    {            
        ResultSet rs           = null;
        PreparedStatement ptrs = null;
        ConjuntoResultado conj = new ConjuntoResultado();
        Connection con         = null;
            try {
                con = Conexion.conexion().getConnection();
                ptrs = con.prepareStatement(query);
                for (Parametro parametro : parametros) {
                    ptrs.setObject(parametro.getPosicion(), parametro.getValor());
                }
                rs = ptrs.executeQuery();
                conj.Fill(rs);
                rs.close();
                ptrs.close();
            } catch (SQLException exConec) {
              throw new RuntimeException(exConec);
            }
         finally
         {  
            try{
                    if(con!=null)
             {
                 if(!(con.isClosed()))
                    con.close();
             }
            }catch(Exception ex)
            {throw new RuntimeException(ex);}
         }
        return conj;
    }
}
