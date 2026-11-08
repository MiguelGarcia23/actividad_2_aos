package es.unex.aos.contenido_digital.repository;

import org.springframework.data.repository.CrudRepository;

import es.unex.aos.contenido_digital.model.ContenidoDigital;

public interface ContenidoRepository extends CrudRepository<ContenidoDigital, Long> {
    
}
