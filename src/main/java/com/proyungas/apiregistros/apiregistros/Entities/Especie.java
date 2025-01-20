package com.proyungas.apiregistros.apiregistros.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Especie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;

    @ManyToOne
    private CategoriaAmenaza categoriaAmenaza;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CategoriaAmenaza getCategoriaAmenaza() {
        return categoriaAmenaza;
    }

    public void setCategoriaAmenaza(CategoriaAmenaza categoriaAmenaza) {
        this.categoriaAmenaza = categoriaAmenaza;
    }
    
    

    

}
