package org.example.spring_security.service;

import org.example.spring_security.dao.UserRepo;
import org.example.spring_security.model.User;
import org.example.spring_security.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UserRepo repo ;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user =  repo.findByUsername(username);
       if(user == null) {
           System.out.println("User not found");
           throw new UsernameNotFoundException("User not found");
       }
       return  new UserPrincipal(user);
    }
}
