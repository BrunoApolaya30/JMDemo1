package com.jmingecor.jmingecor.util.report;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jmingecor.jmingecor.model.entity.Cliente;

import ch.qos.logback.core.net.server.Client;

public class ClientesExporterEXCEL {
    private XSSFWorkbook libro;
    private XSSFSheet hoja;

    private List<Cliente>  listaClientes;

    public ClientesExporterEXCEL(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
        libro = new XSSFWorkbook();
        hoja = libro.createSheet("Clientes");
    }

    private void escribirCabeceraTabla() {
        Row fila = hoja.createRow(0);

        CellStyle estilo = libro.createCellStyle();
        XSSFFont fuente = libro.createFont();
        fuente.setBold(true);
        fuente.setFontHeight(15);
        estilo.setFont(fuente);

        Cell celda = fila.createCell(0);
        celda.setCellValue("ID");
        celda.setCellStyle(estilo);

        celda = fila.createCell(1);
        celda.setCellValue("Documento-Ruc");
        celda.setCellStyle(estilo);

         celda = fila.createCell(2);
        celda.setCellValue("Nombre-R.Social");
        celda.setCellStyle(estilo);

        celda = fila.createCell(3);
        celda.setCellValue("Dirección");
        celda.setCellStyle(estilo);

         celda = fila.createCell(4);
        celda.setCellValue("Correo");
        celda.setCellStyle(estilo);

        celda = fila.createCell(5);
        celda.setCellValue("Telefono");
        celda.setCellStyle(estilo);

        celda = fila.createCell(6);
        celda.setCellValue("Estado");
        celda.setCellStyle(estilo);

        celda = fila.createCell(7);
        celda.setCellValue("Fecha");
        celda.setCellStyle(estilo);

    }

    private void escribirDatosTabla() {
        int numeroFilas = 1;
        CellStyle estilo = libro.createCellStyle();
        XSSFFont fuente = libro.createFont();
        fuente.setFontHeight(14);
        estilo.setFont(fuente);

        for (Cliente cliente : listaClientes) {
            Row fila = hoja.createRow(numeroFilas++);

            Cell celda = fila.createCell(0);
            celda.setCellValue(cliente.getId());
            hoja.autoSizeColumn(0);
            celda.setCellStyle(estilo);

            celda = fila.createCell(1);
            celda.setCellValue(cliente.getDocumento_ruc());
            hoja.autoSizeColumn(1);
            celda.setCellStyle(estilo);

             celda = fila.createCell(2);
            celda.setCellValue(cliente.getNombre_rz());
            hoja.autoSizeColumn(2);
            celda.setCellStyle(estilo);

            celda = fila.createCell(3);
            celda.setCellValue(cliente.getDireccion());
            hoja.autoSizeColumn(3);
            celda.setCellStyle(estilo);

             celda = fila.createCell(4);
            celda.setCellValue(cliente.getCorreo());
            hoja.autoSizeColumn(4);
            celda.setCellStyle(estilo);

            
             celda = fila.createCell(5);
            celda.setCellValue(cliente.getTelefono());
            hoja.autoSizeColumn(5);
            celda.setCellStyle(estilo);

            celda = fila.createCell(6);
            celda.setCellValue(cliente.getEstado());
            hoja.autoSizeColumn(6);
            celda.setCellStyle(estilo);

             celda = fila.createCell(7);
            celda.setCellValue(cliente.getFecha());
            hoja.autoSizeColumn(7);
            celda.setCellStyle(estilo);
        }
    }

    public void exportarExcel(HttpServletResponse response) throws IOException {

        escribirCabeceraTabla();
        escribirDatosTabla();

        ServletOutputStream outputStream = response.getOutputStream();

        libro.write(outputStream);

        libro.close();
        outputStream.close();

        
    }
    
}
