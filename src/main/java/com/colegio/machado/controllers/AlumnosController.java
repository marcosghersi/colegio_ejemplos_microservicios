package com.colegio.machado.controllers;

import com.colegio.machado.controllers.dto.AlumnoDTO;
import com.colegio.machado.controllers.mappers.AlumnoDTOMapper;
import com.colegio.machado.services.AlumnosService;
import com.colegio.machado.services.model.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnosController {

    @Autowired
    private AlumnosService alumnosService;
    @Autowired
    private AlumnoDTOMapper alumnoDTOMapper;

    /**
     * Explicación del método
     * @return explicar qué devuelve
     */
    @GetMapping
    public ResponseEntity<List<AlumnoDTO>> getAlumnos(){
        List<Alumno> alumnos= alumnosService.getAllAlumnos();
        List<AlumnoDTO> alumnoDTOList = alumnoDTOMapper.mapDTO(alumnos);
        return ResponseEntity.ok(alumnoDTOList);
    }

    //@GetMapping("/{id}")
    @GetMapping("/alumno")
    public ResponseEntity<AlumnoDTO> getAlumnoByID(@RequestParam Long id){
        return ResponseEntity.ok(alumnoDTOMapper.toDTO(alumnosService.getAlumnoById(id)));
    }
    @PostMapping
    public ResponseEntity<String> guardaAlumno(@RequestBody AlumnoDTO alumnoDTO){
        alumnosService.guardarAlumno(alumnoDTOMapper.toModel(alumnoDTO));
        return ResponseEntity.created(URI.create("http://algo.es")).body("Creado");
    }


}
