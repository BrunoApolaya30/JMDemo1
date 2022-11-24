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

import com.jmingecor.jmingecor.model.entity.Cotizacion;
import com.jmingecor.jmingecor.model.service.IClienteService;
import com.jmingecor.jmingecor.model.service.ICotizacionService;

@Controller
@RequestMapping("/cotizacion")
public class CotizacionController {
    
    @Autowired
    private ICotizacionService cotizacionService;

    @Autowired
    private IClienteService clienteService;

    @RequestMapping("/")
    public String index(@RequestParam Map<String, Object> params, Model model) {
        int page = params.get("page")  != null ? (Integer.valueOf(params.get("page").toString()) -1 ) : 0;
            int numPage = params.get("numPage")  != null ? (Integer.valueOf(params.get("numPage").toString())) : 5;

            // int numPage = Integer.valueOf(params.get("numPage").toString());

            PageRequest pageRequest = PageRequest.of(page,numPage);
            Page<Cotizacion> pageCotizacion = cotizacionService.getAll(pageRequest);

            int totalPage = pageCotizacion.getTotalPages();

            if(totalPage > 0){
                List<Integer> pages = IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
                model.addAttribute("pages",pages);
        }

        Cotizacion objCotizacion = new Cotizacion();
        model.addAttribute("cotizacion", objCotizacion);
        model.addAttribute("listaCotizaciones", cotizacionService.cargarCotizaciones());

        model.addAttribute("listaClientes", clienteService.cargarClientes());

        model.addAttribute("mensaje","REGISTRAR Cotizacion");
        model.addAttribute("atxt", "a-active");
        model.addAttribute("list",pageCotizacion.getContent());
        model.addAttribute("current",page+1);
        model.addAttribute("next", page+2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        model.addAttribute("numPage", numPage);

        return "cotizacion/main";
    }

    @RequestMapping("/editar/{id}")
    public String update(@PathVariable(value = "id") Long id, Model model) {
        Cotizacion objCotizacion = cotizacionService.buscarCotizacion(id);
        model.addAttribute("cotizacion", objCotizacion);
        model.addAttribute("listaCotizaciones", cotizacionService.cargarCotizaciones());
        return "cotizacion/main";
    }

    @RequestMapping("/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id, Model model) {
        cotizacionService.eliminarCotizacion(id);
        return "redirect:/cotizacion/";
    }
    
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String store(Cotizacion cotizacion, Model model) {
        cotizacionService.guardarCotizacion(cotizacion);
        return "redirect:/cotizacion/";
    }
}
