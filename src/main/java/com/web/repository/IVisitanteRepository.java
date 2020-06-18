package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.entities.Visitante;

public interface IVisitanteRepository extends JpaRepository<Visitante, Integer> {

}
