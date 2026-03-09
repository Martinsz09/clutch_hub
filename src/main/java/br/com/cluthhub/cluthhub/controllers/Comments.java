package br.com.cluthhub.cluthhub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comments")
public class Comments {
    
    @GetMapping
    public String commentsGet() {
        return "comments";
    }
}
