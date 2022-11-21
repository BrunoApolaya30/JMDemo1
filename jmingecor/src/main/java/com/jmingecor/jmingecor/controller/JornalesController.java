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

import com.jmingecor.jmingecor.model.entity.Jornales;
import com.jmingecor.jmingecor.model.service.ICategoriaService;
import com.jmingecor.jmingecor.model.service.IJornalesService;
import com.jmingecor.jmingecor.util.report.JornalesExporterEXCEL;
import com.jmingecor.jmingecor.util.report.JornalesExporterPDF;
import com.lowagie.text.DocumentException;

@Controller
@RequestMapping("/jornales")
public class JornalesController {
    @Autowired
    private IJornalesService jornalesService;

    @Autowired
    private ICategoriaService categoriaService;

    @RequestMapping("/")
    public String index(@RequestParam Map<String, Object> params, Model model) {
        int page = params.get("page")  != null ? (Integer.valueOf(params.get("page").toString()) -1 ) : 0;
        int numPage = params.get("numPage") != null ? (Integer.valueOf(params.get("numPage").toString())) : 5;

        PageRequest pageRequest = PageRequest.of(page,numPage);
        Page<Jornales> pageJornales = jornalesService.getAll(pageRequest);

        int totalPage = pageJornales.getTotalPages();

        if(totalPage > 0){
                List<Integer> pages = IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
                model.addAttribute("pages",pages);
        }

        Jornales objJornales = new Jornales();
        model.addAttribute("jornales", objJornales);
        model.addAttribute("listaJornales", jornalesService.cargarJornales());

        model.addAttribute("listaCategorias", categoriaService.cargarCategoria());

        model.addAttribute("mensaje","REGISTRAR Equipo");
        model.addAttribute("atxt", "a-active");
        model.addAttribute("list",pageJornales.getContent());
        model.addAttribute("current",page+1);
        model.addAttribute("next", page+2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        model.addAttribute("numPage", numPage);


        return "jornales/main";
    }

    public String update(@PathVariable(value = "id") Long id, Model model) {
        Jornales objJornales = jornalesService.buscarJornales(id);
        model.addAttribute("jornales", objJornales);
        model.addAttribute("listaJornales", jornalesService.cargarJornales());
        return "jornales/main";
    }

     @RequestMapping("/eliminar/{id}")
     public String delete(@PathVariable(value = "id") Long id, Model model) {
         jornalesService.eliminarJornales(id);
         return "redirect:/jornales/";
     }
    
     @RequestMapping(value = "/form", method = RequestMethod.POST)
     public String store(Jornales jornales, Model model) {
         jornalesService.guardarJornales(jornales);
         return "redirect:/jornales/";
     }
    
      @RequestMapping("/exportarPdf")
     public void exportarPDF(HttpServletResponse response) throws DocumentException, IOException {
         //* Devuelve el tipo de contenido */
         response.setContentType("application/pdf");

         DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
         String fechaActual = dateFormatter.format(new Date());
         String cabecera = "Content-Disposition";
         String valor = "attachment; filename=Equipos_" + fechaActual + ".pdf";

         response.setHeader(cabecera, valor);
         List<Jornales> jornales = jornalesService.cargarJornales();

         JornalesExporterPDF exporterPDF = new JornalesExporterPDF(jornales);

         exporterPDF.exportarPDF(response);

     }
    
    @RequestMapping("/exportarExcel")
    public void exportarExcel(HttpServletResponse response) throws DocumentException, IOException {
        //* Devuelve el tipo de contenido */
        response.setContentType("application/octet-stream");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());
        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Jornales_" + fechaActual + ".xlsx";

        response.setHeader(cabecera, valor);
        List<Jornales> jornales = jornalesService.cargarJornales();

        JornalesExporterEXCEL exporterEXCEL = new JornalesExporterEXCEL(jornales);

        exporterEXCEL.exportarExcel(response);

    }

}
