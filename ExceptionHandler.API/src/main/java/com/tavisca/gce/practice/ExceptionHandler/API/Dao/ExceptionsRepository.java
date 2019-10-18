package com.tavisca.gce.practice.ExceptionHandler.API.Dao;

import com.tavisca.gce.practice.ExceptionHandler.API.Model.ErrorDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExceptionsRepository extends MongoRepository<ErrorDetails, String> {
}
