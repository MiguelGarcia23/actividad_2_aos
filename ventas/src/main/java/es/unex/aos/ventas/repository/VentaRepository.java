package es.unex.aos.ventas.repository;

import org.springframework.data.repository.CrudRepository;

import es.unex.aos.ventas.model.Venta;

public interface VentaRepository extends CrudRepository<Venta, Long> {
    
}
