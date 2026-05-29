package com.colegio.machado.repositories.mappers;

import com.colegio.machado.repositories.entities.AlumnoEntity;
import com.colegio.machado.services.model.Alumno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlumnoEntityMapper {

    @Mapping(target = "clase", ignore = true)
    Alumno toModel(AlumnoEntity entity);

    @Mapping(target = "clase", ignore = true)
    AlumnoEntity toEntity(Alumno alumno);
    
    void updateEntity(Alumno alumno, @MappingTarget AlumnoEntity alumnoEntity);

    List<AlumnoEntity> mapEntity(List<Alumno> alumnos);

    List<Alumno> mapModel(List<AlumnoEntity> alumnosEntity);
}
