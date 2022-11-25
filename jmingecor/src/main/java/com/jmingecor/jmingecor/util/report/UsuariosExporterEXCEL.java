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

import com.jmingecor.jmingecor.model.entity.Usuario;

public class UsuariosExporterEXCEL {
    
    private XSSFWorkbook libro;
    private XSSFSheet hoja;

    private List<Usuario> listaUsuarios;

    public UsuariosExporterEXCEL(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
        libro = new XSSFWorkbook();
        hoja = libro.createSheet("Usuarios");
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
        celda.setCellValue("Dni");
        celda.setCellStyle(estilo);

        celda = fila.createCell(2);
        celda.setCellValue("Nombre");
        celda.setCellStyle(estilo);

        celda = fila.createCell(3);
        celda.setCellValue("Cargo");
        celda.setCellStyle(estilo);

         celda = fila.createCell(4);
        celda.setCellValue("Correo");
        celda.setCellStyle(estilo);

        celda = fila.createCell(5);
        celda.setCellValue("Estado");
        celda.setCellStyle(estilo);

         celda = fila.createCell(6);
        celda.setCellValue("Fecha");
        celda.setCellStyle(estilo);

    }

    private void escribirDatosTabla() {
        int numeroFilas = 1;
        CellStyle estilo = libro.createCellStyle();
        XSSFFont fuente = libro.createFont();
        fuente.setFontHeight(14);
        estilo.setFont(fuente);

        for (Usuario usuario : listaUsuarios) {
            Row fila = hoja.createRow(numeroFilas++);

            Cell celda = fila.createCell(0);
            celda.setCellValue(usuario.getId());
            hoja.autoSizeColumn(0);
            celda.setCellStyle(estilo);

            celda = fila.createCell(1);
            celda.setCellValue(usuario.getDocumento());
            hoja.autoSizeColumn(1);
            celda.setCellStyle(estilo);

            celda = fila.createCell(2);
            celda.setCellValue(usuario.getNombre_completo());
            hoja.autoSizeColumn(2);
            celda.setCellStyle(estilo);

             celda = fila.createCell(3);
            celda.setCellValue(usuario.getCargo().getTipo());
            hoja.autoSizeColumn(3);
            celda.setCellStyle(estilo);

            celda = fila.createCell(4);
            celda.setCellValue(usuario.getCorreo());
            hoja.autoSizeColumn(4);
            celda.setCellStyle(estilo);

             celda = fila.createCell(5);
            celda.setCellValue(usuario.getEstado());
            hoja.autoSizeColumn(5);
            celda.setCellStyle(estilo);

            
             celda = fila.createCell(6);
            celda.setCellValue(usuario.getFecha_registro());
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
