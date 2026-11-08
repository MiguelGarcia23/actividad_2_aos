package es.unex.aos.contenido_digital.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity 
public class ContenidoDigital {

    @Id 
    @GeneratedValue 
    private Long id;
    private String tipo;    // Imagen o video
    private String urlArchivo; // URL del archivo de imagen o video

    public ContenidoDigital() {
    }

    public ContenidoDigital(String tipo, String urlArchivo) {
        this.tipo = tipo;
        this.urlArchivo = urlArchivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUrlArchivo() {
        return urlArchivo;
    }

    public void setUrlArchivo(String urlArchivo) {
        this.urlArchivo = urlArchivo;
    }
    
}
