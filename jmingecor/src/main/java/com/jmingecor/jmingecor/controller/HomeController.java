package com.jmingecor.jmingecor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index() {
        return "login";
    }
    @RequestMapping("/home")
    public String home(){
        return "inicio";
    }
    
}
