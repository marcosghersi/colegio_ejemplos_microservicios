package com.colegio.machado.repositories.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ALUMNOS")
public class AlumnoEntity {
    private static final String ID_SEQUENCE = "ID_SEQUENCE";
    /**
     * ID único de la entidad
     */
    @Id
    @GeneratedValue(generator = ID_SEQUENCE, strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = ID_SEQUENCE,
            sequenceName = ID_SEQUENCE,
            allocationSize = 1       // 👈 debe coincidir con INCREMENT BY 1 del SQL
    )
    private Long id;

    /**
     * Nombre del Alumno
     */
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private Integer edad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "clase_id")
    private ClaseEntity clase;
}
