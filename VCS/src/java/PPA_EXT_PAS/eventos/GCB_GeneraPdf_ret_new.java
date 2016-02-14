package PPA_EXT_PAS.eventos;


/**
 * Creado: CLS Juan Torres
 * Proyecto: 9553: Workflow Bodega Multicompañia.
 * Fecha: 12/06/2014
 * LIDER CLS: Mariuxi Dominguez
 */

//import axisBeans.gestionClientes.DatosCabeceraPdf;


import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.*;
import PPA_EXT_PAS.dominio.DatosCabeceraPdf_rec_new;
import java.awt.*;
import java.util.List;
import java.util.Vector;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import PPA_EXT_PAS.dominio.GBB_SolRetiroDetalle_ret_new;
import PPA_EXT_PAS.dominio.DatosCabeceraPdf_rec_new;
import PPA_EXT_PAS.dominio.Informe_Peticion_Verbal_cab;
import java.io.FileOutputStream;


public class GCB_GeneraPdf_ret_new {
        private static Font fontBold = FontFactory.getFont(FontFactory.HELVETICA,11,Font.BOLD,new Color(255,255,255));
        private static Font fontNormal = FontFactory.getFont(FontFactory.HELVETICA,11,Font.NORMAL,new Color(255,255,255));
        //new Font(Font.FontFamily.COURIER, 12, Font.BOLD);
        //private static Font fontNormal = new Font(Font.FontFamily.COURIER, 11, Font.NORMAL);
	public GCB_GeneraPdf_ret_new(){
            super();
        }
                
	public PdfPTable addPdfTitle(String title){
		
		float[] widths = {0.1f, 0.8f};
		PdfPTable table = new PdfPTable(widths);
		
		
		
		Image jpg = null;
		
		try {
			
			 
             java.net.URL otraurl = new URL("http://130.2.20.196:7778/siscmo/imagenes/logoPorta.gif");

			RandomAccessFile rf = new RandomAccessFile(otraurl.getFile(), "r");
	        int size = (int)rf.length();
	        byte imext[] = new byte[size];
	        rf.readFully(imext);
	        rf.close();
			
		    jpg = Image.getInstance(imext);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        table.addCell(jpg);
        PdfPCell cs = new PdfPCell(new Paragraph(title,FontFactory.getFont(FontFactory.HELVETICA, 16,
				Font.BOLD, new Color(205,38,38))));
        cs.setHorizontalAlignment(Element.ALIGN_CENTER);
        cs.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cs);
        table.setWidthPercentage(100);
        
        return table;
	}
	
	public void addTitles (PdfPTable pfTable, String titulo, String detalle){
	
		
		pfTable.getDefaultCell().setBackgroundColor(new Color(205,38,38));
		pfTable.addCell(new Paragraph(titulo,FontFactory.getFont(FontFactory.HELVETICA,8,Font.BOLD,new Color(255,255,255))));
		pfTable.getDefaultCell().setBackgroundColor(new Color(250, 250, 250));
		pfTable.addCell(new Paragraph(detalle,FontFactory.getFont(FontFactory.HELVETICA,8,Font.BOLD)));
		
		
		
	}
	
	public PdfPTable createTitleTable (PPA_EXT_PAS.dominio.DatosCabeceraPdf_rec_new Campos[]){
		
		float[] widths = {0.11f, 0.89f};
		PdfPTable table = new PdfPTable(widths);
		/*addTitles(table, "Region", "TODOS");
		addTitles(table, "Area", "TODOS");
		addTitles(table, "Departamento", "TODOS");
		addTitles(table, "T. Solicitud", "TODOS");*/
		for(int li_i=0;li_i<Campos.length;li_i++) { 
		   addTitles(table, Campos[li_i].tipo, Campos[li_i].dato);
        }
		table.setWidthPercentage(100);
		
		return table;
		
		
	}
	
