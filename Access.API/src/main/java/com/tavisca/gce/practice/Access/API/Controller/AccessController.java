package com.tavisca.gce.practice.Access.API.Controller;

import com.tavisca.gce.practice.Access.API.Dao.StudentRepo;
import com.tavisca.gce.practice.Access.API.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccessController {
    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/students")
    public List<Student> getStudent(){
        return studentRepo.findAll();
    }

}
