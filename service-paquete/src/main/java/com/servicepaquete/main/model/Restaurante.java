package com.servicepaquete.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurante {



    private String nombre;
    private String descripcion;
    private String direccion;
    private String telefono;
    private String horario;
    private Long ID_paquete;

}
