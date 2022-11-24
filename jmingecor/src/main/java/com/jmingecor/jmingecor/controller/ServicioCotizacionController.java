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

import com.jmingecor.jmingecor.model.entity.ServicioCotizacion;
import com.jmingecor.jmingecor.model.service.IServicioCotizacionService;

@Controller
@RequestMapping("/servcotizacion")
public class ServicioCotizacionController {
    
    @Autowired
    private IServicioCotizacionService servicioCotizacionService;    

    @RequestMapping("/{id}")    
    public String index(@PathVariable(value = "id") Long idCot, @RequestParam Map<String, Object> params, Model model) {
        int page = params.get("page")  != null ? (Integer.valueOf(params.get("page").toString()) -1 ) : 0;
        int numPage = params.get("numPage")  != null ? (Integer.valueOf(params.get("numPage").toString())) : 5;
            

        PageRequest pageRequest = PageRequest.of(page,numPage);
        Page<ServicioCotizacion> pageServCotizacion = servicioCotizacionService.getAll(pageRequest);

        int totalPage = pageServCotizacion.getTotalPages();

        if(totalPage > 0){
            List<Integer> pages = IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages",pages);
        }

        ServicioCotizacion objServicioCotizacion = new ServicioCotizacion();
        model.addAttribute("servicioCotizacion", objServicioCotizacion);
        model.addAttribute("listaServicioCotizacion", servicioCotizacionService.cargarServicioCotizacion(idCot));        

        model.addAttribute("idCoti", idCot);
        model.addAttribute("mensaje","REGISTRAR Servicio Cotizacion");
        model.addAttribute("atxt", "a-active");
        model.addAttribute("list",pageServCotizacion.getContent());
        model.addAttribute("current",page+1);
        model.addAttribute("next", page+2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        model.addAttribute("numPage", numPage);

        return "serviciocotizacion/main";
    }

    @RequestMapping("{id}/editar/{idS}")
    public String update(@PathVariable(value = "id") Long idCot, @PathVariable(value = "idS") Long id, Model model) {
        ServicioCotizacion objServicioCotizacion = servicioCotizacionService.buscarServicioCotizacion(id);
        model.addAttribute("servicioCotizacion", objServicioCotizacion);
        model.addAttribute("listaServicioCotizacion", servicioCotizacionService.cargarServicioCotizacion(idCot));
        return "serviciocotizacion/main";
    }

    @RequestMapping("{id}/eliminar/{idS}")
    public String delete(@PathVariable(value = "id") Long idCot, @PathVariable(value = "idS") Long id, Model model) {
        servicioCotizacionService.eliminarServicioCotizacion(id);
        return "redirect:/servcotizacion/{id}";
    }

    @RequestMapping(value = "/form/{id}", method = RequestMethod.POST)
    public String store(@PathVariable(value = "id") Long idCot, ServicioCotizacion servicioCotizacion, Model model) {        
        servicioCotizacionService.guardarServicioCotizacion(servicioCotizacion);
        return "redirect:/servcotizacion/{id}";
    }
}
