package org.example.gestormagia.repository;

import org.example.gestormagia.model.Hechizo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HechizoRepository extends JpaRepository<Hechizo, Long> {

    List<Hechizo> findByTipo(String tipo);

    List<Hechizo> findByNombreContaining(String nombre);

    Optional<Hechizo> findByNombre(String nombre);

    void deleteByNombre(String nombre);
}
