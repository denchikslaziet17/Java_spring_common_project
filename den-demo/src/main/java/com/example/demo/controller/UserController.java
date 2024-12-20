package com.example.demo.controller;



import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }


    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {return userService.getUserById(id);}

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        userService.createUser(user.getId(),user.getName(), user.getSurname(), user.getEmail(), user.getAge());
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.removeUser(id);
    }


}


