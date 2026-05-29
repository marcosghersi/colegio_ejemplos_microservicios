package com.colegio.machado.controllers.mappers;


import com.colegio.machado.controllers.dto.ClaseDTO;
import com.colegio.machado.controllers.dto.ClaseRequestDTO;
import com.colegio.machado.services.model.Clase;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AlumnoDTOMapper.class})
public interface ClaseDTOMapper {
    //@Mapping(source = "name", target = "nombreDelChaval")
    ClaseDTO toDTO(Clase clase);
    Clase toModel(ClaseDTO claseDTO);

    List<ClaseDTO> mapDTO(List<Clase> clases);
    List<Clase> mapModel(List<ClaseDTO> claseDTO);

    //NUEVO PARA POST/PUT
    Clase toModel(ClaseRequestDTO dto);
}
