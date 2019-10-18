package com.tavisca.gce.practice.ExceptionHandler.API.Controller;

import com.tavisca.gce.practice.ExceptionHandler.API.Dao.ExceptionsRepository;
import com.tavisca.gce.practice.ExceptionHandler.API.Model.ErrorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {
    @Autowired
    ExceptionsRepository exceptionsRepository;

    @PostMapping(path="/exceptions")
    public ErrorDetails handleException(@RequestBody ErrorDetails errorDetails){

           ErrorDetails e=exceptionsRepository.save(errorDetails);
           System.out.println(e);
            return errorDetails;
    }


}
