// TaskModel.java
package com.djalovic.taskHeroProba3.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tasks_table")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String taskText;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UsersModel user;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public UsersModel getUser() {
        return user;
    }

    public void setUser(UsersModel user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskModel taskModel = (TaskModel) o;
        return Objects.equals(id, taskModel.id) && Objects.equals(taskText, taskModel.taskText) && Objects.equals(user, taskModel.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskText, user);
    }

    @Override
    public String toString() {
        return "TaskModel{" +
                "id=" + id +
                ", taskText='" + taskText + '\'' +
                ", user=" + user +
                '}';
    }
}
