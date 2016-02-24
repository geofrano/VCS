package accesodatos;
/*
 * @author Geovanny Barrera - Luis Pita
 */
import java.util.Properties;
import javax.sql.DataSource;//Va a tener todas las conexiones (es el pool_conexiones)
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class Conexion {
    public static DataSource conexion(){
        DataSource ds = null;
        Properties prop = new Properties();
        
        try {
           prop.load(Conexion.class.getResourceAsStream("database.properties"));
           ds = BasicDataSourceFactory.createDataSource(prop);//CREA EL POOL DE CONEXIONES
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ds;
    }
}
