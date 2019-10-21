package com.tavisca.gce.request.api.Service;

import com.tavisca.gce.request.api.Dao.InputRepo;
import com.tavisca.gce.request.api.Model.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@ControllerAdvice
@RestController
class ErrorHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Exception> handleNoDataException(RuntimeException ex) {

        final String uri = "http://localhost:5050/exceptions";

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity( uri,ex, Exception.class);

    }
}