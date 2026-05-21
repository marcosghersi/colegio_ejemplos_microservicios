package com.colegio.machado.repositories;

import com.colegio.machado.repositories.entities.AlumnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnosRepository extends JpaRepository<AlumnoEntity, Long> {
}
