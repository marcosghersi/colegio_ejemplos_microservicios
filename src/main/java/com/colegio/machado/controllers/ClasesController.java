package com.colegio.machado.controllers;

import com.colegio.machado.controllers.dto.ClaseDTO;
import com.colegio.machado.controllers.dto.ClaseRequestDTO;
import com.colegio.machado.controllers.mappers.ClaseDTOMapper;
import com.colegio.machado.repositories.entities.ClaseEntity;
import com.colegio.machado.services.ClasesService;
import com.colegio.machado.services.model.Clase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clases")
public class ClasesController {

    @Autowired
    private ClasesService clasesService;
    @Autowired
    private ClaseDTOMapper claseDTOMapper;

    /**
     * Explicación del método
     *
     * @return explicar qué devuelve
     */
    @GetMapping
    public ResponseEntity<List<ClaseDTO>> getClases() {
        List<Clase> clases = clasesService.getAllClases();
        List<ClaseDTO> claseDTOList = claseDTOMapper.mapDTO(clases);
        return ResponseEntity.ok(claseDTOList);
    }

    //@GetMapping("/{id}")
    @GetMapping("/{id}")
    public ResponseEntity<ClaseDTO> getClaseByID(@PathVariable Long id) {
        return ResponseEntity.ok(claseDTOMapper.toDTO(clasesService.getClaseById(id)));
    }

    @PostMapping
    public ResponseEntity<ClaseDTO> guardarClase(@RequestBody ClaseRequestDTO request) {
        // DTO → Modelo
        Clase clase = claseDTOMapper.toModel(request);
        // Guardar en service
        Clase guardada = clasesService.guardarClase(clase);
        // Modelo → DTO
        ClaseDTO response = claseDTOMapper.toDTO(guardada);
        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClaseDTO> actualizarClase(@PathVariable Long id, @RequestBody ClaseRequestDTO request) {

        Clase clase = claseDTOMapper.toModel(request);
        Clase actualizada = clasesService.actualizarClase(id, clase);
        ClaseDTO response = claseDTOMapper.toDTO(actualizada);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping ("/{id}")
    public void eliminarClase(@PathVariable Long id) {
        clasesService.eliminarClase(id);
    }
}
