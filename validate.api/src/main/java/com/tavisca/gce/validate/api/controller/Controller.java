package com.tavisca.gce.validate.api.controller;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tavisca.gce.validate.api.NotValidException;
import com.tavisca.gce.validate.api.dao.StudentRepo;
import com.tavisca.gce.validate.api.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
public class Controller {

    @Autowired
    StudentRepo repo;

    @PostMapping("/students")
    public String getUsers(@RequestBody String student) {

        Student studentJson =new Gson().fromJson(student, (Student.class));
        Pattern pattern =Pattern.compile("([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z]+)\\.([a-zA-Z]{2,5})");
        Matcher matcher=pattern.matcher(studentJson.getEmail());
        if(matcher.find()) {
            repo.save(studentJson);
            return "Validated";
        }
        else {
            throw new NotValidException("Email Not Valid exception");
        }
    }

}