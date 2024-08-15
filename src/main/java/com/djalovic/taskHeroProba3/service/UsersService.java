package com.djalovic.taskHeroProba3.service;

import com.djalovic.taskHeroProba3.model.UsersModel;
import com.djalovic.taskHeroProba3.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public UsersModel registerUser(String firstName, String lastName, int age, String username, String password){
        if(usersRepository.findFirstByUsername(username).isPresent()){
            System.out.println("Duplicate login");
            return null;
        }
        UsersModel usersModel = new UsersModel();
        usersModel.setFirstName(firstName);
        usersModel.setLastName(lastName);
        usersModel.setAge(age);
        usersModel.setUsername(username);
        usersModel.setPassword(password);
        return usersRepository.save(usersModel);
    }


    public UsersModel authenticate (String username, String password){
        return usersRepository.findByUsernameAndPassword(username, password).orElse(null);
    }

    public UsersModel findByUsername(String username) {
        return usersRepository.findFirstByUsername(username).orElse(null);
    }


}
