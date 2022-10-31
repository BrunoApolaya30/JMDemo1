package com.jmingecor.jmingecor.util.report;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.jmingecor.jmingecor.model.entity.Categoria;
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

public class CategoriaExporterPDF {
    
    private List<Categoria> listaCategorias;

    public CategoriaExporterPDF(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    private void escribirCabeceraTabla(PdfPTable tabla) {

        PdfPCell celda = new PdfPCell();
        celda.setBackgroundColor(Color.BLUE);
        celda.setPadding(5);
        Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
        fuente.setColor(Color.white);

        celda.setPhrase(new Phrase("ID", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Nombre", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Descripción", fuente));
        tabla.addCell(celda);

    }

    private void escribirDatosTabla(PdfPTable tabla) {
        for (Categoria categoria : listaCategorias) {
            tabla.addCell(String.valueOf(categoria.getId()));
            tabla.addCell(categoria.getNombre());
            tabla.addCell(categoria.getDescripcion());
        }
    }

    public void exportarPDF(HttpServletResponse response) throws DocumentException, IOException {
        Document documento = new Document(PageSize.A4);

        PdfWriter.getInstance(documento, response.getOutputStream());
        
        documento.open();

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fuente.setColor(Color.BLUE);
        fuente.setSize(18);

        Paragraph titulo = new Paragraph("Lista de Categorias", fuente);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(titulo);
        
        PdfPTable tabla = new PdfPTable(3);
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(15);
        tabla.setWidths(new float[] { 1f, 3f, 4f });
        

        tabla.setWidthPercentage(110);

        escribirCabeceraTabla(tabla);
        escribirDatosTabla(tabla);
        documento.add(tabla);
        documento.close();

    }

}
