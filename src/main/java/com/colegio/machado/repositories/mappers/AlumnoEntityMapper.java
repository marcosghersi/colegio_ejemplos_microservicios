package com.colegio.machado.repositories.mappers;

import com.colegio.machado.repositories.entities.AlumnoEntity;
import com.colegio.machado.services.model.Alumno;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlumnoEntityMapper {
    //@Mapping(source = "name", target = "nombreDelChaval")
    AlumnoEntity toEntity(Alumno alumno);
    Alumno toModel(AlumnoEntity alumnoEntity);

    List<AlumnoEntity> mapEntity(List<Alumno> alumnos);
    List<Alumno> mapModel(List<AlumnoEntity> alumnosEntity);
}
