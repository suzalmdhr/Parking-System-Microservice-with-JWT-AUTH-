package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<User> makeUser(@RequestBody User user){

        User users = this.userService.createUser(user);

        return ResponseEntity.ok(users);
        
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id){

User user = this.userService.findUser(id);

return ResponseEntity.ok(user);

    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
List<User> allUsers = this.userService.getAll();

return ResponseEntity.ok(allUsers);

    }

}
