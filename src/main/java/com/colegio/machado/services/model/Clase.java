package com.colegio.machado.services.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Clase {
    private Long id;
    private String clase;
    private String profesor;

    private List<Alumno> alumnos;
}
