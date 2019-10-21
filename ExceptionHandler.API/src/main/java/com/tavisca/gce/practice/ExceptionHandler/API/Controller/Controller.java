package com.tavisca.gce.practice.ExceptionHandler.API.Controller;

import com.google.gson.Gson;
import com.tavisca.gce.practice.ExceptionHandler.API.Dao.ExceptionsRepository;
import com.tavisca.gce.practice.ExceptionHandler.API.Model.ErrorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;


@RestController
public class Controller {
    @Autowired
    ExceptionsRepository exceptionsRepository;

    @PostMapping(path="/exceptions")
    public Exception handleException(@RequestBody Exception exception,WebRequest request){

           ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false));
           ErrorDetails e=exceptionsRepository.save(errorDetails);
           return exception;
    }


}
