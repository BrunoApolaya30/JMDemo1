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
import com.jmingecor.jmingecor.model.entity.Cliente;


public class ClientesExporterPDF {
    
     private List<Cliente> listaClientes;

    public ClientesExporterPDF(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    private void escribirCabeceraTabla(PdfPTable tabla) {

        PdfPCell celda = new PdfPCell();
        celda.setBackgroundColor(java.awt.Color.BLUE);
        celda.setPadding(5);
        Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
        fuente.setColor(java.awt.Color.white);

        celda.setPhrase(new Phrase("ID", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Documento--RUC", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Nombre-R.Social", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Dirección", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Correo", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Telefono", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Estado", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Fecha", fuente));
        tabla.addCell(celda);
    }

    private void escribirDatosTabla(PdfPTable tabla) {
        for (Cliente cliente : listaClientes) {
            tabla.addCell(String.valueOf(cliente.getId()));
            tabla.addCell(cliente.getDocumento_ruc());
            tabla.addCell(cliente.getNombre_rz());
            tabla.addCell(cliente.getDireccion() );
            tabla.addCell(cliente.getCorreo());
            tabla.addCell(cliente.getTelefono());
            tabla.addCell(cliente.getEstado());
            tabla.addCell(String.valueOf(cliente.getFecha()));
        }
    }

    public void exportarPDF(HttpServletResponse response) throws DocumentException, IOException {
        Document documento = new Document(PageSize.A4);

        PdfWriter.getInstance(documento, response.getOutputStream());
        
        documento.open();

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fuente.setColor(java.awt.Color.BLUE);
        fuente.setSize(18);

        Paragraph titulo = new Paragraph("Lista de Clientes", fuente);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(titulo);
        
        PdfPTable tabla = new PdfPTable(8);
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(15);
        tabla.setWidths(new float[] { 1f, 2f, 2f,2f,2f,2f,2f,2f });
        

        tabla.setWidthPercentage(110);

        escribirCabeceraTabla(tabla);
        escribirDatosTabla(tabla);
        documento.add(tabla);
        documento.close();

    }

}
