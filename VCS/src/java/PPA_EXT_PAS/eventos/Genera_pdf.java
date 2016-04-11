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

    //reporte Ficha del Estudiante
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
