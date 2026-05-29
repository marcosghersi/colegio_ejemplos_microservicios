package com.colegio.machado.services.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Alumno {

    private Long id;

    /**
     * Nombre del Alumno
     */
    private String nombre;

    private String apellido;

    private Integer edad;

    private Clase clase;

}
