package com.group2.bookshopwebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExController {

    @GetMapping("404")
    String notFound(){
        return "debug";
    }
}
