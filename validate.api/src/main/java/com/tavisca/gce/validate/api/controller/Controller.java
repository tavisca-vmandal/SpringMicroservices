package com.tavisca.gce.validate.api.controller;


import com.google.gson.Gson;

import com.google.gson.JsonObject;
import com.tavisca.gce.validate.api.NotValidException;

import com.tavisca.gce.validate.api.dao.ValidateRepo;
import com.tavisca.gce.validate.api.model.InputDetails;
import com.tavisca.gce.validate.api.model.Student;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
public class Controller {

    @Autowired
    ValidateRepo validateRepo;

    @PostMapping("/students")
    public String addStudent(@RequestBody String student) throws JSONException {

        JSONObject studentJsonObject=new JSONObject(student);
        Student studentJson =new Gson().fromJson(studentJsonObject.get("studentDetails").toString(), (Student.class));
        Pattern pattern =Pattern.compile("([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z]+)\\.([a-zA-Z]{2,5})");
        Matcher matcher=pattern.matcher(studentJson.getEmail());
        if(matcher.find()) {
            final String dataWriteUri="http://localhost:8085/students";
            saveInputDetails(studentJson.toString(),studentJsonObject.get("tid").toString(),dataWriteUri,"Valid");
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject( dataWriteUri,studentJsonObject.toString(), String.class);
            return "Validated";
        }
        else {
            final String exceptionUri = "http://localhost:5050/exceptions";
            saveInputDetails(studentJson.toString(),studentJsonObject.get("tid").toString(),exceptionUri,"Invalid");
            throw new NotValidException("Email Not Valid exception");
        }

    }

    public void saveInputDetails(String student,String tid,String serviceTo,String status){
        InputDetails inputDetails=new InputDetails(student.toString(),tid,new Date(),this.getClass().toString(),serviceTo,status);
        validateRepo.save(inputDetails);
    }
}