package es.unex.aos.contenido_digital;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.unex.aos.contenido_digital.model.ContenidoDigital;
import es.unex.aos.contenido_digital.repository.ContenidoRepository;
import jakarta.annotation.PostConstruct;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ContenidoDigitalApplication {

	@Autowired ContenidoRepository contenidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ContenidoDigitalApplication.class, args);
	}

	@PostConstruct
	public void init() {

		List list = new ArrayList<>();

		ContenidoDigital contenido1 = new ContenidoDigital("Imagen", "https://example.com/imagen1.jpg");
		list.add(contenido1);
		
		ContenidoDigital contenido2 = new ContenidoDigital("Video", "https://example.com/video1.mp4");
		list.add(contenido2);

		contenidoRepository.saveAll(list);

	}

}
