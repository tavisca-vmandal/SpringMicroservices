package com.tavisca.gce.practice.Save.API.Controller;


import com.tavisca.gce.practice.Save.API.Dao.StudentRepository;
import com.tavisca.gce.practice.Save.API.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class Controller {

    @Autowired
    StudentRepository repo;


    @PostMapping("/students")
    public Student getUsers(@RequestBody Student student) {

        Student s=repo.save(student);
        return s;
    }

    @GetMapping("/students")
    public List<Student> getStudent(){
        return repo.findAll();
    }

}