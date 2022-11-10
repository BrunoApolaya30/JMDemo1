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

import com.jmingecor.jmingecor.model.entity.Material;
import com.jmingecor.jmingecor.model.service.ICategoriaService;
import com.jmingecor.jmingecor.model.service.IMaterialService;
import com.jmingecor.jmingecor.util.report.MaterialExporterEXCEL;
import com.jmingecor.jmingecor.util.report.MaterialExporterPDF;
import com.lowagie.text.DocumentException;

@Controller
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    private IMaterialService materialService;

    @Autowired
    private ICategoriaService categoriaService;

    @RequestMapping("/")
    public String index(@RequestParam Map<String, Object> params, Model model) {

        int page = params.get("page")  != null ? (Integer.valueOf(params.get("page").toString()) -1 ) : 0;
            int numPage = params.get("numPage")  != null ? (Integer.valueOf(params.get("numPage").toString())) : 5;

            // int numPage = Integer.valueOf(params.get("numPage").toString());

            PageRequest pageRequest = PageRequest.of(page,numPage);
            Page<Material> pageMaterial = materialService.getAll(pageRequest);

            int totalPage = pageMaterial.getTotalPages();

            if(totalPage > 0){
                List<Integer> pages = IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
                model.addAttribute("pages",pages);
        }


        Material objMaterial = new Material();
        model.addAttribute("material", objMaterial);
        model.addAttribute("listaMateriales", materialService.cargarMateriales());

        model.addAttribute("listaCategorias", categoriaService.cargarCategoria());

        model.addAttribute("mensaje","REGISTRAR Material");
        model.addAttribute("atxt", "a-active");
        model.addAttribute("list",pageMaterial.getContent());
        model.addAttribute("current",page+1);
        model.addAttribute("next", page+2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        model.addAttribute("numPage", numPage);


        return "material/main";
    }

    public String update(@PathVariable(value = "id") Long id, Model model) {
        Material objMaterial = materialService.buscarMaterial(id);
        model.addAttribute("material", objMaterial);
        model.addAttribute("listaMateriales", materialService.cargarMateriales());
        return "material/main";
    }

    @RequestMapping("/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id, Model model) {
        materialService.eliminarMaterial(id);
        return "redirect:/material/";
    }
    
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String store(Material material, Model model) {
        materialService.guardarMaterial(material);
        return "redirect:/material/";
    }


     @RequestMapping("/exportarPdf")
     public void exportarPDF(HttpServletResponse response) throws DocumentException, IOException {
         //* Devuelve el tipo de contenido */
         response.setContentType("application/pdf");

         DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
         String fechaActual = dateFormatter.format(new Date());
         String cabecera = "Content-Disposition";
         String valor = "attachment; filename=Materiales_" + fechaActual + ".pdf";

         response.setHeader(cabecera, valor);
         List<Material> materiales = materialService.cargarMateriales();

         MaterialExporterPDF exporterPDF = new MaterialExporterPDF(materiales);

         exporterPDF.exportarPDF(response);

     }
    
    @RequestMapping("/exportarExcel")
    public void exportarExcel(HttpServletResponse response) throws DocumentException, IOException {
        //* Devuelve el tipo de contenido */
        response.setContentType("application/octet-stream");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());
        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Materiales_" + fechaActual + ".xlsx";

        response.setHeader(cabecera, valor);
        List<Material> materiales = materialService.cargarMateriales();

        MaterialExporterEXCEL exporterEXCEL = new MaterialExporterEXCEL(materiales);

        exporterEXCEL.exportarExcel(response);

    }
}
