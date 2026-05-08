package com.EjercicioAyudantia.ISoft.Service;

import com.EjercicioAyudantia.ISoft.Model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TaskService {

    List<Task> tasks = new ArrayList<>();


    private Long idTask = 1L;

    public Task createTask(Task task) {
        idTask ++;
        task.setId(idTask);
        task.setCompleted(false);
        tasks.add(task);
        return task;
    }

}
