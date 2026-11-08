package es.unex.aos.contenido_digital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.unex.aos.contenido_digital.model.ContenidoDigital;
import es.unex.aos.contenido_digital.repository.ContenidoRepository;

@RestController 
@RequestMapping("/api/contenido_digital")
public class ContenidoController {

    @Autowired 
    private ContenidoRepository contenidoRepository;

    @GetMapping
    public Iterable<ContenidoDigital> getContenidoDigital() {
        return contenidoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ContenidoDigital getContenidoById(Long id) {
        return contenidoRepository.findById(id).get();
    }
    
}
