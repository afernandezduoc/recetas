package com.demo.recetas.controller;

import com.demo.recetas.model.Receta;
import com.demo.recetas.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final RecetaRepository recetaRepository;

    @Autowired
    public HomeController(RecetaRepository recetaRepository) {
        this.recetaRepository = recetaRepository;
    }

    @GetMapping("/")
    public String inicio(Model model) {
        // Aquí podrías obtener recetas recientes o populares desde la base de datos
        List<Receta> recetasRecientes = recetaRepository.findAll(); // Ejemplo de obtener todas las recetas
        model.addAttribute("recetas", recetasRecientes);
        return "index"; // Plantilla Thymeleaf para la página de inicio
    }
}
