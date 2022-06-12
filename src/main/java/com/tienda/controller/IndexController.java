package com.tienda.controller;

import com.tienda.dao.ClienteDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.tienda.domain.Cliente;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@Slf4j
public class IndexController {
    
    @Autowired
    private ClienteDao ClienteDao;
    
    @GetMapping("/")
    public String inicio (Model model){
    log.info("Ahora utilizamos MVC");
    
    /* Cliente cliente = new Cliente("Kevin", "Alvarado Núñez", "kevin.alv2208@gmail.com", "6391-5528");
    Cliente cliente2 = new Cliente("Karina", "Alvarado Núñez", "kary082008@gmail.com", "6171-7572");
    
    var clientes = Arrays.asList(cliente,cliente2);
    
    model.addAttribute("cliente",cliente);
    model.addAttribute("clientes",clientes); */ 
    
    var clientes = ClienteDao.findAll();
    model.addAttribute("clientes", clientes);
    return"index";
    } 
}
