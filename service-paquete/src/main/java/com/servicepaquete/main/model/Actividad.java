package com.servicepaquete.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actividad {

    private String nombre;
    private String descripcion;
    private String fecha;
    private String hora;
    private String lugar;
    private String costo;
    private String imagenes;
    private Long ID_paquete;
}
