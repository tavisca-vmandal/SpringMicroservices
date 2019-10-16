package com.tavisca.gce.validate.api.controller;


import com.tavisca.gce.validate.api.dao.StudentRepo;
import com.tavisca.gce.validate.api.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {

    @Autowired
    StudentRepo repo;

    @PostMapping("/students")
    public String getUsers(@RequestBody Student student) {
        repo.save(student);
        return "Validated";
    }

}