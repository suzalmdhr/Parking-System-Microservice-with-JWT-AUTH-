package com.example.config;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.example.entity.User;

public class CustomUserService implements UserDetails {

    @Autowired
   private User userInfo;

    

   public CustomUserService(User userInfo){
    super();
    this.userInfo=userInfo;
   }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       
       return null;
    }

    @Override
    public String getPassword() {
      return userInfo.getPassword();
    }

    @Override
    public String getUsername() {
        return userInfo.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
      return true;
    }

    @Override
    public boolean isAccountNonLocked() {
       return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

