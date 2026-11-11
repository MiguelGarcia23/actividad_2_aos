package es.unex.aos.servicio_central.dto;

import java.util.Set;

import es.unex.aos.servicio_central.dto.LineaVentaDTO;

public class VentaDTO {
    public Long idCliente;
    public float total;
    public Set<LineaVentaDTO> lineasVenta;
}