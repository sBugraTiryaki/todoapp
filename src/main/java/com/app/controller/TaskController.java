package com.app.controller;

import com.app.models.Task;
import com.app.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks(Model model){

        List<Task> tasks = taskService.getAllTasks();

        model.addAttribute("tasks", tasks);

        return "tasks";

    }

    @PostMapping
    public String CreateTask(@RequestParam String title) {

        taskService.createTask(title);

        return "redirect:/";

    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);

        return "redirect:/";

    }

    @GetMapping("toggle/{id}")
    public String toggleTask(@PathVariable Long id) {

        taskService.toggleTask(id);

        return "redirect:/";

    }

}