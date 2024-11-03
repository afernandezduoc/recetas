package com.demo.recetas.controller;

import com.demo.recetas.model.Receta;
import com.demo.recetas.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}