package org.example.spring_security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.spring_security.model.Student;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Phan Hoang Thai", "Java"),
            new Student(2, "Quach Xuan Truong", "Python"),
            new Student(3,"Nguyen Xuan Tiep", "c++")
    ));
    @GetMapping("students")
    public List<Student> getStudents() {
        return students;
    }
    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");


    }
    @PostMapping("students")
    public void addStudent(@RequestBody Student student) {
        students.add(student);

    }
}

