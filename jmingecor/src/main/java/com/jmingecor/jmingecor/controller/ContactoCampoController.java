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

import com.jmingecor.jmingecor.model.entity.ContactoCampo;
import com.jmingecor.jmingecor.model.service.IContactoCampoService;
import com.jmingecor.jmingecor.util.report.ContactoCampoExporterEXCEL;
import com.jmingecor.jmingecor.util.report.ContactoCampoExporterPDF;
import com.lowagie.text.DocumentException;

@Controller
@RequestMapping("/contactocampo")
public class ContactoCampoController {

    @Autowired
    private IContactoCampoService contactoCampoService;

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, Object> params){
        
        int page = params.get("page")  != null ? (Integer.valueOf(params.get("page").toString()) -1 ) : 0;
        int numPage = params.get("numPage") != null ? (Integer.valueOf(params.get("numPage").toString())) : 5;

        PageRequest pageRequest = PageRequest.of(page,numPage);
        Page<ContactoCampo> pageContactoCampo = contactoCampoService.getAll(pageRequest);
        
        int totalPage = pageContactoCampo.getTotalPages();

        if(totalPage > 0){
            List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages", pages);
        }

        ContactoCampo objContactoCampo = new ContactoCampo();
        model.addAttribute("contactoCampo",objContactoCampo);
        model.addAttribute("listaContactoCampo", contactoCampoService.cargarContactosCampo());
        model.addAttribute("list", pageContactoCampo.getContent());
        model.addAttribute("current", page+1);
        model.addAttribute("next", page+2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        model.addAttribute("numPage", numPage);
        return "contactocampo/main";
    }

    @RequestMapping("/editar/{id_contacto_campo}")
    public String update(@PathVariable(value = "id_contacto_campo") Long id_contacto_campo, Model model) {
        ContactoCampo objContactoCampo = contactoCampoService.buscarContactoCampo(id_contacto_campo);
        model.addAttribute("contactoCampo", objContactoCampo);
        model.addAttribute("listaContactoCampo", contactoCampoService.cargarContactosCampo());
        return "contactocampo/main";   
    }
    
    @RequestMapping("/eliminar/{id_contacto_campo}")
    public String delete(@PathVariable(value = "id_contacto_campo") Long id_contacto_campo, Model model) {
        contactoCampoService.eliminarContactoCampo(id_contacto_campo);
        return "redirect:/contactocampo/";
    }

    @RequestMapping(value="/form", method = RequestMethod.POST)
    public String store(ContactoCampo contactoCampo, Model model) {
        contactoCampoService.guardarContactoCampo(contactoCampo);
        return "redirect:/contactocampo/";
    }

    
         @RequestMapping("/exportarPdf")
     public void exportarPDF(HttpServletResponse response) throws DocumentException, IOException {
         //* Devuelve el tipo de contenido */
         response.setContentType("application/pdf");

         DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
         String fechaActual = dateFormatter.format(new Date());
         String cabecera = "Content-Disposition";
         String valor = "attachment; filename=ContactoCampo_" + fechaActual + ".pdf";

         response.setHeader(cabecera, valor);
         List<ContactoCampo> contactoCampo = contactoCampoService.cargarContactosCampo();

         ContactoCampoExporterPDF exporterPDF = new ContactoCampoExporterPDF(contactoCampo);

         exporterPDF.exportarPDF(response);

     }
    
    @RequestMapping("/exportarExcel")
    public void exportarExcel(HttpServletResponse response) throws DocumentException, IOException {
        //* Devuelve el tipo de contenido */
        response.setContentType("application/octet-stream");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());
        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=ContactoCampo_" + fechaActual + ".xlsx";

        response.setHeader(cabecera, valor);
        List<ContactoCampo> contactoCampos = contactoCampoService.cargarContactosCampo();

        ContactoCampoExporterEXCEL exporterEXCEL = new ContactoCampoExporterEXCEL(contactoCampos);

        exporterEXCEL.exportarExcel(response);

    }
}
