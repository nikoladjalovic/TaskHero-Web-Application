package com.djalovic.taskHeroProba3.repository;

import com.djalovic.taskHeroProba3.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersModel, Integer> {
     Optional<UsersModel> findByUsernameAndPassword(String username, String password);
     Optional<UsersModel> findFirstByUsername(String username);
}
