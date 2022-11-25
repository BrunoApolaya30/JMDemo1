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

import com.jmingecor.jmingecor.model.entity.DetalleValeSalida;
import com.jmingecor.jmingecor.model.service.IDetalleValeSalidaService;

@Controller
@RequestMapping("/valeDetalleSalida")
public class DetalleValeSalidaController {
    
    @Autowired
    private IDetalleValeSalidaService detalleValeSalidaService;

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, Object> params) {
        
        int page = params.get("page")  != null ? (Integer.valueOf(params.get("page").toString()) -1 ) : 0;
        int numPage = params.get("numPage") != null ? (Integer.valueOf(params.get("numPage").toString())) : 5;
            
        PageRequest pageRequest = PageRequest.of(page,numPage);
        Page<DetalleValeSalida> pageDetalleValeSalida = detalleValeSalidaService.getAll(pageRequest);

        int totalPage = pageDetalleValeSalida.getTotalPages();

        if (totalPage > 0) {
            List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages", pages);
        }

        DetalleValeSalida objDetalleValeSalida = new DetalleValeSalida();
        model.addAttribute("valeDetalleSalida", objDetalleValeSalida);
        model.addAttribute("listaValeDetalleSalida", detalleValeSalidaService.cargarDetalleValeSalida());
        model.addAttribute("list", pageDetalleValeSalida.getContent());
        model.addAttribute("current",page+1);
        model.addAttribute("next", page+2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        model.addAttribute("numPage", numPage);

        return "valeDetalleSalida/main";
    }

    @RequestMapping("/editar/{id_detalle_salida}")
    public String update(@PathVariable(value = "id_detalle_salida") Long id_detalle_salida, Model model) {
        DetalleValeSalida objDetalleValeSalida = detalleValeSalidaService.buscarDetalleValeSalida(id_detalle_salida);
        model.addAttribute("valeDetalleSalida", objDetalleValeSalida);
        model.addAttribute("listaValeDetalleSalida", detalleValeSalidaService.cargarDetalleValeSalida());
        return "valeDetalleSalida/main";
    }

    @RequestMapping("/eliminar/{id_detalle_salida}")
    public String delete(@PathVariable(value = "id_detalle_salida") Long id_detalle_salida, Model model) {
        detalleValeSalidaService.eliminarDetalleValeSalida(id_detalle_salida);
        return "redirect:/valeDetalleSalida/";
    }
    
    @RequestMapping(value="/form", method = RequestMethod.POST)
    public String store(DetalleValeSalida detalleValeSalida, Model model){
        detalleValeSalidaService.guardarDetalleValeSalida(detalleValeSalida);
        return "redirect:/valeDetalleSalida/";
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
