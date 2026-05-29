package com.colegio.machado.repositories.mappers;

import com.colegio.machado.repositories.entities.ClaseEntity;
import com.colegio.machado.services.model.Clase;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AlumnoEntityMapper.class})
public interface ClaseEntityMapper {

    ClaseEntity toEntity(Clase clase);

    Clase toModel(ClaseEntity claseEntity);

    List<ClaseEntity> mapEntity(List<Clase> clase);

    List<Clase> mapModel(List<ClaseEntity> claseEntity);
}
