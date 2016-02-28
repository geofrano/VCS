/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPA_EXT_PAS.eventos;

import PPA_EXT_PAS.dominio.Carta_Compromiso;
import PPA_EXT_PAS.dominio.Informe_Peticion_Verbal_cab;
import static PPA_EXT_PAS.eventos.Administrar_Ficha_Estudiante.toJSONObject;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEvent;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
/**
 *
 * @author Geovanny Barrera
 */
public class Genera_pdf {
   public static final String SEPARADOR = "_______________________________________________________________________________";
    private static Font fontBold = FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, new Color(255, 255, 255));
    private static Font fontNormal = FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, new Color(255, 255, 255));

    //new Font(Font.FontFamily.COURIER, 12, Font.BOLD);
    public Genera_pdf() {
        super();
    }
    		//reporte

    public void dibujaPdfsolRetiroEstado(Document document, String ruta_imagen,float dimension[], List< Carta_Compromiso> carta_comp, String ruta) {

        float[] widths = new float[dimension.length];

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta + "Ficha_estudiante.pdf"));
            document.open();
            Chunk chunkSeparador =  new Chunk(SEPARADOR);
            //Image imagen = Image.getInstance("/VCS/Logo_UPS.png");
            //InputStream inputStream = getClass().getClassLoader().getResourceAsStream("images/Logo_UPS.png");
            //InputStream is = new BufferedInputStream(inputStream);
            Image imagen = Image.getInstance(ruta_imagen+"/Logo_UPS.png");
            Image imagen2 = Image.getInstance(ruta_imagen+"/logo_vinculacion.png");


            imagen2.scalePercent(59f);
            imagen.scalePercent(5f);
            //PdfPTable table = new PdfPTable(1);
            //table.getDefaultCell().setBackgroundColor(new Color(205, 38, 38));
            
           imagen2.setAbsolutePosition(416f,763f);
            
            /*PdfPTable table = new PdfPTable(2);
            Image imagen3;
            imagen3 = Image.getInstance(ruta_imagen+"/logo_vinculacion.png");
            imagen.setAbsolutePosition(10, 650f);           
            PdfPCell celda1 = new PdfPCell(imagen3);
            PdfPCell celda2 = new PdfPCell(new Phrase("Departamento de RH"));
            celda1.setBorder(0);
            celda2.setBorder(Rectangle.BOTTOM);
            celda2.setBorder(Rectangle.BOTTOM | Rectangle.RIGHT);
            
            table.addCell(celda1);
            table.addCell(celda2);            
            
            table.setTotalWidth(350f);
            document.add(table);*/
            
            //table.addCell(imagen);
            document.add(imagen);
            document.add(imagen2);
            document.add(chunkSeparador);
            
            PdfPTable table = new PdfPTable(6);
            PdfPCell celda1 = new PdfPCell();
            
            //document.add(table);
                        //Agregamos la imagen al documento.

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
            document.add(new Paragraph("FICHA DEL ESTUDIANTE PARA EL TUTOR"));

            for (Iterator<Carta_Compromiso> it = carta_comp.iterator(); it.hasNext();) {
                Carta_Compromiso opciones = it.next();
                celda1 = new PdfPCell(new Paragraph("CARTA COMPROMISO: "+opciones.getId_carta_compromiso()));
                document.add(new Paragraph(opciones.getId_carta_compromiso(), FontFactory.getFont(FontFactory.HELVETICA, 8)));
                document.add(new Paragraph(opciones.getId_carta_compromiso(), FontFactory.getFont(FontFactory.HELVETICA, 8)));

            }
            table.addCell(celda1);
            document.add(table);
            document.add(new Chunk("dsfdsfs                                          aaaaaaaa "));

                //document.add(getInformationFooter("Gracias por visitarnos!"));
            //table.setWidthPercentage(100);
            //document.add(table);	
            document.close();
        } catch (FileNotFoundException | DocumentException e) {

            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Genera_pdf.class.getName()).log(Level.SEVERE, null, ex);
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
}
