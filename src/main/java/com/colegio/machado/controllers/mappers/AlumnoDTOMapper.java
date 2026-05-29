package com.colegio.machado.controllers.mappers;

import com.colegio.machado.controllers.dto.AlumnoDTO;
import com.colegio.machado.controllers.dto.AlumnoRequestDTO;
import com.colegio.machado.controllers.dto.ClaseRequestDTO;
import com.colegio.machado.controllers.dto.SimpleClaseDTO;
import com.colegio.machado.services.model.Alumno;
import com.colegio.machado.services.model.Clase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlumnoDTOMapper {
        // @Mapping(source = "name", target = "nombreDelChaval")
        AlumnoDTO toDTO(Alumno alumno);

        Alumno toModel(AlumnoDTO alumnoDTO);

        List<AlumnoDTO> mapDTO(List<Alumno> alumnos);

        List<Alumno> mapModel(List<AlumnoDTO> alumnosDTO);

        default SimpleClaseDTO map(Clase clase) {
                if (clase == null)
                        return null;

                return new SimpleClaseDTO(
                                clase.getId(),
                                clase.getClase());
        }

        default Clase map(SimpleClaseDTO claseDTO) {
                if (claseDTO == null)
                        return null;

                return new Clase(
                                claseDTO.id(),
                                claseDTO.clase(),
                                null,
                                null);
        }

        //NUEVO PARA POST/PUT
        @Mapping(target = "clase", ignore = true)
        @Mapping(target = "id", ignore = true)
        Alumno toModel(AlumnoRequestDTO dto);

}
