package com.elfuturodelsaber.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elfuturodelsaber.entidades.Docente;

public interface DocenteRepository extends JpaRepository<Docente, Long> {
}