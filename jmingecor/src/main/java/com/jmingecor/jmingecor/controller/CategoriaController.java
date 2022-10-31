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

import com.jmingecor.jmingecor.model.entity.Categoria;
import com.jmingecor.jmingecor.model.service.ICategoriaService;
import com.jmingecor.jmingecor.util.report.CategoriaExporterEXCEL;
import com.jmingecor.jmingecor.util.report.CategoriaExporterPDF;
import com.lowagie.text.DocumentException;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private ICategoriaService categoriaService;

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, Object> params) {
        
        int page = params.get("page")  != null ? (Integer.valueOf(params.get("page").toString()) -1 ) : 0;
        int numPage = params.get("numPage") != null ? (Integer.valueOf(params.get("numPage").toString())) : 5;
            
        PageRequest pageRequest = PageRequest.of(page,numPage);
        Page<Categoria> pageCategoria = categoriaService.getAll(pageRequest);

        int totalPage = pageCategoria.getTotalPages();
        
        if (totalPage > 0) {
            List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages", pages);
        }
            
        Categoria objCategoria = new Categoria();
        model.addAttribute("categoria", objCategoria);
        model.addAttribute("listaCategorias", categoriaService.cargarCategoria());
        model.addAttribute("list", pageCategoria.getContent());
        model.addAttribute("current",page+1);
        model.addAttribute("next", page+2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        model.addAttribute("numPage", numPage);

        return "categoria/main";
    }

    @RequestMapping("/editar/{id}")
    public String update(@PathVariable(value = "id") Long id, Model model) {
        Categoria objCategoria = categoriaService.buscarCategoria(id);
        model.addAttribute("categoria", objCategoria);
        model.addAttribute("listaCategorias", categoriaService.cargarCategoria());
        return "categoria/main";
    }

    @RequestMapping("/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id, Model model) {
        categoriaService.eliminarCategoria(id);
        return "redirect:/categoria/";
    }
    
    @RequestMapping(value="/form", method = RequestMethod.POST)
    public String store(Categoria categoria, Model model) {
        categoriaService.guardarCategoria(categoria);
        return "redirect:/categoria/";
    }

    @RequestMapping("/exportarPdf")
    public void exportarPDF(HttpServletResponse response) throws DocumentException, IOException {
        //* Devuelve el tipo de contenido */
        response.setContentType("application/pdf");

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
        response.setContentType("application/octet-stream");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());
        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Categorias_" + fechaActual + ".xlsx";

        response.setHeader(cabecera, valor);
        List<Categoria> categorias = categoriaService.cargarCategoria();

        CategoriaExporterEXCEL exporterPDF = new CategoriaExporterEXCEL(categorias);

        exporterPDF.exportarExcel(response);

    }

}
