package com.example.service;

import java.util.List;

import com.example.entity.User;

public interface UserService {


    User createUser(User user); 

    User updateUser(User user);

    User findUser(int id);

   List<User> getAll();

   String generateToken(String name);

    void validateToken(String token);





}
