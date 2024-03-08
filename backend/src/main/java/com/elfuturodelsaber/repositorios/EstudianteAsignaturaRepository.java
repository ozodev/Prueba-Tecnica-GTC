package com.elfuturodelsaber.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elfuturodelsaber.entidades.EstudianteAsignatura;
import com.elfuturodelsaber.entidades.EstudianteAsignaturaId;

public interface EstudianteAsignaturaRepository extends JpaRepository<EstudianteAsignatura, EstudianteAsignaturaId> {
}