package org.example.gestormagia.controller;

import org.example.gestormagia.dto.HechizoDto;
import org.example.gestormagia.service.HechizoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hechizos")
public class HechizoController {

    @Autowired
    private HechizoService hechizoService;

    // CRUD Endpoints
    @GetMapping
    public List<HechizoDto> obtenerHechizos() {
        return hechizoService.obtenerHechizos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HechizoDto> obtenerHechizoPorId(@PathVariable Long id) {
        Optional<HechizoDto> hechizo = hechizoService.obtenerHechizoPorId(id);
        return hechizo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HechizoDto> crearHechizo(@RequestBody HechizoDto hechizoDto) {
        return new ResponseEntity<>(hechizoService.guardarHechizo(hechizoDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HechizoDto> actualizarHechizo(@PathVariable Long id, @RequestBody HechizoDto hechizoDto) {
        Optional<HechizoDto> hechizoActualizado = hechizoService.actualizarHechizo(id, hechizoDto);
        return hechizoActualizado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHechizo(@PathVariable Long id) {
        if (hechizoService.eliminarHechizo(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/tipo/{tipo}")
    public List<HechizoDto> buscarHechizosPorTipo(@PathVariable String tipo) {
        return hechizoService.buscarHechizosPorTipo(tipo);
    }

    @GetMapping("/buscar")
    public List<HechizoDto> buscarHechizosPorNombre(@RequestParam String nombre) {
        return hechizoService.buscarHechizosPorNombreContiene(nombre);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<HechizoDto> buscarHechizoPorNombreExacto(@PathVariable String nombre) {
        Optional<HechizoDto> hechizo = hechizoService.buscarHechizoPorNombreExacto(nombre);
        return hechizo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/nombre/{nombre}")
    public ResponseEntity<Void> eliminarHechizoPorNombre(@PathVariable String nombre) {
        if (hechizoService.eliminarHechizoPorNombre(nombre)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
