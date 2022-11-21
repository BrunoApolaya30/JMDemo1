package com.jmingecor.jmingecor.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmingecor.jmingecor.model.entity.Almacen;
import com.jmingecor.jmingecor.model.service.IAlmacenService;
import com.jmingecor.jmingecor.util.report.AlmacenExporterEXCEL;
import com.jmingecor.jmingecor.util.report.AlmacenExporterPDF;
import com.lowagie.text.DocumentException;

@Controller
@RequestMapping("/almacen")
public class AlmacenController {
    
    @Autowired
    private IAlmacenService almacenService;

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, Object> params) {

        int page = params.get("page")  != null ? (Integer.valueOf(params.get("page").toString()) -1 ) : 0;
        int numPage = params.get("numPage") != null ? (Integer.valueOf(params.get("numPage").toString())) : 5;
            
        PageRequest pageRequest = PageRequest.of(page,numPage);
        Page<Almacen> pageAlmacen = almacenService.getAll(pageRequest);

        int totalPage = pageAlmacen.getTotalPages();
        
        if (totalPage > 0) {
            List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages", pages);
        }

        Almacen objAlmacen = new Almacen();
        model.addAttribute("almacen", objAlmacen);
        model.addAttribute("listaAlmacenes", almacenService.cargarAlmacenes());
        model.addAttribute("list", pageAlmacen.getContent());
        model.addAttribute("current",page+1);
        model.addAttribute("next", page+2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        model.addAttribute("numPage", numPage);

        return "almacen/main";
    }

    public String update(@PathVariable(value = "id") Long id, Model model) {
        Almacen objAlmacen = almacenService.buscarAlmacen(id);
        model.addAttribute("almacen", objAlmacen);
        model.addAttribute("listaAlmacenes", almacenService.cargarAlmacenes());
        return "almacen/main";
    }

    @RequestMapping("/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id, Model model) {
        almacenService.eliminarAlmacen(id);
        return "redirect:/almacen/";
    }

    @RequestMapping(value="/form", method = RequestMethod.POST)
    public String store(Almacen almacen, Model model) {
        almacenService.guardarAlmacen(almacen);
        return "redirect:/almacen/";
    }

    @RequestMapping("/exportarPdf")
    public void exportarPDF(HttpServletResponse response) throws DocumentException, IOException {
        //* Devuelve el tipo de contenido */
        response.setContentType("application/pdf");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());
        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Almacenes_" + fechaActual + ".pdf";

        response.setHeader(cabecera, valor);
        List<Almacen> almacenes = almacenService.cargarAlmacenes();

        AlmacenExporterPDF exporterPDF = new AlmacenExporterPDF(almacenes);

        exporterPDF.exportarPDF(response);

    }

    @RequestMapping("/exportarExcel")
    public void exportarExcel(HttpServletResponse response) throws DocumentException, IOException {
        //* Devuelve el tipo de contenido */
        response.setContentType("application/octet-stream");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());
        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Almacenes_" + fechaActual + ".xlsx";

        response.setHeader(cabecera, valor);
        List<Almacen> almacenes = almacenService.cargarAlmacenes();

        AlmacenExporterEXCEL exporterPDF = new AlmacenExporterEXCEL(almacenes);

        exporterPDF.exportarExcel(response);

    }
}
