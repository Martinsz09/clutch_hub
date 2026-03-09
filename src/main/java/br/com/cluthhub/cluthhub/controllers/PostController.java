package br.com.cluthhub.cluthhub.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import br.com.cluthhub.cluthhub.domain.dto.PostDto;
import br.com.cluthhub.cluthhub.domain.model.Post;
import br.com.cluthhub.cluthhub.domain.repository.PostRepository;
import br.com.cluthhub.cluthhub.service.PostService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;

    @GetMapping("/post/create") 
    public String postGet() {
        return "create-post";
    }

    @PostMapping("/post/create")
    public String postPost(@ModelAttribute PostDto postDto) {
        postService.save(postDto);
        return "redirect:/";
    }

    @GetMapping("/")
    public String postFindAll(Model model) {
        List<Post> allPosts = postRepository.findAll();
        model.addAttribute("posts", allPosts);
        return "index"; 
    }
}