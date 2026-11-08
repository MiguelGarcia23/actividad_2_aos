package es.unex.aos.incidencias.repository;

import org.springframework.data.repository.CrudRepository;

import es.unex.aos.incidencias.model.Incidencia;

public interface IncidenciaRepository extends CrudRepository<Incidencia, Long> {
    
}
