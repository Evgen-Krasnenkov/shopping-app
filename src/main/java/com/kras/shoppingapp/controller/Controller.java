package com.kras.shoppingapp.controller;

import com.kras.shoppingapp.service.EasyWebService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final EasyWebService easyWebService;

    public Controller(EasyWebService easyWebService) {
        this.easyWebService = easyWebService;
    }

    @GetMapping("/hello")
    public String sayReply(){
        return "Rest Controller! " + easyWebService.getValue();
    }
}
