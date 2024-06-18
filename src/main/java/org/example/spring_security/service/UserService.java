package org.example.spring_security.service;

import org.example.spring_security.dao.UserRepo;
import org.example.spring_security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;
    private BCryptPasswordEncoder encoderew = new BCryptPasswordEncoder(12);
    public User saveUser(User user) {
        user.setPassword(encoderew.encode(user.getPassword()));
        System.out.println(user.getPassword());
        return userRepository.save(user);
    }

}
