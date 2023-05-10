package com.arjuna.Costumer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/home")
    public String showHomePage(){
        return "Home";
    }
}
