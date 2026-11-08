package es.unex.aos.incidencias.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.unex.aos.incidencias.model.Incidencia;
import es.unex.aos.incidencias.repository.IncidenciaRepository;

@RestController 
@RequestMapping("/api/incidencias")
public class IncidenciaController {

    @Autowired IncidenciaRepository incidenciaRepository;

    @GetMapping
    public Iterable<Incidencia> getIncidencias() {
        return incidenciaRepository.findAll();
    }

    // Basado en Lab 1.es.md (Parte 4)
    @GetMapping("/{id}")
    public Incidencia getIncidencia(@PathVariable Long id){
        return incidenciaRepository.findById(id).get();
    }
    
}
