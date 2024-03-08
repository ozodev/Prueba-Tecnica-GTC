package com.elfuturodelsaber.entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class EstudianteAsignaturaId implements Serializable {
    @Column(name = "id_estudiante")
    private Long estudianteId;

    @Column(name = "id_asignatura")
    private Long asignaturaId;
}