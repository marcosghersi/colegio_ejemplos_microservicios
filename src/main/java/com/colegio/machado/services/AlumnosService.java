package com.colegio.machado.services;

import com.colegio.machado.repositories.AlumnosRepository;
import com.colegio.machado.repositories.entities.AlumnoEntity;
import com.colegio.machado.repositories.mappers.AlumnoEntityMapper;
import com.colegio.machado.services.model.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnosService {

    @Autowired
    AlumnosRepository alumnosRepository;
    @Autowired
    AlumnoEntityMapper alumnoMapper;

    public List<Alumno> getAllAlumnos(){
        List<AlumnoEntity> alumnosEntity = alumnosRepository.findAll();
        List<Alumno> alumnos = alumnoMapper.mapModel(alumnosEntity);

        return alumnos;
    }

    public Alumno getAlumnoById(Long id){
        //AlumnoEntity alumnoEntity = alumnosRepository.getReferenceById(id);
        //Alumno alumno = alumnoMapper.toModel(alumnosRepository.getReferenceById(id));
        //return alumno;
        return alumnoMapper.toModel(alumnosRepository.getReferenceById(id));
    }

    public void guardarAlumno(Alumno alumno){
        alumnosRepository.save(alumnoMapper.toEntity(alumno));
    }

}
