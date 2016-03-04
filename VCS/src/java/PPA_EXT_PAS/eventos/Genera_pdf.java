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
import static com.lowagie.text.Chunk.NEWLINE;
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
import com.lowagie.text.pdf.draw.DrawInterface;
import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

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
            Chunk chunk = new Chunk(ruta);
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
                //document.add(new Paragraph("CARTA :"+opciones.getId_carta_compromiso()));
                //document.add(new Paragraph("CARTA COMPROMISO: "+opciones.getId_carta_compromiso(), FontFactory.getFont(FontFactory.HELVETICA, 8)));
                //document.add(new Paragraph(opciones.getId_carta_compromiso(), FontFactory.getFont(FontFactory.HELVETICA, 8)));
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
        } catch (IOException ex) {
            Logger.getLogger(Genera_pdf.class.getName()).log(Level.SEVERE, null, ex);
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
    
    //reporte Oficio de Seguimiento
    public void dibujaPdfInformeSeguimiento(Document document, String ruta_imagen, float dimension[], List< Carta_Compromiso> carta_comp, String ruta, String cod_cc,String institucion, String sede) {

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
            Paragraph titulo = new Paragraph(new Paragraph("INFORME DE SEGUIMIENTO", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, Color.BLACK)));
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            String tipo_doc;
            for (Iterator<Carta_Compromiso> it = carta_comp.iterator(); it.hasNext();) {
                Carta_Compromiso opciones = it.next();
                if (opciones.getCed_estudiante().length() > 10) {
                    tipo_doc = "PASAPORTE";
                } else {
                    tipo_doc = "CÉDULA DE CIUDADANÍA";
                }
                PdfPTable table = new PdfPTable(4);

                /*PdfPCell cell;
                cell = new PdfPCell(new Phrase("Cell with colspan 3"));
                cell.setColspan(3);
                table.addCell(cell);*/
                Paragraph enter = new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK));
                document.add(enter);

                PdfPCell cell=new PdfPCell(new Paragraph("CARTA COMPROMISO: \n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));

                //enter
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

                Administrar_Ficha_Estudiante adm_ficha_est = new Administrar_Ficha_Estudiante();
                List< Carta_Compromiso> carta_comp2 = adm_ficha_est.obtiene_elemento(cod_cc,"AC");
                PdfPTable table_act = new PdfPTable(5);
                PdfPCell cell16=new PdfPCell(new Paragraph("CARTA COMPROMISO: \n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                PdfPCell cell17=new PdfPCell(new Paragraph("CARTA COMPROMISO: \n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                PdfPCell cell18=new PdfPCell(new Paragraph("CARTA COMPROMISO: \n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                cell18.setColspan(3);
                //PdfPCell cell19=new PdfPCell(new Paragraph("CARTA COMPROMISO: \n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                //PdfPCell cell20=new PdfPCell(new Paragraph("CARTA COMPROMISO: \n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                table_act.addCell(cell16);
                table_act.addCell(cell17);
                table_act.addCell(cell18);
                document.add(table_act);
                
                for (Iterator<Carta_Compromiso> it2 = carta_comp2.iterator(); it2.hasNext();) {
                    Carta_Compromiso elemento = it.next();
                    System.out.println("elemnto "+elemento.getActividad_1());
                }
                
                document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, Color.BLACK)));
                SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy",new Locale("es_ES"));
                Date fecha_suscripcion = fmt.parse(opciones.getFecha_suscripcion());
                
                SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
                String fecha=formateador.format(fecha_suscripcion);
                String fecha_suscrip=fecha.replace(fecha.substring(2,fecha.length()-4).replace(" de ",""),initcap(fecha.substring(2,fecha.length()-4).replace(" de ","")));
                //document.add(chunkSeparador);
                
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