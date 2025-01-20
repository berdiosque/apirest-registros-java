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

import com.proyungas.apiregistros.apiregistros.Entities.PaisajeProductivoProtegido;
import com.proyungas.apiregistros.apiregistros.Repositories.IPaisajeProductivoProtegidoRepository;

@RestController
@RequestMapping("/ppps")
public class PaisajeProductivoProtegidoController {

    @Autowired
    private IPaisajeProductivoProtegidoRepository pppRepository;

    @GetMapping
    public List<PaisajeProductivoProtegido> getAllRegistros(){
        return pppRepository.findAll();
    }

    @GetMapping("/{id}")
    public PaisajeProductivoProtegido getPaisajeProductivoProtegidoById(@PathVariable Long id) {
        return pppRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el Paisaje Productivo Protegido con el id: " + id));
    }

    @PostMapping
    public PaisajeProductivoProtegido createPaisajeProductivoProtegido(@RequestBody PaisajeProductivoProtegido ppp) {
        return pppRepository.save(ppp);
    }
    
    @PutMapping("/{id}")
    public PaisajeProductivoProtegido updatePaisajeProductivoProtegido(@PathVariable Long id, @RequestBody PaisajeProductivoProtegido pppDetails) {
        PaisajeProductivoProtegido ppp = pppRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el Paisaje Productivo Protegido con el id: " + id));
        ppp.setNombre(pppDetails.getNombre());
        ppp.setDescripcion(pppDetails.getDescripcion());
        ppp.setEcorregiones(pppDetails.getEcorregiones());

        return ppp;
    }

    @DeleteMapping("/{id}")
    public String deletePaisajeProductivoProtegido(@PathVariable Long id){
        PaisajeProductivoProtegido ppp = pppRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("No se encontró el Paisaje Productivo Protegido con el id: " + id));
        pppRepository.delete(ppp);
        return "El Paisaje Productivo Protegido se eliminó correctamente";
    }

}

