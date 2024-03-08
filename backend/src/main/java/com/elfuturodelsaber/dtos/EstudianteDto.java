package com.elfuturodelsaber.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstudianteDto {
    private Long id;
    private String numeroDocumento;
    private String nombres;
    private String apellidos;
    private String email;
    private List<Long> asignaturasIds;
}