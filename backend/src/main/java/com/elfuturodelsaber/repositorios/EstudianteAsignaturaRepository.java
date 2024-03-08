package com.elfuturodelsaber.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elfuturodelsaber.entidades.EstudianteAsignatura;
import com.elfuturodelsaber.entidades.EstudianteAsignaturaId;

public interface EstudianteAsignaturaRepository extends JpaRepository<EstudianteAsignatura, EstudianteAsignaturaId> {

    List<EstudianteAsignatura> findByEstudianteId(Long estudianteId);

}