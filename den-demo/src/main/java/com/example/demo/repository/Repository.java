package com.example.demo.repository;

import com.example.demo.model.User;

import java.util.List;
import java.util.Map;

public interface Repository {
    public List<User> getAllUsers();
    public void addUser(Long id , String name, String surname, String email , int age);
    public void deleteUser(Long id);

    public User getUserById(Long id);
}
