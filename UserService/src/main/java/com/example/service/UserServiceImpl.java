package com.example.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.entity.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User createUser(User user) {
       return this.userDao.save(user);
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
