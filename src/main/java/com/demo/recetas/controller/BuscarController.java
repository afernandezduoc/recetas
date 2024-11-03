package com.demo.recetas.controller;

import com.demo.recetas.model.Receta;
import com.demo.recetas.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BuscarController {

    private final RecetaRepository recetaRepository;

    @Autowired
    public BuscarController(RecetaRepository recetaRepository) {
        this.recetaRepository = recetaRepository;
    }

    @GetMapping("/buscar")
    public String buscarRecetas(@RequestParam(value = "nombre", required = false) String nombre, Model model) {
        List<Receta> resultados = nombre != null ? recetaRepository.findByNombreContaining(nombre) : List.of();
        model.addAttribute("resultados", resultados);
        return "buscar"; // Plantilla Thymeleaf que muestra los resultados de búsqueda
    }

}