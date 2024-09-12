package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;
import com.netflix.discovery.converters.Auto;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/register")
    public ResponseEntity<User> makeUser(@RequestBody User user){

        User users = this.userService.createUser(user);

        return ResponseEntity.ok(users);
        
    }


     @PostMapping("/token")
    public ResponseEntity<String> getToken(@RequestBody User user){


        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));


        if(authenticate.isAuthenticated()){

           
         String token = this.userService.generateToken(user.getName());

         return ResponseEntity.ok(token);
        }
        else{
            throw new RuntimeException("invalid access");
        }

    }


    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token){

        userService.validateToken(token);
        return "Token is valid";
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
