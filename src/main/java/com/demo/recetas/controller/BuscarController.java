// BuscarController.java
package com.demo.recetas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class BuscarController {
    @GetMapping("/buscar")
    public String mostrarPaginaBusqueda(
            @RequestHeader(value = "Authorization", required = false) String authorization, 
            HttpSession session) {
        if (authorization != null && authorization.startsWith("Bearer ")) {
            session.setAttribute("Authorization", authorization);
        }
        return "buscar";
    }
}
