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

import com.jmingecor.jmingecor.model.entity.DetalleVTecnica;
import com.jmingecor.jmingecor.model.service.IDetalleVTecnicaService;

@Controller
@RequestMapping("/detallevtecnica")
public class DetalleVTecnicaController {

    @Autowired
    private IDetalleVTecnicaService detalleVTecnicaService;
    
    @RequestMapping("/")
    public String index(@RequestParam Map<String, Object> params, Model model) {
        int page = params.get("page")  != null ? (Integer.valueOf(params.get("page").toString()) -1 ) : 0;
            int numPage = params.get("numPage")  != null ? (Integer.valueOf(params.get("numPage").toString())) : 5;

            // int numPage = Integer.valueOf(params.get("numPage").toString());

            PageRequest pageRequest = PageRequest.of(page,numPage);
            Page<DetalleVTecnica> pageDetalleVTecnica = detalleVTecnicaService.getAll(pageRequest);

            int totalPage = pageDetalleVTecnica.getTotalPages();

            if(totalPage > 0){
                List<Integer> pages = IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
                model.addAttribute("pages",pages);
        }

        DetalleVTecnica objDetalleVTecnica = new DetalleVTecnica();
        model.addAttribute("detalleVTecnica", objDetalleVTecnica);
        model.addAttribute("listaDetalleVTecnica", detalleVTecnicaService.cargarDetalleVTecnica());        

        model.addAttribute("mensaje","REGISTRAR Detalle visita tecnica");
        model.addAttribute("atxt", "a-active");
        model.addAttribute("list",pageDetalleVTecnica.getContent());
        model.addAttribute("current",page+1);
        model.addAttribute("next", page+2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        model.addAttribute("numPage", numPage);

        return "detallevtecnica/main";
    }

    public String update(@PathVariable(value = "id") Long id, Model model) {
        DetalleVTecnica objDetalleVTecnica = detalleVTecnicaService.buscarDetalleVTecnica(id);
        model.addAttribute("detalleVTecnica", objDetalleVTecnica);
        model.addAttribute("listaDetalleVTecnica", detalleVTecnicaService.cargarDetalleVTecnica());
        return "detallevtecnica/main";
    }
    @RequestMapping("/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id, Model model) {
        detalleVTecnicaService.eliminarDetalleVTecnica(id);
        return "redirect:/detallevtecnica/";
    }
    
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String store(DetalleVTecnica detalleVTecnica, Model model) {
        detalleVTecnicaService.guardarDetalleVTecnica(detalleVTecnica);
        return "redirect:/detallevtecnica/";
    }
}
