package com.proyungas.apiregistros.apiregistros.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyungas.apiregistros.apiregistros.Entities.Especie;
import com.proyungas.apiregistros.apiregistros.Repositories.IEspecieRepository;

@RestController
@RequestMapping("/especies")
public class EspecieController {

    @Autowired
    private IEspecieRepository especieRepository;

    @GetMapping
    public List<Especie> getAllEspecies(){
        return especieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Especie getEspecieById(@PathVariable Long id) {
        return especieRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró la especie con el id: " + id));
    }

    @PostMapping
    public Especie createEspecie(@RequestBody Especie especie) {
        return especieRepository.save(especie);
    }
    
    @PutMapping("/{id}")
    public Especie updateEspecie(@PathVariable Long id, @RequestBody Especie especieDetails) {
        Especie especie = especieRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró la especie con el id: " + id));
        especie.setNombre(especieDetails.getNombre());
        especie.setDescripcion(especieDetails.getDescripcion());
        especie.setCategoriaAmenaza(especieDetails.getCategoriaAmenaza());
        return especie;
    }

    @DeleteMapping("/{id}")
    public String deleteEspecie(@PathVariable Long id){
        Especie especie = especieRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("No se encontró la especie con el id: " + id));
        especieRepository.delete(especie);
        return "La especie se eliminó correctamente";
    }

}

