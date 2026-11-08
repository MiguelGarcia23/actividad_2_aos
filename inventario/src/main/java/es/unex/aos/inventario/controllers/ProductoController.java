package es.unex.aos.inventario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.unex.aos.inventario.model.Producto;
import es.unex.aos.inventario.repository.ProductoRepository;

@RestController 
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired 
    private ProductoRepository productoRepository;

    @GetMapping
    public Iterable<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }
    
}
