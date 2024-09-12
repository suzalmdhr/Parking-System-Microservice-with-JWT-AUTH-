package com.example.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.entity.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;

    @Override
    public User createUser(User user) {
      user.setPassword(passwordEncoder.encode(user.getPassword()));
       return this.userDao.save(user);
    }

    @Override
    public String generateToken(String name){
        return jwtService.generateToken(name);

    }


    @Override
    public void validateToken(String token){
         jwtService.validateToken(token);
    }



    @Override
    public User updateUser(User user) {
      User users = this.userDao.findById(user.getId()).orElseThrow( () -> new NoSuchElementException("No such user"));

      users.setName(user.getName());
      users.setPassword(user.getPassword());
      users.setEmail(user.getEmail());

      return this.userDao.save(users);
    }

    @Override
    public User findUser(int id) {
       
         User users = this.userDao.findById(id).orElseThrow(() -> new NoSuchElementException("No such user"));

         return users;
    }

    @Override
    public List<User> getAll() {
       
        return this.userDao.findAll();
    }

    

}
