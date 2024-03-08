package com.elfuturodelsaber.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elfuturodelsaber.entidades.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}