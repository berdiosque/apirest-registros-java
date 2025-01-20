package com.proyungas.apiregistros.apiregistros.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyungas.apiregistros.apiregistros.Repositories.IRegistroRepository;
import com.proyungas.apiregistros.apiregistros.Entities.Registro;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/registros")
public class RegistroController {

    @Autowired
    private IRegistroRepository registroRepository;

    @GetMapping
    public List<Registro> getAllRegistros(){
        return registroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Registro getRegistroById(@PathVariable Long id) {
        return registroRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el registro con el id: " + id));
    }

    @PostMapping
    public Registro createRegistro(@RequestBody Registro registro) {
        return registroRepository.save(registro);
    }
    
    @PutMapping("/{id}")
    public Registro updateRegistro(@PathVariable Long id, @RequestBody Registro registroDetails) {
        Registro registro = registroRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el registro con el id: " + id));
        registro.setEspecie(registroDetails.getEspecie());
        registro.setPaisajeProductivoProtegido(registroDetails.getPaisajeProductivoProtegido());
        registro.setFotoUrl(registroDetails.getFotoUrl());
        return registro;
    }

    @DeleteMapping("/{id}")
    public String deleteRegistro(@PathVariable Long id){
        Registro registro = registroRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("No se encontró el registro con el id: " + id));
        registroRepository.delete(registro);
        return "El registro se eliminó correctamente";
    }

}
