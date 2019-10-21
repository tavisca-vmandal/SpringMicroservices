package com.tavisca.gce.request.api.Controller;

import com.tavisca.gce.request.api.Dao.InputRepo;
import com.tavisca.gce.request.api.Model.Input;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.UUID;

@RestController
public class Controller {

    @Autowired
    InputRepo inputRepo;

    String student;

    @PostMapping(name="/students")
    public String  addUserByCallingValidateAPI(@RequestBody String student) throws JSONException {

        this.student=student;

        String tid= UUID.randomUUID().toString();

        JSONObject studentJsonObject=new JSONObject();
        studentJsonObject.put("tid",tid);
        studentJsonObject.put("studentDetails",student);


        final String validateUri = "http://localhost:6060/students";
        Input input;

        if(!student.contains("roll"))
        {
            logToInputDataBase("http://localhost:5050/exceptions","Invalid",tid);
            String errorMessage="No Input Data";
            throw new RuntimeException(errorMessage);
        }

        logToInputDataBase(validateUri,"Valid",tid);

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject( validateUri, studentJsonObject.toString(), String.class);
        return result;

//        InputService inputService=new InputService(validateUri,student);
//        return inputService.callValidateApi();
  }

  public void logToInputDataBase(String serviceTo,String status,String tid){
      Input input=new Input(student,tid,new Date(),this.getClass().toString(),serviceTo,status);
      inputRepo.save(input);
  }

}
