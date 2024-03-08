package com.elfuturodelsaber.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AsignaturaDto {
    private Long id;
    private String descripcion;
    private Long docenteId;
}