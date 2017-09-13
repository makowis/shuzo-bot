package com.makowis.shuzobot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    // Login form
    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
