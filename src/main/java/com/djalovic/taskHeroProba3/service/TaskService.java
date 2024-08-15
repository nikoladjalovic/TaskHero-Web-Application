// TaskService.java
package com.djalovic.taskHeroProba3.service;

import com.djalovic.taskHeroProba3.model.TaskModel;
import com.djalovic.taskHeroProba3.model.UsersModel;
import com.djalovic.taskHeroProba3.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskModel> findTasksByUser(UsersModel user) {
        return taskRepository.findByUser(user);
    }

    public TaskModel save(TaskModel task) {
        return taskRepository.save(task);
    }

    public void deleteById(Integer id) {
        taskRepository.deleteById(id);
    }

    public TaskModel findById(Integer id) {
        return taskRepository.findById(id).orElse(null);
    }
}
