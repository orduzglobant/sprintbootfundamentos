package com.fundamentos.sprintboot.fundamentos.controller;

import com.fundamentos.sprintboot.fundamentos.caseuse.CreateUser;
import com.fundamentos.sprintboot.fundamentos.caseuse.DeleteUser;
import com.fundamentos.sprintboot.fundamentos.caseuse.GetUser;
import com.fundamentos.sprintboot.fundamentos.caseuse.UpdateUser;
import com.fundamentos.sprintboot.fundamentos.entity.User;
import com.fundamentos.sprintboot.fundamentos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    //create, get, update, delete
    private GetUser getUser;
    @Autowired
    private CreateUser createUser;
    @Autowired
    private DeleteUser deleteUser;

    @Autowired
    private UpdateUser updateUser;

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

    @PostMapping("/")
    ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(createUser.save(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteUser(@PathVariable Long id){
        deleteUser.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    ResponseEntity<User> replaceUser(@RequestBody User user, @PathVariable Long id){
        return new ResponseEntity<>(updateUser.update(user, id), HttpStatus.OK);
    }

    @GetMapping("/pageable")
    public List<User> getUserPageable(@RequestParam int page ,@RequestParam int size){
        return userService.findAll(PageRequest.of(page, size));
    }

}
