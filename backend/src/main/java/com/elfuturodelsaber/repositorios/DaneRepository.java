package com.elfuturodelsaber.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elfuturodelsaber.entidades.Dane;

@Repository
public interface DaneRepository extends JpaRepository<Dane, Long> {
}