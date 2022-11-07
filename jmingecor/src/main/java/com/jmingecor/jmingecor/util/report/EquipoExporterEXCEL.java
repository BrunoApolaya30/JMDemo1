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

import com.jmingecor.jmingecor.model.entity.Equipo;

public class EquipoExporterEXCEL {
     private XSSFWorkbook libro;
    private XSSFSheet hoja;

    private List<Equipo> listaequipos;

    public EquipoExporterEXCEL(List<Equipo> listaEquipos) {
        this.listaequipos = listaEquipos;
        libro = new XSSFWorkbook();
        hoja = libro.createSheet("Equipos");
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
        celda.setCellValue("Nombre");
        celda.setCellStyle(estilo);

        celda = fila.createCell(2);
        celda.setCellValue("Descripción");
        celda.setCellStyle(estilo);

         celda = fila.createCell(3);
        celda.setCellValue("Categoria");
        celda.setCellStyle(estilo);

        celda = fila.createCell(4);
        celda.setCellValue("Fecha");
        celda.setCellStyle(estilo);

         celda = fila.createCell(5);
        celda.setCellValue("Fecha");
        celda.setCellStyle(estilo);

        celda = fila.createCell(6);
        celda.setCellValue("Peso");
        celda.setCellStyle(estilo);

         celda = fila.createCell(7);
        celda.setCellValue("Peso Total");
        celda.setCellStyle(estilo);

        celda = fila.createCell(8);
        celda.setCellValue("Alquiler");
        celda.setCellStyle(estilo);

         celda = fila.createCell(9);
        celda.setCellValue("Observaciones");
        celda.setCellStyle(estilo);

    }

    private void escribirDatosTabla() {
        int numeroFilas = 1;
        CellStyle estilo = libro.createCellStyle();
        XSSFFont fuente = libro.createFont();
        fuente.setFontHeight(14);
        estilo.setFont(fuente);

        for (Equipo equipo : listaequipos) {
            Row fila = hoja.createRow(numeroFilas++);

            Cell celda = fila.createCell(0);
            celda.setCellValue(equipo.getId());
            hoja.autoSizeColumn(0);
            celda.setCellStyle(estilo);

            celda = fila.createCell(1);
            celda.setCellValue(equipo.getNombre());
            hoja.autoSizeColumn(1);
            celda.setCellStyle(estilo);

            celda = fila.createCell(2);
            celda.setCellValue(equipo.getDescripcion());
            hoja.autoSizeColumn(2);
            celda.setCellStyle(estilo);

             celda = fila.createCell(3);
            celda.setCellValue(equipo.getCategoria().getNombre());
            hoja.autoSizeColumn(3);
            celda.setCellStyle(estilo);

             celda = fila.createCell(4);
            celda.setCellValue(equipo.getFecha());
            hoja.autoSizeColumn(4);
            celda.setCellStyle(estilo);

             celda = fila.createCell(5);
            celda.setCellValue(equipo.getCantidad());
            hoja.autoSizeColumn(5);
            celda.setCellStyle(estilo);

             celda = fila.createCell(6);
            celda.setCellValue(equipo.getPeso());
            hoja.autoSizeColumn(6);
            celda.setCellStyle(estilo);

             celda = fila.createCell(7);
            celda.setCellValue(equipo.getPeso_total());
            hoja.autoSizeColumn(7);
            celda.setCellStyle(estilo);

             celda = fila.createCell(8);
            celda.setCellValue(equipo.getAlquiler());
            hoja.autoSizeColumn(8);
            celda.setCellStyle(estilo);

             celda = fila.createCell(9);
            celda.setCellValue(equipo.getObservaciones());
            hoja.autoSizeColumn(9);
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
