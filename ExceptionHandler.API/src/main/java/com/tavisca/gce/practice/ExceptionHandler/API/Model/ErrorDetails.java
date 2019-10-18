package com.tavisca.gce.practice.ExceptionHandler.API.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class ErrorDetails {

    @Id
    private ObjectId id;
    private Date timestamp;
    private String message;
    private String details;

    public String get_id() { return id.toHexString(); }
    public void set_id(ObjectId id) { this.id = id; }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ErrorDetails(ObjectId id, Date timestamp, String message, String details) {
        this.id = id;
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
