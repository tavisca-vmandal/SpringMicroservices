package com.tavisca.gce.request.api.Controller;

import com.tavisca.gce.request.api.Dao.InputRepo;
import com.tavisca.gce.request.api.Model.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
public class Controller {
    @Autowired
    InputRepo inputRepo;

    @PostMapping(name="/students")
    public String  addUserByCallingValidateAPI(@RequestBody String student){

        final String uri = "http://localhost:6060/students";

        if(!student.contains("roll"))
        {
            throw new RuntimeException("NO Input Data");
        }

        Input input=new Input(student,new Date(),this.getClass().toString(),uri);
        inputRepo.save(input);

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject( uri, student, String.class);
        return result;
    }

}
