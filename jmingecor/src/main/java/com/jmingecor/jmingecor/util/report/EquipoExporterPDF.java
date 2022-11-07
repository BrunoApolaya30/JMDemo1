package com.jmingecor.jmingecor.util.report;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.jmingecor.jmingecor.model.entity.Equipo;

public class EquipoExporterPDF {
     private List<Equipo> listaequipos;

    public EquipoExporterPDF(List<Equipo> listaequipos) {
        this.listaequipos = listaequipos;
    }

    private void escribirCabeceraTabla(PdfPTable tabla) {

        PdfPCell celda = new PdfPCell();
        celda.setBackgroundColor(java.awt.Color.BLUE);
        celda.setPadding(5);
        Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
        fuente.setColor(java.awt.Color.white);

        celda.setPhrase(new Phrase("ID", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Nombre", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Descripción", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Categoria", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Fecha", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Cantidad", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Peso", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Peso Total", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Alquiler", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Observaciones", fuente));
        tabla.addCell(celda);
    }

    private void escribirDatosTabla(PdfPTable tabla) {
        for (Equipo equipo : listaequipos) {
            tabla.addCell(String.valueOf(equipo.getId()));
            tabla.addCell(equipo.getNombre());
            tabla.addCell(equipo.getDescripcion());
            tabla.addCell(equipo.getCategoria().getNombre());
            tabla.addCell(equipo.getFecha().toString());
            tabla.addCell(String.valueOf(equipo.getCantidad()));
            tabla.addCell(String.valueOf(equipo.getPeso()));
            tabla.addCell(String.valueOf(equipo.getPeso_total()));
            tabla.addCell(String.valueOf(equipo.getAlquiler()));
            tabla.addCell(equipo.getObservaciones());
        }
    }

    public void exportarPDF(HttpServletResponse response) throws DocumentException, IOException {
        Document documento = new Document(PageSize.A4);

        PdfWriter.getInstance(documento, response.getOutputStream());
        
        documento.open();

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fuente.setColor(java.awt.Color.BLUE);
        fuente.setSize(18);

        Paragraph titulo = new Paragraph("Lista de Equipos", fuente);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(titulo);
        
        PdfPTable tabla = new PdfPTable(10);
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(15);
        tabla.setWidths(new float[] { 1f, 2f, 2f,2f,2f,1f,1f,1f,1f,3f });
        

        tabla.setWidthPercentage(110);

        escribirCabeceraTabla(tabla);
        escribirDatosTabla(tabla);
        documento.add(tabla);
        documento.close();

    }

}