	public PdfPTable createDetailTableHeader (String cadena [],float dimension[]){
		
		float[] widths= new float[dimension.length];  
		
		//{0.05f, 0.1f, 0.1f, 0.1f, 0.05f, 0.05f, 0.05f, 0.1f, 0.05f, 0.05f, 0.1f, 0.05f, 0.05f, 0.05f, 0.05f };
		
		for(int li_j=0;li_j<dimension.length;li_j++) 
		{
		   widths[li_j]=dimension[li_j]; 

		}
		
		PdfPTable table = new PdfPTable(widths);
		table.getDefaultCell().setBackgroundColor(new Color(205,38,38));
		
        for(int li=0;li<cadena.length;li++) { 

		   table.addCell(new Paragraph(cadena[li],FontFactory.getFont(FontFactory.HELVETICA, 8,
				Font.BOLD, new Color(255, 255, 255))));
		  
        }

		/*table.addCell(new Paragraph("Region",FontFactory.getFont(FontFactory.HELVETICA, 10,
				Font.BOLD, new Color(255, 255, 255))));*/
		
		table.setWidthPercentage(100);
		
		return table;
		
		
	}
	
	
	
	public PdfPTable createDetailTableHeader1 (String cadena [],float dimension[]){
		
		float[] widths= new float[dimension.length];  
		
		//{0.05f, 0.1f, 0.1f, 0.1f, 0.05f, 0.05f, 0.05f, 0.1f, 0.05f, 0.05f, 0.1f, 0.05f, 0.05f, 0.05f, 0.05f };
		
		for(int li_j=0;li_j<dimension.length;li_j++) 
		{
		   widths[li_j]=dimension[li_j]; 

		}
		
		PdfPTable table = new PdfPTable(widths);
		table.getDefaultCell().setBackgroundColor(new Color(205,38,38));
		
        for(int li=0;li<cadena.length;li++) { 

		   table.addCell(new Paragraph(cadena[li],FontFactory.getFont(FontFactory.HELVETICA, 8,
				Font.BOLD, new Color(255, 255, 255))));
		  
        }


		
		table.setWidthPercentage(100);
		
		return table;
		
		
	}


/***********************************************************************************************************************************************************/






/***********************************************************************************************************************************************************/


