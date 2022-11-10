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
import com.jmingecor.jmingecor.model.entity.Material;


public class MaterialExporterPDF {
    
    private List<Material> listaMateriales;

    public MaterialExporterPDF(List<Material> listaMateriales) {
        this.listaMateriales = listaMateriales;
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

        celda.setPhrase(new Phrase("Categoria", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Precio", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Lugar De Compra", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Precio De Obra", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("IGV", fuente));
        tabla.addCell(celda);
    }

    private void escribirDatosTabla(PdfPTable tabla) {
        for (Material material : listaMateriales) {
            tabla.addCell(String.valueOf(material.getId()));
            tabla.addCell(material.getNombre());
            tabla.addCell(material.getCategoria().getNombre());
            tabla.addCell(String.valueOf(material.getPrecio()));
            tabla.addCell(material.getLugar_compra_material());
            tabla.addCell(String.valueOf(material.getIgv_material()));
            tabla.addCell(String.valueOf(material.getPrecio_obra_material()));
        }
    }

    public void exportarPDF(HttpServletResponse response) throws DocumentException, IOException {
        Document documento = new Document(PageSize.A4);

        PdfWriter.getInstance(documento, response.getOutputStream());
        
        documento.open();

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fuente.setColor(java.awt.Color.BLUE);
        fuente.setSize(18);

        Paragraph titulo = new Paragraph("Lista de Materiales", fuente);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(titulo);
        
        PdfPTable tabla = new PdfPTable(7);
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(15);
        tabla.setWidths(new float[] { 1f, 2f, 2f,2f,2f,2f,2f });
        

        tabla.setWidthPercentage(110);

        escribirCabeceraTabla(tabla);
        escribirDatosTabla(tabla);
        documento.add(tabla);
        documento.close();

    }

}
