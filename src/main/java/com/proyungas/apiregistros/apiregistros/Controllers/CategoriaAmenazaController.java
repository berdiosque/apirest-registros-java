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

import com.proyungas.apiregistros.apiregistros.Entities.CategoriaAmenaza;
import com.proyungas.apiregistros.apiregistros.Repositories.ICategoriaAmenazaRepository;

@RestController
@RequestMapping("/cateogorias")
public class CategoriaAmenazaController {
    @Autowired
    private ICategoriaAmenazaRepository categoriaAmenazaRepository;

    @GetMapping
    public List<CategoriaAmenaza> getAllCategoriasAmenaza(){
        return categoriaAmenazaRepository.findAll();
    }

    @GetMapping("/{id}")
    public CategoriaAmenaza getCategoriaAmenazaById(@PathVariable Long id) {
        return categoriaAmenazaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró la categoría con el id: " + id));
    }

    @PostMapping
    public CategoriaAmenaza createCategoriaAmenaza(@RequestBody CategoriaAmenaza categoriaAmenaza) {
        return categoriaAmenazaRepository.save(categoriaAmenaza);
    }
    
    @PutMapping("/{id}")
    public CategoriaAmenaza updateCategoriaAmenaza(@PathVariable Long id, @RequestBody CategoriaAmenaza categoriaDetails) {
        CategoriaAmenaza categoriaAmenaza = categoriaAmenazaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró la categoría con el id: " + id));
        categoriaAmenaza.setNombre(categoriaDetails.getNombre());
        categoriaAmenaza.setDescripcion(categoriaDetails.getDescripcion());
        categoriaAmenaza.setSiglas(categoriaDetails.getSiglas());
        return categoriaAmenaza;
    }

    @DeleteMapping("/{id}")
    public String deleteCategoriaAmenaza(@PathVariable Long id){
        CategoriaAmenaza categoriaAmenaza = categoriaAmenazaRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("No se encontró la categoría con el id: " + id));
        categoriaAmenazaRepository.delete(categoriaAmenaza);
        return "La categoría se eliminó correctamente";
    }

}

