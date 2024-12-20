package com.example.demo.service;

import com.example.demo.exceptions.UserAlreadyExistsException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.getAllUsers();
    }

    public void createUser(Long id ,String name, String surname, String email,int age) {
        try {
            userRepository.addUser(id, name, surname, email, age);
        } catch (UserAlreadyExistsException e) {
            throw new UserAlreadyExistsException("user already exists");
        }
    }

    public void removeUser(Long id) {
        try {
            userRepository.deleteUser(id);
        }
        catch (UserNotFoundException e) {
            throw new UserNotFoundException("can't delete , id not found");
        }
    }

    public User getUserById(Long id)
    {
        if (userRepository.getUserById(id) == null){
        throw new UserNotFoundException("user is not found");
        }

        return userRepository.getUserById(id);
    }
}




