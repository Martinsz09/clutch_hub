package br.com.cluthhub.cluthhub.controllers;

import br.com.cluthhub.cluthhub.domain.dto.AuthDto;
import br.com.cluthhub.cluthhub.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@ModelAttribute AuthDto dto) {


        authService.register(dto);

        return "redirect:/auth/login";
    }
}