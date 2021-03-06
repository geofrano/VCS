/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPA_EXT_PAS.eventos;

import PPA_EXT_PAS.dominio.Carta_Compromiso;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Geovanny Barrera
 */
public class Genera_pdf {

    public static final String SEPARADOR = "__________________________________________________________________________";
    private static Font fontBold = FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, new Color(255, 255, 255));
    private static Font fontNormal = FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, new Color(255, 255, 255));

    //new Font(Font.FontFamily.COURIER, 12, Font.BOLD);
    public Genera_pdf() {
        super();
    }
    //reporte Ficha del estudiante
    public void dibujaPdfFichaEstudiante(Document document, String ruta_imagen, float dimension[], List< Carta_Compromiso> carta_comp, String ruta) {

        float[] widths = new float[dimension.length];

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta + "Ficha_estudiante.pdf"));
            document.open();
            Chunk chunkSeparador = new Chunk(SEPARADOR, FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
            //Image imagen = Image.getInstance("/VCS/Logo_UPS.png");
            //InputStream inputStream = getClass().getClassLoader().getResourceAsStream("images/Logo_UPS.png");
            //InputStream is = new BufferedInputStream(inputStream);
            Image imagen = Image.getInstance(ruta_imagen + "/Logo_UPS.png");
            Image imagen2 = Image.getInstance(ruta_imagen + "/logo_vinculacion.png");

            imagen2.scalePercent(59f);
            imagen.scalePercent(5f);
            //PdfPTable table = new PdfPTable(1);
            //table.getDefaultCell().setBackgroundColor(new Color(205, 38, 38));

            imagen2.setAbsolutePosition(416f, 763f);

            document.add(imagen);
            document.add(imagen2);

            Paragraph titulo = new Paragraph(new Paragraph("FICHA DEL ESTUDIANTE PARA EL TUTOR", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, Color.BLACK)));
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            String tipo_doc;

            for (Iterator<Carta_Compromiso> it = carta_comp.iterator(); it.hasNext();) {
                Carta_Compromiso opciones = it.next();
                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                //document.add(new Chunk(NEWLINE));
                Paragraph dat_est = new Paragraph(new Paragraph("DATOS DEL ESTUDIANTE", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                //document.add(dat_est);
                PdfPTable table1 = new PdfPTable(1);
                PdfPCell celda1 = new PdfPCell(dat_est);
                celda1.setFixedHeight(16f);
                celda1.setBackgroundColor(Color.LIGHT_GRAY);
                celda1.setHorizontalAlignment(Element.ALIGN_LEFT);
                table1.addCell(celda1);
                table1.setTotalWidth(3f);
                table1.setWidthPercentage(100);
                document.add(table1);
                //document.add(chunkSeparador);

                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 6, Font.BOLD, Color.BLACK)));

                Paragraph comb = new Paragraph();
                comb.add(new Chunk("CARTA COMPROMISO: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb.add(new Chunk(opciones.getId_carta_compromiso(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                comb.add(new Chunk("                                                ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                comb.add(new Chunk("ACTIVIDAD: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb.add(new Chunk(opciones.getTipo_actividad(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(comb);

                Paragraph comb2 = new Paragraph();
                comb2.add(new Chunk("TIPO DE DOCUMENTO: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                if (opciones.getCed_estudiante().length() > 10) {
                    tipo_doc = "PASAPORTE";
                } else {
                    tipo_doc = "CÉDULA DE CIUDADANÍA";
                }
                comb2.add(new Chunk(tipo_doc, FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                comb2.add(new Chunk("                                                ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                comb2.add(new Chunk("INICIO: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb2.add(new Chunk(opciones.getDia_inicio() + "/" + opciones.getMes_inicio() + "/" + opciones.getAnio_inicio(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(comb2);

                Paragraph comb3 = new Paragraph();
                comb3.add(new Chunk(tipo_doc + ": ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb3.add(new Chunk(opciones.getCed_estudiante(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                comb3.add(new Chunk("                                                ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                comb3.add(new Chunk("FIN: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb3.add(new Chunk(opciones.getDia_fin() + "/" + opciones.getMes_fin() + "/" + opciones.getAnio_fin(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(comb3);

                Paragraph comb4 = new Paragraph();
                comb4.add(new Chunk("APELLIDOS Y NOMBRES: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb4.add(new Chunk(opciones.getNomb_estudiante().toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(comb4);

                Paragraph comb5 = new Paragraph();
                comb5.add(new Chunk("DIRECCION: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb5.add(new Chunk(opciones.getDireccion_est().toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(comb5);

                Paragraph comb6 = new Paragraph();
                comb6.add(new Chunk("TELÉFONOS: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb6.add(new Chunk(opciones.getFono_estudiante(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                comb6.add(new Chunk("                                   ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                comb6.add(new Chunk("E-MAIL: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb6.add(new Chunk(opciones.getMail_estudiante(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(comb6);

                Paragraph comb7 = new Paragraph();
                comb7.add(new Chunk("FACEBOOK: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb7.add(new Chunk(opciones.getFacebook_est(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                comb7.add(new Chunk("                                   ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                comb7.add(new Chunk("TWITTER: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb7.add(new Chunk(opciones.getTwitter_est(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(comb7);

                Paragraph comb8 = new Paragraph();
                comb8.add(new Chunk("LINKEDIN: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb8.add(new Chunk(opciones.getLinked_in_est(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(comb8);

                Paragraph comb9 = new Paragraph();
                comb9.add(new Chunk("CARRERA: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb9.add(new Chunk(opciones.getCarrera_grado().toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                comb9.add(new Chunk("             ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                comb9.add(new Chunk("CICLO Ó SEMESTRE QUE CURSA: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb9.add(new Chunk(opciones.getCiclo_curso(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(comb9);

                //document.add(new Paragraph(""));
                //document.add(new Paragraph("\nDATOS DE LA EMPRESA Y/0 PROYECTO",FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                //document.add(chunkSeparador);
                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 6, Font.BOLD, Color.BLACK)));

                Paragraph dat_est2 = new Paragraph(new Paragraph("DATOS DE LA CARRERA Y/O PROYECTO", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                //document.add(dat_est);
                PdfPTable table2 = new PdfPTable(1);
                PdfPCell celda2 = new PdfPCell(dat_est2);
                celda2.setFixedHeight(16f);
                celda2.setBackgroundColor(Color.LIGHT_GRAY);
                celda2.setHorizontalAlignment(Element.ALIGN_LEFT);
                table2.addCell(celda2);
                table2.setTotalWidth(3f);
                table2.setWidthPercentage(100);
                document.add(table2);

                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 6, Font.BOLD, Color.BLACK)));

                Paragraph comb10 = new Paragraph();
                comb10.add(new Chunk("INSTITUCIÓN O EMPRESA DE INTERÉS: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb10.add(new Chunk(opciones.getNomb_empresa().toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(comb10);

                Paragraph comb11 = new Paragraph();
                comb11.add(new Chunk("RESPONSABLE DE LA EMPRESA: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb11.add(new Chunk(opciones.getNombre_representante().toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                comb11.add(new Chunk("             ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                comb11.add(new Chunk("DEL PROYECTO: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb11.add(new Chunk(opciones.getNombre_proyecto(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(comb11);//CAMBIAR

                Paragraph comb12 = new Paragraph();
                comb12.add(new Chunk("ÁREA O DEPARTAMENTO DE INTERÉS: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb12.add(new Chunk(opciones.getArea_actividad().toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(comb12);

                Paragraph comb13 = new Paragraph();
                comb13.add(new Chunk("RESPONSABLE DEL ÁREA: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb13.add(new Chunk(opciones.getResponsable_area().toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                comb13.add(new Chunk("             ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                comb13.add(new Chunk("HORARIO PREVISTO: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb13.add(new Chunk(opciones.getHorario_previsto(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(comb13);

                Paragraph comb14 = new Paragraph();
                comb14.add(new Chunk("CARGO DEL RESPONSABLE CIA.: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb14.add(new Chunk(opciones.getCargo_representante().toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                comb14.add(new Chunk("   ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                comb14.add(new Chunk("TELÉFONOS: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb14.add(new Chunk(opciones.getTelf_representante(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(comb14);

                Paragraph comb15 = new Paragraph();
                comb15.add(new Chunk("DIRECCIÓN DE LA COMPAÑÍA: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb15.add(new Chunk(opciones.getDir_empresa().toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(comb15);

                Paragraph comb16 = new Paragraph();
                comb16.add(new Chunk("NOMBRE DEL PROGRAMA: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb16.add(new Chunk(opciones.getNombre_programa().toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(comb16);

                Paragraph comb17 = new Paragraph();
                comb17.add(new Chunk("NOMBRE DEL PROYECTO(en el caso de extensiones universitarias): ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                document.add(comb17);
                if (opciones.getNombre_proyecto().length() < 5) {
                    document.add(new Chunk("\n\n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                } else {
                    document.add(new Chunk(opciones.getNombre_proyecto().toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                }

                Paragraph comb18 = new Paragraph();
                comb18.add(new Chunk("DETALLE BREVEMENTE LAS ACTIVIDADES A REALIZAR (en el caso de Pasantías o Prácticas Pre profesionales): ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                document.add(comb18);
                document.add(new Chunk(opciones.getActividad_1(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));

                Paragraph comb19 = new Paragraph();
                comb19.add(new Chunk("\nNOMBRE DEL TUTOR: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                comb19.add(new Chunk(opciones.getNombre_tutor(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(comb19);

                Paragraph comb20 = new Paragraph();
                comb20.add(new Chunk("\n\n\n        ________________________             ", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD, Color.BLACK)));
                comb20.add(new Chunk("   _____________________________________________                 ", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD, Color.BLACK)));
                comb20.add(new Chunk("________________________", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD, Color.BLACK)));
                document.add(comb20);

                Paragraph comb21 = new Paragraph();
                comb21.add(new Chunk("         FIRMA DEL ESTUDIANTE             ", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD, Color.BLACK)));
                comb21.add(new Chunk("   RESPONSABLE DE PRÁCTICAS PRE PROFESIONALES,               ", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD, Color.BLACK)));
                comb21.add(new Chunk("FIRMA DOCENTE TUTOR", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD, Color.BLACK)));
                document.add(comb21);

                Paragraph comb22 = new Paragraph();
                comb22.add(new Chunk("                                                                        PASANTÍAS Y EXTENSIONES DE LA CARRERA DE\n", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD, Color.BLACK)));
                document.add(comb22);
                Paragraph comb24 = new Paragraph(opciones.getCarrera_grado(), FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD, Color.BLACK));
                comb24.setAlignment(Element.ALIGN_CENTER);
                document.add(comb24);

                Paragraph comb23 = new Paragraph();
                comb23.add(new Chunk("\nLUGAR Y FECHA DEL REGISTRO:  ", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD, Color.BLACK)));
                comb23.add(new Chunk(opciones.getLugar_suscripcion() + ", " + opciones.getFecha_suscripcion(), FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, Color.BLACK)));
                document.add(comb23);

            }

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

    //reporte Carta Compromiso
    public void dibujaPdfCartaCompromiso(Document document, String ruta_imagen, float dimension[], List< Carta_Compromiso> carta_comp, String ruta) {

        float[] widths = new float[dimension.length];

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta + "Carta_compromiso.pdf"));
            document.open();
            //Image imagen = Image.getInstance("/VCS/Logo_UPS.png");
            //InputStream inputStream = getClass().getClassLoader().getResourceAsStream("images/Logo_UPS.png");
            //InputStream is = new BufferedInputStream(inputStream);
            Image imagen = Image.getInstance(ruta_imagen + "/Logo_UPS.png");
            Image imagen2 = Image.getInstance(ruta_imagen + "/logo_vinculacion.png");

            imagen2.scalePercent(40f);
            imagen.scalePercent(3f);
            //PdfPTable table = new PdfPTable(1);
            //table.getDefaultCell().setBackgroundColor(new Color(205, 38, 38));

            imagen2.setAbsolutePosition(476f, 799f);
            imagen.setAbsolutePosition(50f, 799f);
            
            document.add(imagen);
            document.add(imagen2);

            Paragraph titulo = new Paragraph(new Paragraph("CARTA COMPROMISO INTERINSTITUCIONAL", FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD, Color.BLACK)));
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);

            for (Iterator<Carta_Compromiso> it = carta_comp.iterator(); it.hasNext();) {
                Carta_Compromiso opciones = it.next();
                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 2, Font.NORMAL, Color.BLACK)));
                //document.add(new Chunk(NEWLINE));
                Paragraph dat_est = new Paragraph(new Paragraph("I. INFORMACION GENERAL", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                //document.add(dat_est);
                PdfPTable table1 = new PdfPTable(1);
                PdfPCell celda1 = new PdfPCell(dat_est);
                celda1.setFixedHeight(16f);
                celda1.setBackgroundColor(Color.LIGHT_GRAY);
                celda1.setHorizontalAlignment(Element.ALIGN_LEFT);
                table1.addCell(celda1);
                table1.setTotalWidth(3f);
                table1.setWidthPercentage(100);
                document.add(table1);
                //document.add(chunkSeparador);

                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 1, Font.NORMAL, Color.BLACK)));

                Paragraph paraf_cod_tit = new Paragraph();
                Paragraph paraf_cod_val = new Paragraph();
                Paragraph paraf_num_tit = new Paragraph();
                Paragraph paraf_num_val = new Paragraph();
                paraf_cod_tit.add(new Chunk("CÓDIGO: ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                paraf_cod_val.add(new Chunk(opciones.getId_carta_compromiso(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));
                paraf_num_tit.add(new Chunk("NO.: ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                paraf_num_val.add(new Chunk(opciones.getId_carta_compromiso().substring(13), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));
                
                Paragraph paraf_emp_tit = new Paragraph();
                Paragraph paraf_emp_val = new Paragraph();
                paraf_emp_tit.add(new Chunk("NOMBRE DE LA EMPRESA O INSTITUCIÓN: ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                paraf_emp_val.add(new Chunk(opciones.getNomb_empresa(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));
                
                
                PdfPTable table_cab = new PdfPTable(4);
                PdfPCell celda1_cab = new PdfPCell(paraf_cod_tit);
                PdfPCell celda2_cab = new PdfPCell(paraf_cod_val);
                PdfPCell celda3_cab = new PdfPCell(paraf_num_tit);
                PdfPCell celda4_cab = new PdfPCell(paraf_num_val);
                PdfPCell celda5_cab = new PdfPCell(paraf_emp_tit);
                PdfPCell celda6_cab = new PdfPCell(paraf_emp_val);
                
                celda1_cab.setHorizontalAlignment(Element.ALIGN_RIGHT);
                celda3_cab.setHorizontalAlignment(Element.ALIGN_RIGHT);
                celda4_cab.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda6_cab.setColspan(3);
                
                celda1_cab.setBorder(0);
                celda2_cab.setBorder(Rectangle.BOTTOM);
                celda3_cab.setBorder(0);
                celda4_cab.setBorder(Rectangle.BOTTOM);
                celda5_cab.setBorder(0);
                celda6_cab.setBorder(Rectangle.BOTTOM);
                
                table_cab.addCell(celda1_cab);
                table_cab.addCell(celda2_cab);
                table_cab.addCell(celda3_cab);
                table_cab.addCell(celda4_cab);
                table_cab.addCell(celda5_cab);
                table_cab.addCell(celda6_cab);
                table_cab.setWidthPercentage(100);
                float[] medidaCeldas_cab = {0.63f, 0.60f, 0.40f, 0.55f};
                table_cab.setWidths(medidaCeldas_cab);// ASIGNO LAS MEDIDAS A LA TABLA (ANCHO)
                document.add(table_cab);
                
                PdfPTable table_dir = new PdfPTable(4);
                Paragraph paraf_dir_tit = new Paragraph();
                Paragraph paraf_telef_tit = new Paragraph();
                Paragraph paraf_dir_val = new Paragraph();
                Paragraph paraf_telef_val = new Paragraph();
                paraf_dir_tit.add(new Chunk("DIRECCIÓN: ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                paraf_dir_val.add(new Chunk(opciones.getDir_empresa(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));
                paraf_telef_tit.add(new Chunk("TELÉFONO: ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                paraf_telef_val.add(new Chunk(opciones.getTelf_representante(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));
                PdfPCell celda1_dir = new PdfPCell(paraf_dir_tit);
                PdfPCell celda2_dir = new PdfPCell(paraf_dir_val);
                PdfPCell celda3_dir = new PdfPCell(paraf_telef_tit);
                PdfPCell celda4_dir = new PdfPCell(paraf_telef_val);
                
                celda1_dir.setBorder(0);
                celda2_dir.setBorder(Rectangle.BOTTOM);
                celda3_dir.setBorder(0);
                celda4_dir.setBorder(Rectangle.BOTTOM);
                
                table_dir.addCell(celda1_dir);
                table_dir.addCell(celda2_dir);
                table_dir.addCell(celda3_dir);
                table_dir.addCell(celda4_dir);
                table_dir.setWidthPercentage(100);
                float[] medidaCeldas_dir = {0.18f, 0.90f, 0.18f, 0.80f};
                table_dir.setWidths(medidaCeldas_dir);// ASIGNO LAS MEDIDAS A LA TABLA (ANCHO)
                document.add(table_dir);
                
                PdfPTable table_act = new PdfPTable(2);
                
                Paragraph paraf_act_tit = new Paragraph();
                Paragraph paraf_act_val = new Paragraph();
                paraf_act_tit.add(new Chunk("ACTIVIDAD PRINCIPAL DE LA EMPRESA O INSTITUCIÓN: ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                paraf_act_val.add(new Chunk(opciones.getAct_empresa(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));
                PdfPCell celda1_act = new PdfPCell(paraf_act_tit);
                PdfPCell celda2_act = new PdfPCell(paraf_act_val);
                
                celda1_act.setBorder(0);
                celda2_act.setBorder(Rectangle.BOTTOM);
                
                table_act.addCell(celda1_act);
                table_act.addCell(celda2_act);
                
                table_act.setWidthPercentage(100);
                float[] medidaCeldas_act = {0.24f, 0.90f};
                table_act.setWidths(medidaCeldas_act);// ASIGNO LAS MEDIDAS A LA TABLA (ANCHO)
                document.add(table_act);
                
                PdfPTable table_est = new PdfPTable(2);
                
                Paragraph paraf_est_tit = new Paragraph();
                Paragraph paraf_est_val = new Paragraph();
                paraf_est_tit.add(new Chunk("APELLIDOS Y NOMBRES DEL ESTUDIANTE: ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                paraf_est_val.add(new Chunk(opciones.getNomb_estudiante().toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));
                
                PdfPCell celda1_est = new PdfPCell(paraf_est_tit);
                PdfPCell celda2_est = new PdfPCell(paraf_est_val);
                
                celda1_est.setBorder(0);
                celda2_est.setBorder(Rectangle.BOTTOM);
                
                table_est.addCell(celda1_est);
                table_est.addCell(celda2_est);
                
                table_est.setWidthPercentage(100);
                float[] medidaCeldas_est = {0.39f, 0.90f};
                table_est.setWidths(medidaCeldas_est);// ASIGNO LAS MEDIDAS A LA TABLA (ANCHO)
                document.add(table_est);
                
                Paragraph comb6 = new Paragraph();
                comb6.add(new Chunk("CARRERA DE GRADO: ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                comb6.add(new Chunk(opciones.getCarrera_grado(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));
                comb6.add(new Chunk("                         ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));
                comb6.add(new Chunk("CICLO o SEMESTRE QUE CURSA: ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                comb6.add(new Chunk(opciones.getCiclo_curso(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));
                document.add(comb6);

                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 2, Font.NORMAL, Color.BLACK)));
                
                Paragraph dat_est3 = new Paragraph(new Paragraph("II. DESCRIPCIÓN ESTRATÉGICA DE INTERVENCIÓN", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                //document.add(dat_est);
                PdfPTable table3 = new PdfPTable(1);
                PdfPCell celda3 = new PdfPCell(dat_est3);
                celda3.setFixedHeight(16f);
                celda3.setBackgroundColor(Color.LIGHT_GRAY);
                celda3.setHorizontalAlignment(Element.ALIGN_LEFT);
                table3.addCell(celda3);
                table3.setTotalWidth(3f);
                table3.setWidthPercentage(100);
                document.add(table3);

                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 1, Font.NORMAL, Color.BLACK)));
                
                PdfPTable table_tipo_act = new PdfPTable(4);
                Paragraph paraf_tipo_act_tit = new Paragraph();
                Paragraph paraf_tipo_act_val = new Paragraph();
                Paragraph paraf_duracion_tit = new Paragraph();
                Paragraph paraf_duracion_val = new Paragraph();
                
                paraf_tipo_act_tit.add(new Chunk("TIPO DE ACTIVIDAD ACADÉMICA: ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                paraf_tipo_act_val.add(new Chunk(opciones.getTipo_actividad(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));
                paraf_duracion_tit.add(new Chunk("DURACIÓN: ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                paraf_duracion_val.add(new Chunk(opciones.getTotal_horas()+" horas", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));
                
                PdfPCell celda1_tipo_act = new PdfPCell(paraf_tipo_act_tit);
                PdfPCell celda2_tipo_act = new PdfPCell(paraf_tipo_act_val);
                PdfPCell celda3_tipo_act = new PdfPCell(paraf_duracion_tit);
                PdfPCell celda4_tipo_act = new PdfPCell(paraf_duracion_val);
                
                celda1_tipo_act.setBorder(0);
                celda2_tipo_act.setBorder(Rectangle.BOTTOM);
                celda3_tipo_act.setBorder(0);
                celda4_tipo_act.setBorder(Rectangle.BOTTOM);
                
                table_tipo_act.addCell(celda1_tipo_act);
                table_tipo_act.addCell(celda2_tipo_act);
                table_tipo_act.addCell(celda3_tipo_act);
                table_tipo_act.addCell(celda4_tipo_act);
                
                table_tipo_act.setWidthPercentage(100);
                float[] medidaCeldas_tipo_act = {0.66f, 0.95f,0.30f, 0.78f};
                table_tipo_act.setWidths(medidaCeldas_tipo_act);// ASIGNO LAS MEDIDAS A LA TABLA (ANCHO)
                document.add(table_tipo_act);
                
                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 1, Font.BOLD, Color.BLACK)));
                
                PdfPTable table_objetivo_ac = new PdfPTable(4);
                
                Paragraph campo1=new Paragraph("OBJETIVO DE LA\nACTIVIDAD ACADÉMICA: ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK));
                Paragraph campo2=new Paragraph(opciones.getObjetivo_actividad(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK));
                Paragraph campo3=new Paragraph("FECHA INICIO:", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK));
                Paragraph campo4=new Paragraph(opciones.getDia_inicio() + "/" + opciones.getMes_inicio() + "/" + opciones.getAnio_inicio(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK));
                Paragraph campo5=new Paragraph("FECHA FINAL:", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK));
                Paragraph campo6=new Paragraph(opciones.getDia_fin() + "/" + opciones.getMes_fin() + "/" + opciones.getAnio_fin(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK));
                Paragraph campo7=new Paragraph("HORARIO PREVISTO", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK));
                Paragraph campo8=new Paragraph(opciones.getHorario_previsto(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK));
                
		PdfPCell celda_1=new PdfPCell(campo1);
                PdfPCell celda_2=new PdfPCell(campo2);
                PdfPCell celda_3=new PdfPCell(campo3);
                PdfPCell celda_4=new PdfPCell(campo4);
                PdfPCell celda_5=new PdfPCell(campo5);
                PdfPCell celda_6=new PdfPCell(campo6);
                PdfPCell celda_7=new PdfPCell(campo7);
                PdfPCell celda_8=new PdfPCell(campo8);
                
                celda_1.setBorder(0);
                //celda_2.setBorder(0);
                celda_3.setBorder(0);
                celda_4.setBorder(Rectangle.BOTTOM);
                celda_5.setBorder(0);
                celda_6.setBorder(Rectangle.BOTTOM);
                celda_7.setBorder(0);
                celda_8.setBorder(Rectangle.BOTTOM);
                
                celda_1.setHorizontalAlignment(Element.ALIGN_LEFT);
                celda_2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda_3.setHorizontalAlignment(Element.ALIGN_LEFT);
                celda_4.setHorizontalAlignment(Element.ALIGN_LEFT);
                celda_5.setHorizontalAlignment(Element.ALIGN_LEFT);
                celda_6.setHorizontalAlignment(Element.ALIGN_LEFT);
                celda_7.setHorizontalAlignment(Element.ALIGN_LEFT);
                celda_8.setHorizontalAlignment(Element.ALIGN_LEFT);
                
                celda_2.setRowspan(3);
                celda_1.setRowspan(3);
                
                table_objetivo_ac.addCell(celda_1);
                table_objetivo_ac.addCell(celda_2);
                table_objetivo_ac.addCell(celda_3);
                table_objetivo_ac.addCell(celda_4);
                table_objetivo_ac.addCell(celda_5);
                table_objetivo_ac.addCell(celda_6);
                table_objetivo_ac.addCell(celda_7);
                table_objetivo_ac.addCell(celda_8);
                
                table_objetivo_ac.setWidthPercentage(100);//Para que ocupe toda la hoja
                float[] medidaCeldas_ob_tab = {0.50f, 2.10f, 0.64f, 1.18f};
                table_objetivo_ac.setWidths(medidaCeldas_ob_tab);// ASIGNO LAS MEDIDAS A LA TABLA (ANCHO)
                document.add(table_objetivo_ac);
                
                PdfPTable table_programa = new PdfPTable(2);
                
                Paragraph paraf_prog_tit = new Paragraph();
                Paragraph paraf_prog_val = new Paragraph();
                paraf_prog_tit.add(new Chunk("NOMBRE PROGRAMA: ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                paraf_prog_val.add(new Chunk(opciones.getNombre_programa(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));
                
                PdfPCell celda_1_prog=new PdfPCell(paraf_prog_tit);
                PdfPCell celda_2_prog=new PdfPCell(paraf_prog_val);
                
                celda_1_prog.setBorder(0);
                celda_2_prog.setBorder(Rectangle.BOTTOM);
                table_programa.addCell(celda_1_prog);
                table_programa.addCell(celda_2_prog);
                
                table_programa.setWidthPercentage(100);//Para que ocupe toda la hoja
                float[] medidaCeldas_prog = {0.45f, 2.10f};
                table_programa.setWidths(medidaCeldas_prog);// ASIGNO LAS MEDIDAS A LA TABLA (ANCHO)
                document.add(table_programa);
                
                PdfPTable table_area = new PdfPTable(4);
                
                Paragraph paraf_area_tit = new Paragraph();
                Paragraph paraf_area_val = new Paragraph();
                Paragraph paraf_resp_area_tit = new Paragraph();
                Paragraph paraf_resp_area_val = new Paragraph();
                paraf_area_tit.add(new Chunk("ÁREA QUE REQUIERE LA ACTIVIDAD ACADÉMICA: ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                paraf_area_val.add(new Chunk(opciones.getArea_actividad().toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));
                paraf_resp_area_tit.add(new Chunk("RESPONSABLE DEL ÁREA: ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                paraf_resp_area_val.add(new Chunk(opciones.getResponsable_area(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));
                
                PdfPCell celda_1_area=new PdfPCell(paraf_area_tit);
                PdfPCell celda_2_area=new PdfPCell(paraf_area_val);
                PdfPCell celda_3_area=new PdfPCell(paraf_resp_area_tit);
                PdfPCell celda_4_area=new PdfPCell(paraf_resp_area_val);
                
                celda_1_area.setBorder(0);
                celda_2_area.setBorder(Rectangle.BOTTOM);
                celda_3_area.setBorder(0);
                celda_4_area.setBorder(Rectangle.BOTTOM);
                table_area.addCell(celda_1_area);
                table_area.addCell(celda_2_area);
                table_area.addCell(celda_3_area);
                table_area.addCell(celda_4_area);
                
                table_area.setWidthPercentage(100);//Para que ocupe toda la hoja
                float[] medidaCeldas_area = {1.10f, 1f,0.70f,1f};
                table_area.setWidths(medidaCeldas_area);// ASIGNO LAS MEDIDAS A LA TABLA (ANCHO)
                document.add(table_area);
                
                Paragraph act_prev_tit = new Paragraph();
                act_prev_tit.add(new Chunk("ACTIVIDADES PREVISTAS A SER DESARROLLADAS EN LA ACTIVIDAD ACADÉMICA:(SEÑALE AQUELLAS QUE PREVÉN RESULTADOS Y PRODUCTOS)", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                document.add(act_prev_tit);
                Administrar_Ficha_Estudiante adm_ficha_est = new Administrar_Ficha_Estudiante();
                List< Carta_Compromiso> carta_comp2_act = adm_ficha_est.obtiene_elemento2(opciones.getId_carta_compromiso(),"AC");
                
                PdfPTable table_actividades = new PdfPTable(1);
                
                for (Iterator<Carta_Compromiso> it2 = carta_comp2_act.iterator(); it2.hasNext();) {
                    Carta_Compromiso elemento = it2.next();
                    Paragraph act_contenido = new Paragraph();
                    act_contenido.add(new Chunk(elemento.getActividad_1(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));
                    PdfPCell celda_1_actividades=new PdfPCell(act_contenido);
                    celda_1_actividades.setBorder(Rectangle.BOTTOM);
                    table_actividades.addCell(celda_1_actividades);
                }
                table_actividades.setWidthPercentage(100);//Para que ocupe toda la hoja
                document.add(table_actividades);
                
                Paragraph result_prev_tit = new Paragraph();
                result_prev_tit.add(new Chunk("RESULTADOS PREVISTOS DE ACTIVIDAD ACADÉMICA:", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                document.add(result_prev_tit);
                List< Carta_Compromiso> carta_comp2_res = adm_ficha_est.obtiene_elemento2(opciones.getId_carta_compromiso(),"RE");
                
                PdfPTable table_resultados = new PdfPTable(1);
                
                for (Iterator<Carta_Compromiso> it2 = carta_comp2_res.iterator(); it2.hasNext();) {
                    Carta_Compromiso elemento = it2.next();
                    Paragraph act_contenido = new Paragraph();
                    act_contenido.add(new Chunk(elemento.getActividad_1(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));
                    PdfPCell celda_1_resultados=new PdfPCell(act_contenido);
                    celda_1_resultados.setBorder(Rectangle.BOTTOM);
                    table_resultados.addCell(celda_1_resultados);
                }
                table_resultados.setWidthPercentage(100);//Para que ocupe toda la hoja
                document.add(table_resultados);
                
                
                Paragraph recursos_prev_tit = new Paragraph();
                recursos_prev_tit.add(new Chunk("RECURSOS: PRODUCTOS ENTREGABLES PREVISTOS DE LA ACTIVIDAD ACADÉMICA Y LOS MATERIALES FÍSICOS QUE SE GENERAN EN LA INTERVENCIÓN", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                document.add(recursos_prev_tit);
                List< Carta_Compromiso> carta_comp2_rec = adm_ficha_est.obtiene_elemento2(opciones.getId_carta_compromiso(),"RC");
                
                PdfPTable table_productos = new PdfPTable(1);
                
                for (Iterator<Carta_Compromiso> it2 = carta_comp2_rec.iterator(); it2.hasNext();) {
                    Carta_Compromiso elemento = it2.next();
                    Paragraph act_contenido = new Paragraph();
                    act_contenido.add(new Chunk(elemento.getActividad_1(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));
                    PdfPCell celda_1_productos=new PdfPCell(act_contenido);
                    celda_1_productos.setBorder(Rectangle.BOTTOM);
                    table_productos.addCell(celda_1_productos);
                }
                table_productos.setWidthPercentage(100);//Para que ocupe toda la hoja
                document.add(table_productos);
                
                Paragraph recursos_tutor_tit = new Paragraph();
                recursos_tutor_tit.add(new Chunk("NOMBRE DEL TUTOR: ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                recursos_tutor_tit.add(new Chunk(opciones.getNombre_tutor(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                document.add(recursos_tutor_tit);
                
                //document.add(new Paragraph(""));
                //document.add(new Paragraph("\nDATOS DE LA EMPRESA Y/0 PROYECTO",FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                //document.add(chunkSeparador);
                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 1, Font.NORMAL, Color.BLACK)));

                Paragraph dat_est2 = new Paragraph(new Paragraph("III. ACEPTACIÓN Y LEGALIZACIÓN", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                //document.add(dat_est);
                PdfPTable table2 = new PdfPTable(1);
                PdfPCell celda2 = new PdfPCell(dat_est2);
                celda2.setFixedHeight(16f);
                celda2.setBackgroundColor(Color.LIGHT_GRAY);
                celda2.setHorizontalAlignment(Element.ALIGN_LEFT);
                table2.addCell(celda2);
                table2.setTotalWidth(3f);
                table2.setWidthPercentage(100);
                document.add(table2);

                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 1, Font.BOLD, Color.BLACK)));

                PdfPTable table_aceptacion = new PdfPTable(6);
                
                Paragraph paraf_rep_tit = new Paragraph();
                Paragraph paraf_rep_val = new Paragraph();
                Paragraph paraf_rep_cargo_tit = new Paragraph();
                Paragraph paraf_rep_cargo_val = new Paragraph();
                Paragraph paraf_rep_telef_tit = new Paragraph();
                Paragraph paraf_rep_telef_val = new Paragraph();
                Paragraph paraf_deleg_tit = new Paragraph();
                Paragraph paraf_deleg_val = new Paragraph();
                Paragraph paraf_deleg_cargo_tit = new Paragraph();
                Paragraph paraf_deleg_cargo_val = new Paragraph();
                Paragraph paraf_deleg_telef_tit = new Paragraph();
                Paragraph paraf_deleg_telef_val = new Paragraph();
                Paragraph paraf_suscrip_tit = new Paragraph();
                Paragraph paraf_suscrip_val = new Paragraph();
                
                paraf_rep_tit.add(new Chunk("APELLIDOS Y NOMBRES DEL REPRESENTANTE LEGAL: ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                paraf_rep_val.add(new Chunk(opciones.getNombre_representante().toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));
                paraf_rep_cargo_tit.add(new Chunk("CARGO: ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                paraf_rep_cargo_val.add(new Chunk(opciones.getCargo_representante(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));
                paraf_rep_telef_tit.add(new Chunk("TELÉFONO: ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                paraf_rep_telef_val.add(new Chunk(opciones.getTelf_representante(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));

                paraf_deleg_tit.add(new Chunk("APELLIDOS Y NOMBRES DELEGADO UPS: ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                paraf_deleg_val.add(new Chunk(opciones.getDir_tecnico().toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));
                paraf_deleg_cargo_tit.add(new Chunk("CARGO: ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                paraf_deleg_cargo_val.add(new Chunk(opciones.getCargo_dir_tec(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));
                paraf_deleg_telef_tit.add(new Chunk("TELÉFONO: ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                paraf_deleg_telef_val.add(new Chunk(opciones.getTelf_delegado(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));

                paraf_suscrip_tit.add(new Chunk("LUGAR Y FECHA SUSCRIPCIÓN: ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK)));
                paraf_suscrip_val.add(new Chunk(opciones.getLugar_suscripcion() + ", " + opciones.getFecha_suscripcion(), FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK)));
                
                PdfPCell celda_1_aceptacion=new PdfPCell(paraf_rep_tit);
                PdfPCell celda_2_aceptacion=new PdfPCell(paraf_rep_val);
                PdfPCell celda_3_aceptacion=new PdfPCell(paraf_rep_cargo_tit);
                PdfPCell celda_4_aceptacion=new PdfPCell(paraf_rep_cargo_val);
                PdfPCell celda_5_aceptacion=new PdfPCell(paraf_rep_telef_tit);
                PdfPCell celda_6_aceptacion=new PdfPCell(paraf_rep_telef_val);
                PdfPCell celda_7_aceptacion=new PdfPCell(paraf_deleg_tit);
                PdfPCell celda_8_aceptacion=new PdfPCell(paraf_deleg_val);
                PdfPCell celda_9_aceptacion=new PdfPCell(paraf_deleg_cargo_tit);
                PdfPCell celda_10_aceptacion=new PdfPCell(paraf_deleg_cargo_val);
                PdfPCell celda_11_aceptacion=new PdfPCell(paraf_deleg_telef_tit);
                PdfPCell celda_12_aceptacion=new PdfPCell(paraf_deleg_telef_val);
                PdfPCell celda_13_aceptacion=new PdfPCell(paraf_suscrip_tit);
                PdfPCell celda_14_aceptacion=new PdfPCell(paraf_suscrip_val);
                
                celda_1_aceptacion.setBorder(0);
                celda_2_aceptacion.setBorder(Rectangle.BOTTOM);
                celda_3_aceptacion.setBorder(0);
                celda_4_aceptacion.setBorder(Rectangle.BOTTOM);
                celda_5_aceptacion.setBorder(0);
                celda_6_aceptacion.setBorder(Rectangle.BOTTOM);
                celda_7_aceptacion.setBorder(0);
                celda_8_aceptacion.setBorder(Rectangle.BOTTOM);
                celda_9_aceptacion.setBorder(0);
                celda_10_aceptacion.setBorder(Rectangle.BOTTOM);
                celda_11_aceptacion.setBorder(0);
                celda_12_aceptacion.setBorder(Rectangle.BOTTOM);
                celda_13_aceptacion.setBorder(0);
                celda_14_aceptacion.setBorder(Rectangle.BOTTOM);
                
                celda_14_aceptacion.setColspan(5);
                
                table_aceptacion.addCell(celda_1_aceptacion);
                table_aceptacion.addCell(celda_2_aceptacion);
                table_aceptacion.addCell(celda_3_aceptacion);
                table_aceptacion.addCell(celda_4_aceptacion);
                table_aceptacion.addCell(celda_5_aceptacion);
                table_aceptacion.addCell(celda_6_aceptacion);
                table_aceptacion.addCell(celda_7_aceptacion);
                table_aceptacion.addCell(celda_8_aceptacion);
                table_aceptacion.addCell(celda_9_aceptacion);
                table_aceptacion.addCell(celda_10_aceptacion);
                table_aceptacion.addCell(celda_11_aceptacion);
                table_aceptacion.addCell(celda_12_aceptacion);
                table_aceptacion.addCell(celda_13_aceptacion);
                table_aceptacion.addCell(celda_14_aceptacion);
                
                table_aceptacion.setWidthPercentage(100);
                float[] medidaCeldas_aceptacion = {0.90f, 1f,0.24f,0.50f,0.28f,0.40f};
                table_aceptacion.setWidths(medidaCeldas_aceptacion);// ASIGNO LAS MEDIDAS A LA TABLA (ANCHO)
                
                document.add(table_aceptacion);
                
                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 5, Font.NORMAL, Color.BLACK)));
                
                PdfPTable table_firma_rep_leg = new PdfPTable(3);
                PdfPCell tit_firma_rep_leg=new PdfPCell(new Paragraph(new Paragraph("REPRESENTANTE LEGAL ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK))));
                PdfPCell tit_firma2_rep_leg=new PdfPCell(new Paragraph(new Paragraph("\n\n\nfirma", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK))));
                PdfPCell tit_firma3_rep_leg=new PdfPCell(new Paragraph(new Paragraph("\n\n\nsello", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK))));
                tit_firma_rep_leg.setBorder(0);
                tit_firma_rep_leg.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table_firma_rep_leg.addCell(tit_firma_rep_leg);
                table_firma_rep_leg.addCell(tit_firma2_rep_leg);
                table_firma_rep_leg.addCell(tit_firma3_rep_leg);
                table_firma_rep_leg.setWidthPercentage(100);//Para que ocupe toda la hoja
                document.add(table_firma_rep_leg);
                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 3, Font.NORMAL, Color.BLACK)));

                PdfPTable table_firma_deleg_ups = new PdfPTable(3);
                PdfPCell tit_firma_deleg_ups=new PdfPCell(new Paragraph(new Paragraph("DIRECCIÓN TÉCNICA DE \nVINCULACIÓN CON LA \nSOCIEDAD ", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK))));
                PdfPCell tit_firma2_deleg_ups=new PdfPCell(new Paragraph(new Paragraph("\n\n\nfirma", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK))));
                PdfPCell tit_firma3_deleg_ups=new PdfPCell(new Paragraph(new Paragraph("\n\n\nsello", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK))));
                tit_firma_deleg_ups.setBorder(0);
                tit_firma_deleg_ups.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table_firma_deleg_ups.addCell(tit_firma_deleg_ups);
                table_firma_deleg_ups.addCell(tit_firma2_deleg_ups);
                table_firma_deleg_ups.addCell(tit_firma3_deleg_ups);
                table_firma_deleg_ups.setWidthPercentage(100);//Para que ocupe toda la hoja
                
                document.add(table_firma_deleg_ups);
                

            }

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

    //reporte Cronograma de actividades
    public void dibujaPdfCronograma(Document document, String ruta_imagen, float dimension[], List< Carta_Compromiso> carta_comp, String ruta) {

        float[] widths = new float[dimension.length];

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta + "Cronograma.pdf"));
            document.open();
            Chunk chunkSeparador = new Chunk(SEPARADOR, FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
            //Image imagen = Image.getInstance("/VCS/Logo_UPS.png");
            //InputStream inputStream = getClass().getClassLoader().getResourceAsStream("images/Logo_UPS.png");
            //InputStream is = new BufferedInputStream(inputStream);
            Image imagen = Image.getInstance(ruta_imagen + "/Logo_UPS.png");
            Image imagen2 = Image.getInstance(ruta_imagen + "/logo_vinculacion.png");

            imagen2.scalePercent(59f);
            imagen.scalePercent(5f);
            //PdfPTable table = new PdfPTable(1);
            //table.getDefaultCell().setBackgroundColor(new Color(205, 38, 38));

            imagen2.setAbsolutePosition(650f, 555f);
            imagen.setAbsolutePosition(45f, 550f);
            document.add(imagen);
            document.add(imagen2);

            
            String tipo_doc;

            for (Iterator<Carta_Compromiso> it = carta_comp.iterator(); it.hasNext();) {
                Carta_Compromiso opciones = it.next();
                
                Paragraph titulo = new Paragraph(new Paragraph("PROGRAMA DE "+opciones.getTipo_actividad().toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 15, Font.BOLD, Color.BLACK)));
                titulo.setAlignment(Element.ALIGN_CENTER);
                document.add(titulo);
                
                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                //document.add(new Chunk(NEWLINE));
                
                //document.add(chunkSeparador);
                
                
                Paragraph paraf_cc = new Paragraph();
                Paragraph paraf_act = new Paragraph();
                Paragraph paraf_cc_val = new Paragraph();
                Paragraph paraf_act_val = new Paragraph();
                paraf_cc.add(new Chunk("CARTA COMPROMISO: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                paraf_cc_val.add(new Chunk(opciones.getId_carta_compromiso(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                paraf_act.add(new Chunk("TIPO DE ACTIVIDAD: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                paraf_act_val.add(new Chunk(opciones.getTipo_actividad(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                //document.add(comb);

                Paragraph paraf_inst = new Paragraph();
                Paragraph paraf_inst_val = new Paragraph();
                Chunk chunk_int_val = new Chunk(opciones.getNomb_empresa(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK));
                //chunk_int_val.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
                //document.add(chunk_int_val);
                paraf_inst.add(new Chunk("INSTITUCIÓN: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                paraf_inst_val.add(chunk_int_val);
                //document.add(comb2);

                Paragraph paraf_est = new Paragraph();
                Paragraph paraf_est_val = new Paragraph();
                Paragraph paraf_ced = new Paragraph();
                Paragraph paraf_ced_val = new Paragraph();
                paraf_est.add(new Chunk("ESTUDIANTE: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                paraf_est_val.add(new Chunk(opciones.getNomb_estudiante(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                paraf_ced.add(new Chunk("CÉDULA DE CIUDADANÍA: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                paraf_ced_val.add(new Chunk(opciones.getCed_estudiante().toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                //document.add(comb3);
                
                PdfPTable table_cab = new PdfPTable(4);
                PdfPCell cell_cab_1=new PdfPCell(paraf_cc);
                PdfPCell cell_cab_2=new PdfPCell(paraf_cc_val);
                PdfPCell cell_cab_3=new PdfPCell(paraf_act);
                PdfPCell cell_cab_4=new PdfPCell(paraf_act_val);
                PdfPCell cell_cab_5=new PdfPCell(paraf_inst);
                PdfPCell cell_cab_6=new PdfPCell(paraf_inst_val);
                PdfPCell cell_cab_7=new PdfPCell(paraf_est);
                PdfPCell cell_cab_8=new PdfPCell(paraf_est_val);
                PdfPCell cell_cab_9=new PdfPCell(paraf_ced);
                PdfPCell cell_cab_10=new PdfPCell(paraf_ced_val);
                
                cell_cab_1.setBorder(0);    cell_cab_2.setBorder(Rectangle.BOTTOM);    cell_cab_3.setBorder(0);
                cell_cab_4.setBorder(Rectangle.BOTTOM);    cell_cab_5.setBorder(0);    cell_cab_6.setBorder(Rectangle.BOTTOM);
                cell_cab_7.setBorder(0);    cell_cab_8.setBorder(Rectangle.BOTTOM);    cell_cab_9.setBorder(0);
                cell_cab_10.setBorder(Rectangle.BOTTOM);
                
                cell_cab_6.setColspan(3);
                
                table_cab.addCell(cell_cab_1);
                table_cab.addCell(cell_cab_2);
                table_cab.addCell(cell_cab_3);
                table_cab.addCell(cell_cab_4);
                table_cab.addCell(cell_cab_5);
                table_cab.addCell(cell_cab_6);
                table_cab.addCell(cell_cab_7);
                table_cab.addCell(cell_cab_8);
                table_cab.addCell(cell_cab_9);
                table_cab.addCell(cell_cab_10);
                table_cab.setWidthPercentage(100);
                float[] medidaCeldas_cab = {0.35f, 0.60f, 0.40f, 0.55f};
                table_cab.setWidths(medidaCeldas_cab);// ASIGNO LAS MEDIDAS A LA TABLA (ANCHO)
                document.add(table_cab);
                
                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));

                Administrar_Carta_Compromiso adm_cc = new Administrar_Carta_Compromiso();
                
                Paragraph dat_just_tit = new Paragraph(new Paragraph("JUSTIFICACIÓN: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                Paragraph dat_obj_tit = new Paragraph(new Paragraph("OBJETIVOS: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                Paragraph dat_duracion_tit = new Paragraph(new Paragraph("DURACIÓN: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                dat_just_tit.setAlignment(Element.ALIGN_LEFT);
                dat_obj_tit.setAlignment(Element.ALIGN_LEFT);
                dat_duracion_tit.setAlignment(Element.ALIGN_LEFT);
                
                Paragraph dat_just = new Paragraph(new Paragraph(adm_cc.devuelveParametroCC("JUSTIF_"+adm_cc.devuelveDatoCC(opciones.getId_carta_compromiso(), "cc_tipo_actividad")), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                Paragraph dat_obj = new Paragraph(new Paragraph(opciones.getObjetivo_actividad(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                Paragraph dat_duracion = new Paragraph(new Paragraph(opciones.getTotal_horas()+" horas", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                
                
                PdfPTable table_just = new PdfPTable(2);
                PdfPCell celda_just_tit = new PdfPCell(dat_just_tit);
                PdfPCell celda_obj_tit = new PdfPCell(dat_obj_tit);
                PdfPCell celda_duracion_tit = new PdfPCell(dat_duracion_tit);
                PdfPCell celda_just = new PdfPCell(dat_just);
                PdfPCell celda_obj = new PdfPCell(dat_obj);
                PdfPCell celda_duracion = new PdfPCell(dat_duracion);
                //celda_just.setFixedHeight(16f);
                //celda_just.setBackgroundColor(Color.LIGHT_GRAY);
                celda_just_tit.setHorizontalAlignment(Element.ALIGN_LEFT);
                celda_obj_tit.setHorizontalAlignment(Element.ALIGN_LEFT);
                celda_duracion_tit.setHorizontalAlignment(Element.ALIGN_LEFT);
                celda_just.setHorizontalAlignment(Element.ALIGN_LEFT);
                celda_obj.setHorizontalAlignment(Element.ALIGN_LEFT);
                celda_duracion.setHorizontalAlignment(Element.ALIGN_LEFT);
                
                celda_just_tit.setBorder(0);
                celda_obj_tit.setBorder(0);
                celda_duracion_tit.setBorder(0);
                
                table_just.addCell(celda_just_tit);
                table_just.addCell(celda_just);
                table_just.addCell(celda_obj_tit);
                table_just.addCell(celda_obj);
                table_just.addCell(celda_duracion_tit);
                table_just.addCell(celda_duracion);
                //table_just.setTotalWidth(3f);
                //table_just.setWidthPercentage(100);
                table_just.setHorizontalAlignment(Element.ALIGN_CENTER);
                float[] medidaCeldas_just = {0.18f, 0.80f};
                table_just.setWidths(medidaCeldas_just);// ASIGNO LAS MEDIDAS A LA TABLA (ANCHO)
                document.add(table_just);
                
                
                Paragraph comb4 = new Paragraph();
                comb4.add(new Chunk("RECURSOS QUE INTERVIENEN: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                document.add(comb4);
                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 5, Font.NORMAL, Color.BLACK)));
                
                Administrar_Ficha_Estudiante adm_ficha_est = new Administrar_Ficha_Estudiante();
                List< Carta_Compromiso> carta_comp2_act = adm_ficha_est.obtiene_elemento2(opciones.getId_carta_compromiso(),"RC");
                
                String recursos="";
                
                for (Iterator<Carta_Compromiso> it2 = carta_comp2_act.iterator(); it2.hasNext();) {
                    Carta_Compromiso elemento = it2.next();
                    recursos=recursos+elemento.getActividad_1()+"-";
                }
                PdfPTable table_rec = new PdfPTable(1);
                recursos=recursos.substring(2,recursos.length()-1).replace("-2. -3.", "").replace("-3. -4.", "").replace("-4. -5.", "").replace("-5. -6.", "").replace(" -6.", "");
                Paragraph act_contenido = new Paragraph();
                act_contenido.add(new Chunk(recursos, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                PdfPCell celda_recursos = new PdfPCell(act_contenido);
                table_rec.addCell(celda_recursos);
                table_rec.setWidthPercentage(100);
                document.add(table_rec);
                
                Paragraph cronog_tit = new Paragraph();
                cronog_tit.add(new Chunk("\nCRONOGRAMA DE ACTIVIDADES", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, Color.BLACK)));
                cronog_tit.setAlignment(Element.ALIGN_CENTER);
                document.add(cronog_tit);
                
                //document.add(new Paragraph(""));
                //document.add(new Paragraph("\nDATOS DE LA EMPRESA Y/0 PROYECTO",FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                //document.add(chunkSeparador);
                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 6, Font.BOLD, Color.BLACK)));
                
                PdfPTable table_act = new PdfPTable(18);
                Paragraph tit_actividades = new Paragraph();
                tit_actividades.add(new Chunk("ACTIVIDADES                                    ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                Paragraph tit_semanas = new Paragraph();
                tit_semanas.add(new Chunk("SEMANAS", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                Paragraph tit_sem_1 = new Paragraph();
                tit_sem_1.add(new Chunk("1", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                Paragraph tit_sem_2 = new Paragraph();
                tit_sem_2.add(new Chunk("2", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                Paragraph tit_sem_3 = new Paragraph();
                tit_sem_3.add(new Chunk("3", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                Paragraph tit_sem_4 = new Paragraph();
                tit_sem_4.add(new Chunk("4", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                Paragraph tit_sem_5 = new Paragraph();
                tit_sem_5.add(new Chunk("5", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                Paragraph tit_sem_6 = new Paragraph();
                tit_sem_6.add(new Chunk("6", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                Paragraph tit_sem_7 = new Paragraph();
                tit_sem_7.add(new Chunk("7", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                Paragraph tit_sem_8 = new Paragraph();
                tit_sem_8.add(new Chunk("8", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                Paragraph tit_sem_9 = new Paragraph();
                tit_sem_9.add(new Chunk("9", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                Paragraph tit_sem_10 = new Paragraph();
                tit_sem_10.add(new Chunk("10", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                Paragraph tit_sem_11 = new Paragraph();
                tit_sem_11.add(new Chunk("11", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                Paragraph tit_sem_12 = new Paragraph();
                tit_sem_12.add(new Chunk("12", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                Paragraph tit_sem_13 = new Paragraph();
                tit_sem_13.add(new Chunk("13", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                Paragraph tit_sem_14 = new Paragraph();
                tit_sem_14.add(new Chunk("14", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                Paragraph tit_sem_15 = new Paragraph();
                tit_sem_15.add(new Chunk("15", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                Paragraph tit_total_act = new Paragraph();
                tit_total_act.add(new Chunk("TOTAL", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                Paragraph tit_total_gnral = new Paragraph();
                tit_total_gnral.add(new Chunk("TOTAL", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                Paragraph tit_h = new Paragraph();
                tit_h.add(new Chunk(" h ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                Paragraph blanco = new Paragraph();
                blanco.add(new Chunk(" ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                
                tit_h.setAlignment(Element.ALIGN_CENTER);
                
                PdfPCell celda_1 = new PdfPCell(tit_actividades);
                PdfPCell celda_2 = new PdfPCell(tit_semanas);
                PdfPCell celda_3 = new PdfPCell(tit_sem_1);
                PdfPCell celda_4 = new PdfPCell(tit_sem_2);
                PdfPCell celda_5 = new PdfPCell(tit_sem_3);
                PdfPCell celda_6 = new PdfPCell(tit_sem_4);
                PdfPCell celda_7 = new PdfPCell(tit_sem_5);
                PdfPCell celda_8 = new PdfPCell(tit_sem_6);
                PdfPCell celda_9 = new PdfPCell(tit_sem_7);
                PdfPCell celda_sem8 = new PdfPCell(tit_sem_8);
                PdfPCell celda_sem9 = new PdfPCell(tit_sem_9);
                PdfPCell celda_sem10 = new PdfPCell(tit_sem_10);
                PdfPCell celda_sem11 = new PdfPCell(tit_sem_11);
                PdfPCell celda_sem12 = new PdfPCell(tit_sem_12);
                PdfPCell celda_sem13 = new PdfPCell(tit_sem_13);
                PdfPCell celda_sem14 = new PdfPCell(tit_sem_14);
                PdfPCell celda_sem15 = new PdfPCell(tit_sem_15);
                
                PdfPCell celda_10 = new PdfPCell(tit_total_act);
                PdfPCell celda_11 = new PdfPCell(tit_total_gnral);
                PdfPCell celda_12 = new PdfPCell(tit_h);
                PdfPCell celda_blank = new PdfPCell(blanco); 
                celda_11.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda_12.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda_10.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda_3.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda_4.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda_5.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda_6.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda_7.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda_8.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda_9.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda_sem8.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda_sem9.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda_sem10.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda_sem11.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda_sem12.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda_sem13.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda_sem14.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda_sem15.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda_1.setRowspan(2);
                celda_2.setColspan(15);
                celda_11.setColspan(2);
                celda_2.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                table_act.addCell(celda_1);
                table_act.addCell(celda_2);
                table_act.addCell(celda_blank);
                table_act.addCell(celda_blank);
                table_act.addCell(celda_3);
                table_act.addCell(celda_4);
                table_act.addCell(celda_5);
                table_act.addCell(celda_6);
                table_act.addCell(celda_7);
                table_act.addCell(celda_8);
                table_act.addCell(celda_9);
                table_act.addCell(celda_sem8);
                table_act.addCell(celda_sem9);
                table_act.addCell(celda_sem10);
                table_act.addCell(celda_sem11);
                table_act.addCell(celda_sem12);
                table_act.addCell(celda_sem13);
                table_act.addCell(celda_sem14);
                table_act.addCell(celda_sem15);
                table_act.addCell(celda_10);
                table_act.addCell(celda_blank);

                List< Carta_Compromiso> carta_comp3_act = adm_ficha_est.obtiene_elemento3(opciones.getId_carta_compromiso(),"AC");
                int num_h_sem1=0;
                int num_h_sem2=0;
                int num_h_sem3=0;
                int num_h_sem4=0;
                int num_h_sem5=0;
                int num_h_sem6=0;
                int num_h_sem7=0;
                int num_h_sem8=0;
                int num_h_sem9=0;
                int num_h_sem10=0;
                int num_h_sem11=0;
                int num_h_sem12=0;
                int num_h_sem13=0;
                int num_h_sem14=0;
                int num_h_sem15=0;
                String valor_sem1="";
                String valor_sem2="";
                String valor_sem3="";
                String valor_sem4="";
                String valor_sem5="";
                String valor_sem6="";
                String valor_sem7="";
                String valor_sem8="";
                String valor_sem9="";
                String valor_sem10="";
                String valor_sem11="";
                String valor_sem12="";
                String valor_sem13="";
                String valor_sem14="";
                String valor_sem15="";
                
                int sum_act=0;
                int sum_tot=0;
                
                for (Iterator<Carta_Compromiso> it2 = carta_comp3_act.iterator(); it2.hasNext();) {
                    Carta_Compromiso elemento = it2.next();
                    Paragraph actividades = new Paragraph();
                    actividades.add(new Chunk(elemento.getActividad_1(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                    PdfPCell celda_13 = new PdfPCell(actividades);
                    valor_sem1="";
                    valor_sem2="";
                    valor_sem3="";
                    valor_sem4="";
                    valor_sem5="";
                    valor_sem6="";
                    valor_sem7="";
                    valor_sem8="";
                    valor_sem9="";
                    valor_sem10="";
                    valor_sem11="";
                    valor_sem12="";
                    valor_sem13="";
                    valor_sem14="";
                    valor_sem15="";
                    
                    num_h_sem1=Integer.parseInt(elemento.getProducto_1());
                    num_h_sem2=Integer.parseInt(elemento.getProducto_2());
                    num_h_sem3=Integer.parseInt(elemento.getProducto_3());
                    num_h_sem4=Integer.parseInt(elemento.getProducto_4());
                    num_h_sem5=Integer.parseInt(elemento.getProducto_5());
                    num_h_sem6=Integer.parseInt(elemento.getProducto_6());
                    num_h_sem7=Integer.parseInt(elemento.getActividad_3());
                    num_h_sem8=Integer.parseInt(elemento.getResultado_1());
                    num_h_sem9=Integer.parseInt(elemento.getResultado_2());
                    num_h_sem10=Integer.parseInt(elemento.getResultado_3());
                    num_h_sem11=Integer.parseInt(elemento.getResultado_4());
                    num_h_sem12=Integer.parseInt(elemento.getResultado_5());
                    num_h_sem13=Integer.parseInt(elemento.getResultado_6());
                    num_h_sem14=Integer.parseInt(elemento.getActividad_4());
                    num_h_sem15=Integer.parseInt(elemento.getActividad_5());
                    
                    sum_act=num_h_sem1+num_h_sem2+num_h_sem3+num_h_sem4+num_h_sem5+num_h_sem6+num_h_sem7+
                            num_h_sem8+num_h_sem9+num_h_sem10+num_h_sem11+num_h_sem12+num_h_sem13+num_h_sem14+num_h_sem15;
                    sum_tot= sum_tot +sum_act;
                    if(num_h_sem1 > 0){
                        valor_sem1="X";
                    }
                    if(num_h_sem2 > 0){
                        valor_sem2="X";
                    }
                    if(num_h_sem3 > 0){
                        valor_sem3="X";
                    }
                    if(num_h_sem4 > 0){
                        valor_sem4="X";
                    }
                    if(num_h_sem5 > 0){
                        valor_sem5="X";
                    }
                    if(num_h_sem6 > 0){
                        valor_sem6="X";
                    }
                    if(num_h_sem7 > 0){
                        valor_sem7="X";
                    }
                    if(num_h_sem8 > 0){
                        valor_sem8="X";
                    }
                    if(num_h_sem9 > 0){
                        valor_sem9="X";
                    }
                    if(num_h_sem10 > 0){
                        valor_sem10="X";
                    }
                    if(num_h_sem11 > 0){
                        valor_sem11="X";
                    }
                    if(num_h_sem12 > 0){
                        valor_sem12="X";
                    }
                    if(num_h_sem13 > 0){
                        valor_sem13="X";
                    }
                    if(num_h_sem14 > 0){
                        valor_sem14="X";
                    }
                    if(num_h_sem15 > 0){
                        valor_sem15="X";
                    }
                    
                    Paragraph sem_1 = new Paragraph();
                    sem_1.add(new Chunk(valor_sem1, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                    sem_1.setAlignment(Element.ALIGN_CENTER);
                    PdfPCell celda_14 = new PdfPCell(sem_1);
                    celda_14.setHorizontalAlignment(Element.ALIGN_CENTER);
                    Paragraph sem_2 = new Paragraph();
                    sem_2.add(new Chunk(valor_sem2, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                    sem_2.setAlignment(Element.ALIGN_CENTER);
                    PdfPCell celda_15 = new PdfPCell(sem_2);
                    Paragraph sem_3 = new Paragraph();
                    sem_3.add(new Chunk(valor_sem3, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                    sem_3.setAlignment(Element.ALIGN_CENTER);
                    PdfPCell celda_16 = new PdfPCell(sem_3);
                    Paragraph sem_4 = new Paragraph();
                    sem_4.add(new Chunk(valor_sem4, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                    sem_4.setAlignment(Element.ALIGN_CENTER);
                    PdfPCell celda_17 = new PdfPCell(sem_4);
                    Paragraph sem_5 = new Paragraph();
                    sem_5.add(new Chunk(valor_sem5, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                    sem_5.setAlignment(Element.ALIGN_CENTER);
                    PdfPCell celda_18 = new PdfPCell(sem_5);
                    Paragraph sem_6 = new Paragraph();
                    sem_6.add(new Chunk(valor_sem6, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                    sem_6.setAlignment(Element.ALIGN_CENTER);
                    PdfPCell celda_19 = new PdfPCell(sem_6);
                    Paragraph sem_7 = new Paragraph();
                    sem_7.add(new Chunk(valor_sem7, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                    sem_7.setAlignment(Element.ALIGN_CENTER);
                    PdfPCell celda_20 = new PdfPCell(sem_7);
                    Paragraph sem_8 = new Paragraph();
                    sem_8.add(new Chunk(valor_sem8, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                    sem_8.setAlignment(Element.ALIGN_CENTER);
                    PdfPCell celda_30 = new PdfPCell(sem_8);
                    Paragraph sem_9 = new Paragraph();
                    sem_9.add(new Chunk(valor_sem9, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                    sem_9.setAlignment(Element.ALIGN_CENTER);
                    PdfPCell celda_31 = new PdfPCell(sem_9);
                    Paragraph sem_10 = new Paragraph();
                    sem_10.add(new Chunk(valor_sem10, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                    sem_10.setAlignment(Element.ALIGN_CENTER);
                    PdfPCell celda_32 = new PdfPCell(sem_10);
                    Paragraph sem_11 = new Paragraph();
                    sem_11.add(new Chunk(valor_sem11, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                    sem_11.setAlignment(Element.ALIGN_CENTER);
                    PdfPCell celda_33 = new PdfPCell(sem_11);
                    Paragraph sem_12 = new Paragraph();
                    sem_12.add(new Chunk(valor_sem12, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                    sem_12.setAlignment(Element.ALIGN_CENTER);
                    PdfPCell celda_34 = new PdfPCell(sem_12);
                    Paragraph sem_13 = new Paragraph();
                    sem_13.add(new Chunk(valor_sem13, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                    sem_13.setAlignment(Element.ALIGN_CENTER);
                    PdfPCell celda_35 = new PdfPCell(sem_13);
                    Paragraph sem_14 = new Paragraph();
                    sem_14.add(new Chunk(valor_sem14, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                    sem_14.setAlignment(Element.ALIGN_CENTER);
                    PdfPCell celda_36 = new PdfPCell(sem_14);
                    Paragraph sem_15 = new Paragraph();
                    sem_15.add(new Chunk(valor_sem15, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                    sem_15.setAlignment(Element.ALIGN_CENTER);
                    PdfPCell celda_37 = new PdfPCell(sem_15);
                    
                    Paragraph tot_act = new Paragraph();
                    tot_act.add(new Chunk(sum_act+"", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                    PdfPCell celda_21 = new PdfPCell(tot_act);
                    
                    celda_14.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda_15.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda_16.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda_17.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda_18.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda_19.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda_20.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda_30.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda_31.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda_32.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda_33.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda_34.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda_35.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda_36.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda_37.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda_21.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda_12.setHorizontalAlignment(Element.ALIGN_CENTER);
                    
                    table_act.addCell(celda_13);
                    table_act.addCell(celda_14);
                    table_act.addCell(celda_15);
                    table_act.addCell(celda_16);
                    table_act.addCell(celda_17);
                    table_act.addCell(celda_18);
                    table_act.addCell(celda_19);
                    table_act.addCell(celda_20);
                    table_act.addCell(celda_30);
                    table_act.addCell(celda_31);
                    table_act.addCell(celda_32);
                    table_act.addCell(celda_33);
                    table_act.addCell(celda_34);
                    table_act.addCell(celda_35);
                    table_act.addCell(celda_36);
                    table_act.addCell(celda_37);
                    table_act.addCell(celda_21);
                    table_act.addCell(celda_12);
                }
                Paragraph tot_gnral = new Paragraph();
                tot_gnral.add(new Chunk(sum_tot+"", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                tot_gnral.setAlignment(Element.ALIGN_CENTER);
                PdfPCell celda_22 = new PdfPCell(tot_gnral);
                celda_22.setHorizontalAlignment(Element.ALIGN_CENTER);
                table_act.addCell(celda_blank);
                table_act.addCell(celda_blank);
                table_act.addCell(celda_blank);
                table_act.addCell(celda_blank);
                table_act.addCell(celda_blank);
                table_act.addCell(celda_blank);
                table_act.addCell(celda_blank);
                table_act.addCell(celda_blank);
                table_act.addCell(celda_blank);
                table_act.addCell(celda_blank);
                table_act.addCell(celda_blank);
                table_act.addCell(celda_blank);
                table_act.addCell(celda_blank);
                table_act.addCell(celda_blank);
                table_act.addCell(celda_11);
                table_act.addCell(celda_22);
                table_act.addCell(celda_12);
                
                table_act.setWidthPercentage(100);
                float[] medidaCeldas = {6.00f, 0.30f, 0.30f, 0.30f,0.30f, 0.30f, 0.30f,0.30f,0.30f,0.30f,0.30f,0.30f,0.30f,0.30f,0.30f,0.55f, 0.58f,0.30f};
                table_act.setWidths(medidaCeldas);// ASIGNO LAS MEDIDAS A LA TABLA (ANCHO)
                document.add(table_act);
                
                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD, Color.BLACK)));
                
                PdfPTable table_firmas = new PdfPTable(2);
                
                Paragraph comb21 = new Paragraph();
                comb21.add(new Chunk(opciones.getNomb_estudiante()+"\n"+"CÉDULA DE CIUDADANÍA: "+opciones.getCed_estudiante(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                
                Paragraph comb22 = new Paragraph();
                comb22.add(new Chunk(opciones.getNombre_delegado()+"\n", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                comb22.add(new Chunk("CARRERA DE "+opciones.getCarrera_grado(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                
                Paragraph comb23 = new Paragraph();
                comb23.add(new Chunk("__________________________________________", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                
                
                PdfPCell celda_firma_est = new PdfPCell(comb21);
                PdfPCell celda_firm_resp_ups = new PdfPCell(comb22);
                PdfPCell celda_firm_guion = new PdfPCell(comb23);
                celda_firma_est.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda_firm_resp_ups.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda_firm_guion.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                celda_firma_est.setBorder(0);
                celda_firm_resp_ups.setBorder(0);
                celda_firm_guion.setBorder(0);
                
                table_firmas.addCell(celda_firm_guion);
                table_firmas.addCell(celda_firm_guion);
                table_firmas.addCell(celda_firma_est);
                table_firmas.addCell(celda_firm_resp_ups);
                table_firmas.setWidthPercentage(100);
                document.add(table_firmas);

            }

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

    //reporte Peticion de Aprobacion
    public void dibujaPdfPeticionAprob(Document document, String ruta_imagen, float dimension[], List< Carta_Compromiso> carta_comp, String ruta, String institucion, String sede) {

        float[] widths = new float[dimension.length];

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta + "Peticion_Aprobacion.pdf"));
            document.open();

            String tipo_doc;
            for (Iterator<Carta_Compromiso> it = carta_comp.iterator(); it.hasNext();) {
                Carta_Compromiso opciones = it.next();
                SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy",new Locale("es_ES"));
                Date fecha_suscripcion = fmt.parse(opciones.getFecha_suscripcion());
                
                SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
                String fecha=formateador.format(fecha_suscripcion);
                String fecha_suscrip=fecha.replace(fecha.substring(2,fecha.length()-4).replace(" de ",""),initcap(fecha.substring(2,fecha.length()-4).replace(" de ","")));
                
                System.out.println("FECHA "+fecha_suscrip);
                Paragraph titulo = new Paragraph(initcap(opciones.getLugar_suscripcion()) + ", " + fecha_suscrip, FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                titulo.setAlignment(Element.ALIGN_RIGHT);
                document.add(titulo);
                if (opciones.getCed_estudiante().length() > 10) {
                    tipo_doc = "PASAPORTE";
                } else {
                    tipo_doc = "CÉDULA DE CIUDADANÍA";
                }

                document.add(new Paragraph("\n\n\n\n\n\n\n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));

                Paragraph dir_carrera = new Paragraph(opciones.getDir_carrera().toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                titulo.setAlignment(Element.ALIGN_LEFT);
                document.add(dir_carrera);

                Paragraph carg_dir_carrera = new Paragraph(opciones.getCargo_dir_carrera(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                carg_dir_carrera.setAlignment(Element.ALIGN_LEFT);
                document.add(carg_dir_carrera);

                Paragraph universidad = new Paragraph(institucion + ", " + "Sede " + sede, FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                universidad.setAlignment(Element.ALIGN_LEFT);
                document.add(universidad);

                document.add(new Paragraph("Presente.-", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(new Paragraph("\n\n\nDe mis consideraciones:", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));

                Paragraph comb = new Paragraph();
                comb.add(new Chunk("\n\n\nYo, " + opciones.getNomb_estudiante().toUpperCase() + " con " + tipo_doc
                        + " N° " + opciones.getCed_estudiante()
                        + " solicito a Ud. la AUTORIZACIÓN DEL INICIO DE LA ACTIVIDAD de " + opciones.getTipo_actividad()
                        + ", en la Empresa / Institución: " + opciones.getNomb_empresa().toUpperCase()
                        + ", desde " + opciones.getDia_inicio() + "-" + opciones.getMes_inicio() + "-" + opciones.getAnio_inicio()
                        + " hasta " + opciones.getDia_fin() + "-" + opciones.getMes_fin() + "-" + opciones.getAnio_fin() + ".", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                comb.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(comb);

                document.add(new Paragraph("\n\n\n\n\nAtentamente,\n\n\n\n\n\n\n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(new Paragraph("______________________________________", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(new Paragraph(opciones.getNomb_estudiante().toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(new Paragraph(tipo_doc + ": " + opciones.getCed_estudiante(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                
            }
            document.close();
        } catch (FileNotFoundException | DocumentException e) {
            Logger.getLogger(Genera_pdf.class.getName()).log(Level.SEVERE, null, e);
        } catch (ParseException ex) {
            Logger.getLogger(Genera_pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //reporte Oficio de Notificacion al Tutor
    public void dibujaPdfNotificacionTutor(Document document, String ruta_imagen, float dimension[], List< Carta_Compromiso> carta_comp, String ruta, String cod_cc,String institucion, String sede) {

        float[] widths = new float[dimension.length];

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta + "Oficio_notificacion_Tutor.pdf"));
            document.open();
            
            Image imagen = Image.getInstance(ruta_imagen + "/Logo_UPS.png");
            Image imagen2 = Image.getInstance(ruta_imagen + "/logo_vinculacion.png");

            imagen2.scalePercent(59f);
            imagen.scalePercent(5f);

            imagen2.setAbsolutePosition(380f, 763f);

            document.add(imagen);
            document.add(imagen2);
 
            String tipo_doc;
            for (Iterator<Carta_Compromiso> it = carta_comp.iterator(); it.hasNext();) {
                Carta_Compromiso opciones = it.next();
                if (opciones.getCed_estudiante().length() > 10) {
                    tipo_doc = "PASAPORTE";
                } else {
                    tipo_doc = "CÉDULA DE CIUDADANÍA";
                }
                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy",new Locale("es_ES"));
                Date fecha_suscripcion = fmt.parse(opciones.getFecha_suscripcion());
                
                SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
                String fecha=formateador.format(fecha_suscripcion);
                String fecha_suscrip=fecha.replace(fecha.substring(2,fecha.length()-4).replace(" de ",""),initcap(fecha.substring(2,fecha.length()-4).replace(" de ","")));
                //document.add(chunkSeparador);
                Paragraph titulo = new Paragraph(initcap(opciones.getLugar_suscripcion()) + ", " + fecha_suscrip, FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                titulo.setAlignment(Element.ALIGN_RIGHT);
                document.add(titulo);
                
                document.add(new Paragraph("\n\n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));

                document.add(new Paragraph("Señor (a) ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(new Paragraph(opciones.getNombre_tutor().toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                document.add(new Paragraph("Docente de la Carrera de "+opciones.getCarrera_grado(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                document.add(new Paragraph("Presente.-", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                
                document.add(new Paragraph("\n\nDe mis consideraciones: \n\n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                Paragraph paraf1 = new Paragraph("Por medio de la presente comunico a usted, "+
                        "que ha sido designado por parte de la Dirección de Carrera como TUTOR "+
                        "de las actividades de "+opciones.getTipo_actividad().toUpperCase()+" del estudiante "+opciones.getNomb_estudiante().toUpperCase()+" "+
                        "con "+tipo_doc+" Nº "+opciones.getCed_estudiante()+".", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                paraf1.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(paraf1);
                
                Paragraph paraf = new Paragraph("\nCabe destacar que su función es recibir el criterio "+
                            "del responsable de la institución durante el proceso en mención, "+
                            "y así proceder a acreditar las actividades realizadas por el estudiante en:\n\n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                paraf.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(paraf);
                
                document.add(new Paragraph("Nombre de Institución: "+opciones.getNomb_empresa().toUpperCase()+".", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(new Paragraph("Departamento o área: "+opciones.getArea_actividad()+".", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(new Paragraph("Responsable en la institución: "+opciones.getResponsable_area()+".", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(new Paragraph("Carta Compromiso: "+cod_cc+".", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(new Paragraph("Fecha de Inicio: "+opciones.getDia_inicio() + "-" + opciones.getMes_inicio() + "-" + opciones.getAnio_inicio()+".", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(new Paragraph("Fecha de Fin: "+opciones.getDia_fin() + "-" + opciones.getMes_fin() + "-" + opciones.getAnio_fin()+".", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                
                Paragraph paraf2 = new Paragraph("\nPara este efecto se adjunta la Ficha del Estudiante con "
                           + "toda la información relacionada a dicha actividad. "
                           + "Por lo expuesto anteriormente, reiteramos nuestro agradecimiento y "
                           + "le solicitamos brindar las facilidades necesarias para el "
                           + "cumplimiento de este objetivo.", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                paraf2.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(paraf2);
                                
                document.add(new Paragraph("\nAtentamente,\n\n\n\n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                

                Paragraph comb20 = new Paragraph();
                comb20.add(new Chunk("_____________________________", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                document.add(comb20);
                
                document.add(new Paragraph(opciones.getDir_tecnico(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                document.add(new Paragraph(opciones.getCargo_dir_tec(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                document.add(new Paragraph(institucion+", "+"Sede "+sede, FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                
            }	
            document.close();
        } catch (FileNotFoundException | DocumentException e) {

            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Genera_pdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Genera_pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //reporte Informe de Seguimiento
    public void dibujaPdfInformeSeguimiento(Document document, String ruta_imagen, float dimension[], List< Carta_Compromiso> carta_comp, String ruta, String cod_cc,String institucion, String sede) {

        float[] widths = new float[dimension.length];

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta + "Informe_Seguimiento.pdf"));
            document.open();
            
            Image imagen = Image.getInstance(ruta_imagen + "/Logo_UPS.png");
            Image imagen2 = Image.getInstance(ruta_imagen + "/logo_vinculacion.png");

            imagen2.scalePercent(59f);
            imagen.scalePercent(5f);

            imagen2.setAbsolutePosition(437f, 763f);

            document.add(imagen);
            document.add(imagen2);
            Paragraph titulo = new Paragraph(new Paragraph("INFORME DE SEGUIMIENTO", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, Color.BLACK)));
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            String tipo_doc;
            Paragraph enter = new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK));
            
            for (Iterator<Carta_Compromiso> it = carta_comp.iterator(); it.hasNext();) {
                Carta_Compromiso opciones = it.next();
                if (opciones.getCed_estudiante().length() > 10) {
                    tipo_doc = "PASAPORTE";
                } else {
                    tipo_doc = "CÉDULA DE CIUDADANÍA";
                }
                PdfPTable table = new PdfPTable(4);

                document.add(enter);

                PdfPCell cell=new PdfPCell(new Paragraph("CARTA COMPROMISO: \n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));

                PdfPCell cell1=new PdfPCell(new Paragraph(cod_cc, FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                PdfPCell cell2=new PdfPCell(new Paragraph("TIPO DE ACTIVIDAD: \n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                PdfPCell cell3=new PdfPCell(new Paragraph(opciones.getTipo_actividad(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));

                PdfPCell cell4=new PdfPCell(new Paragraph("ESTUDIANTE: \n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                PdfPCell cell5=new PdfPCell(new Paragraph(opciones.getNomb_estudiante(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                PdfPCell cell6=new PdfPCell(new Paragraph(tipo_doc+": \n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                PdfPCell cell7=new PdfPCell(new Paragraph(opciones.getCed_estudiante(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));

                PdfPCell cell8=new PdfPCell(new Paragraph("TUTOR UPS: \n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                PdfPCell cell9=new PdfPCell(new Paragraph(opciones.getNombre_tutor(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                PdfPCell cell10=new PdfPCell(new Paragraph("TUTOR DE LA INSTITUCIÓN: \n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                PdfPCell cell11=new PdfPCell(new Paragraph(opciones.getResponsable_area(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));

                PdfPCell cell12=new PdfPCell(new Paragraph("INSTITUCIÓN: \n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                PdfPCell cell13=new PdfPCell(new Paragraph(opciones.getNomb_empresa().toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                PdfPCell cell14=new PdfPCell(new Paragraph("RESPONSABLE INSTITUCIÓN: \n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                PdfPCell cell15=new PdfPCell(new Paragraph(opciones.getNombre_representante(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));

                cell.setBorder(0);   cell1.setBorder(0);        cell2.setBorder(0);        cell3.setBorder(0);
                cell4.setBorder(0);  cell5.setBorder(0);        cell6.setBorder(0);        cell7.setBorder(0);
                cell8.setBorder(0);  cell9.setBorder(0);        cell10.setBorder(0);       cell11.setBorder(0);
                cell12.setBorder(0); cell13.setBorder(0);       cell14.setBorder(0);       cell15.setBorder(0);

                table.addCell(cell);        table.addCell(cell1);
                table.addCell(cell2);       table.addCell(cell3);

                table.addCell(cell4);       table.addCell(cell5);
                table.addCell(cell6);       table.addCell(cell7);

                table.addCell(cell8);       table.addCell(cell9);
                table.addCell(cell10);      table.addCell(cell11);

                table.addCell(cell12);      table.addCell(cell13);
                table.addCell(cell14);      table.addCell(cell15);

                table.setWidthPercentage(100);

                document.add(table);
                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 5, Font.BOLD, Color.BLACK)));
                
                Administrar_Ficha_Estudiante adm_ficha_est = new Administrar_Ficha_Estudiante();
                List< Carta_Compromiso> carta_comp2 = adm_ficha_est.obtiene_elemento(cod_cc,"AC");
                PdfPTable table_act = new PdfPTable(5);
                Paragraph camp1=new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 5, Font.BOLD, Color.BLACK));
                Paragraph camp2=new Paragraph("HORAS \nASIGNADAS", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp3=new Paragraph("CRITERIOS DE DESEMPEÑO", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp4=new Paragraph("Técnico **", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp5=new Paragraph("Personal *", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp6=new Paragraph("Contextual *", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                camp1.add(new Paragraph("ACTIVIDADES", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                PdfPCell cell16=new PdfPCell(camp1);
                PdfPCell cell17=new PdfPCell(camp2);
                PdfPCell cell18=new PdfPCell(camp3);
                PdfPCell cell19=new PdfPCell(camp4);
                PdfPCell cell20=new PdfPCell(camp5);
                PdfPCell cell21=new PdfPCell(camp6);
                
                cell16.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell17.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell18.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell19.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell20.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                cell18.setColspan(3);
                cell16.setRowspan(2);
                cell17.setRowspan(2);
                //PdfPCell cell19=new PdfPCell(new Paragraph("CARTA COMPROMISO: \n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                //PdfPCell cell20=new PdfPCell(new Paragraph("CARTA COMPROMISO: \n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                table_act.addCell(cell16);
                table_act.addCell(cell17);
                table_act.addCell(cell18);
                table_act.addCell(cell19);
                table_act.addCell(cell20);
                table_act.addCell(cell21);
                PdfPCell cell25=new PdfPCell(),cell26=new PdfPCell();
                int total_parcial=0,contador=0;
                for (Iterator<Carta_Compromiso> it2 = carta_comp2.iterator(); it2.hasNext();) {
                    Carta_Compromiso elemento = it2.next();
                    contador=contador+1;
                    
                    total_parcial = total_parcial+Integer.parseInt(elemento.getActividad_2());
                    
                    PdfPCell cell22=new PdfPCell(new Paragraph(elemento.getActividad_1(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                    PdfPCell cell23=new PdfPCell(new Paragraph(elemento.getActividad_2()+" h", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                    PdfPCell cell24=new PdfPCell(new Paragraph("", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                    cell25=new PdfPCell(new Paragraph("", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                    cell26=new PdfPCell(new Paragraph("", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                    
                    cell23.setHorizontalAlignment(Element.ALIGN_CENTER);
                    
                    table_act.addCell(cell22);
                    table_act.addCell(cell23);
                    table_act.addCell(cell24);
                    if(contador == 1){
                        cell25.setRowspan(6);
                        cell26.setRowspan(6);
                        table_act.addCell(cell25);
                        table_act.addCell(cell26);
                    }
                    
                    
                    
                }
                table_act.setWidthPercentage(100);//Para que ocupe toda la hoja
                float[] medidaCeldas = {2.00f, 0.60f, 0.55f, 0.55f,0.58f};
                table_act.setWidths(medidaCeldas);// ASIGNO LAS MEDIDAS A LA TABLA (ANCHO)
                
                    
                document.add(table_act);
                
                Paragraph camp7 =new Paragraph("\nTOTAL HORAS : ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                camp7.add(new Chunk("   "+opciones.getTotal_horas()+" horas ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.UNDERLINE, Color.BLACK)));
                camp7.add(new Chunk("   TOTAL PARCIAL : ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                camp7.add(new Chunk("     "+total_parcial+" h     ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.UNDERLINE, Color.BLACK)));
                document.add(camp7);
                
                document.add(enter);
                
                Paragraph camp8 =new Paragraph();
                camp8.add(new Chunk("FECHA DE VISITA: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                camp8.add(new Chunk("                                                                        ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.UNDERLINE, Color.BLACK)));
                document.add(camp8);
                
                document.add(enter);document.add(enter);document.add(enter);document.add(enter);
                document.add(enter);document.add(enter);document.add(enter);
                
                Paragraph camp9 =new Paragraph();
                camp9.add(new Chunk("           __________________________________     ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                camp9.add(new Chunk("      ___________________________________     ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(camp9);
                
                Paragraph camp10 =new Paragraph();
                camp10.add(new Chunk("                          Firma del Tutor UPS          ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                camp10.add(new Chunk("                               Firma del Tutor Institución  ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                document.add(camp10);
                document.add(enter);document.add(enter);
                document.add(new Paragraph("** Calificar sobre 5 cada actividad. (5 - Muy Satisfactorio, 4 - Satisfactorio, 3 - Aceptable, 2 - Deficiente, 1 - Malo)", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(new Paragraph("* Calificar sobre 5 el criterio personal y contextual. (5 - Muy Satisfactorio, 4 - Satisfactorio, 3 - Aceptable, 2 - Deficiente, 1 - Malo)", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
            }
            document.close();
        } catch (FileNotFoundException | DocumentException e) {

            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Genera_pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //reporte Informe del Estudiante
    public void dibujaPdfInformeEstudiante(Document document, String ruta_imagen, float dimension[], List< Carta_Compromiso> carta_comp, String ruta, String cod_cc,String institucion, String sede) {

        float[] widths = new float[dimension.length];

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta + "Informe_Estudiante.pdf"));
            document.open();
            
            Image imagen = Image.getInstance(ruta_imagen + "/Logo_UPS.png");
            Image imagen2 = Image.getInstance(ruta_imagen + "/logo_vinculacion.png");

            imagen2.scalePercent(59f);
            imagen.scalePercent(5f);

            imagen2.setAbsolutePosition(437f, 763f);

            document.add(imagen);
            document.add(imagen2);
            Paragraph titulo = new Paragraph(new Paragraph("INFORME DEL ESTUDIANTE", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, Color.BLACK)));
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            String tipo_doc;
            Paragraph enter = new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK));
            
            for (Iterator<Carta_Compromiso> it = carta_comp.iterator(); it.hasNext();) {
                Carta_Compromiso opciones = it.next();
                if (opciones.getCed_estudiante().length() > 10) {
                    tipo_doc = "PASAPORTE";
                } else {
                    tipo_doc = "CÉDULA DE CIUDADANÍA";
                }
                PdfPTable table = new PdfPTable(4);

                document.add(enter);

                PdfPCell cell=new PdfPCell(new Paragraph("CARTA COMPROMISO: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                PdfPCell cell1=new PdfPCell(new Paragraph(cod_cc, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                Paragraph tipo_act=new Paragraph("TIPO DE ACTIVIDAD: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK));
                tipo_act.add(new Paragraph(opciones.getTipo_actividad(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                PdfPCell cell2=new PdfPCell(tipo_act);
                Paragraph inst=new Paragraph("INSTITUCIÓN: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK));
                inst.add(new Paragraph(opciones.getNomb_empresa(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                PdfPCell cell4=new PdfPCell(inst);
                Paragraph estudiante=new Paragraph("ESTUDIANTE: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK));
                estudiante.add(new Paragraph(opciones.getNomb_estudiante(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                PdfPCell cell6=new PdfPCell(estudiante);
                Paragraph cedula=new Paragraph(tipo_doc+": ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK));
                cedula.add(new Paragraph(opciones.getCed_estudiante(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));                
                PdfPCell cell8=new PdfPCell(cedula);
                
                
                cell.setBorder(0);   cell1.setBorder(0);        cell2.setBorder(0);
                cell4.setBorder(0);  cell6.setBorder(0);
                cell8.setBorder(0);       
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                cell6.setColspan(2);
                cell2.setColspan(2);
                cell8.setColspan(2);
                cell4.setColspan(4);
                table.addCell(cell);        table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell4);
                table.addCell(cell6);
                table.addCell(cell8);

                table.setWidthPercentage(100);

                document.add(table);
                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 5, Font.BOLD, Color.BLACK)));
                
                Administrar_Ficha_Estudiante adm_ficha_est = new Administrar_Ficha_Estudiante();
                List< Carta_Compromiso> carta_comp2 = adm_ficha_est.obtiene_elemento(cod_cc,"AC");
                PdfPTable table_act = new PdfPTable(4);
                Paragraph camp1=new Paragraph("ACTIVIDADES", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp2=new Paragraph("LOGROS *", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp3=new Paragraph("PRODUCTOS", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp4=new Paragraph("OBSERVACIONES", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));

                PdfPCell cell16=new PdfPCell(camp1);
                PdfPCell cell17=new PdfPCell(camp2);
                PdfPCell cell18=new PdfPCell(camp3);
                PdfPCell cell19=new PdfPCell(camp4);
                
                cell16.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell17.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell18.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell19.setHorizontalAlignment(Element.ALIGN_CENTER);

                //PdfPCell cell19=new PdfPCell(new Paragraph("CARTA COMPROMISO: \n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                //PdfPCell cell20=new PdfPCell(new Paragraph("CARTA COMPROMISO: \n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                table_act.addCell(cell16);
                table_act.addCell(cell17);
                table_act.addCell(cell18);
                table_act.addCell(cell19);
                int total_parcial=0,contador=0;
                for (Iterator<Carta_Compromiso> it2 = carta_comp2.iterator(); it2.hasNext();) {
                    Carta_Compromiso elemento = it2.next();
                    contador=contador+1;
                    
                    total_parcial = total_parcial+Integer.parseInt(elemento.getActividad_2());
                    
                    PdfPCell cell22=new PdfPCell(new Paragraph(elemento.getActividad_1(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                    PdfPCell cell24=new PdfPCell(new Paragraph("\n\n\n\n\n", FontFactory.getFont(FontFactory.HELVETICA, 9, Font.NORMAL, Color.BLACK)));
                    //cell24.setFixedHeight(16f);
                    cell22.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell22.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
                    table_act.addCell(cell22);
                    table_act.addCell(cell24);
                    table_act.addCell(cell24);
                    table_act.addCell(cell24);
                    
                    
                }
                table_act.setWidthPercentage(100);//Para que ocupe toda la hoja
                float[] medidaCeldas = {1.60f, 0.60f, 0.70f, 0.80f};
                table_act.setWidths(medidaCeldas);// ASIGNO LAS MEDIDAS A LA TABLA (ANCHO)
                document.add(table_act);
                
                Paragraph camp7 =new Paragraph("CONCLUSIONES", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                document.add(camp7);
                
                document.add(enter);
                
                Paragraph camp8 =new Paragraph();
                camp8.add(new Chunk("_____________________________________________________________________________________", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                camp8.add(new Chunk("_____________________________________________________________________________________", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                camp8.add(new Chunk("_____________________________________________________________________________________", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));                
                document.add(camp8);
                
                document.add(enter);
                Paragraph camp9 =new Paragraph("RECOMENDACIONES", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                document.add(camp9);
                document.add(enter);
                document.add(camp8);
                
                document.add(enter);document.add(enter);document.add(enter);document.add(enter);
                document.add(new Paragraph("________________________________", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(new Paragraph("Firma del Estudiante", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(enter);
                document.add(new Paragraph("Adjunto:    ANEXOS (si aplica)", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(enter);
                document.add(new Paragraph("* Logros con respecto a la actividad técnica y/o personal.", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
            }
            document.close();
        } catch (FileNotFoundException | DocumentException e) {

            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Genera_pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //reporte Autoevaluacion del Estudiante
    public void dibujaPdfAutoevalEstudiante(Document document, String ruta_imagen, float dimension[], List< Carta_Compromiso> carta_comp, String ruta, String cod_cc,String institucion, String sede) {

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta + "Autoevaluacion_Estudiante.pdf"));
            document.open();
            
            Image imagen = Image.getInstance(ruta_imagen + "/Logo_UPS.png");
            Image imagen2 = Image.getInstance(ruta_imagen + "/logo_vinculacion.png");

            imagen2.scalePercent(59f);
            imagen.scalePercent(5f);

            imagen2.setAbsolutePosition(437f, 763f);

            document.add(imagen);
            document.add(imagen2);
            Paragraph titulo = new Paragraph(new Paragraph("AUTOEVALUACIÓN DEL ESTUDIANTE", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, Color.BLACK)));
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            String tipo_doc;
            Paragraph enter = new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK));
            
            for (Iterator<Carta_Compromiso> it = carta_comp.iterator(); it.hasNext();) {
                Carta_Compromiso opciones = it.next();
                if (opciones.getCed_estudiante().length() > 10) {
                    tipo_doc = "PASAPORTE";
                } else {
                    tipo_doc = "CÉDULA DE CIUDADANÍA";
                }
                PdfPTable table = new PdfPTable(4);

                document.add(enter);

                PdfPCell cell=new PdfPCell(new Paragraph("CARTA COMPROMISO: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                PdfPCell cell1=new PdfPCell(new Paragraph(cod_cc, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                Paragraph tipo_act=new Paragraph("TIPO DE ACTIVIDAD: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK));
                tipo_act.add(new Paragraph(opciones.getTipo_actividad(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                PdfPCell cell2=new PdfPCell(tipo_act);
                Paragraph inst=new Paragraph("INSTITUCIÓN: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK));
                inst.add(new Paragraph(opciones.getNomb_empresa(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                PdfPCell cell4=new PdfPCell(inst);
                Paragraph estudiante=new Paragraph("ESTUDIANTE: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK));
                estudiante.add(new Paragraph(opciones.getNomb_estudiante(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                PdfPCell cell6=new PdfPCell(estudiante);
                Paragraph cedula=new Paragraph(tipo_doc+": ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK));
                cedula.add(new Paragraph(opciones.getCed_estudiante(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));                
                PdfPCell cell8=new PdfPCell(cedula);

                cell.setBorder(0);   cell1.setBorder(0);        cell2.setBorder(0);
                cell4.setBorder(0);  cell6.setBorder(0);
                cell8.setBorder(0);       
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                cell6.setColspan(2);
                cell2.setColspan(2);
                cell8.setColspan(2);
                cell4.setColspan(4);
                table.addCell(cell);        table.addCell(cell1);
                table.addCell(cell2);       table.addCell(cell4);
                table.addCell(cell6);       table.addCell(cell8);

                table.setWidthPercentage(100);

                document.add(table);
                document.add(new Paragraph("Auto-evalúe con honestidad su grado de participación "
                        + "durante el tiempo que efectúo  en la Institución la extensión universitaria, "
                        + "en función de las siguientes equivalencias:", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                document.add(enter);
                Paragraph calificacion1= new Paragraph("Muy Satisfactorio", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK));
                Paragraph calificacion1v= new Paragraph("5", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK));
                Paragraph calificacion2= new Paragraph("Satisfactorio", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK));
                Paragraph calificacion2v= new Paragraph("4", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK));
                Paragraph calificacion3= new Paragraph("Aceptable", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK));
                Paragraph calificacion3v= new Paragraph("3", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK));                
                Paragraph calificacion4= new Paragraph("Deficiente", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK));
                Paragraph calificacion4v= new Paragraph("2", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK));
                Paragraph calificacion5= new Paragraph("Malo", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK));
                Paragraph calificacion5v= new Paragraph("1", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK));
                
                PdfPTable calificaciones = new PdfPTable(3);
                PdfPCell cellCali1=new PdfPCell(calificacion1);
                PdfPCell cellCali2=new PdfPCell(calificacion1v);
                PdfPCell cellCali3=new PdfPCell(calificacion2);
                PdfPCell cellCali4=new PdfPCell(calificacion2v);
                PdfPCell cellCali5=new PdfPCell(calificacion3);
                PdfPCell cellCali6=new PdfPCell(calificacion3v);
                PdfPCell cellCali7=new PdfPCell(calificacion4);
                PdfPCell cellCali8=new PdfPCell(calificacion4v);
                PdfPCell cellCali9=new PdfPCell(calificacion5);
                PdfPCell cellCali10=new PdfPCell(calificacion5v);
                
                cellCali1.setBorder(0);
                cellCali2.setBorder(0);
                cellCali3.setBorder(0);
                cellCali4.setBorder(0);
                cellCali5.setBorder(0);
                cellCali6.setBorder(0);
                cellCali7.setBorder(0);
                cellCali8.setBorder(0);
                cellCali9.setBorder(0);
                cellCali10.setBorder(0);
                
                cellCali1.setColspan(2);
                cellCali3.setColspan(2);
                cellCali5.setColspan(2);
                cellCali7.setColspan(2);
                cellCali9.setColspan(2);
                
                cellCali1.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cellCali2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellCali3.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cellCali4.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellCali5.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cellCali6.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellCali7.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cellCali8.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellCali9.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cellCali10.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                calificaciones.addCell(cellCali1);
                calificaciones.addCell(cellCali2);
                calificaciones.addCell(cellCali3);
                calificaciones.addCell(cellCali4);
                calificaciones.addCell(cellCali5);
                calificaciones.addCell(cellCali6);
                calificaciones.addCell(cellCali7);
                calificaciones.addCell(cellCali8);
                calificaciones.addCell(cellCali9);
                calificaciones.addCell(cellCali10);
                float[] medidaCeldas1 = {7.00f, 0.50f, 1f};
                calificaciones.setWidths(medidaCeldas1);// ASIGNO LAS MEDIDAS A LA TABLA (ANCHO)
                calificaciones.setWidthPercentage(100);
                document.add(calificaciones);
                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 5, Font.BOLD, Color.BLACK)));
                
  
                PdfPTable table_act = new PdfPTable(6);
                Paragraph camp1=new Paragraph("ASPECTOS Y EVIDENCIAS", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp2=new Paragraph("ESCALA", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp3=new Paragraph("1", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp4=new Paragraph("2", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp5=new Paragraph("3", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp6=new Paragraph("4", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp7=new Paragraph("5", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp8=new Paragraph("a. Asistencia y puntualidad durante la extensión universitaria.", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                Paragraph camp9=new Paragraph("b. Responsabilidad, disposición y cumplimiento en la ejecución de tareas.", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                Paragraph camp10=new Paragraph("c. En las relaciones con el personal de la Institución ha predominado la cortesía, el buen trato y la amabilidad.", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                Paragraph camp11=new Paragraph("d. Utilización adecuada de procedimientos metodológicos. ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                Paragraph camp12=new Paragraph("e. Conocimientos teóricos y prácticos de la carrera.", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                Paragraph camp13=new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));

                PdfPCell cell16=new PdfPCell(camp1);
                PdfPCell cell17=new PdfPCell(camp2);
                PdfPCell cell18=new PdfPCell(camp3);
                PdfPCell cell19=new PdfPCell(camp4);
                PdfPCell cell110=new PdfPCell(camp5);
                PdfPCell cell111=new PdfPCell(camp6);
                PdfPCell cell12=new PdfPCell(camp7);
                PdfPCell cell_1=new PdfPCell(camp8);
                PdfPCell cell_2=new PdfPCell(camp9);
                PdfPCell cell_3=new PdfPCell(camp10);
                PdfPCell cell_4=new PdfPCell(camp11);
                PdfPCell cell_5=new PdfPCell(camp12);
                PdfPCell cell_blanco=new PdfPCell(camp13);
                
                cell16.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell17.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell18.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell19.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell110.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                cell16.setRowspan(2);
                cell17.setColspan(5);
                table_act.addCell(cell16);
                table_act.addCell(cell17);
                table_act.addCell(cell18);
                table_act.addCell(cell19);
                table_act.addCell(cell110);
                table_act.addCell(cell111);
                table_act.addCell(cell12);
                table_act.addCell(cell_1);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_2);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_3);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_4);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_5);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                
                table_act.setWidthPercentage(100);//Para que ocupe toda la hoja
                float[] medidaCeldas = {1.60f, 0.60f, 0.60f, 0.60f,0.60f,0.60f};
                table_act.setWidths(medidaCeldas);// ASIGNO LAS MEDIDAS A LA TABLA (ANCHO)
                document.add(table_act);

                document.add(enter);document.add(enter);document.add(enter);document.add(enter);document.add(enter);
                document.add(new Paragraph("________________________________", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(new Paragraph("Firma del Estudiante", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
            }
            document.close();
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Genera_pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //reporte Autoevaluacion del Estudiante
    public void dibujaPdfInformeTutor(Document document, String ruta_imagen, float dimension[], List< Carta_Compromiso> carta_comp, String ruta, String cod_cc,String institucion, String sede) {

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta + "Informe_Estudiante.pdf"));
            document.open();
            
            Image imagen = Image.getInstance(ruta_imagen + "/Logo_UPS.png");
            Image imagen2 = Image.getInstance(ruta_imagen + "/logo_vinculacion.png");

            imagen2.scalePercent(59f);
            imagen.scalePercent(5f);

            imagen2.setAbsolutePosition(437f, 763f);

            document.add(imagen);
            document.add(imagen2);
            Paragraph titulo = new Paragraph(new Paragraph("INFORME DEL TUTOR", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, Color.BLACK)));
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            String tipo_doc;
            Paragraph enter = new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK));
            
            for (Iterator<Carta_Compromiso> it = carta_comp.iterator(); it.hasNext();) {
                Carta_Compromiso opciones = it.next();
                if (opciones.getCed_estudiante().length() > 10) {
                    tipo_doc = "PASAPORTE";
                } else {
                    tipo_doc = "CÉDULA DE CIUDADANÍA";
                }
                PdfPTable table = new PdfPTable(4);

                document.add(enter);

                PdfPCell cell=new PdfPCell(new Paragraph("CARTA COMPROMISO: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                PdfPCell cell1=new PdfPCell(new Paragraph(cod_cc, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                Paragraph tipo_act=new Paragraph("TIPO DE ACTIVIDAD: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK));
                tipo_act.add(new Paragraph(opciones.getTipo_actividad(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                PdfPCell cell2=new PdfPCell(tipo_act);
                Paragraph tutor=new Paragraph("TUTOR: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK));
                tutor.add(new Paragraph(opciones.getNombre_tutor(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                PdfPCell cell4=new PdfPCell(tutor);
                Paragraph inst=new Paragraph("INSTITUCIÓN: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK));
                inst.add(new Paragraph(opciones.getNomb_empresa(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                PdfPCell cell5=new PdfPCell(inst);
                Paragraph estudiante=new Paragraph("ESTUDIANTE: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK));
                estudiante.add(new Paragraph(opciones.getNomb_estudiante(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                PdfPCell cell6=new PdfPCell(estudiante);
                Paragraph cedula=new Paragraph(tipo_doc+": ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK));
                cedula.add(new Paragraph(opciones.getCed_estudiante(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));                
                PdfPCell cell7=new PdfPCell(cedula);

                cell.setBorder(0);   cell1.setBorder(0);        cell2.setBorder(0);
                cell4.setBorder(0);  cell6.setBorder(0);        cell5.setBorder(0);   cell7.setBorder(0);
                
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                cell6.setColspan(2);
                cell2.setColspan(2);
                cell5.setColspan(2);
                cell4.setColspan(2);
                cell7.setColspan(2);
                table.addCell(cell);        
                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell4);
                table.addCell(cell5);
                table.addCell(cell6);
                table.addCell(cell7);

                table.setWidthPercentage(100);

                document.add(table);
                document.add(enter);
                
                Paragraph calificacion1= new Paragraph("Muy Satisfactorio", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK));
                Paragraph calificacion1v= new Paragraph("5", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK));
                Paragraph calificacion2= new Paragraph("Satisfactorio", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK));
                Paragraph calificacion2v= new Paragraph("4", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK));
                Paragraph calificacion3= new Paragraph("Aceptable", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK));
                Paragraph calificacion3v= new Paragraph("3", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK));                
                Paragraph calificacion4= new Paragraph("Deficiente", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK));
                Paragraph calificacion4v= new Paragraph("2", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK));
                Paragraph calificacion5= new Paragraph("Malo", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK));
                Paragraph calificacion5v= new Paragraph("1", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK));
                
                PdfPTable calificaciones = new PdfPTable(3);
                PdfPCell cellCali1=new PdfPCell(calificacion1);
                PdfPCell cellCali2=new PdfPCell(calificacion1v);
                PdfPCell cellCali3=new PdfPCell(calificacion2);
                PdfPCell cellCali4=new PdfPCell(calificacion2v);
                PdfPCell cellCali5=new PdfPCell(calificacion3);
                PdfPCell cellCali6=new PdfPCell(calificacion3v);
                PdfPCell cellCali7=new PdfPCell(calificacion4);
                PdfPCell cellCali8=new PdfPCell(calificacion4v);
                PdfPCell cellCali9=new PdfPCell(calificacion5);
                PdfPCell cellCali10=new PdfPCell(calificacion5v);
                
                cellCali1.setBorder(0);
                cellCali2.setBorder(0);
                cellCali3.setBorder(0);
                cellCali4.setBorder(0);
                cellCali5.setBorder(0);
                cellCali6.setBorder(0);
                cellCali7.setBorder(0);
                cellCali8.setBorder(0);
                cellCali9.setBorder(0);
                cellCali10.setBorder(0);
                
                cellCali1.setColspan(2);
                cellCali3.setColspan(2);
                cellCali5.setColspan(2);
                cellCali7.setColspan(2);
                cellCali9.setColspan(2);
                
                cellCali1.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cellCali2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellCali3.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cellCali4.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellCali5.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cellCali6.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellCali7.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cellCali8.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellCali9.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cellCali10.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                calificaciones.addCell(cellCali1);
                calificaciones.addCell(cellCali2);
                calificaciones.addCell(cellCali3);
                calificaciones.addCell(cellCali4);
                calificaciones.addCell(cellCali5);
                calificaciones.addCell(cellCali6);
                calificaciones.addCell(cellCali7);
                calificaciones.addCell(cellCali8);
                calificaciones.addCell(cellCali9);
                calificaciones.addCell(cellCali10);
                float[] medidaCeldas1 = {7.00f, 0.50f, 1f};
                calificaciones.setWidths(medidaCeldas1);// ASIGNO LAS MEDIDAS A LA TABLA (ANCHO)
                calificaciones.setWidthPercentage(100);
                document.add(calificaciones);
                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 5, Font.BOLD, Color.BLACK)));
                
  
                PdfPTable table_act = new PdfPTable(6);
                Paragraph camp1=new Paragraph("CUESTONARIO", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp2=new Paragraph("ESCALA", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp3=new Paragraph("1", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp4=new Paragraph("2", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp5=new Paragraph("3", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp6=new Paragraph("4", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp7=new Paragraph("5", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp8=new Paragraph("a. ¿Se cumplió con las actividades propuestas en la Carta Compromiso?", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                Paragraph camp9=new Paragraph("b. ¿Satisfacieron los resultados a la labor institucional?", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                Paragraph camp10=new Paragraph("c. ¿El estudiante tuvo la información necesaria del proceso de pasantías, prácticas pre profesionales ó extensiones?", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                Paragraph camp11=new Paragraph("d. La calidad de los productos ofrecidos fueron:", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                Paragraph camp12=new Paragraph("e. El comportamiento del estudiante en la institución externa fue:", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                Paragraph camp13=new Paragraph("f. La destreza desmostrada del estudiante en sus actividades fue:", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                Paragraph camp14=new Paragraph("g. El nivel de información proporcionada por la institución externa fue:", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                Paragraph camp15=new Paragraph("h. La relación del estudiante con el tutor de la institución externa fue:", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                Paragraph camp16=new Paragraph("i. La relación del estudiante con el tutor de la UPS fue:", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));                
                Paragraph camp17=new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                

                PdfPCell cell16=new PdfPCell(camp1);
                PdfPCell cell17=new PdfPCell(camp2);
                PdfPCell cell18=new PdfPCell(camp3);
                PdfPCell cell19=new PdfPCell(camp4);
                PdfPCell cell110=new PdfPCell(camp5);
                PdfPCell cell111=new PdfPCell(camp6);
                PdfPCell cell12=new PdfPCell(camp7);
                PdfPCell cell_1=new PdfPCell(camp8);
                PdfPCell cell_2=new PdfPCell(camp9);
                PdfPCell cell_3=new PdfPCell(camp10);
                PdfPCell cell_4=new PdfPCell(camp11);
                PdfPCell cell_5=new PdfPCell(camp12);
                PdfPCell cell_6=new PdfPCell(camp13);
                PdfPCell cell_7=new PdfPCell(camp14);
                PdfPCell cell_8=new PdfPCell(camp15);
                PdfPCell cell_9=new PdfPCell(camp16);
                PdfPCell cell_blanco=new PdfPCell(camp17);
                
                cell16.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell17.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell18.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell19.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell110.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                cell16.setRowspan(2);
                cell17.setColspan(5);
                table_act.addCell(cell16);
                table_act.addCell(cell17);
                table_act.addCell(cell18);
                table_act.addCell(cell19);
                table_act.addCell(cell110);
                table_act.addCell(cell111);
                table_act.addCell(cell12);
                table_act.addCell(cell_1);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_2);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_3);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_4);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_5);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_6);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_7);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_8);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_9);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                table_act.addCell(cell_blanco);
                
                table_act.setWidthPercentage(100);//Para que ocupe toda la hoja
                float[] medidaCeldas = {1.60f, 0.60f, 0.60f, 0.60f,0.60f,0.60f};
                table_act.setWidths(medidaCeldas);// ASIGNO LAS MEDIDAS A LA TABLA (ANCHO)
                document.add(table_act);
                document.add(enter);
                document.add(new Paragraph("En caso de tener observaciones, inquietudes y/o sugerencias, detallar a continuación:", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));                
                Paragraph lineas =new Paragraph();
                lineas.add(new Chunk("_____________________________________________________________________________________", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                lineas.add(new Chunk("_____________________________________________________________________________________", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                lineas.add(new Chunk("_____________________________________________________________________________________", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));                
                document.add(lineas);
                
                document.add(enter);document.add(enter);document.add(enter);document.add(enter);document.add(enter);
                document.add(new Paragraph("________________________________", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(new Paragraph("Firma Docente Tutor", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
            }
            document.close();
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Genera_pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //reporte Autoevaluacion del Estudiante
    public void dibujaPdfInformeFinal(Document document, String ruta_imagen, float dimension[], List< Carta_Compromiso> carta_comp, String ruta, String cod_cc,String institucion, String sede) {

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta + "Informe_Estudiante.pdf"));
            document.open();
            
            Image imagen = Image.getInstance(ruta_imagen + "/Logo_UPS.png");
            Image imagen2 = Image.getInstance(ruta_imagen + "/logo_vinculacion.png");

            imagen2.scalePercent(59f);
            imagen.scalePercent(5f);

            imagen2.setAbsolutePosition(437f, 763f);

            document.add(imagen);
            document.add(imagen2);
            Paragraph titulo = new Paragraph(new Paragraph("INFORME FINAL", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, Color.BLACK)));
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            String tipo_doc;
            Paragraph enter = new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK));
            
            for (Iterator<Carta_Compromiso> it = carta_comp.iterator(); it.hasNext();) {
                Carta_Compromiso opciones = it.next();
                if (opciones.getCed_estudiante().length() > 10) {
                    tipo_doc = "PASAPORTE";
                } else {
                    tipo_doc = "CÉDULA DE CIUDADANÍA";
                }
                PdfPTable table = new PdfPTable(4);

                document.add(enter);
                
                Paragraph inst=new Paragraph("INSTITUCIÓN: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK));
                inst.add(new Paragraph(opciones.getNomb_empresa(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.UNDERLINE, Color.BLACK)));
                Paragraph estudiante=new Paragraph("ESTUDIANTE: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK));
                estudiante.add(new Paragraph(opciones.getNomb_estudiante(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.UNDERLINE, Color.BLACK)));
                Paragraph cedula=new Paragraph(tipo_doc+": ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK));
                cedula.add(new Paragraph(opciones.getCed_estudiante(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.UNDERLINE, Color.BLACK)));
                Paragraph plazo=new Paragraph("PLAZO DEL INSTRUMENTO LEGAL: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK));
                Paragraph fecha_ini_efec=new Paragraph("Fecha de inicio efectivo: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK));
                Paragraph fecha_fin_efec=new Paragraph("Fecha de término efectivo: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK));
                
                Paragraph programa=new Paragraph("PROGRAMA O PROYECTO (si aplica): ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK));
                if (opciones.getNombre_proyecto().trim().length() < 2){
                    programa.add(new Paragraph("_____________________________________________________", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                }else{
                    programa.add(new Paragraph(opciones.getNombre_proyecto(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.UNDERLINE, Color.BLACK)));
                }

                PdfPCell cell=new PdfPCell(new Paragraph("CC / CO Código: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                PdfPCell cell1=new PdfPCell(new Paragraph(cod_cc, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.UNDERLINE, Color.BLACK)));
                PdfPCell cell2=new PdfPCell(inst);
                PdfPCell cell3=new PdfPCell(estudiante);
                PdfPCell cell4=new PdfPCell(cedula);
                PdfPCell cell5=new PdfPCell(programa);
               
                cell.setBorder(0);   cell1.setBorder(0);        cell2.setBorder(0);
                cell3.setBorder(0);  cell4.setBorder(0);        cell5.setBorder(0);
                
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                cell2.setColspan(2);
                cell3.setColspan(2);
                cell4.setColspan(2);
                cell5.setColspan(4);
                
                table.addCell(cell);        
                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                table.addCell(cell4);
                table.addCell(cell5);

                table.setWidthPercentage(100);
                document.add(table);
                
                PdfPTable table2 = new PdfPTable(7);
                PdfPCell cell6=new PdfPCell(plazo);
                PdfPCell cell7=new PdfPCell(new Paragraph("Desde "+opciones.getDia_inicio()+"-"+opciones.getMes_inicio()+"-"+opciones.getAnio_inicio()+
                                        " hasta "+opciones.getDia_fin()+"-"+opciones.getMes_fin()+"-"+opciones.getAnio_fin(), 
                                        FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                PdfPCell cell8=new PdfPCell(fecha_ini_efec);
                PdfPCell cell9=new PdfPCell(new Paragraph("                    ",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.UNDERLINE, Color.BLACK)));
                PdfPCell cell10=new PdfPCell(fecha_fin_efec);
                PdfPCell cell11=new PdfPCell(enter);
                PdfPCell cell_lin1=new PdfPCell(new Paragraph("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                PdfPCell cell_lin2=new PdfPCell(new Paragraph("",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                PdfPCell cell_lin3=new PdfPCell(new Paragraph("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));

                cell_lin1.setBorder(0);
                cell_lin2.setBorder(0);
                cell_lin3.setBorder(0);
                cell_lin1.setVerticalAlignment(Element.ALIGN_TOP);
                cell_lin3.setVerticalAlignment(Element.ALIGN_TOP);
                
                cell6.setBorder(0);
                cell7.setBorder(0);
                cell8.setBorder(0);
                cell9.setBorder(0);
                cell10.setBorder(0);
                cell11.setBorder(0);
                
                table2.addCell(cell6);
                table2.addCell(cell7);
                table2.addCell(cell11);
                table2.addCell(cell8);
                table2.addCell(cell9);
                table2.addCell(cell10);
                table2.addCell(cell9);
                table2.addCell(cell_lin2);
                table2.addCell(cell_lin1);
                table2.addCell(cell_lin2);
                table2.addCell(cell_lin2);
                table2.addCell(cell_lin3);
                table2.addCell(cell_lin2);
                table2.addCell(cell_lin3);
                
                float[] medidaCeldas3 = {1.20f, 0.90f, 0.3060f, 0.80f,0.60f,0.90f,0.60f};
                table2.setWidths(medidaCeldas3);// ASIGNO LAS MEDIDAS A LA TABLA (ANCHO)
                table2.setWidthPercentage(100);
                document.add(table2);
                //document.add(enter);
                PdfPTable table3 = new PdfPTable(7);
                PdfPCell presup_ref=new PdfPCell(new Paragraph("PRESUPUESTO REFERENCIAL (si aplica): ",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                PdfPCell presup_ejec_linea=new PdfPCell(new Paragraph("_________",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                PdfPCell presup_ejec=new PdfPCell(new Paragraph("PRESUPUESTO EJECUTADO (si aplica): ",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                PdfPCell porc_eje=new PdfPCell(new Paragraph("% de Ejecución: ",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                PdfPCell porc_eje_linea=new PdfPCell(new Paragraph("_________",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));

                presup_ref.setBorder(0);
                presup_ejec_linea.setBorder(0);
                presup_ejec.setBorder(0);
                porc_eje.setBorder(0);
                presup_ejec_linea.setBorder(0);
                porc_eje_linea.setBorder(0);
                presup_ejec.setColspan(2);
                
                presup_ref.setVerticalAlignment(Element.ALIGN_TOP);
                presup_ejec_linea.setVerticalAlignment(Element.ALIGN_MIDDLE);
                presup_ejec.setVerticalAlignment(Element.ALIGN_TOP);
                porc_eje.setVerticalAlignment(Element.ALIGN_TOP);
                porc_eje_linea.setVerticalAlignment(Element.ALIGN_MIDDLE);
                
                table3.addCell(presup_ref);
                table3.addCell(presup_ejec_linea);
                table3.addCell(presup_ejec);
                table3.addCell(porc_eje_linea);
                table3.addCell(porc_eje);
                table3.addCell(porc_eje_linea);
                float[] medidaCeldas4 = {1.50f, 0.70f, 1f, 0.50f,0.70f,0.90f,0.70f};
                table3.setWidths(medidaCeldas4);// ASIGNO LAS MEDIDAS A LA TABLA (ANCHO)
                table3.setWidthPercentage(100);
                document.add(table3);
                
                Paragraph emp1= new Paragraph("RESP.:", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK));
                Paragraph emp1v=new Paragraph(opciones.getNombre_delegado(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.UNDERLINE, Color.BLACK));
                Paragraph emp2= new Paragraph("CARRERA:", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK));
                emp2.add(new Paragraph(opciones.getCarrera_grado(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.UNDERLINE, Color.BLACK)));
                Paragraph emp3= new Paragraph("HOMÓLOGO INSTITUCIONAL:", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK));
                emp3.add(new Paragraph(opciones.getNombre_representante(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.UNDERLINE, Color.BLACK)));
                Paragraph emp6= new Paragraph("OBJETO DE LA CC / CO: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK));
                emp6.add(new Paragraph(opciones.getObjetivo_actividad(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.UNDERLINE, Color.BLACK)));
                
                PdfPTable dat_emp = new PdfPTable(7);
                PdfPCell cellemp1=new PdfPCell(emp1);
                PdfPCell cellemp2=new PdfPCell(emp1v);
                PdfPCell cellemp3=new PdfPCell(emp2);
                PdfPCell cellemp6=new PdfPCell(emp3);
                PdfPCell cellemp8=new PdfPCell(emp6);
                
                cellemp1.setBorder(0);
                cellemp2.setBorder(0);
                cellemp3.setBorder(0);
                
                cellemp6.setBorder(0);
                cellemp8.setBorder(0);
                
                cellemp8.setColspan(7);
                cellemp3.setColspan(3);
                cellemp6.setColspan(2);
                
                dat_emp.addCell(cellemp1);
                dat_emp.addCell(cellemp2);
                dat_emp.addCell(cellemp3);
                dat_emp.addCell(cellemp6);
                dat_emp.addCell(cellemp8);

                float[] medidaCeldas1 = {0.40f, 1f, 0.50f, 1f,0.70f,0.90f,1f};
                dat_emp.setWidths(medidaCeldas1);// ASIGNO LAS MEDIDAS A LA TABLA (ANCHO)
                dat_emp.setWidthPercentage(100);
                document.add(dat_emp);
                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 5, Font.BOLD, Color.BLACK)));
                
  
                PdfPTable table_act = new PdfPTable(4);
                Paragraph camp1=new Paragraph("PRODUCTOS GENERADOS", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp2=new Paragraph("CRITERIOS DE EVALUACIÓN", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp3=new Paragraph("Satisfacción *", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp4=new Paragraph("Utilidad *", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                Paragraph camp5=new Paragraph("Pertinencia *", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK));
                PdfPCell cell16=new PdfPCell(camp1);
                PdfPCell cell17=new PdfPCell(camp2);
                PdfPCell cell18=new PdfPCell(camp3);
                PdfPCell cell19=new PdfPCell(camp4);
                PdfPCell cell110=new PdfPCell(camp5);
                Paragraph camp6=new Paragraph("");
                
                PdfPCell cell_blanco=new PdfPCell(enter);
                
                cell16.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell17.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell18.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell19.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell110.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                cell16.setRowspan(2);
                cell17.setColspan(3);
                table_act.addCell(cell16);
                table_act.addCell(cell17);
                table_act.addCell(cell18);
                table_act.addCell(cell19);
                table_act.addCell(cell110);
                
                Administrar_Ficha_Estudiante adm_ficha_est = new Administrar_Ficha_Estudiante();
                List< Carta_Compromiso> carta_comp2 = adm_ficha_est.obtiene_elemento2(cod_cc,"RC");
                for (Iterator<Carta_Compromiso> it2 = carta_comp2.iterator(); it2.hasNext();) {
                    Carta_Compromiso elemento = it2.next();
                    camp6=new Paragraph(elemento.getActividad_1(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                    table_act.addCell(camp6);
                    table_act.addCell(cell_blanco);
                    table_act.addCell(cell_blanco);
                    table_act.addCell(cell_blanco);
                }

                table_act.setWidthPercentage(100);//Para que ocupe toda la hoja
                float[] medidaCeldas = {1.60f, 0.60f, 0.60f, 0.60f};
                table_act.setWidths(medidaCeldas);// ASIGNO LAS MEDIDAS A LA TABLA (ANCHO)
                document.add(table_act);
                            
                Paragraph prov =new Paragraph(new Paragraph("       PROVINCIA/CIUDAD/CANTÓN: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                prov.add(new Chunk("___________________", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                prov.add(new Chunk("      FECHA: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                prov.add(new Chunk("____________", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                prov.add(new Chunk("      LUGAR: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                prov.add(new Chunk("____________", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
                document.add(prov);
                Paragraph comparecientes =new Paragraph(new Paragraph("COMPARECIENTES: ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                document.add(enter);
                document.add(comparecientes);
                
                PdfPTable table_firma = new PdfPTable(3);
                PdfPCell tit_firma=new PdfPCell(new Paragraph(new Paragraph("REPRESENTANTE LEGAL ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK))));
                PdfPCell tit_firma2=new PdfPCell(new Paragraph(new Paragraph("\n\n\n\n\n\n\nfirma", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK))));
                PdfPCell tit_firma3=new PdfPCell(new Paragraph(new Paragraph("\n\n\n\n\n\n\nsello", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK))));
                tit_firma.setBorder(0);
                tit_firma.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table_firma.addCell(tit_firma);
                table_firma.addCell(tit_firma2);
                table_firma.addCell(tit_firma3);
                table_firma.setWidthPercentage(100);//Para que ocupe toda la hoja
                document.add(table_firma);
                
                document.add(enter);document.add(enter);document.add(enter);
                Paragraph nota =new Paragraph(new Paragraph("NOTA:   ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                nota.add(new Paragraph("CC - Carta Compromiso; CO - Convenio.", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(nota);
                document.add(new Paragraph("         * Calificar sobre 5 cada producto generado (5 - Muy Satisfactorio, 4 - Satisfactorio, 3 - Aceptable, \n         2 - Deficiente, 1 - Malo).", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK)));
            }
            document.close();
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Genera_pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //reporte Carta de Aceptacion
    public void dibujaPdfCartaAceptacion(Document document, String ruta_imagen, float dimension[], List< Carta_Compromiso> carta_comp, String ruta, String cod_cc,String institucion, String sede) {

        float[] widths = new float[dimension.length];

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta + "Carta_aceptacion.pdf"));
            document.open();
            
            Image imagen = Image.getInstance(ruta_imagen + "/Logo_UPS.png");
            Image imagen2 = Image.getInstance(ruta_imagen + "/logo_vinculacion.png");

            imagen2.scalePercent(59f);
            imagen.scalePercent(5f);

            imagen2.setAbsolutePosition(380f, 763f);

            //document.add(imagen);
            //document.add(imagen2);
 
            String tipo_doc;
            for (Iterator<Carta_Compromiso> it = carta_comp.iterator(); it.hasNext();) {
                Carta_Compromiso opciones = it.next();
                if (opciones.getCed_estudiante().length() > 10) {
                    tipo_doc = "PASAPORTE";
                } else {
                    tipo_doc = "CÉDULA DE CIUDADANÍA";
                }
                document.add(new Paragraph("\n\n\n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy",new Locale("es_ES"));
                Date fecha_suscripcion = fmt.parse(opciones.getFecha_suscripcion());
                
                SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
                String fecha=formateador.format(fecha_suscripcion);
                String fecha_suscrip=fecha.replace(fecha.substring(2,fecha.length()-4).replace(" de ",""),initcap(fecha.substring(2,fecha.length()-4).replace(" de ","")));
                //document.add(chunkSeparador);
                Paragraph titulo = new Paragraph(initcap(opciones.getLugar_suscripcion()) + ", " + fecha_suscrip, FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                titulo.setAlignment(Element.ALIGN_RIGHT);
                document.add(titulo);
                
                document.add(new Paragraph("\n\n\n\n\n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));

                document.add(new Paragraph(opciones.getDir_tecnico().toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                document.add(new Paragraph(opciones.getCargo_dir_tec(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                document.add(new Paragraph(institucion+", Sede "+sede, FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                document.add(new Paragraph("Presente.-", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                
                document.add(new Paragraph("\n\n\nDe mis consideraciones: \n\n\n\n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                Paragraph paraf1 = new Paragraph("Por medio de la presente comunico a usted, "+
                        "la aceptación del estudiante "+opciones.getNomb_estudiante().toUpperCase()+
                        " con "+tipo_doc+" Nº "+opciones.getCed_estudiante()+" para la ejecución de "+
                        opciones.getTipo_actividad().toUpperCase()+", del "+opciones.getDia_inicio()+"-"+
                        opciones.getMes_inicio()+"-"+opciones.getAnio_inicio()+" al "+
                        opciones.getDia_fin()+"-"+opciones.getMes_fin()+"-"+opciones.getAnio_fin()+".", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                paraf1.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(paraf1);
                
                document.add(new Paragraph("\n\n\n\n\n\nAtentamente,\n\n\n\n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                

                Paragraph comb20 = new Paragraph();
                comb20.add(new Chunk("_____________________________", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                //document.add(comb20);
                
                document.add(new Paragraph(opciones.getNombre_representante(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(new Paragraph(opciones.getCargo_representante(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                document.add(new Paragraph("       (Sello) ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                
            }	
            document.close();
        } catch (FileNotFoundException | DocumentException e) {

            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Genera_pdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Genera_pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //reporte Peticion Verbal
    public void dibujaPdfPeticionVerbal(Document document, String ruta_imagen, float dimension[], List< Carta_Compromiso> carta_comp, String ruta, String cod_cc,String institucion, String sede) {

        float[] widths = new float[dimension.length];

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta + "Peticion_Verbal.pdf"));
            document.open();
            
            Image imagen = Image.getInstance(ruta_imagen + "/Logo_UPS.png");
            Image imagen2 = Image.getInstance(ruta_imagen + "/logo_vinculacion.png");

            imagen2.scalePercent(59f);
            imagen.scalePercent(5f);

            imagen2.setAbsolutePosition(380f, 763f);

            document.add(imagen);
            document.add(imagen2);
 
            String tipo_doc;
            for (Iterator<Carta_Compromiso> it = carta_comp.iterator(); it.hasNext();) {
                Carta_Compromiso opciones = it.next();
                if (opciones.getCed_estudiante().length() > 10) {
                    tipo_doc = "PASAPORTE";
                } else {
                    tipo_doc = "CÉDULA DE CIUDADANÍA";
                }
                document.add(new Paragraph("\n\n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));

                PdfPTable table = new PdfPTable(1);
                PdfPCell cell=new PdfPCell(new Paragraph("INFORME DE PETICIÓN VERBAL", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, Color.BLACK)));
                //cell.setBorder(0);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                table.setWidthPercentage(100);
                document.add(table);
                
                document.add(new Paragraph("\n\n\n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy",new Locale("es_ES"));
                Date fecha_suscripcion = fmt.parse(opciones.getFecha_suscripcion());
                
                SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
                String fecha=formateador.format(fecha_suscripcion);
                String fecha_suscrip=fecha.replace(fecha.substring(2,fecha.length()-4).replace(" de ",""),initcap(fecha.substring(2,fecha.length()-4).replace(" de ","")));
                //document.add(chunkSeparador);
                Paragraph titulo = new Paragraph(initcap(opciones.getLugar_suscripcion()) + ", " + fecha_suscrip, FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                titulo.setAlignment(Element.ALIGN_RIGHT);
                document.add(titulo);
                
                document.add(new Paragraph("\n\n\n\n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));

                document.add(new Paragraph(opciones.getDir_tecnico().toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                document.add(new Paragraph(opciones.getCargo_dir_tec(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                document.add(new Paragraph(institucion+", Sede "+sede, FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                document.add(new Paragraph("Presente.-", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                
                document.add(new Paragraph("\n\n\nDe mis consideraciones: \n\n\n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                Paragraph paraf1 = new Paragraph("Por medio de la presente comunico a usted, "+
                        "que la Empresa o Institución: "+opciones.getNomb_empresa().toUpperCase()+
                        "; a través, de su "+opciones.getCargo_representante()+": "+opciones.getNombre_representante()+" hizo expreso su deseo en forma verbal de solicitar "+
                        "estudiantes para la actividad de "+opciones.getTipo_actividad().toUpperCase()+".", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK));
                paraf1.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(paraf1);
                
                document.add(new Paragraph("\n\n\nAtentamente,\n\n\n\n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                
                
                document.add(new Paragraph(opciones.getActividad_3(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, Color.BLACK)));
                document.add(new Paragraph("Responsable de Prácticas Pre \n"
                        + "profesionales, Pasantías y \nExtensiones de la carrera de \n"+
                             opciones.getCarrera_grado(), FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                
            }	
            document.close();
        } catch (FileNotFoundException | DocumentException e) {

            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Genera_pdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
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

    private String initcap(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1).toLowerCase();
    }
}
