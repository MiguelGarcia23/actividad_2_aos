package es.unex.aos.servicio_central.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import es.unex.aos.servicio_central.dto.VentaDTO;
import es.unex.aos.servicio_central.dto.LineaVentaDTO;

@RestController
@RequestMapping("/api/servicio-central")
public class ServicioCentralController {

    @Autowired RestTemplate restTemplate;

    // MICROSERVICIO INVENTARIO
    @GetMapping("/inventario")
    @HystrixCommand(fallbackMethod = "fallbackInventario")
    public String getInventario() {
        String url = "http://inventario-service/api/productos";
        return restTemplate.getForObject(url, String.class);
    }

    public String fallbackInventario() {
        return "El servicio de inventario no está disponible en este momento. Por favor, inténtelo más tarde.";
    }

    @GetMapping("/producto-con-imagen/{id}")
    @HystrixCommand(fallbackMethod = "fallbackProductoConImagen")
    public Map<String, Object> getProductoConImagen(@PathVariable Long id) {
        
        // Consultar producto
        String urlProducto = "http://inventario-service/api/productos/" + id;
        Map<String, Object> producto = restTemplate.getForObject(urlProducto, Map.class);

        // Consultar imagen
        if (producto != null && producto.get("idContenido") != null) {
            Long idContenido = Long.valueOf(producto.get("idContenido").toString());
            String urlContenido = "http://contenido-digital-service/api/contenido-digital/" + idContenido;

            // Obtener imagen y agregarla a la respuesta
            Map<String, Object> contenido = restTemplate.getForObject(urlContenido, Map.class);
            producto.put("imagen", contenido);
        }
        return producto;
    }

    public Map<String, Object> fallbackProductoConImagen(Long id) {
        Map<String, Object> error = new java.util.HashMap<>();
        error.put("error", "No se pudo recuperar la información completa del producto.");
        return error;
    }

    // MICROSERVICIO VENTAS
    @GetMapping("/ventas")
    @HystrixCommand(fallbackMethod = "fallbackVentas")
    public String getVentas() {
        String url = "http://ventas-service/api/ventas";
        return restTemplate.getForObject(url, String.class);
    }

    public String fallbackVentas() {
        return "El servicio de ventas no está disponible en este momento. Por favor, inténtelo más tarde.";
    }

    @PostMapping("/ventas")
    @HystrixCommand(fallbackMethod = "fallbackVentasCrear")
    public String registraVenta(@RequestBody VentaDTO ventaDTO) {

        // Actualizar stock
        if (ventaDTO.lineasVenta != null) {
            for (LineaVentaDTO linea : ventaDTO.lineasVenta) {
                String urlInventario = "http://inventario-service/api/productos/" + linea.idProducto + "/reducir-stock/" + linea.cantidad;
                restTemplate.put(urlInventario, null);
            }
        }

        // Registrar venta
        String url = "http://ventas-service/api/ventas";
        return restTemplate.postForObject(url, ventaDTO, String.class);
    }

    public String fallbackVentasCrear(VentaDTO ventaDTO) {
        return "El servicio de ventas no está disponible en este momento. Por favor, inténtelo más tarde.";
    }

    // MICROSERVICIO CONTENIDO DIGITAL
    @GetMapping("/contenido-digital")
    @HystrixCommand(fallbackMethod = "fallbackContenidoDigital")
    public String getContenidoDigital() {
        String url = "http://contenido-digital-service/api/contenido-digital";
        return restTemplate.getForObject(url, String.class);
    }

    public String fallbackContenidoDigital() {
        return "El servicio de contenido digital no está disponible en este momento. Por favor, inténtelo más tarde.";
    }

    // MICROSERVICIO INCIDENCIAS
    @GetMapping("/incidencias")
    @HystrixCommand(fallbackMethod = "fallbackIncidencias")
    public String getIncidencias() {
        String url = "http://incidencias-service/api/incidencias";
        return restTemplate.getForObject(url, String.class);
    }

    public String fallbackIncidencias() {
        return "El servicio de incidencias no está disponible en este momento. Por favor, inténtelo más tarde.";
    }

    // DASHBOARD
    @GetMapping("/dashboard")
    @HystrixCommand(fallbackMethod = "fallbackDashboard")
    public String getDashboard() {
    
        String urlVentas = "http://ventas-service/api/ventas";
        String urlIncidencias = "http://incidencias-service/api/incidencias";

        String ventas = restTemplate.getForObject(urlVentas, String.class);
        String incidencias = restTemplate.getForObject(urlIncidencias, String.class);

        return "Dashboard:\n" + "Ventas: " + ventas + "\n" + "Incidencias: " + incidencias;
    
    }

    public String fallbackDashboard() {
        return "El Dashboard no está disponible en este momento. Por favor, inténtelo más tarde.";
    }
    
}