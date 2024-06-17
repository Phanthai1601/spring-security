package org.example.spring_security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController1 {
    @GetMapping("/hehe")
    public String greet(HttpServletRequest request){
        return "Hello World"+ request.getSession().getId();
    }
    @GetMapping("about")
    public String about(HttpServletRequest request){
        return "Phan Hoàng Thái"+ request.getSession().getId();
    }

}
