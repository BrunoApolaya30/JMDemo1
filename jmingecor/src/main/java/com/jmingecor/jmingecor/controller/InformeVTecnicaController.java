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

import com.jmingecor.jmingecor.model.entity.InformeVTecnica;
import com.jmingecor.jmingecor.model.service.IInformeVTecnicaService;

@Controller
@RequestMapping("/informevtecnica")
public class InformeVTecnicaController {

    @Autowired
    private IInformeVTecnicaService informeVTecnicaService;

    @RequestMapping("/")
    public String index(@RequestParam Map<String, Object> params, Model model) {
        int page = params.get("page")  != null ? (Integer.valueOf(params.get("page").toString()) -1 ) : 0;
            int numPage = params.get("numPage")  != null ? (Integer.valueOf(params.get("numPage").toString())) : 5;

            // int numPage = Integer.valueOf(params.get("numPage").toString());

            PageRequest pageRequest = PageRequest.of(page,numPage);
            Page<InformeVTecnica> pageInformeVTecnica = informeVTecnicaService.getAll(pageRequest);

            int totalPage = pageInformeVTecnica.getTotalPages();

            if(totalPage > 0){
                List<Integer> pages = IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
                model.addAttribute("pages",pages);
        }

        InformeVTecnica objInformeVTecnica = new InformeVTecnica();
        model.addAttribute("informeVTecnica", objInformeVTecnica);
        model.addAttribute("listaInformeVTecnica", informeVTecnicaService.cargarInformeVTecnica());        

        model.addAttribute("mensaje","REGISTRAR Informe visita tecnica");
        model.addAttribute("atxt", "a-active");
        model.addAttribute("list",pageInformeVTecnica.getContent());
        model.addAttribute("current",page+1);
        model.addAttribute("next", page+2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        model.addAttribute("numPage", numPage);

        return "informevtecnica/main";
    }

    public String update(@PathVariable(value = "id") Long id, Model model) {
        InformeVTecnica objInformeVTecnica = informeVTecnicaService.buscarInformeVTecnica(id);
        model.addAttribute("informeVTecnica", objInformeVTecnica);
        model.addAttribute("listaEquipos", informeVTecnicaService.cargarInformeVTecnica());
        return "informevtecnica/main";
    }

    @RequestMapping("/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id, Model model) {
        informeVTecnicaService.eliminarInformeVTecnica(id);
        return "redirect:/informevtecnica/";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String store(InformeVTecnica informeVTecnica, Model model) {
        informeVTecnicaService.guardarInformeVTecnica(informeVTecnica);
        return "redirect:/informevtecnica/";
    }
    
}
