package com.proyungas.apiregistros.apiregistros.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private PaisajeProductivoProtegido paisajeProductivoProtegido;

    @ManyToOne
    private Especie especie;

    private String fotoUrl;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaisajeProductivoProtegido getPaisajeProductivoProtegido() {
        return paisajeProductivoProtegido;
    }

    public void setPaisajeProductivoProtegido(PaisajeProductivoProtegido paisajeProductivoProtegido) {
        this.paisajeProductivoProtegido = paisajeProductivoProtegido;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    


}
