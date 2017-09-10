package shuzobot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EncouragementWordController {
    @GetMapping("/encouragementWord")
    public String index(Model model) {
        model.addAttribute("message", "Hello Thymeleaf!!");
        return "encouragementWord";
    }
}
