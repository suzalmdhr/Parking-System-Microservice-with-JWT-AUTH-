package com.example.config;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import com.example.dao.UserDao;
import com.example.entity.User;

@Component
public class CustomUserDetailsService  implements UserDetailsService{

    @Autowired
    private UserDao userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
       
 User user = this.userRepo.findByName(username).get();

 if(user == null){
    throw new UsernameNotFoundException("User cannot be found");
 }
 CustomUserService userDetails =new CustomUserService(user);
 return userDetails;

    }

}

