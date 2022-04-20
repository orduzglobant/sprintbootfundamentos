package com.fundamentos.sprintboot.fundamentos.controller;

import com.fundamentos.sprintboot.fundamentos.caseuse.GetUser;
import com.fundamentos.sprintboot.fundamentos.entity.User;
import com.fundamentos.sprintboot.fundamentos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    //create, get, update, delete
    private GetUser getUser;

    @Autowired
    private UserService userService;

    public UserRestController(GetUser getUser) {
        this.getUser = getUser;
    }

    @GetMapping("/")
    List<User> get(){
        //return userService.getAllUsers();
       return  getUser.getAll();
    }

}
