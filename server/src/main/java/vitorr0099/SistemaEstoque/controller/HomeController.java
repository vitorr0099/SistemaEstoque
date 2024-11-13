package vitorr0099.SistemaEstoque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Mapeamento da URL raiz
    @GetMapping("http://localhost:8080/")
    public String home() {
        return "index"; // Nome da página Thymeleaf (index.html)
    }
}