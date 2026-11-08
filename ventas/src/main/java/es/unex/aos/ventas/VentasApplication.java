package es.unex.aos.ventas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.unex.aos.ventas.model.LineaVenta;
import es.unex.aos.ventas.model.Venta;
import es.unex.aos.ventas.repository.VentaRepository;
import jakarta.annotation.PostConstruct;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VentasApplication {

	@Autowired VentaRepository ventaRepository;

	public static void main(String[] args) {
		SpringApplication.run(VentasApplication.class, args);
	}

	@PostConstruct 
	public void init() {

		List list = new ArrayList<>();

		Set<LineaVenta> set = new HashSet<>();
		set.add(new LineaVenta(1l, 2, 10.0f));
		set.add(new LineaVenta(2l, 3, 20.0f));
		set.add(new LineaVenta(3l, 4, 30.0f));

		list.add(new Venta(1l, 200.0f, set));
		list.add(new Venta(2l, 200.0f, set));

		ventaRepository.saveAll(list);

	}

}
