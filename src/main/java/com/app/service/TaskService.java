package com.app.service;

import com.app.models.Task;
import com.app.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    
    public List<Task> getCompletedTasks() {
        return taskRepository.findAll().stream()
                .filter(Task::isCompleted)
                .collect(Collectors.toList());
    }
    
    public List<Task> getActiveTasks() {
        return taskRepository.findAll().stream()
                .filter(task -> !task.isCompleted())
                .collect(Collectors.toList());
    }

    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task ID: " + id));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}
