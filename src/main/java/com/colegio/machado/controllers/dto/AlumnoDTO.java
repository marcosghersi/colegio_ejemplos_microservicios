package com.colegio.machado.controllers.dto;

public record AlumnoDTO(Long id, String nombre, String apellido, Integer edad, SimpleClaseDTO clase){}
