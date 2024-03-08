package com.elfuturodelsaber.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GradoDto {
    private Long id;
    private String descripcion;
    private DocenteDto docente;
    private List<EstudianteGradoDto> estudiantes;
}
