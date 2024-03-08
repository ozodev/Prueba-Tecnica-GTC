package com.elfuturodelsaber.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstudianteAsignaturaDto {
    private Long estudianteId;
    private Long asignaturaId;
    private Double nota;
    private Integer periodo;
}