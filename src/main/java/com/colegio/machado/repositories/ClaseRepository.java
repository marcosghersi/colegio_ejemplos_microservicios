package com.colegio.machado.repositories;

import com.colegio.machado.repositories.entities.ClaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaseRepository extends JpaRepository<ClaseEntity, Long> {

    @Query("SELECT c FROM ClaseEntity c LEFT JOIN FETCH c.alumnos WHERE c.id = :id")
    ClaseEntity findByIdWithAlumnos(@Param("id") Long id);
}
