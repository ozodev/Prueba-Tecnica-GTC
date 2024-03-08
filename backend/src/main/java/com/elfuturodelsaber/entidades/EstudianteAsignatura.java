package com.elfuturodelsaber.entidades;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiante_asignatura")
public class EstudianteAsignatura {

    @EmbeddedId
    private EstudianteAsignaturaId id;

    @ManyToOne
    @MapsId("estudianteId") // Esto le indica a JPA cómo mapear el id compuesto en la relación
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne
    @MapsId("asignaturaId") // Esto le indica a JPA cómo mapear el id compuesto en la relación
    @JoinColumn(name = "id_asignatura")
    private Asignatura asignatura;

    private Double nota;
    private Integer periodo;
}