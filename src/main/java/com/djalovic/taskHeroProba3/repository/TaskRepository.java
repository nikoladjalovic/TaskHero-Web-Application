// TaskRepository.java
package com.djalovic.taskHeroProba3.repository;

import com.djalovic.taskHeroProba3.model.TaskModel;
import com.djalovic.taskHeroProba3.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskModel, Integer> {
    List<TaskModel> findByUser(UsersModel user);
}
