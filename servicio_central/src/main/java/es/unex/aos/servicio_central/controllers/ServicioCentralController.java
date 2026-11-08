package es.unex.aos.servicio_central.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

    // MICROSERVICIO VENTAS
    @PostMapping("/ventas")
    @HystrixCommand(fallbackMethod = "fallbackVentas")
    public String registraVenta(@RequestBody Object ventaDTO) {
        String url = "http://ventas-service/api/ventas";
        return restTemplate.postForObject(url, ventaDTO, String.class);
    }

    public String fallbackVentas() {
        return "El servicio de ventas no está disponible en este momento. Por favor, inténtelo más tarde.";
    }

    // MICROSERVICIO CONTENIDO DIGITAL
    @GetMapping("/contenido-digital")
    @HystrixCommand(fallbackMethod = "fallbackContenidoDigital")
    public String getContenidoDigital() {
        String url = "http://contenido-digital-service/api/contenido";
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
