package PPA_EXT_PAS.eventos;

/**
 * Creado: CLS Juan Torres
 * Proyecto: 9553: Workflow Bodega Multicompa�ia.
 * Fecha: 12/06/2014
 * LIDER CLS: Mariuxi Dominguez
 */
/*******************************************************************************

 ** MODIFICADO O CREADO:   CLS DIEGO MENDEZ
 ** PROYECTO:              [10112] Bodega MOVIMIENTO ACTIVO FIJO
 ** FECHA:                 07/03/2015
 ** LIDER CLS:             ISABEL AVILEZ
 ** LIDER CLARO:           SIS WENDY RAMOS 
 * ******************************************************************************/
/*******************************************************************************

 ** MODIFICADO O CREADO:   CLS DIEGO MENDEZ
 ** PROYECTO:              [10112] Bodega MOVIMIENTO ACTIVO FIJO
 ** FECHA:                 07/03/2015
 ** LIDER CLS:             ISABEL AVILEZ
 ** LIDER CLARO:           SIS WENDY RAMOS
 ** COMENTARIO:            SE AGREGA METODOS PARA BODEGA MOV-ACT FIJO 
 * ******************************************************************************/
import java.io.IOException;
/*import java.sql.CallableStatement;*/
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.jsp.PageContext;
import PPA_EXT_PAS.dominio.GBB_SolRetiroDetalle_ret_new;




public class GBB_SolRetiro_ret_new {      
	
	
	//private GBB_Empleado_ret_new solicitante;   
	public GBB_SolRetiro_ret_new(PageContext p_pc) throws IOException {     
	 	 super();

        }
   public GBB_SolRetiro_ret_new() throws IOException {}                
   
/**
 * Obtener campos de Retiro
*/
/*esta clase seria la clase de evento*/
public List obtenerListaRetiroPdf(String query) throws SQLException{
	ResultSet rs = null;
	
	System.out.println("query PDF:"+query);
	List  l = new ArrayList();
/*
	try{
		PreparedStatement pr = m_conn.prepareStatement(query);
		rs =pr.executeQuery();	
		
		while (rs.next()){*/
			System.out.println("X1");
			GBB_SolRetiroDetalle_ret_new item = new GBB_SolRetiroDetalle_ret_new();
			item.setID_STUD_RETIRO("12345");
			item.setUsuario("GBARRERA");
			item.setEstado("Activo");
			item.setFechaSolicitud("15/12/2015");	
			item.setDESCRIPCION("MARIA LUISA PITA OTERO");
			item.setSERIE("1245474722");			
			item.setCANTIDAD(2);			
			item.setDESTINO("ADADADAD");
			item.setCONTRATISTA("LUIS PITA OTERO");
			l.add(item);
        /*
		}	
		
		
	}catch (Exception e){
		e.printStackTrace();
	}
	finally{
	 if(rs != null)rs.close();  
	}*/
	
	return l;
}

}
   
   
   

