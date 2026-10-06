package com.EjercicioAyudantia.ISoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {

    private Long id;
    private String titulo;
    private String prioridad;
    private String fechaLimite;
    private boolean completada = false;

}