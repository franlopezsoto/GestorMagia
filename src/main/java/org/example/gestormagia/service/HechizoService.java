package org.example.gestormagia.service;

import org.example.gestormagia.dto.HechizoDto;
import org.example.gestormagia.model.Hechizo;
import org.example.gestormagia.repository.HechizoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HechizoService {

    @Autowired
    private HechizoRepository hechizoRepository;

    // Convertir entidad a DTO
    private HechizoDto mapearADto(Hechizo hechizo) {
        return new HechizoDto(hechizo.getId(), hechizo.getNombre(), hechizo.getTipo());
    }

    // Convertir DTO a entidad
    private Hechizo mapearAEntidad(HechizoDto dto) {
        return new Hechizo(dto.getNombre(), dto.getTipo(), null);
    }

    // Métodos CRUD

    public List<HechizoDto> obtenerHechizos() {
        return hechizoRepository.findAll().stream()
                .map(this::mapearADto)
                .collect(Collectors.toList());
    }

    public Optional<HechizoDto> obtenerHechizoPorId(Long id) {
        return hechizoRepository.findById(id).map(this::mapearADto);
    }

    public HechizoDto guardarHechizo(HechizoDto hechizoDto) {
        Hechizo hechizo = mapearAEntidad(hechizoDto);
        Hechizo guardado = hechizoRepository.save(hechizo);
        return mapearADto(guardado);
    }

    public Optional<HechizoDto> actualizarHechizo(Long id, HechizoDto hechizoDto) {
        return hechizoRepository.findById(id).map(hechizoExistente -> {
            hechizoExistente.setNombre(hechizoDto.getNombre());
            hechizoExistente.setTipo(hechizoDto.getTipo());
            hechizoExistente.setDescripcion(hechizoDto.getDescripcion());
            return mapearADto(hechizoRepository.save(hechizoExistente));
        });
    }

    public boolean eliminarHechizo(Long id) {
        if (hechizoRepository.existsById(id)) {
            hechizoRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public List<HechizoDto> buscarHechizosPorTipo(String tipo) {
        return hechizoRepository.findByTipo(tipo).stream()
                .map(this::mapearADto)
                .collect(Collectors.toList());
    }

    public List<HechizoDto> buscarHechizosPorNombreContiene(String nombre) {
        return hechizoRepository.findByNombreContaining(nombre).stream()
                .map(this::mapearADto)
                .collect(Collectors.toList());
    }

    public Optional<HechizoDto> buscarHechizoPorNombreExacto(String nombre) {
        return hechizoRepository.findByNombre(nombre).map(this::mapearADto);
    }

    public boolean eliminarHechizoPorNombre(String nombre) {
        Optional<Hechizo> hechizo = hechizoRepository.findByNombre(nombre);
        if (hechizo.isPresent()) {
            hechizoRepository.deleteByNombre(nombre);
            return true;
        }
        return false;
    }
}
