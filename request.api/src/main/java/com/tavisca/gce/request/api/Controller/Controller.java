package com.tavisca.gce.request.api.Controller;

import com.tavisca.gce.request.api.Model.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
    @PostMapping(name="/students")
    public String  addUserByCallingOtherAPI(@RequestBody Student student){

        final String uri = "http://localhost:6060/students";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject( uri, student, String.class);
        return result;
    }

}
