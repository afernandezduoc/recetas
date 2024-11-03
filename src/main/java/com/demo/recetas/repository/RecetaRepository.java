package com.demo.recetas.repository;

import com.demo.recetas.model.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Long> {

    // Método personalizado para buscar recetas que contengan el nombre especificado
    List<Receta> findByNombreContaining(String nombre);
}

