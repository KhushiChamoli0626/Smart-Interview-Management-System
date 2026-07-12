package com.khushi.smart_interview_management.controller;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import com.khushi.smart_interview_management.entity.User;
import com.khushi.smart_interview_management.service.UserService;

import com.khushi.smart_interview_management.enums.UserRole;

import java.util.List;

@RestController     //Creates REST APIs
@RequestMapping("/users")      //Used to define a common URL path for all APIs in a controller.
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){     //Parameterized Constructor
        this.userService=userService;
    }

    //POST : save user
    @PostMapping
    public User saveUser(@Valid @RequestBody User users){
        return userService.saveUser(users);
    }

    //GET : fetch all users
    @GetMapping
    public List<User> getAllUsers(){      
        return userService.getAllUsers();
    }

    //PUT/UPDATE : updates user by id
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User users) {      
        return userService.updateUser(id, users);
    }

    //DELETE : deletes user by id
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
       userService.deleteUser(id);
       return "User deleted successfully";
    }

    //BULK : add all users together
    @PostMapping("/bulk")
    public List<User> addUsers(@Valid @RequestBody List<User> users){
       return userService.saveAllUsers(users);
    }

    //SEARCH users
    @GetMapping("/search")
    public List<User> searchRole(@RequestParam UserRole role){
       return userService.searchRole(role);
    }
}

