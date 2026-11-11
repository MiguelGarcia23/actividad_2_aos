package es.unex.aos.inventario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
    public Producto getProductoById(@PathVariable Long id) {
        return productoRepository.findById(id).get();
    }

    @PutMapping("/{id}/reducir-stock/{cantidad}")
    public void reducirStock(@PathVariable Long id, @PathVariable int cantidad) {
        Producto producto = productoRepository.findById(id).get();
        producto.setStock(producto.getStock() - cantidad);
        productoRepository.save(producto);
    }
    
}
