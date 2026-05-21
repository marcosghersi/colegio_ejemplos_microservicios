package com.colegio.machado.controllers.mappers;


import com.colegio.machado.controllers.dto.AlumnoDTO;
import com.colegio.machado.services.model.Alumno;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlumnoDTOMapper {
    //@Mapping(source = "name", target = "nombreDelChaval")
    AlumnoDTO toDTO(Alumno alumno);
    Alumno toModel(AlumnoDTO alumnoDTO);

    List<AlumnoDTO> mapDTO(List<Alumno> alumnos);
    List<Alumno> mapModel(List<AlumnoDTO> alumnosDTO);
}
