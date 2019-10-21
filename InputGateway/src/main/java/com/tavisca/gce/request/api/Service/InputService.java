package com.tavisca.gce.request.api.Service;

import com.tavisca.gce.request.api.Dao.InputRepo;
import com.tavisca.gce.request.api.Model.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class InputService {
    @Autowired
    InputRepo inputRepo;

    private String uri;
    private String student;

    public InputService() {
    }

    public InputService(String uri, String student) {
        this.uri = uri;
        this.student=student;
    }

    public String callValidateApi(){
        Input input;
        if(!student.contains("roll"))
        {
            input=new Input();
            inputRepo.save(input);
            String errorMessage="No Input Data";
            throw new RuntimeException(errorMessage);
        }

        input=new Input();
        inputRepo.save(input);

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject( uri, student, String.class);
        return result;
    }

}
