package com.jmingecor.jmingecor.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

public class Error implements ErrorController {
    @RequestMapping("/error")
    public String handleError() {
        //do something like logging
        return "error";
    }
}
