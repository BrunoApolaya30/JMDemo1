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

import com.jmingecor.jmingecor.model.entity.Almacen;


public class AlmacenExporterEXCEL {
     private XSSFWorkbook libro;
    private XSSFSheet hoja;

    private List<Almacen> listaAlmacenes;

    public AlmacenExporterEXCEL(List<Almacen> listaAlmacenes) {
        this.listaAlmacenes = listaAlmacenes;
        libro = new XSSFWorkbook();
        hoja = libro.createSheet("Almacenes");
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
        celda.setCellValue("Ubicación");
        celda.setCellStyle(estilo);

        celda = fila.createCell(2);
        celda.setCellValue("Descripción");
        celda.setCellStyle(estilo);

    }

    private void escribirDatosTabla() {
        int numeroFilas = 1;
        CellStyle estilo = libro.createCellStyle();
        XSSFFont fuente = libro.createFont();
        fuente.setFontHeight(14);
        estilo.setFont(fuente);

        for (Almacen almacen : listaAlmacenes) {
            Row fila = hoja.createRow(numeroFilas++);

            Cell celda = fila.createCell(0);
            celda.setCellValue(almacen.getId());
            hoja.autoSizeColumn(0);
            celda.setCellStyle(estilo);

            celda = fila.createCell(1);
            celda.setCellValue(almacen.getUbicacion());
            hoja.autoSizeColumn(1);
            celda.setCellStyle(estilo);

            celda = fila.createCell(2);
            celda.setCellValue(almacen.getDescripcion());
            hoja.autoSizeColumn(2);
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
