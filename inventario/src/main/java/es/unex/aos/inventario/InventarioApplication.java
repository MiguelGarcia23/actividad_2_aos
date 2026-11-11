package es.unex.aos.inventario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.unex.aos.inventario.model.Producto;
import es.unex.aos.inventario.repository.ProductoRepository;
import jakarta.annotation.PostConstruct;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InventarioApplication {

	@Autowired ProductoRepository productoRepository;

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}

	@PostConstruct
	public void init() {

		List list = new ArrayList<>();

		Producto producto1 = new Producto("Producto 1", 10.0f, 1.0f, "Categoria 1", 3, 1L);
		list.add(producto1);

		Producto producto2 = new Producto("Producto 2", 20.0f, 2.0f, "Categoria 2", 3, 2L);
		list.add(producto2);
		
		Producto producto3 = new Producto("Producto 3", 30.0f, 3.0f, "Categoria 1", 5, 1L);
		list.add(producto3);

		productoRepository.saveAll(list);
		
	}

}
