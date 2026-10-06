package com.EjercicioAyudantia.ISoft.controller;
import com.EjercicioAyudantia.ISoft.model.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private List<Task> tasks = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Task>> getTasks(
            @RequestParam(required = false) String prioridad,
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String fechaLimite) {

        List<Task> filteredTasks = new ArrayList<>();

        for (Task t : tasks) {
            boolean matchesPrioridad = prioridad == null || t.getPrioridad().equals(prioridad);
            boolean matchesTitulo = titulo == null || t.getTitulo().toLowerCase().contains(titulo.toLowerCase());
            boolean matchesFechaLimite = fechaLimite == null || (t.getFechaLimite() != null && t.getFechaLimite().equals(fechaLimite));

            if (matchesPrioridad && matchesTitulo && matchesFechaLimite) {
                filteredTasks.add(t);
            }
        }

        return ResponseEntity.ok(filteredTasks);
    }


}

