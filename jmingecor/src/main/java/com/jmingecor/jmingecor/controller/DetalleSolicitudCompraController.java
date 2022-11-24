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

import com.jmingecor.jmingecor.model.entity.DetalleSolicitudCompra;
import com.jmingecor.jmingecor.model.service.IDetalleSolicitudCompraService;

@Controller
@RequestMapping("/detalleSolicitudCompra")
public class DetalleSolicitudCompraController {
    
    @Autowired
    private IDetalleSolicitudCompraService detalleSolicitudCompraService;

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, Object> params) {
        
        int page = params.get("page")  != null ? (Integer.valueOf(params.get("page").toString()) -1 ) : 0;
        int numPage = params.get("numPage") != null ? (Integer.valueOf(params.get("numPage").toString())) : 5;
            
        PageRequest pageRequest = PageRequest.of(page,numPage);
        Page<DetalleSolicitudCompra> pageDetalleSolicitudCompra= detalleSolicitudCompraService.getAll(pageRequest);

        int totalPage = pageDetalleSolicitudCompra.getTotalPages();

        if (totalPage > 0) {
            List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages", pages);
        }

        DetalleSolicitudCompra objDetalleSolicitudCompra = new DetalleSolicitudCompra();
        model.addAttribute("detalleSolicitudCompra", objDetalleSolicitudCompra);
        model.addAttribute("listaDetalleSolicitudCompra", detalleSolicitudCompraService.cargarDetalleSolicitudCompra());
        model.addAttribute("list", pageDetalleSolicitudCompra.getContent());
        model.addAttribute("current",page+1);
        model.addAttribute("next", page+2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        model.addAttribute("numPage", numPage);

        return "detalleSolicitudCompra/main";
    }

    @RequestMapping("/editar/{iddetalle_scompra}")
    public String update(@PathVariable(value = "iddetalle_scompra") Long iddetalle_scompra, Model model) {
        DetalleSolicitudCompra objDetalleSolicitudCompra = detalleSolicitudCompraService.buscarDetalleSolicitudCompra(iddetalle_scompra);
        model.addAttribute("detalleSolicitudCompra", objDetalleSolicitudCompra);
        model.addAttribute("listaDetalleSolicitudCompra", detalleSolicitudCompraService.cargarDetalleSolicitudCompra());
        return "detalleSolicitudCompra/main";
    }

    @RequestMapping("/eliminar/{iddetalle_scompra}")
    public String delete(@PathVariable(value = "iddetalle_scompra") Long iddetalle_scompra, Model model) {
        detalleSolicitudCompraService.eliminarDetalleSolicitudCompra(iddetalle_scompra);
        return "redirect:/detalleSolicitudCompra/";
    }
    
    @RequestMapping(value="/form", method = RequestMethod.POST)
    public String store(DetalleSolicitudCompra detalleSolicitudCompra, Model model){
        detalleSolicitudCompraService.guardarDetalleSolicitudCompra(detalleSolicitudCompra);
        return "redirect:/detalleSolicitudCompra/";
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
