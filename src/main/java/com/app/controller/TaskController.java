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
    public String getTasks(@RequestParam(required = false, defaultValue = "all") String filter, Model model) {
        List<Task> tasks;
        
        switch (filter) {
            case "active":
                tasks = taskService.getActiveTasks();
                break;
            case "completed":
                tasks = taskService.getCompletedTasks();
                break;
            default:
                tasks = taskService.getAllTasks();
                break;
        }

        model.addAttribute("tasks", tasks);
        model.addAttribute("activeFilter", filter);
        model.addAttribute("allCount", taskService.getAllTasks().size());
        model.addAttribute("activeCount", taskService.getActiveTasks().size());
        model.addAttribute("completedCount", taskService.getCompletedTasks().size());

        return "tasks";
    }

    @PostMapping
    public String CreateTask(@RequestParam String title, @RequestParam(required = false, defaultValue = "all") String filter) {
        taskService.createTask(title);
        return "redirect:/?filter=" + filter;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id, @RequestParam(required = false, defaultValue = "all") String filter) {
        taskService.deleteTask(id);
        return "redirect:/?filter=" + filter;
    }

    @GetMapping("toggle/{id}")
    public String toggleTask(@PathVariable Long id, @RequestParam(required = false, defaultValue = "all") String filter) {
        taskService.toggleTask(id);
        return "redirect:/?filter=" + filter;
    }
}
