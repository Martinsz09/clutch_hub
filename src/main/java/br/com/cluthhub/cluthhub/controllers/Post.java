package br.com.cluthhub.cluthhub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class Post {

    @GetMapping("/create") 
    public String postGet() {
        return "create-post";
    }

        
}
