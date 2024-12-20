package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserById(Long userId) throws Exception {
        Optional<User> optional = userRepository.findById(userId);

        if(optional.isPresent()) {return optional.get();}
        throw new Exception("No user with id :" + userId);

    }
}
