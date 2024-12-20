package com.example.service;

import com.example.model.User;

public interface UserService {

        public User findUserById(Long userId) throws Exception;
}
