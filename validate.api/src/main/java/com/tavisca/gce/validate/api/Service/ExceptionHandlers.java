package com.tavisca.gce.validate.api.Service;

import com.tavisca.gce.validate.api.NotValidException;
import com.tavisca.gce.validate.api.model.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@ControllerAdvice
@RestController

public class ExceptionHandlers extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotValidException.class)
    public final ResponseEntity<ErrorDetails> handleNotValidException(NotValidException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
                request.getDescription(false));
        //return new ResponseEntity<>(errorDetails, HttpStatus.NOT_ACCEPTABLE);

        final String uri = "http://localhost:5050/exceptions";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity( uri,errorDetails, ErrorDetails.class);

    }
}

