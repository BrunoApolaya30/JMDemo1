package com.jmingecor.jmingecor.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmingecor.jmingecor.model.entity.SolicitudRequerimiento;
import com.jmingecor.jmingecor.model.service.ISolicitudRequerimientoService;

@Controller
@RequestMapping("/solicitudRequerimiento")
public class SolicitudRequerimientoController {
    
    @Autowired
    private ISolicitudRequerimientoService solicitudRequerimientoService;

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, Object> params) {
        
        int page = params.get("page")  != null ? (Integer.valueOf(params.get("page").toString()) -1 ) : 0;
        int numPage = params.get("numPage") != null ? (Integer.valueOf(params.get("numPage").toString())) : 5;
            
        PageRequest pageRequest = PageRequest.of(page,numPage);
        Page<SolicitudRequerimiento> pageSolicitudRequerimiento = solicitudRequerimientoService.getAll(pageRequest);

        int totalPage = pageSolicitudRequerimiento.getTotalPages();

        if (totalPage > 0) {
            List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages", pages);
        }

        SolicitudRequerimiento objSolicitudRequerimiento = new SolicitudRequerimiento();
        model.addAttribute("solicitudRequerimiento", objSolicitudRequerimiento);
        model.addAttribute("listaSolicitudRequerimiento", solicitudRequerimientoService.cargarSolicitudRequerimiento());
        model.addAttribute("list", pageSolicitudRequerimiento.getContent());
        model.addAttribute("current",page+1);
        model.addAttribute("next", page+2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        model.addAttribute("numPage", numPage);

        return "solicitudRequerimiento/main";

    }

    @RequestMapping("/editar/{id_solicitudr}")
    public String update(@PathVariable(value = "id_solicitudr") Long id_solicitudr, Model model) {
        SolicitudRequerimiento objSolicitudRequerimiento = solicitudRequerimientoService.buscarSolicitudRequerimiento(id_solicitudr);
        model.addAttribute("solicitudRequerimiento", objSolicitudRequerimiento);
        model.addAttribute("listaSolicitudRequerimiento", solicitudRequerimientoService.cargarSolicitudRequerimiento());
        return "solicitudRequerimiento/main";
    }

    @RequestMapping("/eliminar/{id_solicitudr}")
    public String delete(@PathVariable(value = "id_solicitudr") Long id_solicitudr, Model model) {
        solicitudRequerimientoService.eliminarSolicitudRequerimiento(id_solicitudr);
        return "redirect:/solicitudRequerimiento/";
    }
    
    @RequestMapping(value="/form", method = RequestMethod.POST)
    public String store(SolicitudRequerimiento solicitudRequerimiento, Model model){
        solicitudRequerimientoService.guardarSolicitudRequerimiento(solicitudRequerimiento);
        return "redirect:/solicitudRequerimiento/";
    }

    //@RequestMapping("/exportarPdf")
    /*public void exportarPDF(HttpServletResponse response) throws DocumentException, IOException {
        //* Devuelve el tipo de contenido */
        /*response.setContentType("application/pdf");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());
        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Categorias_" + fechaActual + ".pdf";

        response.setHeader(cabecera, valor);
        List<Categoria> categorias = categoriaService.cargarCategoria();

        CategoriaExporterPDF exporterPDF = new CategoriaExporterPDF(categorias);

        exporterPDF.exportarPDF(response);

    }

    @RequestMapping("/exportarExcel")
    public void exportarExcel(HttpServletResponse response) throws DocumentException, IOException {
        //* Devuelve el tipo de contenido */
        /*response.setContentType("application/octet-stream");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());
        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Categorias_" + fechaActual + ".xlsx";

        response.setHeader(cabecera, valor);
        List<Categoria> categorias = categoriaService.cargarCategoria();

        CategoriaExporterEXCEL exporterPDF = new CategoriaExporterEXCEL(categorias);

        exporterPDF.exportarExcel(response);

    }*/

}
