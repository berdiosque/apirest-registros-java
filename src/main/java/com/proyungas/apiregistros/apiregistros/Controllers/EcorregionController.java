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

import com.proyungas.apiregistros.apiregistros.Entities.Ecorregion;
import com.proyungas.apiregistros.apiregistros.Repositories.IEcorregionRepository;

@RestController
@RequestMapping("/ecorregiones")
public class EcorregionController {

    @Autowired
    private IEcorregionRepository ecorregionRepository;

    @GetMapping
    public List<Ecorregion> getAllEcorregiones(){
        return ecorregionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ecorregion getEcorregionById(@PathVariable Long id) {
        return ecorregionRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró la ecorregión con el id: " + id));
    }

    @PostMapping
    public Ecorregion creatEcorregion(@RequestBody Ecorregion ecorregion) {
        return ecorregionRepository.save(ecorregion);
    }
    
    @PutMapping("/{id}")
    public Ecorregion updateEcorregion(@PathVariable Long id, @RequestBody Ecorregion ecorregionDetails) {
        Ecorregion ecorregion = ecorregionRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró la ecorregión con el id: " + id));
        ecorregion.setNombre(ecorregionDetails.getNombre());
        return ecorregion;
    }

    @DeleteMapping("/{id}")
    public String deleteEcorregion(@PathVariable Long id){
        Ecorregion ecorregion = ecorregionRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("No se encontró la ecorregion con el id: " + id));
        ecorregionRepository.delete(ecorregion);
        return "La ecorregión se eliminó correctamente";
    }

}

