package com.djalovic.taskHeroProba3.controller;

import com.djalovic.taskHeroProba3.model.TaskModel;
import com.djalovic.taskHeroProba3.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.djalovic.taskHeroProba3.model.UsersModel;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("")
    public String getIndexPage(Model model){
        model.addAttribute("loginRequest", new UsersModel());
        return "index";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest",new UsersModel());
        return "register";
    }

    @GetMapping("/contact")
    public String getContactPage(){
        return "contact";
    }

    @GetMapping("/about")
    public String getAboutPage(){
        return "about";
    }

    @GetMapping("/success")
    public String getSuccessPage(){
        return "success";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UsersModel usersModel){
        System.out.println("register request" + usersModel);
        UsersModel registeredUser = usersService.registerUser(usersModel.getFirstName(),usersModel.getLastName(),usersModel.getAge(),usersModel.getUsername(),usersModel.getPassword());
        if(registeredUser == null){
            return "errorRegister";
        }else {
            return "redirect:/success";
        }
    }

    @PostMapping("")
    public String login(@ModelAttribute UsersModel usersModel, Model model) {
        System.out.println("login request" + usersModel);
        UsersModel authenticated = usersService.authenticate(usersModel.getUsername(), usersModel.getPassword());
        if (authenticated != null) {
            model.addAttribute("username", authenticated.getUsername());
            return "redirect:/tasks?username=" + authenticated.getUsername();
        } else {
            return "errorLogin";
        }
    }

}
