package com.proyungas.apiregistros.apiregistros.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyungas.apiregistros.apiregistros.Entities.Registro;

public interface IRegistroRepository extends JpaRepository<Registro, Long>{

}
