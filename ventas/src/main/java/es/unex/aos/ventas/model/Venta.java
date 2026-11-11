package es.unex.aos.ventas.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity 
public class Venta {
    
    @Id
    @GeneratedValue
    private Long id;
    private Long idCliente; // Referencia al cliente
    private float total;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "venta_id")
    private Set<LineaVenta> lineasVenta;

    public Venta() {
    }

    public Venta(Long idCliente, float total, Set<LineaVenta> lineasVenta) {
        this.idCliente = idCliente;
        this.total = total;
        this.lineasVenta = lineasVenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Set<LineaVenta> getLineasVenta() {
        return lineasVenta;
    }

    public void setLineasVenta(Set<LineaVenta> lineasVenta) {
        this.lineasVenta = lineasVenta;
    }

}
