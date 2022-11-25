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

import com.jmingecor.jmingecor.model.entity.ContactoCampo;

public class ContactoCampoExporterEXCEL {
    
    private XSSFWorkbook libro;
    private XSSFSheet hoja;

    private List<ContactoCampo> listaContactoCampo;

    public ContactoCampoExporterEXCEL(List<ContactoCampo> listaContactoCampo) {
        this.listaContactoCampo = listaContactoCampo;
        libro = new XSSFWorkbook();
        hoja = libro.createSheet("Contacto en Campo");
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
        celda.setCellValue("Empresa");
        celda.setCellStyle(estilo);

        celda = fila.createCell(2);
        celda.setCellValue("Cargo");
        celda.setCellStyle(estilo);

         celda = fila.createCell(3);
        celda.setCellValue("Telefono");
        celda.setCellStyle(estilo);

        celda = fila.createCell(4);
        celda.setCellValue("Correo");
        celda.setCellStyle(estilo);

    }

    private void escribirDatosTabla() {
        int numeroFilas = 1;
        CellStyle estilo = libro.createCellStyle();
        XSSFFont fuente = libro.createFont();
        fuente.setFontHeight(14);
        estilo.setFont(fuente);

        for (ContactoCampo contactoCampo : listaContactoCampo) {
            Row fila = hoja.createRow(numeroFilas++);

            Cell celda = fila.createCell(0);
            celda.setCellValue(contactoCampo.getId());
            hoja.autoSizeColumn(0);
            celda.setCellStyle(estilo);

            celda = fila.createCell(1);
            celda.setCellValue(contactoCampo.getEmpresa());
            hoja.autoSizeColumn(1);
            celda.setCellStyle(estilo);

             celda = fila.createCell(2);
            celda.setCellValue(contactoCampo.getCargo_empresa());
            hoja.autoSizeColumn(2);
            celda.setCellStyle(estilo);

            celda = fila.createCell(3);
            celda.setCellValue(contactoCampo.getTelefono());
            hoja.autoSizeColumn(3);
            celda.setCellStyle(estilo);

             celda = fila.createCell(4);
            celda.setCellValue(contactoCampo.getCorreo());
            hoja.autoSizeColumn(4);
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
