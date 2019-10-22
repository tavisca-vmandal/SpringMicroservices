package com.tavisca.gce.practice.Save.API.Controller;


import com.google.gson.Gson;
import com.tavisca.gce.practice.Save.API.Dao.InputRepo;
import com.tavisca.gce.practice.Save.API.Dao.StudentRepository;
import com.tavisca.gce.practice.Save.API.Model.InputDetails;
import com.tavisca.gce.practice.Save.API.Model.Student;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
public class Controller {

    @Autowired
    StudentRepository repo;

    @Autowired
    InputRepo inputRepo;

    @PostMapping("/students")
    public Student getUsers(@RequestBody String student) throws JSONException {

        JSONObject studentJsonObject=new JSONObject(student);
        Student studentJson =new Gson().fromJson(studentJsonObject.get("studentDetails").toString(), (Student.class));
        Student s=repo.save(studentJson);

        String tid= (String) studentJsonObject.get("tid");
        InputDetails inputDetails=new InputDetails(studentJson.toString(),tid,new Date(),this.getClass().toString(),"User","Valid");
        inputRepo.save(inputDetails);
        return s;
    }

    @GetMapping("/students")
    public List<Student> getStudent(){
        return repo.findAll();
    }

}