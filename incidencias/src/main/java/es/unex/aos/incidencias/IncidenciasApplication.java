package es.unex.aos.incidencias;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.unex.aos.incidencias.model.Incidencia;
import es.unex.aos.incidencias.repository.IncidenciaRepository;
import jakarta.annotation.PostConstruct;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class IncidenciasApplication {

	@Autowired IncidenciaRepository incidenciaRepository;

	public static void main(String[] args) {
		SpringApplication.run(IncidenciasApplication.class, args);
	}

	@PostConstruct
	public void init() {

		List list = new ArrayList<>();

		Incidencia incidencia1 = new Incidencia("Cliente 1", "Descripción 1", "Abierta");
		list.add(incidencia1);

		Incidencia incidencia2 = new Incidencia("Cliente 2", "Descripción 2", "En proceso");
		list.add(incidencia2);

		incidenciaRepository.saveAll(list);

	}

}
