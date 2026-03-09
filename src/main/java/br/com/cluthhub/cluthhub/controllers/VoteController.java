package br.com.cluthhub.cluthhub.controllers;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.cluthhub.cluthhub.service.VoteService;

@Controller
@RequestMapping("/votes")
public class VoteController {

    private final VoteService voteService;
    
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }


    @PostMapping("/{postId}") 
    public String vote(@PathVariable UUID postId, @RequestParam Integer value) {
        voteService.vote(postId, value);
        return "redirect:/";
    }
}