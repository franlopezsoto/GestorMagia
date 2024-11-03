package org.example.gestormagia.repository;

import org.example.gestormagia.model.Hechizo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HechizoRepository extends JpaRepository<Hechizo, Long> {

    // Encuentra hechizos por tipo
    List<Hechizo> findByTipo(String tipo);

    // Encuentra hechizos que contienen cierta palabra en el nombre
    List<Hechizo> findByNombreContaining(String nombre);

    // Encuentra un hechizo por su nombre exacto
    Optional<Hechizo> findByNombre(String nombre);

    // Elimina un hechizo por su nombre
    void deleteByNombre(String nombre);
}
