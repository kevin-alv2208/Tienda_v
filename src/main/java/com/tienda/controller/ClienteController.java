package com.tienda.controller;

import com.tienda.domain.Cliente;
import com.tienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/cliente/listado")
   public String inicio (Model model){
    var clientes = clienteService.getClientes();
    model.addAttribute("cliente",clientes);
    return "/clientes/listado";
   }
   
    @GetMapping("/cliente/nuevoCliente")
    public String nuevoCliente(Cliente cliente) {
        return "/cliente/modificar";
    }

    @PostMapping("/cliente/guardarCliente")
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/clientemodificar";
    }

    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarCliente(Cliente cliente, Model model) {
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }
    
}
