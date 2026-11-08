package es.unex.aos.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import es.unex.aos.inventario.model.Producto;

@RestResource(path= "productos", rel="productos")
public interface ProductoRepository extends CrudRepository<Producto, Long> {


    
}