	 public PdfPTable createTitleSubtotal (String descripcion,String valor){
		
		 float[] widths = {0.12f, 0.88f};
		 PdfPTable table = new PdfPTable(widths);
	     		
		 table.addCell(new Paragraph(descripcion,FontFactory.getFont(FontFactory.HELVETICA,8,Font.BOLD)));
		 table.addCell(new Paragraph(valor,FontFactory.getFont(FontFactory.HELVETICA,8,Font.BOLD)));

		 table.setWidthPercentage(100);
		
		return table;
		
		
	}


	

		
 /**
  * cima JONATHAN CEDEÑO
  *Permite dibujar un pdf que contenga el informe tecnico
  */	
  public void dibujaPdfMInformeTecnico(Document document,String titulo,PPA_EXT_PAS.dominio.DatosCabeceraPdf_rec_new Campos[],String cadena[],float dimension[],String datos[] ){
 		
 	    float[] widths= new float[dimension.length];  
 	 try {
 	    document.add(addPdfTitle(titulo));
 		document.add(createTitleTable(Campos));
 		 widths[0]=5;
 		 PdfPTable table = new PdfPTable(widths); 
 		 table.getDefaultCell().setBackgroundColor(new Color(205,38,38));   		
		 table.addCell(new Paragraph(datos[9],FontFactory.getFont(FontFactory.HELVETICA, 8,
					Font.BOLD, new Color(255, 255, 255))));      
 		 PdfPTable table1 = new PdfPTable(widths);  
 		 table1.addCell(new Paragraph(datos[10],FontFactory.getFont(FontFactory.HELVETICA,8))); 
 		   
 		 PdfPTable table2 = new PdfPTable(widths);  
 		 table2.getDefaultCell().setBackgroundColor(new Color(205,38,38));   		
		 table2.addCell(new Paragraph(datos[11],FontFactory.getFont(FontFactory.HELVETICA, 8,
					Font.BOLD, new Color(255, 255, 255))));          
		 PdfPTable table3 = new PdfPTable(widths);  
 		 table3.addCell(new Paragraph(datos[12],FontFactory.getFont(FontFactory.HELVETICA,8))); 
 		 PdfPTable table4 = new PdfPTable(widths);  
 		 table4.getDefaultCell().setBackgroundColor(new Color(205,38,38));   		
		 table4.addCell(new Paragraph(datos[13],FontFactory.getFont(FontFactory.HELVETICA, 8,
					Font.BOLD, new Color(255, 255, 255))));          
		 PdfPTable table5 = new PdfPTable(widths);  
 		 table5.addCell(new Paragraph(datos[14],FontFactory.getFont(FontFactory.HELVETICA,8))); 
 		 PdfPTable table6 = new PdfPTable(widths); 
 		 table6.getDefaultCell().setBackgroundColor(new Color(205,38,38));   		
		 table6.addCell(new Paragraph(datos[15],FontFactory.getFont(FontFactory.HELVETICA, 8,
					Font.BOLD, new Color(255, 255, 255))));          
		 PdfPTable table7 = new PdfPTable(widths);  
 		 table7.addCell(new Paragraph(datos[16],FontFactory.getFont(FontFactory.HELVETICA,8))); 
 		 PdfPTable table8 = new PdfPTable(widths);  
 		 table8.getDefaultCell().setBackgroundColor(new Color(205,38,38));   		
		 table8.addCell(new Paragraph(datos[17],FontFactory.getFont(FontFactory.HELVETICA, 8,
					Font.BOLD, new Color(255, 255, 255))));          
		 PdfPTable table9 = new PdfPTable(widths);  
		 table9.addCell(new Paragraph(datos[18],FontFactory.getFont(FontFactory.HELVETICA,8))); 
		 table.setWidthPercentage(100);
 	  table1.setWidthPercentage(100);
 	  table2.setWidthPercentage(100);
 	  table3.setWidthPercentage(100);
 	  table4.setWidthPercentage(100);
 	  table5.setWidthPercentage(100);
 	  table6.setWidthPercentage(100);
 	  table7.setWidthPercentage(100);
 	  table8.setWidthPercentage(100);
 	  table9.setWidthPercentage(100);
	     document.add(table);	
      document.add(table1);	
      document.add(table2);	
      document.add(table3);	
      document.add(table4);	
      document.add(table5);	
      document.add(table6);	
      document.add(table7);	
      document.add(table8);	
      document.add(table9);	
		   
		 } catch (Exception e) {
				
				  e.printStackTrace();
	        }

			
	   }

	

	   
	   /**
	    * cima yylb
	    *Permite dibujar un pdf que contenga los despachos de equipos 
	    */	
	    public void dibujaPdfRetiroEquipo(Document document,DatosCabeceraPdf_rec_new Campos[],String cadena[],float dimension[], List listaMoviento ){
	   		
	   	    float[] widths= new float[dimension.length];   
	   	 try {

	   		document.add(createTitleTable(Campos));
	   		document.add(createDetailTableHeader(cadena,dimension));
	   		
	   		for(int li_j=0;li_j<dimension.length;li_j++) 
	   		{
	   		   widths[li_j]=dimension[li_j]; 

	   		 }
	   		
	   		 PdfPTable table = new PdfPTable(widths);

	      
	            String recibido=" ";
	            String noRecibido=" ";
	            GBB_SolRetiroDetalle_ret_new item = new GBB_SolRetiroDetalle_ret_new();
	         
	   	for(int k=0; k<listaMoviento.size();k++){
	   		item=(GBB_SolRetiroDetalle_ret_new) listaMoviento.get(k);	
	   		 recibido=" ";
	   		 noRecibido=" ";
	   		   if (item.getEstadoArticulo().equals("R")){
	   			    recibido="X";
	   		   }
	   		   else{
	   			   if (item.getEstadoArticulo().equals("Q")){
	   			      noRecibido="X";
	   			   }
	   		   }
	          
	   		   
	   		   table.addCell(new Paragraph(recibido,FontFactory.getFont(FontFactory.HELVETICA,8))); 
	           table.addCell(new Paragraph(noRecibido,FontFactory.getFont(FontFactory.HELVETICA,8)));
	           table.addCell(new Paragraph(item.getARTICULO(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
	           table.addCell(new Paragraph(item.getDESCRIPCION(),FontFactory.getFont(FontFactory.HELVETICA,8)));
	   		   table.addCell(new Paragraph(String.valueOf(item.getCANTIDAD()),FontFactory.getFont(FontFactory.HELVETICA,8))); 
	   		   table.addCell(new Paragraph(item.getSERIE(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
	   		   table.addCell(new Paragraph(item.getDESTINO(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
	   		  
	   		   table.addCell(new Paragraph(item.getEstado(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
	   		   table.addCell(new Paragraph(item.getORDEN(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
	   		   table.addCell(new Paragraph(item.getDUI(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
	   		   table.addCell(new Paragraph(item.getPACK(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
	
	   	   }
	   	
	   	 table.setWidthPercentage(100);
	        document.add(table);	
	   	   
	   	 } catch (Exception e) {
	   			
	   			  e.printStackTrace();
	           }

	   		
	   	
	   	
	   	
	      }

	 	  

	    /**
	     * cima yylb
	     *Permite dibujar un pdf que contenga los despachos 
	     */	
	     public void dibujaPdfSolicitudRetiro(Document document,String cadena[],float dimension[],java.util.List listaMoviento ){
	    		
	    	    float[] widths= new float[dimension.length];  
	    	 try {

	    		//document.add(createTitleTable(Campos));
	    		document.add(createDetailTableHeader(cadena,dimension));
	    		
	    		for(int li_j=0;li_j<dimension.length;li_j++) 
	    		{
	    		   widths[li_j]=dimension[li_j]; 

	    		 }
	    		
	    		 PdfPTable table = new PdfPTable(widths);

	       
	         
	             GBB_SolRetiroDetalle_ret_new item = new GBB_SolRetiroDetalle_ret_new();
	          
	    	for(int k=0; k<listaMoviento.size();k++){
	    		item=(GBB_SolRetiroDetalle_ret_new) listaMoviento.get(k);	
	    		 
	    		  table.addCell(new Paragraph(item.getID_STUD_RETIRO(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
	              table.addCell(new Paragraph(item.getUsuario(),FontFactory.getFont(FontFactory.HELVETICA,8)));
	              table.addCell(new Paragraph(item.getEstado(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
	              table.addCell(new Paragraph(item.getFechaSolicitud(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
	              table.addCell(new Paragraph(item.getDESCRIPCION(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
	              table.addCell(new Paragraph(item.getSERIE(),FontFactory.getFont(FontFactory.HELVETICA,8)));               
	    		  table.addCell(new Paragraph(String.valueOf(item.getCANTIDAD()),FontFactory.getFont(FontFactory.HELVETICA,8)));     		 
	    		  table.addCell(new Paragraph(item.getDESTINO(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
	    	
	    	   }
	    	
	    	 table.setWidthPercentage(100);
	         document.add(table);	
	    	   
	    	 } catch (Exception e) {
	    		  
	    			
	    			  e.printStackTrace();
	            }

	    		
	    	
	    	
	    	
	       }
	     
	
/**
 * cima JS
 *Permite dibujar un pdf que contenga los despachos de equipos 
 */
 /*
 public void dibujaPdfAgendaRetiroEquipo(Document document,DatosCabeceraPdf_ret_new Campos[],String cadena[],float dimension[],java.util.List listaMoviento ){
		
	    float[] widths= new float[dimension.length];  
	 try {

		document.add(createTitleTable(Campos));
		document.add(createDetailTableHeader(cadena,dimension));
		
		for(int li_j=0;li_j<dimension.length;li_j++) 
		{
		   widths[li_j]=dimension[li_j]; 

		 }
		
		 PdfPTable table = new PdfPTable(widths);
         GBB_Agenda_ret_new item = new GBB_Agenda_ret_new();
      
	for(int k=0; k<listaMoviento.size();k++){
		item=(GBB_Agenda_ret_new) listaMoviento.get(k);	
		
		table.addCell(new Paragraph(item.getID_STUD_RETIRO(),FontFactory.getFont(FontFactory.HELVETICA,8)));
        table.addCell(new Paragraph(item.getUSR_SOLICITANTE(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
        table.addCell(new Paragraph(item.getCORREO_SOLICITANTE(),FontFactory.getFont(FontFactory.HELVETICA,8)));
		table.addCell(new Paragraph(item.getDESCRIPCION(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
		table.addCell(new Paragraph(item.getID_AREA(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
		table.addCell(new Paragraph(item.getDEPARTAMENTO(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
		table.addCell(new Paragraph(item.getESTADO(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
		   
	   }
	
	 table.setWidthPercentage(100);
     document.add(table);	
	   
	 } catch (Exception e) {
			
			  e.printStackTrace();
        }
 }*/
 /**
  * cima JS
  *Permite dibujar un pdf que solicitudes para los reportes 
  */	
 public void dibujaPdfsolRetiroEquipo(Document document,DatosCabeceraPdf_rec_new Campos[],String cadena[],float dimension[],java.util.List listaMoviento ){
		
	    float[] widths= new float[dimension.length];  
	 try {

		document.add(createTitleTable(Campos));
		document.add(createDetailTableHeader(cadena,dimension));
		
		for(int li_j=0;li_j<dimension.length;li_j++) 
		{
		   widths[li_j]=dimension[li_j]; 

		 }
		
		 PdfPTable table = new PdfPTable(widths);
		 GBB_SolRetiroDetalle_ret_new item = new GBB_SolRetiroDetalle_ret_new();
   
	for(int k=0; k<listaMoviento.size();k++){
		item=(GBB_SolRetiroDetalle_ret_new) listaMoviento.get(k);	
		
		
		table.addCell(new Paragraph(item.getID_STUD_RETIRO(),FontFactory.getFont(FontFactory.HELVETICA,8)));
     table.addCell(new Paragraph(item.getUsuario(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
     table.addCell(new Paragraph(item.getEstado(),FontFactory.getFont(FontFactory.HELVETICA,8)));
		table.addCell(new Paragraph(item.getFechaSolicitud(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
		table.addCell(new Paragraph(item.getDESCRIPCION(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
		table.addCell(new Paragraph(item.getSERIE(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
		table.addCell(new Paragraph(Integer.toString(item.getCANTIDAD()) ,FontFactory.getFont(FontFactory.HELVETICA,8))); 
		table.addCell(new Paragraph(item.getDESTINO(),FontFactory.getFont(FontFactory.HELVETICA,8)));   
	   }
	
	 table.setWidthPercentage(100);
  document.add(table);	
	   
	 } catch (Exception e) {
			
			  e.printStackTrace();
     }
}	
 
 
 /*public void dibujaPdfsolRetiro(Document document,DatosCabeceraPdf_ret_new Campos[],String cadena[],float dimension[],java.util.List listaMoviento ){
		
	    float[] widths= new float[dimension.length];  
	 try {

		document.add(createTitleTable(Campos));
		document.add(createDetailTableHeader(cadena,dimension));
		
		for(int li_j=0;li_j<dimension.length;li_j++) 
		{
		   widths[li_j]=dimension[li_j]; 

		 }
		
		 PdfPTable table = new PdfPTable(widths);
		 GBB_SolRetiroDetalle_ret_new item = new GBB_SolRetiroDetalle_ret_new();

	for(int k=0; k<listaMoviento.size();k++){
		item=(GBB_SolRetiroDetalle_ret_new) listaMoviento.get(k);	

		table.addCell(new Paragraph(item.getID_STUD_RETIRO(),FontFactory.getFont(FontFactory.HELVETICA,8)));
     table.addCell(new Paragraph(item.getEstadoArticulo(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
     table.addCell(new Paragraph(item.getARTICULO(),FontFactory.getFont(FontFactory.HELVETICA,8)));
		table.addCell(new Paragraph(item.getDESCRIPCION(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
		table.addCell(new Paragraph(String.valueOf(item.getCANTIDAD()),FontFactory.getFont(FontFactory.HELVETICA,8))); 
		table.addCell(new Paragraph(item.getSERIE(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
		table.addCell(new Paragraph(item.getDESTINO(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
		table.addCell(new Paragraph(item.getEstado(),FontFactory.getFont(FontFactory.HELVETICA,8)));   
		table.addCell(new Paragraph(item.getCONTRATISTA(),FontFactory.getFont(FontFactory.HELVETICA,8)));   
		table.addCell(new Paragraph(item.getORDEN(),FontFactory.getFont(FontFactory.HELVETICA,8)));   		
		table.addCell(new Paragraph(item.getDUI(),FontFactory.getFont(FontFactory.HELVETICA,8)));   
		table.addCell(new Paragraph(item.getPACK(),FontFactory.getFont(FontFactory.HELVETICA,8)));   		
	}
	
	 table.setWidthPercentage(100);
document.add(table);	
	   
	 } catch (Exception e) {
			
			  e.printStackTrace();
  }
}	
 
 */
 /*
 public void dibujaPdfsolRecepcionEstado(Document document,DatosCabeceraPdf_ret_new Campos[],String cadena[],float dimension[],java.util.List listaMoviento ){
		
	    float[] widths= new float[dimension.length];  
	 try {

		document.add(createTitleTable(Campos));
		document.add(createDetailTableHeader(cadena,dimension));
		
		for(int li_j=0;li_j<dimension.length;li_j++) 
		{
		   widths[li_j]=dimension[li_j]; 

		 }
		
		 PdfPTable table = new PdfPTable(widths);
		 GBB_SolMovimiento_ret_new item = new GBB_SolMovimiento_ret_new();

	for(int k=0; k<listaMoviento.size();k++){
		item=(GBB_SolMovimiento_ret_new) listaMoviento.get(k);	
		
		
		table.addCell(new Paragraph(item.getID_STUD_RETIRO(),FontFactory.getFont(FontFactory.HELVETICA,8)));
  table.addCell(new Paragraph(item.getUsuario(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
  table.addCell(new Paragraph(item.getEstado(),FontFactory.getFont(FontFactory.HELVETICA,8)));
		table.addCell(new Paragraph(item.getFechaSolicitud(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
		table.addCell(new Paragraph(item.getARTICULO(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
		table.addCell(new Paragraph(item.getDESCRIPCION(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
		table.addCell(new Paragraph(item.getSERIE(),FontFactory.getFont(FontFactory.HELVETICA,8)));
		table.addCell(new Paragraph(String.valueOf(item.getCANTIDAD()),FontFactory.getFont(FontFactory.HELVETICA,8))); 
		table.addCell(new Paragraph(item.getDESTINO(),FontFactory.getFont(FontFactory.HELVETICA,8)));   
		table.addCell(new Paragraph(item.getCONTRATISTA(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
		table.addCell(new Paragraph(item.getDUI(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
		table.addCell(new Paragraph(item.getORDEN(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
		table.addCell(new Paragraph(item.getPACK(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
		table.addCell(new Paragraph(item.getEstadoArticulo(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
	   }
	
	 table.setWidthPercentage(100);
document.add(table);	
	   
	 } catch (Exception e) {
			
			  e.printStackTrace();
  }
 }
*/
      private String getCurrentDateTime() {
     	Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yy '-' hh:mm");
     	return ft.format(dNow);
    }
   private Paragraph getHeader(String header) {
    	Paragraph paragraph = new Paragraph();
  		Chunk chunk = new Chunk();
		paragraph.setAlignment(Element.ALIGN_CENTER);
  		chunk.append( header + getCurrentDateTime() + "\n");
  		chunk.setFont(fontBold);
  		paragraph.add(chunk);
  		return paragraph;
     }	 
		//reporte
public void dibujaPdfsolRetiroEstado(Document document,Informe_Peticion_Verbal_cab Campos[]/*,String cadena[]*/,float dimension[],java.util.List listaMoviento,String ruta ){
			
		    float[] widths= new float[dimension.length];	    
		    
		 try {
                     PdfWriter.getInstance(document, new FileOutputStream(ruta+"informe.pdf"));
                     document.open();

                        //document.add(getHeader("LA PITA AMA A MARIA"));
			//document.add(createTitleTable1(Campos,ruta));
			//document.add(createDetailTableHeader1(cadena,dimension));
			
			/*for(int li_j=0;li_j<dimension.length;li_j++) 
			{
			   widths[li_j]=dimension[li_j]; 

			 }*/
			 /*PdfPCell celda = new PdfPCell();
                         Element e = new el
                         celda.addElement();*/
			// PdfPTable table = new PdfPTable(widths);
			 Informe_Peticion_Verbal_cab item = new Informe_Peticion_Verbal_cab();

		for(int k=0; k<listaMoviento.size();k++){
			item=(Informe_Peticion_Verbal_cab) listaMoviento.get(k);	
			//document.add(getInformation(item.getValor()));
			document.add(new Paragraph(item.getValor(),FontFactory.getFont(FontFactory.HELVETICA,8)));
                        
			//table.addCell(new Paragraph(item.getValor(),FontFactory.getFont(FontFactory.HELVETICA,8)));
		     /*table.addCell(new Paragraph(item.getUsuario(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
		     table.addCell(new Paragraph(item.getEstado(),FontFactory.getFont(FontFactory.HELVETICA,8)));
				table.addCell(new Paragraph(item.getFechaSolicitud(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
				table.addCell(new Paragraph(item.getDESCRIPCION(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
				table.addCell(new Paragraph(item.getSERIE(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
				table.addCell(new Paragraph(Integer.toString(item.getCANTIDAD()) ,FontFactory.getFont(FontFactory.HELVETICA,8))); 
				table.addCell(new Paragraph(item.getDESTINO(),FontFactory.getFont(FontFactory.HELVETICA,8)));   */
					   }
		document.add(getInformation("dsfdsfs "));
                //document.add(getInformationFooter("Gracias por visitarnos!"));
		 //table.setWidthPercentage(100);
	     //document.add(table);	
		   document.close();
		 } catch (Exception e) {
				
				  e.printStackTrace();
	  }
	}
	
private Paragraph getInformation(String informacion) {
    	Paragraph paragraph = new Paragraph();
    	Chunk chunk = new Chunk();
  		paragraph.setAlignment(Element.ALIGN_CENTER);
  		chunk.append(informacion);
  		chunk.setFont(fontNormal);
  		paragraph.add(chunk);
   		return paragraph;
}
public PdfPTable createTitleTable1 (Informe_Peticion_Verbal_cab Campos[],String ruta){
	
	float[] widths = {0.11f, 0.89f};
    PdfPTable table = new PdfPTable(widths);			
	PdfPTable tabla_local = new PdfPTable(4);
    PdfPCell celda = new PdfPCell();
   
         for (int i = 0; i<Campos.length; i++)
         {        
   
           if (i == 0){		   
             try{
                 
               Image gif = Image.getInstance(ruta);
               gif.scalePercent(15f);
                 celda.addElement(gif);		                
                 celda.setColspan(1);
               celda.setBorder(0);
               celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                 table.addCell(celda);
             }catch(Exception e){
               System.out.println("error");
             }
   
           }
        	   celda = new PdfPCell(new Paragraph (Campos[i].tipo,FontFactory.getFont(FontFactory.HELVETICA,8,Font.BOLD,new Color(255,255,255))));
        	   celda.setBackgroundColor(new Color(205,38,38));
        	   tabla_local.addCell(celda);
        	   celda = new PdfPCell(new Paragraph (Campos[i].dato,FontFactory.getFont(FontFactory.HELVETICA,8,Font.BOLD)));
        	   celda.setBackgroundColor(new Color(250, 250, 250));
        	   tabla_local.addCell(celda);
           
           }
   
       celda = new PdfPCell(tabla_local);
       celda.setColspan(5);
       table.addCell(celda);
       table.setWidthPercentage(100);
	return table;
	
}


/*
public void dibujaPdfsolRetiro(Document document,DatosCabeceraPdf_ret_new Campos[],String cadena[],float dimension[],java.util.List listaMoviento, String ruta){
	
    float[] widths= new float[dimension.length];  
 try {

		document.add(createTitleTable1(Campos,ruta));
		document.add(createDetailTableHeader1(cadena,dimension));
		

	
	for(int li_j=0;li_j<dimension.length;li_j++) 
	{
	   widths[li_j]=dimension[li_j]; 

	 }
	
	 PdfPTable table = new PdfPTable(widths);
	 GBB_SolRetiroDetalle_ret_new item = new GBB_SolRetiroDetalle_ret_new();

for(int k=0; k<listaMoviento.size();k++){
	item=(GBB_SolRetiroDetalle_ret_new) listaMoviento.get(k);	

	//table.addCell(new Paragraph(item.getID_STUD_RETIRO(),FontFactory.getFont(FontFactory.HELVETICA,8)));
//    table.addCell(new Paragraph(item.getEstadoArticulo(),FontFactory.getFont(FontFactory.HELVETICA,8))); 

	System.out.println("-----item.getEstadoArticulo(): "+item.getEstadoArticulo());
	
    if (item.getEstadoArticulo().equals("")||item.getEstadoArticulo()==null){
    	
	if (item.getEstadoArticulo().equals("X"))
      table.addCell(new Paragraph(item.getEstadoArticulo(),FontFactory.getFont(FontFactory.HELVETICA,8)));
    else
    	table.addCell(new Paragraph(" ",FontFactory.getFont(FontFactory.HELVETICA,8))); 
    
    if (item.getEstadoArticulo().equals("T"))
        table.addCell(new Paragraph("X",FontFactory.getFont(FontFactory.HELVETICA,8)));
      else
      	table.addCell(new Paragraph(" ",FontFactory.getFont(FontFactory.HELVETICA,8))); 
   
    }
    
    table.addCell(new Paragraph(item.getARTICULO(),FontFactory.getFont(FontFactory.HELVETICA,8)));
	table.addCell(new Paragraph(item.getDESCRIPCION(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
	table.addCell(new Paragraph(String.valueOf(item.getCANTIDAD()),FontFactory.getFont(FontFactory.HELVETICA,8))); 
	table.addCell(new Paragraph(item.getSERIE(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
	table.addCell(new Paragraph(item.getDESTINO(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
	table.addCell(new Paragraph(item.getEstado(),FontFactory.getFont(FontFactory.HELVETICA,8)));   
	table.addCell(new Paragraph(item.getCONTRATISTA(),FontFactory.getFont(FontFactory.HELVETICA,8)));   
	table.addCell(new Paragraph(item.getORDEN(),FontFactory.getFont(FontFactory.HELVETICA,8)));   		
	table.addCell(new Paragraph(item.getDUI(),FontFactory.getFont(FontFactory.HELVETICA,8)));   
	table.addCell(new Paragraph(item.getPACK(),FontFactory.getFont(FontFactory.HELVETICA,8)));   		
}

 table.setWidthPercentage(100);
document.add(table);	
   
 } catch (Exception e) {
		
		  e.printStackTrace();
}
}	
*/
/*
public void dibujaPdfsolRetiro2(Document document,DatosCabeceraPdf_ret_new Campos[],String cadena[],float dimension[],java.util.List listaMoviento, String ruta,int estado){
	
    float[] widths= new float[dimension.length];  
 try {

		document.add(createTitleTable1(Campos,ruta));
		document.add(createDetailTableHeader1(cadena,dimension));
	
	
	for(int li_j=0;li_j<dimension.length;li_j++) 
	{
	   widths[li_j]=dimension[li_j]; 

	 }
	
	 PdfPTable table = new PdfPTable(widths);
	 GBB_SolRetiroDetalle_ret_new item = new GBB_SolRetiroDetalle_ret_new();

for(int k=0; k<listaMoviento.size();k++){
	item=(GBB_SolRetiroDetalle_ret_new) listaMoviento.get(k);	

	//table.addCell(new Paragraph(item.getID_STUD_RETIRO(),FontFactory.getFont(FontFactory.HELVETICA,8)));
//    table.addCell(new Paragraph(item.getEstadoArticulo(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
	
	if (estado == 5){
    	
	if (item.getEstadoArticulo().equals("X"))
      table.addCell(new Paragraph(item.getEstadoArticulo(),FontFactory.getFont(FontFactory.HELVETICA,8)));
    else
    	table.addCell(new Paragraph(" ",FontFactory.getFont(FontFactory.HELVETICA,8))); 
    
    if (item.getEstadoArticulo().equals("T"))
        table.addCell(new Paragraph("X",FontFactory.getFont(FontFactory.HELVETICA,8)));
      else
      	table.addCell(new Paragraph(" ",FontFactory.getFont(FontFactory.HELVETICA,8))); 
   
	}
    table.addCell(new Paragraph(item.getARTICULO(),FontFactory.getFont(FontFactory.HELVETICA,8)));
	table.addCell(new Paragraph(item.getDESCRIPCION(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
	table.addCell(new Paragraph(String.valueOf(item.getCANTIDAD()),FontFactory.getFont(FontFactory.HELVETICA,8))); 
	table.addCell(new Paragraph(item.getSERIE(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
	table.addCell(new Paragraph(item.getDESTINO(),FontFactory.getFont(FontFactory.HELVETICA,8))); 
	table.addCell(new Paragraph(item.getEstado(),FontFactory.getFont(FontFactory.HELVETICA,8)));   
	table.addCell(new Paragraph(item.getCONTRATISTA(),FontFactory.getFont(FontFactory.HELVETICA,8)));   
	table.addCell(new Paragraph(item.getORDEN(),FontFactory.getFont(FontFactory.HELVETICA,8)));   		
	table.addCell(new Paragraph(item.getDUI(),FontFactory.getFont(FontFactory.HELVETICA,8)));   
	table.addCell(new Paragraph(item.getPACK(),FontFactory.getFont(FontFactory.HELVETICA,8)));   		
}

 table.setWidthPercentage(100);
document.add(table);	
   
 } catch (Exception e) {
		
		  e.printStackTrace();
}
}	

*/
/*
public PdfPTable createTitleTable (DatosCabeceraPdf_ret_new Campos[]){
	
	float[] widths = {0.11f, 0.89f};
	PdfPTable table = new PdfPTable(widths);
	/*addTitles(table, "Region", "TODOS");
	addTitles(table, "Area", "TODOS");
	addTitles(table, "Departamento", "TODOS");
	addTitles(table, "T. Solicitud", "TODOS");*//*
	for(int li_i=0;li_i<Campos.length;li_i++) { 
	   addTitles(table, Campos[li_i].tipo, Campos[li_i].dato);
    }
	table.setWidthPercentage(100);
	
	return table;
	
	
}
*/
	
}
	
   
