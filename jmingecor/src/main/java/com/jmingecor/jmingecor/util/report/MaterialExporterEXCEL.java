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
import com.jmingecor.jmingecor.model.entity.Material;

public class MaterialExporterEXCEL {

    private XSSFWorkbook libro;
    private XSSFSheet hoja;

    private List<Material> listaMateriales;

    public MaterialExporterEXCEL(List<Material> listaMateriales) {
        this.listaMateriales = listaMateriales;
        libro = new XSSFWorkbook();
        hoja = libro.createSheet("Materiales");
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
        celda.setCellValue("Categoria");
        celda.setCellStyle(estilo);

         celda = fila.createCell(3);
        celda.setCellValue("Precio");
        celda.setCellStyle(estilo);

        celda = fila.createCell(4);
        celda.setCellValue("Lugar De Compra");
        celda.setCellStyle(estilo);

         celda = fila.createCell(5);
        celda.setCellValue("Precio de Obra");
        celda.setCellStyle(estilo);

        celda = fila.createCell(6);
        celda.setCellValue("IGV");
        celda.setCellStyle(estilo);

    }

    private void escribirDatosTabla() {
        int numeroFilas = 1;
        CellStyle estilo = libro.createCellStyle();
        XSSFFont fuente = libro.createFont();
        fuente.setFontHeight(14);
        estilo.setFont(fuente);

        for (Material material : listaMateriales) {
            Row fila = hoja.createRow(numeroFilas++);

            Cell celda = fila.createCell(0);
            celda.setCellValue(material.getId());
            hoja.autoSizeColumn(0);
            celda.setCellStyle(estilo);

            celda = fila.createCell(1);
            celda.setCellValue(material.getNombre());
            hoja.autoSizeColumn(1);
            celda.setCellStyle(estilo);

             celda = fila.createCell(2);
            celda.setCellValue(material.getCategoria().getNombre());
            hoja.autoSizeColumn(2);
            celda.setCellStyle(estilo);

            celda = fila.createCell(3);
            celda.setCellValue(material.getPrecio());
            hoja.autoSizeColumn(3);
            celda.setCellStyle(estilo);

             celda = fila.createCell(4);
            celda.setCellValue(material.getLugar_compra_material());
            hoja.autoSizeColumn(4);
            celda.setCellStyle(estilo);

            
             celda = fila.createCell(5);
            celda.setCellValue(material.getPrecio_obra_material());
            hoja.autoSizeColumn(5);
            celda.setCellStyle(estilo);

             celda = fila.createCell(6);
            celda.setCellValue(material.getIgv_material());
            hoja.autoSizeColumn(6);
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
