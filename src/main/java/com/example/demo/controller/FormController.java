package com.example.demo.controller;


import com.example.demo.model.FormData;
import com.example.demo.service.ServerInterfaceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/submitform")
public class FormController {

    @Autowired
    private ServerInterfaceImpl serverInterface;
    @GetMapping("/insert")
    public String greetingForm() {
        serverInterface.findOdn();
        return "Success";
    }
}