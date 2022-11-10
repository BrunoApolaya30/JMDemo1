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

import com.jmingecor.jmingecor.model.entity.Equipo;
import com.jmingecor.jmingecor.model.service.ICategoriaService;
import com.jmingecor.jmingecor.model.service.IEquipoService;
import com.jmingecor.jmingecor.util.report.EquipoExporterEXCEL;
import com.jmingecor.jmingecor.util.report.EquipoExporterPDF;
import com.lowagie.text.DocumentException;

@Controller
@RequestMapping("/equipo")
public class EquipoController {
    @Autowired
    private IEquipoService equipoService;

    @Autowired
    private ICategoriaService categoriaService;


    @RequestMapping("/")
    public String index(@RequestParam Map<String, Object> params, Model model) {
        int page = params.get("page")  != null ? (Integer.valueOf(params.get("page").toString()) -1 ) : 0;
            int numPage = params.get("numPage")  != null ? (Integer.valueOf(params.get("numPage").toString())) : 5;

            // int numPage = Integer.valueOf(params.get("numPage").toString());

            PageRequest pageRequest = PageRequest.of(page,numPage);
            Page<Equipo> pageEquipo = equipoService.getAll(pageRequest);

            int totalPage = pageEquipo.getTotalPages();

            if(totalPage > 0){
                List<Integer> pages = IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
                model.addAttribute("pages",pages);
        }

        Equipo objEquipo = new Equipo();
        model.addAttribute("equipo", objEquipo);
        model.addAttribute("listaEquipos", equipoService.cargarEquipos());

        model.addAttribute("listaCategorias", categoriaService.cargarCategoria());

        model.addAttribute("mensaje","REGISTRAR Equipo");
        model.addAttribute("atxt", "a-active");
        model.addAttribute("list",pageEquipo.getContent());
        model.addAttribute("current",page+1);
        model.addAttribute("next", page+2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        model.addAttribute("numPage", numPage);

        return "equipo/main";
    }

    public String update(@PathVariable(value = "id") Long id, Model model) {
        Equipo objEquipo = equipoService.buscarEquipo(id);
        model.addAttribute("equipo", objEquipo);
        model.addAttribute("listaEquipos", equipoService.cargarEquipos());
        return "equipo/main";
    }
    @RequestMapping("/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id, Model model) {
        equipoService.eliminarEquipo(id);
        return "redirect:/equipo/";
    }
    
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String store(Equipo equipo, Model model) {
        equipoService.guardarEquipo(equipo);
        return "redirect:/equipo/";
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
         List<Equipo> equipos = equipoService.cargarEquipos();

         EquipoExporterPDF exporterPDF = new EquipoExporterPDF(equipos);

         exporterPDF.exportarPDF(response);

     }
    
    @RequestMapping("/exportarExcel")
    public void exportarExcel(HttpServletResponse response) throws DocumentException, IOException {
        //* Devuelve el tipo de contenido */
        response.setContentType("application/octet-stream");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());
        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Equipos_" + fechaActual + ".xlsx";

        response.setHeader(cabecera, valor);
        List<Equipo> equipos = equipoService.cargarEquipos();

        EquipoExporterEXCEL exporterEXCEL = new EquipoExporterEXCEL(equipos);

        exporterEXCEL.exportarExcel(response);

    }
}
