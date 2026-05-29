package com.colegio.machado.repositories.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "CLASE", schema = "ESCUELADB")
public class ClaseEntity {

    private static final String ID_SEQUENCE = "CLASE_ID_SEQUENCE";

    /**
     * ID único de la entidad
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ID_SEQUENCE)
    @SequenceGenerator(
            name = ID_SEQUENCE,
            sequenceName = "ESCUELADB.CLASE_ID_SEQUENCE",
            allocationSize = 1
    )
    private Long id;

    /**
     * Nombre de la clase
     */
    @Column(name = "NOMBRE")
    private String clase;
    /**
     * Profesor de la clase
     */
    @Column(name = "PROFESOR")
    private String profesor;


    @OneToMany(mappedBy = "clase", fetch = FetchType.LAZY)
    private List<AlumnoEntity> alumnos;

}
