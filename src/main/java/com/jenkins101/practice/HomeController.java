package com.jenkins101.practice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String homePage(){
        return "home";
    }

    @GetMapping("another")
    public String anotherPage(){
        return "anotherpage";
    }
}
