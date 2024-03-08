package com.elfuturodelsaber.entidades;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_tipodocumento")
    private TipoDocumento tipoDocumento;
    private String numeroDocumento;
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    @OneToMany(mappedBy = "docente")
    private List<Asignatura> asignaturas;
    private String gradoEscolaridad;
    @ManyToOne
    @JoinColumn(name = "id_gradoResponsable",foreignKey = @ForeignKey(name = "docente_grado"))
    private Grado gradoResponsable;
    private String email;
    private String fijo;
    private String celular;
}