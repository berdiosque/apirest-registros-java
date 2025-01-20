package com.proyungas.apiregistros.apiregistros.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyungas.apiregistros.apiregistros.Entities.Especie;

public interface IEspecieRepository extends JpaRepository <Especie, Long> {

}
