// TaskController.java
package com.djalovic.taskHeroProba3.controller;

import com.djalovic.taskHeroProba3.model.TaskModel;
import com.djalovic.taskHeroProba3.model.UsersModel;
import com.djalovic.taskHeroProba3.service.TaskService;
import com.djalovic.taskHeroProba3.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UsersService usersService;

    @GetMapping
    public String getTasks(@RequestParam String username, Model model) {
        UsersModel user = usersService.findByUsername(username);
        if (user != null) {
            List<TaskModel> tasks = taskService.findTasksByUser(user);
            model.addAttribute("tasks", tasks);
            model.addAttribute("username", username);
        }
        return "tasks";
    }

    @PostMapping
    public String addTask(@RequestParam String taskText, @RequestParam String username) {
        UsersModel user = usersService.findByUsername(username);
        if (user != null) {
            TaskModel task = new TaskModel();
            task.setTaskText(taskText);
            task.setUser(user);
            taskService.save(task);
        }
        return "redirect:/tasks?username=" + username;
    }

    @PostMapping("/delete")
    public String deleteTask(@RequestParam Integer id, @RequestParam String username) {
        taskService.deleteById(id);
        return "redirect:/tasks?username=" + username;
    }

    @PostMapping("/update")
    public String updateTask(@RequestParam Integer id, @RequestParam String taskText, @RequestParam String username) {
        TaskModel task = taskService.findById(id);
        if (task != null) {
            task.setTaskText(taskText);
            taskService.save(task);
        }
        return "redirect:/tasks?username=" + username;
    }
}
