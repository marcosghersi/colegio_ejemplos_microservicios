package com.colegio.machado.controllers.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public record ClaseDTO(Long id, String clase, String profesor, @JsonIgnore List<AlumnoDTO> alumnos){}