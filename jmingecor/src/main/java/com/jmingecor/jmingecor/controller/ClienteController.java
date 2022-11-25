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

import com.jmingecor.jmingecor.model.entity.Cliente;
import com.jmingecor.jmingecor.model.service.IClienteService;
import com.jmingecor.jmingecor.util.report.ClientesExporterEXCEL;
import com.jmingecor.jmingecor.util.report.ClientesExporterPDF;
import com.lowagie.text.DocumentException;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private IClienteService clienteService;

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, Object> params) {
        
        int page = params.get("page")  != null ? (Integer.valueOf(params.get("page").toString()) -1 ) : 0;
        int numPage = params.get("numPage") != null ? (Integer.valueOf(params.get("numPage").toString())) : 5;
            
        PageRequest pageRequest = PageRequest.of(page,numPage);
        Page<Cliente> pageCliente = clienteService.getAll(pageRequest);
        
        int totalPage = pageCliente.getTotalPages();

        if (totalPage > 0) {
            List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages", pages);
        }

        Cliente objCliente= new Cliente();
        model.addAttribute("cliente", objCliente);
        model.addAttribute("listaClientes", clienteService.cargarClientes());
        model.addAttribute("list", pageCliente.getContent());
        model.addAttribute("current",page+1);
        model.addAttribute("next", page+2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        model.addAttribute("numPage", numPage);
        return "cliente/main";
    }

    @RequestMapping("/editar/{id}")
    public String update(@PathVariable(value = "id") Long id, Model model) {
        Cliente objCliente = clienteService.buscarCliente(id);
        model.addAttribute("cliente", objCliente);
        model.addAttribute("listaClientes", clienteService.cargarClientes());
        return "cliente/main";
    }

    @RequestMapping("/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id, Model model) {
        clienteService.eliminarCliente(id);
        return "redirect:/cliente/";
    }

    @RequestMapping(value="/form", method = RequestMethod.POST)
    public String store(Cliente cliente, Model model) {
        clienteService.guardarCliente(cliente);
        return "redirect:/cliente/";
    }

     @RequestMapping("/exportarPdf")
     public void exportarPDF(HttpServletResponse response) throws DocumentException, IOException {
         //* Devuelve el tipo de contenido */
         response.setContentType("application/pdf");

         DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
         String fechaActual = dateFormatter.format(new Date());
         String cabecera = "Content-Disposition";
         String valor = "attachment; filename=Clientes_" + fechaActual + ".pdf";

         response.setHeader(cabecera, valor);
         List<Cliente> clientes = clienteService.cargarClientes();

         ClientesExporterPDF exporterPDF = new ClientesExporterPDF(clientes);

         exporterPDF.exportarPDF(response);

     }
    
    @RequestMapping("/exportarExcel")
    public void exportarExcel(HttpServletResponse response) throws DocumentException, IOException {
        //* Devuelve el tipo de contenido */
        response.setContentType("application/octet-stream");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());
        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Clientes_" + fechaActual + ".xlsx";

        response.setHeader(cabecera, valor);
        List<Cliente> clientes = clienteService.cargarClientes();

        ClientesExporterEXCEL exporterEXCEL = new ClientesExporterEXCEL(clientes);

        exporterEXCEL.exportarExcel(response);

    }

}
