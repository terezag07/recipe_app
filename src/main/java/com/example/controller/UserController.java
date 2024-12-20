package com.example.controller;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/createuser")
    public User createUser(@RequestBody User user) throws Exception{

        User userExists = userRepository.findByEmail(user.getEmail());
        if(userExists != null){
            throw new Exception("user exists with" + user.getEmail());
        }
        System.out.println("Received User: " + user);
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        userRepository.deleteById(userId);
        return "user deleted";
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }


}
