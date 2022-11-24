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

import com.jmingecor.jmingecor.model.entity.Personal;
import com.jmingecor.jmingecor.model.service.IPersonalService;

/*@Controller
public class PersonalController {

    @Autowired
    private IPersonalService personalService;

    
    public String index(Model model) {
        Personal objPersonal = new Personal();
        model.addAttribute("personal", objPersonal);
        model.addAttribute("listaPersonal", personalService.cargarPersonales());
        return "personal/main";
    }

    public String update(@PathVariable(value = "id") Long id, Model model) {
        Personal objPersonal = personalService.buscarPersonal(id);
        model.addAttribute("personal", objPersonal);
        model.addAttribute("listaPersonal", personalService.cargarPersonales());
        return "personal/main";
    }

    public String delete(@PathVariable(value = "id") Long id, Model model) {
        personalService.eliminarPersonal(id);
        return "redirect:/personal/";
    }
    
    public String store(Personal personal, Model model) {
        personalService.guardarPersonal(personal);
        return "redirect:/personal/";
    }
}*/

@Controller
@RequestMapping("/personal")
public class PersonalController {

    @Autowired
    private IPersonalService personalService;

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params){

        int page = params.get("page")  != null ? (Integer.valueOf(params.get("page").toString()) -1 ) : 0;
        int numPage = params.get("numPage") != null ? (Integer.valueOf(params.get("numPage").toString())) : 5;

        PageRequest pageRequest = PageRequest.of(page,numPage);
        Page<Personal> pagePersonal = personalService.getAll(pageRequest);

        int totalPage = pagePersonal.getTotalPages();

        if(totalPage > 0){
            List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages", pages);
        }

        Personal objPersonal = new Personal();
        model.addAttribute("personal", objPersonal);
        model.addAttribute("listaPersonal", personalService.cargarPersonales());
        model.addAttribute("list", pagePersonal.getContent());
        model.addAttribute("current",page+1);
        model.addAttribute("next", page+2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        model.addAttribute("numPage", numPage);

        return "personal/main";
    }

    @RequestMapping("/editar/{id_personal}")
    public String update(@PathVariable(value = "id_personal") Long id_personal, Model model) {
        Personal objPersonal = personalService.buscarPersonal(id_personal);
        model.addAttribute("personal", objPersonal);
        model.addAttribute("listaPersonal", personalService.cargarPersonales());
        return "personal/main";
    }

    @RequestMapping("/eliminar/{id_personal}")
    public String delete(@PathVariable(value = "id_personal") Long id_personal, Model model) {
        personalService.eliminarPersonal(id_personal);
        return "redirect:/personal/";
    }

    @RequestMapping(value="/form", method = RequestMethod.POST)
    public String store(Personal personal, Model model) {
        personalService.guardarPersonal(personal);
        return "redirect:/personal/";
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

    }*/

    //@RequestMapping("/exportarExcel")
    /*public void exportarExcel(HttpServletResponse response) throws DocumentException, IOException {
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

    } */

}
