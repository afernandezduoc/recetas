package com.demo.recetas.controller;

import com.demo.recetas.model.Receta;
import com.demo.recetas.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecetaController {

    @Autowired
    private RecetaRepository recetaRepository;

    @GetMapping("/api/recetas")
    public List<Receta> obtenerRecetas() {
        return recetaRepository.findAll();
    }

    @GetMapping("/receta/detalle")
    public String detalleReceta(Model model) {
        // Por ahora, datos estáticos
        Receta receta = new Receta("Paella", "Española", "Arroz, Azafrán, Mariscos", "Instrucciones para paella", 45, "Media");

        model.addAttribute("receta", receta);
        return "detalleReceta";
    }

}