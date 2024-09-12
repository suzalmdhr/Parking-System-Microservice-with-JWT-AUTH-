package com.example.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

public interface UserDao extends JpaRepository<User,Integer> {

    Optional<User> findByName(String username);

}
