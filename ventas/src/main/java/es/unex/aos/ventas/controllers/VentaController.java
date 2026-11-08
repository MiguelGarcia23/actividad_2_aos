package es.unex.aos.ventas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.unex.aos.ventas.model.Venta;
import es.unex.aos.ventas.repository.VentaRepository;

@RestController 
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaRepository ventaRepository;

    @GetMapping
    public Iterable<Venta> getVentas() {
        return ventaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Venta getVentaById(@PathVariable Long id) {
        return ventaRepository.findById(id).get();
    }

    @PostMapping 
    public Venta createVenta(@RequestBody Venta venta) {
        return ventaRepository.save(venta);
    }
    
}
